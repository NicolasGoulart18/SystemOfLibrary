package system_of_library.emprestimo;

public class ResultadoEmpr {

   /*
        O que é enum:
            Serve para representar uma variavle que so pode assumir um conjunto especificos de valores que vc definiu

            Por exemplo em Status de pedidos:
            public enum StatusPedido{
            PENDENTE,
            PAGO,
            ENVIADO,
            ENTREGUE,
            CANCELADO

            Ai Status pedido virou um tipo ai posso fazer
            StatusPedido status = StatusPedido.PAGO
            }

            Pq usar no meu projeto ?
                Como eu preciso retorar 2 valores false, o basico boolean não permite, pois so return true/false
                ent o enum entra como uma luva nesse momento
    */
    public enum ResultadoEmprestimo{
       SUCESSO,
       LIVRO_NAO_EXISTE,
       LIVRO_INDISPONIVEL
    }
}
