public class Main {

        public static void main(String[] args) {
4
            Utils utils = new Utils();
            int menu = 0;

            Banco banco = new Banco("Meu Banco Digital");

            while (menu != 9) {

                if (menu == 0 || menu == 8) {
                    menu = utils.viewMenu();
                }

                if (menu == 1 || menu == 2) {
                    banco = utils.criarConta(menu, banco);
                    menu = 8;
                }

                if (menu == 3) {
                    menu = utils.verContas(banco);
                }

                if (menu == 4) {
                    menu = utils.verExtrato(banco);
                }

                if (menu == 5) {
                    banco = utils.depositar(banco);
                    menu = 8;
                }

                if (menu == 6) {
                    banco = utils.sacar(banco);
                    menu = 8;
                }

                if (menu == 7) {
                    banco = utils.transferir(banco);
                    menu = 8;
                }

                if (menu > 9) {
                    System.out.println("OPERAÇÂO INVÁLIDA!\n\n");
                    menu = 0;
                }

            }

        }

    }

