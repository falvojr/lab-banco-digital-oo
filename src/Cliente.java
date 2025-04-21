
public class Cliente {

	private String nome;
	private boolean estudando;

	public Cliente(String nome, boolean estudando) {
		this.nome = nome;
		this.estudando = estudando;
	}

	public String getNome() {
		return nome;
	}

	public boolean isEstudando() {
		return estudando;
	}
}
