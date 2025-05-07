package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		// Dados para teste
		// ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da
		// Silva", 1000.00f, 100.00f);
		// contas.cadastrar(cc1);
		// ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da
		// Silva", 1000.00f, 12);
		// contas.cadastrar(cp1);

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
			System.out.println("*              9 - Listar Contas Por Titular           *");
			System.out.println("*              0 - Sair                                *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*              ENTRE COM A OPÇÃO DESEJADA:             *");
			System.out.println("********************************************************" + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
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

				System.out.println("Digite o Número da Conta:");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);

				if (conta.isPresent()) {
					System.out.println("Digite o Número da Agência:");
					agencia = leia.nextInt();

					System.out.println("\nDigite o Nome do Titular:");
					leia.skip("\\R");
					titular = leia.nextLine();

					tipo = conta.get().getTipo();

					System.out.println("\nDigite o Tipo da Conta (1 - CC | 2 - CP:");
					tipo = leia.nextInt();

					System.out.println("\nDigite o novo Saldo Inicial da Conta:");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("\nDigite o Limite da Conta:");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("\nDigite o Dia do Aniversário da Conta:");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					}

				} else
					System.out.printf("\n Aconta número %d nao existe!", numero);

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				System.out.println("Digite o Número da Conta:");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				System.out.println("Digite o Número da Conta:");
				numero = leia.nextInt();

				System.out.println("Digite o Valor do Saque:");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				System.out.println("Digite o Número da Conta:");
				numero = leia.nextInt();

				System.out.println("Digite o Valor do Depósito:");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				System.out.println("Digite o Número da Conta de Origem:");
				numero = leia.nextInt();

				System.out.println("Digite o Número da Conta de destino:");
				numeroDestino = leia.nextInt();

				System.out.println("Digite o Valor do Deposito:");
				valor = leia.nextFloat();

				contas.transferir(numero, numeroDestino, valor);
				

				keyPress();
				break;
			case 9:
				System.out.println("\nListar Contas por Titular: ");
				
				System.out.println("\nDigite o nome do Titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();
				
				contas.listarPorTitular(titular);
				
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
			int input;
			while ((input = System.in.read()) != '\n') {

				// Ignora qualquer outra tecla diferente do Enter
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {	
			System.err.println("Erro de entrada/saída: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
	        
		}
	}
}
