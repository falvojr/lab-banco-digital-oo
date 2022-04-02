import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Utils {

    private final Scanner scannerMenu = new Scanner(System.in);

    public int viewMenu() {

        System.out.print("( 1 ) Cadastrar nova Conta Corrente ");
        System.out.print("( 2 ) : Cadastrar nova Conta Poupança ");
        System.out.print("( 3 ) Ver Contas Cadastradas\n");
        System.out.print("( 4 ) Consultar Extrato ");
        System.out.print("( 5 ) Depositar ");
        System.out.print("( 6 ) Sacar ");
        System.out.print("( 7 ) Transferir ");
        System.out.print("( 9 ) Sair\n");
        System.out.print("Digite a opção desejada: ");
        return scannerMenu.nextInt();

    }

    public Banco criarConta(int type, Banco banco) {

        Scanner scannerNome = new Scanner(System.in);

        String nome = "";

        while (nome.equals("")) {
            System.out.print("Por favor, Digite o Nome do Cliente: ");
            nome = scannerNome.nextLine();
        }

        Cliente newCliente = new Cliente(nome);

        Conta newAccount;

        if (type == 1) {
            newAccount = new ContaCorrente(newCliente);
        } else {
            newAccount = new ContaPoupanca(newCliente);
        }

        banco.adicionarConta(newAccount);

        System.out.println("NOVA CONTA CADASTRADA!\n\n");

        return banco;

    }

    public int verContas(Banco banco) {

        if (banco.getContas().size() > 0) {
            System.out.println("=== CONTAS REGISTRADAS ===");
            for (int cont = 0; cont < banco.getContas().size(); cont++) {
                banco.getContas().get(cont).listarContas();
            }
            System.out.println("\n");
        } else {
            System.out.println("NÃƒO CONSTAM CONTAS REGISTRADAS!\n\n");
        }

        return 8;

    }

    public int verExtrato(Banco banco) {

        Scanner scannerConta = new Scanner(System.in);
        String conta = "";

        while (conta.equals("")) {
            System.out.print("Por favor, Digite o Número da Conta: ");
            conta = scannerConta.nextLine();
        }

        int localizacaoConta = buscaConta(banco, parseInt(conta));

        if (localizacaoConta != -1) {
            banco.getContas().get(localizacaoConta).imprimirExtrato();
        } else {
            System.out.println("CONTA NÃO LOCALIZADA!\n\n");
        }

        return 8;

    }

    public Banco depositar(Banco banco) {

        Scanner scannerConta = new Scanner(System.in);
        Scanner scannerValor = new Scanner(System.in);
        String conta = "";
        String valor = "";

        while (conta.equals("")) {
            System.out.print("Por favor, Digite o Número da Conta: ");
            conta = scannerConta.nextLine();
        }

        int localizacaoConta = buscaConta(banco, parseInt(conta));

        if (localizacaoConta != -1) {

            while (valor.equals("")) {
                System.out.print("Por favor, Digite o Valor do Deposito: ");
                valor = scannerValor.nextLine();
            }

            banco.getContas().get(localizacaoConta).depositar(Double.parseDouble(valor));
            System.out.println("DEPÓSITO REALIZADO!\n\n");

        } else {
            System.out.println("CONTA NÃO LOCALIZADA!\n\n");
        }

        return banco;

    }

    public Banco sacar(Banco banco) {

        Scanner scannerConta = new Scanner(System.in);
        Scanner scannerValor = new Scanner(System.in);
        String conta = "";
        String valor = "";

        while (conta.equals("")) {
            System.out.print("Por favor, Digite o NÃºmero da Conta: ");
            conta = scannerConta.nextLine();
        }

        int localizacaoConta = buscaConta(banco, parseInt(conta));

        if (localizacaoConta != -1) {

            while (valor.equals("")) {
                System.out.print("Por favor, Digite o Valor do Saque: ");
                valor = scannerValor.nextLine();
            }

            if (banco.getContas().get(localizacaoConta).getSaldo() >= Double.parseDouble(valor)) {
                banco.getContas().get(localizacaoConta).sacar(Double.parseDouble(valor));
                System.out.println("SAQUE REALIZADO!\n\n");
            } else {
                System.out.println("SALDO INSUFICIENTE PARA REALIZAR O SAQUE!\n\n");
            }

        } else {
            System.out.println("CONTA NÃƒO LOCALIZADA!\n\n");
        }

        return banco;

    }

    public Banco transferir(Banco banco) {

        Scanner scannerContaOrigem = new Scanner(System.in);
        Scanner scannerContaDestino = new Scanner(System.in);
        Scanner scannerValor = new Scanner(System.in);
        String contaOrigem = "";
        String contaDestino = "";
        String valor = "0";

        while (contaOrigem.equals("")) {
            System.out.print("Por favor, Digite o NÃºmero da Conta de Origem: ");
            contaOrigem = scannerContaOrigem.nextLine();
        }

        while (contaDestino.equals("")) {
            System.out.print("Por favor, Digite o NÃºmero da Conta de Destino: ");
            contaDestino = scannerContaDestino.nextLine();
        }

        int localizacaoContaOrigem = buscaConta(banco, parseInt(contaOrigem));
        int localizacaoContaDestino = buscaConta(banco, parseInt(contaDestino));

        if (localizacaoContaOrigem != -1 && localizacaoContaDestino != -1) {

            while (Double.parseDouble(valor) <= 0) {
                System.out.print("Por favor, Digite o Valor da TransferÃªncia: ");
                valor = scannerValor.nextLine();
            }

            if (banco.getContas().get(localizacaoContaOrigem).getSaldo() >= Double.parseDouble(valor)) {
                banco.getContas().get(localizacaoContaOrigem).sacar(Double.parseDouble(valor));
                banco.getContas().get(localizacaoContaDestino).depositar(Double.parseDouble(valor));
                System.out.println("TRANSFERÃŠNCIA REALIZADA!\n\n");
            } else {
                System.out.println("SALDO INSUFICIENTE PARA REALIZAR A TRANSFERÃŠNCIA!\n\n");
            }

        } else {
            System.out.println("NÃƒO LOCALIZAMOS A CONTA DE ORIGEM E/OU DESTINO!\n\n");
        }

        return banco;

    }

    private int buscaConta(Banco banco, int conta) {

        int localizacao = -1;

        for (int cont = 0; cont < banco.getContas().size(); cont++) {
            if (banco.getContas().get(cont).getNumero() == conta) {
                localizacao = cont;
                break;
            }
        }

        return localizacao;

    }

}
