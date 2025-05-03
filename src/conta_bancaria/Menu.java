package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		//Dados para teste 
		//ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		//contas.cadastrar(cc1);
		//ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		//contas.cadastrar(cp1);

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
			System.out.println("*              ENTRE COM A OPÇÃO DESEJADA:             *");
			System.out.println("********************************************************" + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("********************************************************");
				System.out.println("BANCO DO BRASIL COM Z - O SEU FUTURO COMESSA AQUI !!   *");
				System.out.println("********************************************************");
				System.out.println(Cores.TEXT_RESET);

				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				
				System.out.println("Digite o Número da Agência:");
				agencia = leia.nextInt();

				System.out.println("\nDigite o Nome do Titular:");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("\nDigite o Tipo da Conta (1 - CC | 2 - CP:");
				tipo = leia.nextInt();

				System.out.println("\nDigite o Saldo Inicial da Conta:");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("\nDigite o Limite da Conta:");
					limite = leia.nextInt();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("\nDigite o Dia do Aniversário da Conta:");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
			}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o Número da Conta:");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("\n********************************************************");
		System.out.println("PROJETO DESENVOLVIDO POR:                              *");
		System.out.println("Samuel de Jesus Silva - samueldjsferreira@gemail.com   *");
		System.out.println("https://github.com/Samuel-ssf                          *");
		System.out.println("********************************************************");
		System.out.println(Cores.TEXT_RESET);

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.err.println("Ocorreu um erro ao tentar ler o teclado");

		}
	}
}
