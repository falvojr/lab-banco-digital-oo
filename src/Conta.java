
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
		if (valor <= 0) {
			System.out.println("❌ Erro: Valor de saque deve ser maior que zero!");
			return;
		}
		
		if (valor > this.saldo) {
			System.out.println("❌ Erro: Saldo insuficiente!");
			System.out.println("   Saldo disponível: R$ " + String.format("%.2f", this.saldo));
			System.out.println("   Valor solicitado: R$ " + String.format("%.2f", valor));
			return;
		}
		
		this.saldo -= valor;
		System.out.println("✅ Saque realizado com sucesso!");
		System.out.println("   Valor: R$ " + String.format("%.2f", valor));
		System.out.println("   Saldo atual: R$ " + String.format("%.2f", this.saldo));
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			System.out.println("❌ Erro: Valor de depósito deve ser maior que zero!");
			return;
		}
		
		this.saldo += valor;
		System.out.println("✅ Depósito realizado com sucesso!");
		System.out.println("   Valor: R$ " + String.format("%.2f", valor));
		System.out.println("   Saldo atual: R$ " + String.format("%.2f", this.saldo));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (valor <= 0) {
			System.out.println("❌ Erro: Valor de transferência deve ser maior que zero!");
			return;
		}
		
		if (valor > this.saldo) {
			System.out.println("❌ Erro: Saldo insuficiente para transferência!");
			System.out.println("   Saldo disponível: R$ " + String.format("%.2f", this.saldo));
			System.out.println("   Valor solicitado: R$ " + String.format("%.2f", valor));
			return;
		}
		
		this.saldo -= valor;
		contaDestino.depositar(valor);
		System.out.println("✅ Transferência realizada com sucesso!");
		System.out.println("   Valor: R$ " + String.format("%.2f", valor));
		System.out.println("   Seu saldo atual: R$ " + String.format("%.2f", this.saldo));
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
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
	}
}
