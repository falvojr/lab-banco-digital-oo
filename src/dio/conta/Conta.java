package dio.conta;

import dio.Cliente;

public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
       this.agencia = Conta.AGENCIA_PADRAO;
       this.numero = SEQUENCIAL++;
       this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Erro: Saldo insuficiente para realizar o saque.");
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
       this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
       if (valor > this.saldo) {
           System.out.println("Erro: Saldo insuficiente para realizar a transferência.");
       } else {
           this.sacar(valor);
           contaDestino.depositar(valor);
       }
    }

    public int getAgencia() {
       return agencia;
    }

    public int getNumero() {
       return numero;
    }

    public double getSaldo() {
       return saldo;
    }

    protected void imprimirInfosComuns() {
       System.out.printf("Titular: %s%n", this.cliente.getNome());
       System.out.printf("Agencia: %d%n", this.agencia);
       System.out.printf("Numero: %d%n", this.numero);
       System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}