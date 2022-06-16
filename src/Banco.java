import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

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
	
	public void imprimirInfosBanco() {
		System.out.println("========Informações do Banco========");
		System.out.println("Nome do Banco: " + nome);
		for (Conta conta : contas) {
			System.out.println("*********************");
			System.out.println("Cliente: " + conta.cliente);
			System.out.println("Agência: " + conta.agencia);
			System.out.println("Numero da Conta: " + conta.numero);
			System.out.println("Saldo: " + conta.saldo);
		}
	}

	@Override
	public String toString() {
		return "Banco [nome=" + nome + ", contas=" + contas + "]";
	}

	

}
