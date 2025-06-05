public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
    
    public SaldoInsuficienteException(double saldoAtual, double valorSaque) {
        super(String.format("Saldo insuficiente. Saldo atual: %.2f, Valor solicitado: %.2f", 
        saldoAtual, valorSaque));
    }
}