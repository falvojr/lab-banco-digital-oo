import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;
    private List<String> extrato;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            registrarTransacao("SAQUE", valor);
            System.out.println("Saque de: " + valor);
        } else {
            System.out.println("Saldo insuficiente para saque de: " + valor);
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarTransacao("DEPÓSITO", valor);
            System.out.println("Depósito de: " + valor);
        } else {
            System.out.println("Valor de depósito inválido: " + valor);
        }
    }

    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            ((Conta) contaDestino).depositar(valor);
            registrarTransacao("TRANSFERÊNCIA PARA CONTA " + ((Conta) contaDestino).getNumero(), valor);
            System.out.println("Transferência de: " + valor);
        } else {
            System.out.println("Saldo insuficiente para transferência de: " + valor);
        }
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        for (String transacao : extrato) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: " + saldo);
    }

    private void registrarTransacao(String tipo, double valor) {
        LocalDateTime dataHora = LocalDateTime.now();
        extrato.add(dataHora + " - " + tipo + ": " + valor);
    }

    public int getNumero() {
        return numero;
    }
}
