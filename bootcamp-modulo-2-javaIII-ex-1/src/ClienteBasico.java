public class ClienteBasico  {

    private Transacao saldo;
    private Transacao saque;
    private Transacao pagamentoServico;

    public ClienteBasico(Transacao saque, Transacao saldo, Transacao pagamentoServico) {
        this.saque = saque;
        this.saldo = saldo;
        this.pagamentoServico = pagamentoServico;
    }

    public void saldo() {
        saldo.transacaoOK();
    }

    public void saquar() {
        saque.transacaoOK();
    }

    public void pagar() {
        pagamentoServico.transacaoOK();
    }

}
