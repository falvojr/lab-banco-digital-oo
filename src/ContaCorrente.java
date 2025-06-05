public class ContaCorrente extends Conta {
    
    private static final double TAXA_MANUTENCAO = 5.0;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        System.out.println(String.format("Taxa de Manutenção: R$ %.2f", TAXA_MANUTENCAO));
    }
    
    @Override
    public double calcularTaxa() {
        return TAXA_MANUTENCAO;
    }
}