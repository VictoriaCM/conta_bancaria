package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;


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

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}
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
					keyPress();
					break;

				case 3:
					System.out.println("Consultar dados da Conta \n\n");

					System.out.println("Digite o número da conta: ");
					numero = sc.nextInt();

					keyPress();
					break;

				case 4:
					System.out.println("Atualizar Dados da Conta \n\n");
					
					System.out.println("Digite o numero da Conta: ");
					numero = sc.nextInt();
					
					Optional <Conta> conta = contas.buscarNaCollection(numero);
					
					if(conta.isPresent()) {
						System.out.println("Digite o número da Agência: ");
						agencia = sc.nextInt();

						System.out.println("Digite o número do Titular: ");
						sc.skip("\\R");
						titular = sc.nextLine();

						System.out.println("Digite o Saldo da conta: ");
						saldo = sc.nextFloat();
						
						tipo = conta.get().getTipo();
						
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

						
					}else
						System.out.println("A conta número:" + numero + "não foi encontrada!");
					keyPress();
					break;

				case 5:
					System.out.println("Encerrar Conta \n\n");
					
					System.out.println("Digite o numero da Conta: ");
					numero = sc.nextInt();
					
					contas.deletar(numero);
					
					keyPress();
					break;

				case 6:
					System.out.println("Saque \n\n");
					
					System.out.println("Digite o Numero da Conta: ");
					saldo = sc.nextInt();
					
					System.out.println("Digite o Valor do Saque: ");
					saldo = sc.nextFloat();
					
					contas.sacar(numero, valor);
					keyPress();
					break;

				case 7:
					System.out.println("Depósito \n\n");
					keyPress();
					break;

				case 8:
					System.out.println("Transferência entre Contas \n\n");
					keyPress();
					break;

				default:
					System.out.println("Opção Inválida! tente novamente.\n");
					keyPress();
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

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida");
		}
	}
}
