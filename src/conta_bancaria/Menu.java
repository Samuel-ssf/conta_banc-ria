package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		
		Conta c1 = new Conta(1, 123, 1, "Samuel", 50000000);
		c1.visualizar();

		// Sacar
		c1.sacar(100);
		c1.visualizar();
		
		// Depositar
		c1.depositar(1000);
		c1.visualizar();

		// Alterar o Nome do Titular Samuel
		c1.setTitular("Samuel Silva");
		c1.visualizar();
		
		//Instanciando um objeto da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Sonia Inês", 600000, 60000);
		cc1.visualizar();
		
		cc1.sacar(661000);
		cc1.visualizar();
		
		cc1.depositar(50000);
		cc1.visualizar();
		
		while (true) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*                 BANCO DO BRAZIL COM Z                *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*              1 - Criar Conta                         *");
			System.out.println("*              2 - Listar Todas as Contas              *");
			System.out.println("*              3 - Buscar Conta por Numero             *");
			System.out.println("*              4 - Atualizar Dados da Conta            *");
			System.out.println("*              5 - Apagar Conta                        *");
			System.out.println("*              6 - Sacar                               *");
			System.out.println("*              7 - Depositar                           *");
			System.out.println("*              8 - Transferir Valores Entre Contas     *");
			System.out.println("*              9 - Sair                                *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("* Entre com a opção desejada:                          *");
			System.out.println("********************************************************" + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("********************************************************");
				System.out.println("Banco do Brazil com Z - O seu Futuro começa aqui!      *");
				System.out.println("********************************************************");
				System.out.println(Cores.TEXT_RESET);

				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

			case 2 -> System.out.println(Cores.TEXT_WHITE + "Listar Todas as Contas\n\n");

			case 3 -> System.out.println(Cores.TEXT_WHITE + "Consultar Dados da Conta - por Número\n\n");

			case 4 -> System.out.println(Cores.TEXT_WHITE + "Atualizar Dados da Conta\n\n");

			case 5 -> System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

			case 6 -> System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

			case 7 -> System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

			case 8 -> System.out.println(Cores.TEXT_WHITE + "Transferência Entre Contas\n\n");

			default -> System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("\n********************************************************");
		System.out.println("Projeto Desenvolvido por:                              *");
		System.out.println("Samuel de Jesus Silva - samueldjsferreira@gemail.com   *");
		System.out.println("https://github.com/Samuel-ssf                          *");
		System.out.println("********************************************************");
		System.out.println(Cores.TEXT_RESET);

	}

}
