public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");


		Banco banco = new Banco();
		banco.setNome("Meu Banco Digital");

		Conta ccVenilton = new ContaCorrente(venilton);
		Conta poupancaVenilton = new ContaPoupanca(venilton);

		banco.adicionarConta(ccVenilton);
		banco.adicionarConta(poupancaVenilton);

		ccVenilton.depositar(500);
		ccVenilton.transferir(200, poupancaVenilton);

		Cliente jessica = new Cliente();
		jessica.setNome("Jéssica");
		Conta ccJessica = new ContaCorrente(jessica);
		banco.adicionarConta(ccJessica);
		ccJessica.depositar(1000);
		ccJessica.transferir(50, ccVenilton);

		banco.imprimirContasDoBanco();
	}
}