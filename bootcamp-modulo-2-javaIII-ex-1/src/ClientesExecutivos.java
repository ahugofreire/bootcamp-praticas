public class ClientesExecutivos {
    private Transacao transferencia;
    private Transacao deposito;

    public ClientesExecutivos(Transacao transferencia, Transacao deposito) {
        this.transferencia = transferencia;
        this.deposito = deposito;
    }

    public void transferir(){
        transferencia.transacaoOK();
    }

    public void depositar() {
        deposito.transacaoOK();
    }
}
