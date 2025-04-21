
public class Main {

	public static void main(String[] args) throws NaoUniversitarioException {
		Agencia agencia1 = new Agencia(1, "Sao Paulo/SP");
		Agencia agencia2 = new Agencia(2, "Belo Horizone/MG");

		Cliente venilton = new Cliente("Venilton", false);
		Cliente vitor = new Cliente("Vitor", true);
		
		Conta cc = new ContaCorrente(venilton, agencia1);
		Conta poupanca = new ContaPoupanca(venilton, agencia1);
		Conta universitario = new ContaUniversitario(vitor, agencia2);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		universitario.depositar(300);
		universitario.imprimirExtrato();

		agencia1.imprimirContas();
		agencia2.imprimirContas();
	}

}
