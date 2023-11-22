package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.0f, 100.0f);
		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "João da Silva", 1000.0f, 9);
		contas.cadastrar(cp1);

		int opcao;

		while (true) {
			System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND
					+ "******************************************************");
			System.out.println("|                                                    |");
			System.out.println("|                    Meow Bank                       |");
			System.out.println("|                                                    |");
			System.out.println("******************************************************");
			System.out.println("|                    Bem-vindo!                      |");
			System.out.println("|            1 - Criar Conta                         |");
			System.out.println("|            2 - Listar todas as Contas              |");
			System.out.println("|            3 - Buscar Conta por Numero             |");
			System.out.println("|            4 - Atualizar Dados da Conta            |");
			System.out.println("|            5 - Apagar Conta                        |");
			System.out.println("|            6 - Sacar                               |");
			System.out.println("|            7 - Depositar                           |");
			System.out.println("|            8 - Transferir valores entre Contas     |");
			System.out.println("|            9 - Sair                                |");
			System.out.println("|                                                    |");
			System.out.println("******************************************************");
			System.out.println("|Entre com a opção desejada:                         |");
			System.out.println("******************************************************" + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println("\nNosso, seu, Meow Bank!");
				sobre();
				sc.close();
				System.exit(0);

				switch (opcao) {
				case 1:
					System.out.println("Criar Conta \n\n");

					System.out.println("Digite o número da Agência: ");
					agencia = sc.nextInt();

					System.out.println("Digite o número do Titular: ");
					sc.skip("\\R");
					titular = sc.nextLine();

					System.out.println("Digite o tipo da conta (1 - CC OU 2 - CP: ");
					tipo = sc.nextInt();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = sc.nextFloat();
						contas.cadastrar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));

					}
					case 2 -> {
						System.out.println("Digite o dia  do Aniversário da Conta: ");
						aniversario = sc.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					}

					break;

				case 2:
					System.out.println("Listar todas as contas \n\n");

					break;

				case 3:
					System.out.println("Consultar dados da Conta \n\n");

					break;

				case 4:
					System.out.println("Atualizar Dados da Conta \n\n");

					break;

				case 5:
					System.out.println("Encerrar Conta \n\n");

					break;

				case 6:
					System.out.println("Saque \n\n");

					break;

				case 7:
					System.out.println("Depósito \n\n");

					break;

				case 8:
					System.out.println("Transferência entre Contas \n\n");

					break;

				default:
					System.out.println("Opção Inválida! tente novamente.\n");
					break;

				}
			}
		}
	}

	private static void sobre() {
		System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND
				+ "\n******************************************************");
		System.out.println("|Projeto desenvolvido por:                           |");
		System.out.println("|Victória Moraes - victoria.candido.mm@gmail.com     |");
		System.out.println("|https://github.com/VictoriaCM                       |");
		System.out.println("******************************************************" + Cores.TEXT_RESET);

	}

}
