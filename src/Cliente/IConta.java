package Cliente;

public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
	void mostrarHistoricoDeTransferencia();
	String nomeDoTipoDaConta();
}
