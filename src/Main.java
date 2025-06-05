// Arquivo: src/Main.java (SUBSTITUA o arquivo existente)
public class Main {

    public static void main(String[] args) {
        // Criando cliente
        Cliente bernard = new Cliente();
        bernard.setNome("Bernard");
        
        // Criando contas
        Conta cc = new ContaCorrente(bernard);
        Conta poupanca = new ContaPoupanca(bernard);
        
        System.out.println("=== TESTANDO OPERAÇÕES BÁSICAS ===");
        
        try {
            // Testando depósito
            cc.depositar(100);
            System.out.println("Depósito de R$ 100 realizado com sucesso!");
            
            // Testando transferência
            cc.transferir(50, poupanca);
            System.out.println("Transferência de R$ 50 realizada com sucesso!");
            
            // Imprimindo extratos
            cc.imprimirExtrato();
            System.out.println();
            poupanca.imprimirExtrato();
            
            // Imprimindo históricos
            cc.imprimirHistorico();
            poupanca.imprimirHistorico();
            
            // Aplicando rendimento na poupança
            System.out.println("\n=== APLICANDO RENDIMENTO ===");
            ((ContaPoupanca) poupanca).aplicarRendimento();
            poupanca.imprimirExtrato();
            
            // Aplicando taxa na conta corrente
            System.out.println("\n=== APLICANDO TAXA ===");
            cc.aplicarTaxa();
            cc.imprimirExtrato();
            
        } catch (SaldoInsuficienteException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (ValorInvalidoException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
        // Testando exceções
        System.out.println("\n=== TESTANDO EXCEÇÕES ===");
        
        try {
            cc.sacar(1000); // Deve dar erro de saldo insuficiente
        } catch (Exception e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
        
        try {
            cc.depositar(-50); // Deve dar erro de valor inválido
        } catch (Exception e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
    }
}