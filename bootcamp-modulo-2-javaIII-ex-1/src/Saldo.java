public class Saldo implements Transacao {


    @Override
    public void transacaoOK() {
        System.out.println("Concultando o saldo com sucesso!");
    }

    @Override
    public void trasacaoNaoOk() {
        System.out.println("Não foi possível consultar o saldo!");
    }
}
