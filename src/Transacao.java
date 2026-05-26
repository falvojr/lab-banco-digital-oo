import java.time.LocalDateTime;
import java.util.Optional;

public class Transacao {


    public enum TipoTransacao{
        SAQUE,
        DEPOSITO,
        TRANSFERENCIA;

    }
    private final TipoTransacao tipo;

    private final LocalDateTime data;

    private final double valor;

    private final IConta contaDestino;

    public Transacao(TipoTransacao tipo, LocalDateTime data, double valor) {
        this(tipo, data, valor, null);
    }

    public Transacao(TipoTransacao tipo, LocalDateTime data,
                     double valor, IConta contaDestino) {

        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                ", tipo=" + tipo +
                ", data=" + data +
                ", valor=" + valor +
                "contaDestino=" + (contaDestino != null ? contaDestino.getNumero() : "N/A") +
                '}';
    }
}
