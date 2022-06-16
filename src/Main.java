import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);
		
		Banco banco1 = new Banco();
		banco1.setNome("Blue Bank");
		List<Conta> contas = new ArrayList<>();
		contas.add(poupanca);
		contas.add(cc);
		banco1.setContas(contas);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		System.out.println();
		banco1.imprimirInfosBanco();
		
		System.out.println();
		System.out.println("====Acessando informações do Banco por toString====");
		System.out.println(banco1.getContas());
		System.out.println(banco1);
	}

}
