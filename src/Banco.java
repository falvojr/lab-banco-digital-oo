import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;


	public Banco() {
		this.contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public void imprimirContasDoBanco() {
		System.out.println("======================================");
		System.out.println("Relatório de Contas do Banco: " + this.nome);
		System.out.println("======================================");
		for (Conta conta : contas) {
			conta.imprimirExtrato();
			System.out.println("--------------------");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}