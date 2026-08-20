package system_of_library.interaction;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import system_of_library.service.Library;
import system_of_library.model.Book;
import system_of_library.usuarios.*;
import system_of_library.emprestimo.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WebServer {

    private static Library library = new Library();
    // Utilizando o construtor com os argumentos que funcionaram no seu projeto
    private static Usuario usuarioLogado = new Bibliotecario("Admin Bibliotecário", "admin@bib.com", "Rua Central, 123", library);

    public static void main(String[] args) throws Exception {
        // Carga inicial de dados para teste
        library.addBook(new Book("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Dom Casmurro", "Machado de Assis", 1899));

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Rotas do sistema
        server.createContext("/", new HomeHandler());
        server.createContext("/cadastrar", new CadastrarHandler());
        server.createContext("/emprestar", new EmprestarHandler());
        server.createContext("/devolver", new DevolverHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("====================================================");
        System.out.println("SERVIDOR RODANDO COM SUCESSO!");
        System.out.println("Acesse no navegador: http://localhost:8080/");
        System.out.println("Usuário logado: " + usuarioLogado.getNome());
        System.out.println("====================================================");

        // Bloqueia a thread principal para o Java NÃO fechar e manter o servidor vivo
        Thread.currentThread().join();
    }

    // 1. Rota Principal: Exibe a lista de livros e o formulário de ações
    static class HomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder linhasTabela = new StringBuilder();

            for (Book b : library.getLivros()) {
                linhasTabela.append("<tr>")
                        .append("<td>").append(b.getId()).append("</td>")
                        .append("<td>").append(b.getTitle()).append("</td>")
                        .append("<td>").append(b.getAuthor()).append("</td>")
                        .append("<td>").append(b.getReleaseyear()).append("</td>")
                        .append("<td>").append(b.isAvailable() ? "<span style='color:green;font-weight:bold;'>Disponível</span>" : "<span style='color:red;font-weight:bold;'>Emprestado</span>").append("</td>")
                        .append("<td>")
                        .append("<form action='/emprestar' method='POST' style='display:inline;'>")
                        .append("<input type='hidden' name='id' value='").append(b.getId()).append("'>")
                        .append("<button type='submit' ").append(b.isAvailable() ? "" : "disabled").append(">Emprestar</button>")
                        .append("</form> ")
                        .append("<form action='/devolver' method='POST' style='display:inline;'>")
                        .append("<input type='hidden' name='id' value='").append(b.getId()).append("'>")
                        .append("<button type='submit' ").append(!b.isAvailable() ? "" : "disabled").append(">Devolver</button>")
                        .append("</form>")
                        .append("</td>")
                        .append("</tr>");
            }

            String html = """
                <!DOCTYPE html>
                <html lang="pt-br">
                <head>
                    <meta charset="UTF-8">
                    <title>Biblioteca Web</title>
                    <style>
                        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8f9fa; }
                        h1, h2 { color: #333; }
                        .card { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px; }
                        table { width: 100%%; border-collapse: collapse; margin-top: 10px; }
                        th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
                        th { background-color: #007bff; color: white; }
                        input[type=text], input[type=number] { padding: 8px; margin: 5px 0; width: 200px; display: inline-block; }
                        button { padding: 8px 12px; background-color: #28a748; color: white; border: none; border-radius: 4px; cursor: pointer; }
                        button:disabled { background-color: #ccc; cursor: not-allowed; }
                    </style>
                </head>
                <body>
                    <h1>📚 Sistema de Gerenciamento de Biblioteca</h1>
                    
                    <div class="card">
                        <p><strong>Usuário ativo:</strong> %s (%s)</p>
                    </div>

                    <div class="card">
                        <h2>Cadastrar Novo Livro</h2>
                        <form action="/cadastrar" method="POST">
                            <input type="text" name="titulo" placeholder="Título do Livro" required>
                            <input type="text" name="autor" placeholder="Autor" required>
                            <input type="number" name="ano" placeholder="Ano de Lançamento" required>
                            <button type="submit">Adicionar Livro</button>
                        </form>
                    </div>

                    <div class="card">
                        <h2>Catálogo de Livros</h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Título</th>
                                    <th>Autor</th>
                                    <th>Ano</th>
                                    <th>Status</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                %s
                            </tbody>
                        </table>
                    </div>
                </body>
                </html>
            """.formatted(usuarioLogado.getNome(), usuarioLogado.getClass().getSimpleName(), linhasTabela.toString());

            enviarResposta(exchange, html);
        }
    }

    // 2. Rota para Cadastrar Livro
    static class CadastrarHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                Map<String, String> params = parseFormData(exchange);
                String titulo = params.get("titulo");
                String autor = params.get("autor");
                int ano = Integer.parseInt(params.get("ano"));

                if (usuarioLogado instanceof Bibliotecario bib) {
                    bib.cadastrarLivro(titulo, autor, ano);
                }
            }
            redirecionarParaHome(exchange);
        }
    }

    // 3. Rota para Emprestar Livro
    static class EmprestarHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                Map<String, String> params = parseFormData(exchange);
                int id = Integer.parseInt(params.get("id"));
                library.lendBook(id, usuarioLogado);
            }
            redirecionarParaHome(exchange);
        }
    }

    // 4. Rota para Devolver Livro
    static class DevolverHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                Map<String, String> params = parseFormData(exchange);
                int id = Integer.parseInt(params.get("id"));
                library.returnBook(id);
            }
            redirecionarParaHome(exchange);
        }
    }

    // Métodos Utilitários
    private static void enviarResposta(HttpExchange exchange, String html) throws IOException {
        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
            os.flush();
        }
    }

    private static void redirecionarParaHome(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Location", "/");
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
    }

    private static Map<String, String> parseFormData(HttpExchange exchange) throws IOException {
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String query = br.readLine();
        Map<String, String> result = new HashMap<>();
        if (query != null) {
            for (String param : query.split("&")) {
                String[] pair = param.split("=");
                if (pair.length > 1) {
                    result.put(URLDecoder.decode(pair[0], StandardCharsets.UTF_8), URLDecoder.decode(pair[1], StandardCharsets.UTF_8));
                }
            }
        }
        return result;
    }
}