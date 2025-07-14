package Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Cliente.Conta Poupan�a ===");
		super.imprimirInfosComuns();
	}

	@Override
	public String nomeDoTipoDaConta()
	{
		return "conta poupança";
	}

	@Override
	public void mostrarHistoricoDeTransferencia()
	{
		System.out.println("=== Historico de transferencias da conta poupança ===");
		mostrarHistorico();
	}
}
