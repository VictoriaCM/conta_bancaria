package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
			
		while (true) {
			System.out.println(Cores.TEXT_BLACK_BOLD +
					Cores.ANSI_WHITE_BACKGROUND +
					"******************************************************");
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
			System.out.println("******************************************************"
			+ Cores.TEXT_RESET);
			
			opcao = sc.nextInt();
			
			if (opcao==9) {
				System.out.println("\nNosso, seu, Meow Bank!");
				sobre();
				sc.close();
				System.exit(0);
				
				switch (opcao) {
				case 1:
					System.out.println("Criar Conta \n\n");
					
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
		System.out.println(Cores.TEXT_BLACK_BOLD +
				Cores.ANSI_WHITE_BACKGROUND + "\n******************************************************");
		System.out.println("|Projeto desenvolvido por:                           |");
		System.out.println("|Victória Moraes - victoria.candido.mm@gmail.com     |");                          
		System.out.println("|https://github.com/VictoriaCM                       |");
		System.out.println("******************************************************" + Cores.TEXT_RESET);

	}

}
