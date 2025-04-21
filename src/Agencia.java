import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private int numero;
    private String localizacao;
    private List<Conta> contas;

    public Agencia(int numero, String localizacao) {
        this.numero = numero;
        this.localizacao = localizacao;
        this.contas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean addConta(Conta c) {
        if(c.agencia.getNumero() == this.numero)
            return contas.add(c);
        return false;
    }

    public void imprimirContas(){
        System.out.println("Lista de clientes Agencia " + numero );
        contas.stream().forEach(c -> System.out.println(c.cliente.getNome()));
    }
    
}
