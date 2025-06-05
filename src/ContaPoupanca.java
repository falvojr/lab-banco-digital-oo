public class ContaPoupanca extends Conta {
    
    private static final double RENDIMENTO_MENSAL = 0.005; // 0.5% ao mês

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
        System.out.println(String.format("Rendimento Mensal: %.1f%%", RENDIMENTO_MENSAL * 100));
    }
    
    @Override
    public double calcularTaxa() {
        return 0.0; // Conta poupança não tem taxa
    }
    
    // Método específico da poupança
    public void aplicarRendimento() {
        double rendimento = saldo * RENDIMENTO_MENSAL;
        saldo += rendimento;
        adicionarTransacao(new Transacao(TipoTransacao.DEPOSITO, rendimento, "Rendimento da poupança"));
    }
}