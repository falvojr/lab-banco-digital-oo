package Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Cliente.Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	@Override
	public String nomeDoTipoDaConta()
	{
		return "Conta corrente";
	}

	@Override
	public void mostrarHistoricoDeTransferencia()
	{
		System.out.println("=== Historico de transferencias da conta corrente ===");
		mostrarHistorico();
	}
	
}
