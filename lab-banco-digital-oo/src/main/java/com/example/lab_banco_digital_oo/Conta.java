package com.example.lab_banco_digital_oo;

import lombok.Data;

@Data
public class Conta implements IConta {

	protected static final int AGENCIA_PADRAO = 1;
	protected static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected String nomeBanco;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
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
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato da conta ===");
		imprimirInfosComuns();
		System.out.println("=== Fim do extrato ===");
	}

	@Override
	public String toString() {
		return "Conta{" +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo +
				", cliente=" + cliente.getNome() +
				", nomeBanco='" + nomeBanco + '\'' +
				'}';
	}
}
