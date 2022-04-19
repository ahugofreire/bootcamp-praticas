public class PagamentoServico implements Transacao{

    @Override
    public void transacaoOK() {
        System.out.println("Pagamento realizado com sucesso!");
    }

    @Override
    public void trasacaoNaoOk() {
        System.out.println("Falha no pagamento!");
    }
}
