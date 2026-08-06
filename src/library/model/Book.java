package library.model;

public class Book {
     private static int contador=1;
     private int id;
     private String titulo;
     private String autor;
     private int anodelancamento;
     private boolean disponivel;

    public Book(String titulo,String autor,int anodelancamento){
        this.id=contador;
        contador++;
        this.titulo=titulo;
        this.autor=autor;
        setAnodelancamento(anodelancamento);
        disponivel=true;

    }



    public int getId(){
        return id;
    }

     public String getTitulo(){

        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }


    public String getAutor(){

        return autor;
    }

    public void setAutor(String autor){

        this.autor=autor;
    }

    public int getAnodelancamento(){

        return anodelancamento;
    }

    public void setAnodelancamento(int anodelancamento){
        if(anodelancamento <=0){
            System.out.println("ERRO: "+getTitulo()+" com data inválido");
        }else{
            this.anodelancamento = anodelancamento;
        }

    }

    //get do boolean
    public boolean isDisponivel() {
        return disponivel;
    }

    //set do boolean
    public void setDisponivel(boolean disponivel){

            this.disponivel = disponivel;

    }
}
