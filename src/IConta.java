import java.util.List;

public interface IConta {
    
    void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException;
    
    void depositar(double valor) throws ValorInvalidoException;
    
    void transferir(double valor, IConta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException;
    
    void imprimirExtrato();
    
    // Novos métodos
    List<Transacao> getHistorico();
    
    void imprimirHistorico();
    
    double calcularTaxa();
}