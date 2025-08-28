package dio;

import dio.conta.Conta;
import dio.conta.ContaCorrente;
import dio.conta.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
       Cliente venilton = new Cliente();
       venilton.setNome("Venilton");
       
       Conta cc = new ContaCorrente(venilton);
       Conta poupanca = new ContaPoupanca(venilton);

       cc.depositar(100);
       cc.transferir(100, poupanca);
       
       cc.imprimirExtrato();
       poupanca.imprimirExtrato();
    }

}