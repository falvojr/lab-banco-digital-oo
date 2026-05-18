
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Cliente patricia = new Cliente();
		patricia.setNome("Patricia");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		Conta ccPatricia = new ContaCorrente(patricia);

		System.out.println("=== TESTE 1: Depósito válido ===");
		cc.depositar(100);
		System.out.println();

		System.out.println("=== TESTE 2: Transferência válida ===");
		cc.transferir(50, poupanca);
		System.out.println();

		System.out.println("=== TESTE 3: Tentativa de saque com saldo insuficiente ===");
		cc.sacar(200);
		System.out.println();

		System.out.println("=== TESTE 4: Saque válido ===");
		cc.sacar(30);
		System.out.println();

		System.out.println("=== TESTE 5: Tentativa de depósito com valor negativo ===");
		cc.depositar(-50);
		System.out.println();

		System.out.println("=== TESTE 6: Transferência para outra pessoa ===");
		cc.transferir(15, ccPatricia);
		System.out.println();

		System.out.println("=== EXTRATOS FINAIS ===\n");
		cc.imprimirExtrato();
		System.out.println();
		poupanca.imprimirExtrato();
		System.out.println();
		ccPatricia.imprimirExtrato();
	}

}
