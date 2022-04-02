
import java.util.List;
import java.util.ArrayList;

    public class Banco {

        private String nome;
        private List<Conta> contas = new ArrayList<>();

        public Banco (String nome) {
            this.nome = nome;
        }

        public Banco () { }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public List<Conta> getContas() {
            return contas;
        }

        public void setContas(List<Conta> contas) {
            this.contas = contas;
        }

        public void adicionarConta(Conta conta) {
            this.contas.add(conta);
        }

    }

