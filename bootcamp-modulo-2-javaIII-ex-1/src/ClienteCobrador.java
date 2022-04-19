public class ClienteCobrador {
    private Transacao saldo;
    private Transacao saque;

    public ClienteCobrador(Transacao saldo, Transacao saque) {
        this.saldo = saldo;
        this.saque = saque;
    }

    public void sacar() {
        saque.transacaoOK();
    }

    public void saldo() {
        saldo.transacaoOK();
    }
}
