import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> historico;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historico = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        validarValor(valor);
        
        if (saldo < valor) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        
        saldo -= valor;
        adicionarTransacao(new Transacao(TipoTransacao.SAQUE, valor, "Saque realizado"));
    }

    @Override
    public void depositar(double valor) throws ValorInvalidoException {
        validarValor(valor);
        
        saldo += valor;
        adicionarTransacao(new Transacao(TipoTransacao.DEPOSITO, valor, "Depósito realizado"));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException {
        validarValor(valor);
        
        this.sacar(valor);
        contaDestino.depositar(valor);
        
        // Atualizar histórico (remover a transação de saque e adicionar transferência)
        historico.remove(historico.size() - 1); // Remove o último saque
        adicionarTransacao(new Transacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, 
                          "Transferência enviada para conta " + ((Conta)contaDestino).getNumero()));
        
        // Adicionar no histórico da conta destino
        ((Conta)contaDestino).adicionarTransacao(new Transacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, 
                                                "Transferência recebida da conta " + this.numero));
    }
    
    @Override
    public List<Transacao> getHistorico() {
        return new ArrayList<>(historico); // Retorna cópia para evitar modificação externa
    }
    
    @Override
    public void imprimirHistorico() {
        System.out.println("\n=== Histórico de Transações ===");
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Conta: " + this.numero);
        System.out.println("----------------------------------------");
        
        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (Transacao transacao : historico) {
                System.out.println(transacao);
            }
        }
        System.out.println("----------------------------------------");
    }
    
    // Método abstrato para calcular taxa (cada tipo de conta implementa)
    @Override
    public abstract double calcularTaxa();
    
    // Métodos auxiliares
    private void validarValor(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor deve ser maior que zero");
        }
    }
    
    protected void adicionarTransacao(Transacao transacao) {
        historico.add(transacao);
    }
    
    // Método para aplicar taxa (pode ser chamado mensalmente)
    public void aplicarTaxa() {
        double taxa = calcularTaxa();
        if (taxa > 0 && saldo >= taxa) {
            saldo -= taxa;
            adicionarTransacao(new Transacao(TipoTransacao.TAXA, taxa, "Taxa de manutenção"));
        }
    }

    // Getters existentes
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }
}