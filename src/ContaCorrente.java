
public class ContaCorrente extends Conta {
	private double chequeEspecial;

	public ContaCorrente(Cliente cliente, double saldo) {
		super(cliente);
		if (saldo <= 1000) {
			this.chequeEspecial = 500;
		} else {
			this.chequeEspecial = saldo / 2;
		}
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirExtrato();
		System.out.println("Cheque Especial: " + chequeEspecial);
	}
}
