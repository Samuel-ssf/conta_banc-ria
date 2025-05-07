package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", numero);
	}

	@Override
	public void listarTodas() {
		for (var conta : ListaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void listarPorTitular(String titular) {

		List<Conta> listaTitulares = ListaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());

		if (listaTitulares.isEmpty())
			System.out.printf("\nNenhuma conta foi encontrada com base no criterio: %s", titular);

		for (var conta : listaTitulares)
			conta.visualizar();
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
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			ListaContas.set(ListaContas.indexOf(buscaConta.get()), conta);
			System.out.println("Dados Anteriores");
			buscaConta.get().visualizar();
			System.out.println("Dados Atualizados");
			procurarPorNumero(buscaConta.get().getNumero());
			System.out.printf("\nA Conta Número %d foi Atualizada com sucesso!", conta.getNumero());

		} else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", conta.getNumero());

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (ListaContas.remove(conta.get()) == true)
				System.out.printf("\nA Conta número %d foi excluida com sucesso!", numero);
		} else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", numero);

	}

	@Override
	public void sacar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.printf("\nO Saque no valor de %s, foi efetuado com sucesso na conta de Número %d!",
						nfMoeda.format(valor), numero);
		} else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", numero);
	}

	@Override
	public void depositar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("\nO Deposito no valor de %s, foi efetuado com sucesso na conta de Número %d!",
					nfMoeda.format(valor), numero);

		} else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", numero);
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isEmpty()) {
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.printf("\nA transferência no valor de %s, para a Conta Número %d, foi efetuada com sucesso!",
						nfMoeda.format(valor), numero);

			}

		} else
			System.out.printf("\nA Conta Número %d não foi Encontrada!", numero);
	}

	public int gerarNumero() {
		return ++numero;

	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : ListaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

}
