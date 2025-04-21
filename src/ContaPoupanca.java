
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente, Agencia agencia) {
		super(cliente, agencia);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");
		super.imprimirInfosComuns();
	}
}
