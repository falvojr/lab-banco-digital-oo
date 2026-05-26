import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private final List<Transacao> historico = new ArrayList<>();
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
		saldo -= valor;
		criarTransacao(Transacao.TipoTransacao.SAQUE, valor);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		criarTransacao(Transacao.TipoTransacao.DEPOSITO, valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.saldo -= valor;
		contaDestino.depositar(valor);
		criarTransacao(Transacao.TipoTransacao.TRANSFERENCIA, valor, contaDestino);
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


	protected void imprimirHistorico(){
		this.historico.forEach(System.out::println);
	}


	public void criarTransacao(Transacao.TipoTransacao tipo, double valor){

		Transacao transacao = new Transacao(
				tipo,
				LocalDateTime.now().withNano(0),
				valor
		);

		salvaNoHistorico(transacao);
	}

	public void criarTransacao(Transacao.TipoTransacao tipo, double valor, IConta contaDestino) {

		Transacao transacao = new Transacao(
				tipo,
				LocalDateTime.now().withNano(0),
				valor,
				contaDestino
		);

		salvaNoHistorico(transacao);
	}


	public void salvaNoHistorico(Transacao transacao){
		historico.add(transacao);

	}

}
