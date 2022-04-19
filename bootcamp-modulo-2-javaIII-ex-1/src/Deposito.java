public class Deposito implements  Transacao{

    @Override
    public void transacaoOK() {
        System.out.println("Depósito realizado com sucesso!");
    }

    @Override
    public void trasacaoNaoOk() {
        System.out.println("Não foi possível realizar o deposito!");
    }
}
