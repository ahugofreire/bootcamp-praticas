public class Main {
    public static void main(String[] args) {
        ClienteBasico clienteBasico = new ClienteBasico(new Saque(), new Saldo(), new PagamentoServico());
        ClienteCobrador clienteCobrador = new ClienteCobrador(new Saque(), new Saldo());
        ClientesExecutivos clientesExecutivos = new ClientesExecutivos(new Transferencia(), new Deposito());

        clienteBasico.saldo();
        clienteBasico.saquar();
        clienteBasico.pagar();

        clienteCobrador.saldo();
        clienteCobrador.sacar();

        clientesExecutivos.depositar();
        clientesExecutivos.transferir();

    }
}
