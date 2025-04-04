package com.example.lab_banco_digital_oo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Banco {

	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public void addContas(Conta conta) {
		this.contas.add(conta);
	}

	public void listarContas() {
		System.out.println("=== Contas do banco " + this.nome + " ===");
		contas.stream()
				.forEach(conta -> System.out.println(conta));

		// for (Conta conta : contas) {
		// 	System.out.println(conta);
		// }
		// System.out.println();
	}

	public void addClientes(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public Conta getContaPorNumero(int numeroContaDeposito) {

		return contas.stream()
				.filter(conta -> conta.getAgencia() == Conta.AGENCIA_PADRAO && conta.getNumero() == numeroContaDeposito)
				.findFirst().orElse(null);

	}

	// @Override
	// public String toString() {
	// 	return "Banco [nome=" + nome + ", contas=" + contas + ", clientes=" + clientes + "]";
	// }

}
