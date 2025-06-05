import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime dataHora;
    private String descricao;
    
    public Transacao(TipoTransacao tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
    }
    
    // Getters
    public TipoTransacao getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("%s - %s: R$ %.2f - %s", 
        dataHora.format(formatter), tipo, valor, descricao);
    }
}