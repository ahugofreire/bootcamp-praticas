public class Saque implements Transacao{

    @Override
    public void transacaoOK() {
        System.out.println("Saque realizado com sucesso!");
    }

    @Override
    public void trasacaoNaoOk() {
        System.out.println("Não foi possivel realizar o saque!");
    }
}
