
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
    public Boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        System.out.println("Saque não realizado: valor inválido ou saldo insuficiente.");
        return false;
    }

	@Override
    public Boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        System.out.println("Depósito não realizado: valor inválido.");
        return false;
    }

	@Override
    public Boolean transferir(double valor, IConta contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        System.out.println("Transferência não realizada.");
        return false;
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

	public Cliente getCliente() {
		return cliente;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
