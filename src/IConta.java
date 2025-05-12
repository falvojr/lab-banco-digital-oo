
public interface IConta {
	
	Boolean sacar(double valor);
	
	Boolean depositar(double valor);
	
	Boolean transferir(double valor, IConta contaDestino);
	
	void  imprimirExtrato();
}
