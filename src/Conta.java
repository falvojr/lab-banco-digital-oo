import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
    protected List<String> historicoDeTrasacoes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
        historicoDeTrasacoes.add("Saque: " + valor);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
        historicoDeTrasacoes.add("Deposito no valor de: " + valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
        historicoDeTrasacoes.add("Transferenica para: " + contaDestino.nomeDoTipoDaConta() + " no valor de: " + valor);
	}

    protected void mostrarHistorico(){
        historicoDeTrasacoes.forEach(transacao -> System.out.println(transacao));
    }

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
