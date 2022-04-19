public class Transferencia implements Transacao{

    public Transferencia() {
    }

    @Override
    public void transacaoOK() {
        System.out.println("Transferência realizado com sucesso!");
    }

    @Override
    public void trasacaoNaoOk() {
        System.out.println("Não foi possível realizar a transferência!");
    }
}
