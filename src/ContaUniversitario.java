public class ContaUniversitario extends Conta {

    public ContaUniversitario(Cliente cliente, Agencia agencia) throws NaoUniversitarioException {
        super(cliente, agencia);
        if(!cliente.isEstudando()) throw new NaoUniversitarioException();
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Universitario ===");
        super.imprimirInfosComuns();
    }
    
}
