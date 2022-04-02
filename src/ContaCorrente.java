public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente, "Corrente");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtratoConta();
    }

}