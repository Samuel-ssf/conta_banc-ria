package conta_bancaria.controller;

import java.util.ArrayList;

import conta.repository.ContaRepository;
import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {

	// Criando a Collction Array List
	private ArrayList<Conta> ListaContas = new ArrayList<Conta>();

	// Variavel para controlar os números das Contas
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.printf("\nA Conta Número %d não foi Encontrada!",numero);
	}

	@Override
	public void listarTodas() {
		for (var conta : ListaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		ListaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println("*          SUA CONTA FOI CRIADA COM SUCESSO !          *");
		System.out.println("********************************************************" + Cores.TEXT_RESET);

	}

	@Override
	public void atualizar(Conta conta) {

	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// Metodos Auxiliares

	public int gerarNumero() {
		return ++ numero;

	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : ListaContas) {
			if (conta.getNumero() == numero)
				return conta;
		}

		return null;
	}
}
