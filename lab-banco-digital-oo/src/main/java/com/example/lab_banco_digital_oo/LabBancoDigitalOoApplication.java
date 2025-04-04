package com.example.lab_banco_digital_oo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabBancoDigitalOoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabBancoDigitalOoApplication.class, args);
		SistemaBancario sistemaBancario = new SistemaBancario();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("=== Menu ===");

			System.out.println("0 - Cadastrar Banco");
			System.out.println("1 - Cadastrar Conta Corrente");
			System.out.println("2 - Cadastrar Conta Poupança");
			System.out.println("3 - Listar Contas por Banco");
			System.out.println("4 - Depositar");
			System.out.println("5 - Sacar");
			System.out.println("6 - Transferir");
			System.out.println("7 - Imprimir Extrato");
			System.out.println("8 - Sair");
			System.out.println("=== Fim do Programa ===");

			switch (scanner.nextInt()) {
				case 0:
					System.out.println("=== Criar Banco ===");
					System.out.println("Digite o nome do banco:");
					String nomeBanco = scanner.next();
					sistemaBancario.addBanco(new Banco(nomeBanco));
					System.out.println("Banco " + nomeBanco + " criado com sucesso!");
					break;

				case 1:
					System.out.println("=== Cadastrar Conta Corrente ===");
					System.out.println("Digite o nome do cliente:");
					String nomeCliente = scanner.next();
					Cliente cliente = new Cliente();
					cliente.setNome(nomeCliente);
					System.out.println("Digite o nome do banco:");
					String bancoNome = scanner.next();
					Banco banco = sistemaBancario.getBancoPorNome(bancoNome);
					if (banco == null) {
						System.out.println("Banco não encontrado. Realizando cadastro de Banco.");
						Banco novoBanco = new Banco(bancoNome);
						sistemaBancario.addBanco(novoBanco);
						banco = novoBanco;
						System.out.println("Banco " + bancoNome + " criado com sucesso!");
						System.out.println("Criando conta corrente para o cliente " + nomeCliente);

						Conta contaCorrente = new ContaCorrente(cliente);
						banco.addContas(contaCorrente);
						contaCorrente.setAgencia(1);
						contaCorrente.setSaldo(200);
						contaCorrente.setCliente(cliente);
						contaCorrente.setNomeBanco(banco.getNome());
						banco.addClientes(cliente);

					} else {

						Conta contaCorrente = new ContaCorrente(cliente);
						banco.addContas(contaCorrente);
						contaCorrente.setAgencia(1);
						contaCorrente.setSaldo(200);
						contaCorrente.setCliente(cliente);
						contaCorrente.setNomeBanco(banco.getNome());
						banco.addClientes(cliente);

						break;
					}

					break;
				case 2:
					System.out.println("=== Cadastrar Conta Poupança ===");
					System.out.println("Digite o nome do cliente:");
					String nomeClientePoupanca = scanner.next();
					Cliente clientePoupanca = new Cliente();
					clientePoupanca.setNome(nomeClientePoupanca);
					System.out.println("Digite o nome do banco:");
					String bancoNomePoupanca = scanner.next();
					Banco bancoPoupanca = sistemaBancario.getBancoPorNome(bancoNomePoupanca);
					if (bancoPoupanca == null) {

						System.out.println("Banco não encontrado. Realizando cadastro de Banco.");
						Banco novoBanco = new Banco(bancoNomePoupanca);
						sistemaBancario.addBanco(novoBanco);
						bancoPoupanca = novoBanco;
						System.out.println("Banco " + bancoNomePoupanca + " criado com sucesso!");
						System.out.println("Criando conta Poupança para o cliente " + nomeClientePoupanca);

						Conta contaPoupanca = new ContaPoupanca(clientePoupanca);
						bancoPoupanca.addContas(contaPoupanca);
						contaPoupanca.setAgencia(2);
						contaPoupanca.setSaldo(1000);
						contaPoupanca.setCliente(clientePoupanca);
						contaPoupanca.setNomeBanco(bancoPoupanca.getNome());
						bancoPoupanca.addClientes(clientePoupanca);

					} else {
						System.out.println("Criando conta Poupança para o cliente " + nomeClientePoupanca);
						Conta contaPoupanca = new ContaPoupanca(clientePoupanca);
						bancoPoupanca.addContas(contaPoupanca);
						contaPoupanca.setAgencia(2);
						contaPoupanca.setSaldo(1000);
						contaPoupanca.setCliente(clientePoupanca);
						contaPoupanca.setNomeBanco(bancoPoupanca.getNome());
						bancoPoupanca.addClientes(clientePoupanca);

						break;
					}
				case 3:
					System.out.println("=== Listar Contas ===");
					System.out.println("Digite o nome do banco:");
					String bancoListarNome = scanner.next();

					Banco bancoListar = sistemaBancario.getBancoPorNome(bancoListarNome);
					if (bancoListar != null) {
						bancoListar.listarContas();
					} else {
						System.out.println("Banco não encontrado.");
						break;
					}
					break;

				case 4:
					System.out.println("=== Depositar ===");
					System.out.println("Digite o nome do banco:");
					String bancoDepositoNome = scanner.next();
					Banco bancoDeposito = sistemaBancario.getBancoPorNome(bancoDepositoNome);

					if (bancoDeposito != null) {
						System.out.println("Digite o número da conta:");
						int numeroContaDeposito = scanner.nextInt();
						Conta contaDeposito = bancoDeposito.getContaPorNumero(numeroContaDeposito);
						if (contaDeposito != null) {
							System.out.println("Digite o valor a ser depositado:");
							double valorDeposito = scanner.nextDouble();
							contaDeposito.depositar(valorDeposito);
							System.out.println("Depósito realizado com sucesso!");
						} else {
							System.out.println("Conta não encontrada.");
						}
					} else {
						System.out.println("Banco não encontrado.");

					}
					break;
				case 5:
					System.out.println("=== Sacar ===");
					System.out.println("Digite o nome do banco:");
					String bancoSacarNome = scanner.next();
					Banco bancoSacar = sistemaBancario.getBancoPorNome(bancoSacarNome);
					if (bancoSacar != null) {
						System.out.println("Digite o número da conta:");
						int numeroContaSacar = scanner.nextInt();
						Conta contaSacar = bancoSacar.getContaPorNumero(numeroContaSacar);
						if (contaSacar != null) {
							System.out.println("Digite o valor a ser sacado:");
							double valorSacar = scanner.nextDouble();
							contaSacar.sacar(valorSacar);
							System.out.println("Saque realizado com sucesso!");
						} else {
							System.out.println("Conta não encontrada.");
						}
					} else {
						System.out.println("Banco não encontrado.");
					}
					break;
				case 6:
					System.out.println("=== Transferir ===");
					System.out.println("Digite o nome do banco:");
					String bancoTransferirNome = scanner.next();
					Banco bancoTransferir = sistemaBancario.getBancoPorNome(bancoTransferirNome);
					if (bancoTransferir != null) {
						System.out.println("Digite o número da conta de origem:");
						int numeroContaOrigem = scanner.nextInt();
						Conta contaOrigem = bancoTransferir.getContaPorNumero(numeroContaOrigem);
						if (contaOrigem != null) {
							System.out.println("Digite o número da conta de destino:");
							int numeroContaDestino = scanner.nextInt();
							Conta contaDestino = bancoTransferir.getContaPorNumero(numeroContaDestino);
							if (contaDestino != null) {
								System.out.println("Digite o valor a ser transferido:");
								double valorTransferir = scanner.nextDouble();
								contaOrigem.transferir(valorTransferir, contaDestino);
								System.out.println("Transferência realizada com sucesso!");
							} else {
								System.out.println("Conta de destino não encontrada.");
							}
						} else {
							System.out.println("Conta de origem não encontrada.");
						}
					} else {
						System.out.println("Banco não encontrado.");
					}
					break;

				case 7:
					System.out.println("=== Imprimir Extrato ===");
					System.out.println("Digite o nome do banco:");
					String bancoExtratoNome = scanner.next();
					Banco bancoExtrato = sistemaBancario.getBancoPorNome(bancoExtratoNome);
					if (bancoExtrato != null) {
						System.out.println("Digite o número da conta:");
						int numeroContaExtrato = scanner.nextInt();
						Conta contaExtrato = bancoExtrato.getContaPorNumero(numeroContaExtrato);
						if (contaExtrato != null) {
							contaExtrato.imprimirExtrato();
						} else {
							System.out.println("Conta não encontrada.");
						}
					} else {
						System.out.println("Banco não encontrado.");
					}
					break;
				case 8:
					System.out.println("=== Sair ===");
					System.out.println("Saindo do sistema...");
					scanner.close();
					return;

				default:

					break;
			}

		}

	}

	public void cadastroBancario() {

	}

}
