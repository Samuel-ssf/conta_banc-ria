package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public class Conta {

	// Atributos da Classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// Metodo Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Conta() {}

	// Metodo Get e Set
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	// Metodos Bancários

	public boolean sacar(float valor) {
		if (this.saldo < valor) {
			System.out.println("\nSaldo é Insuficiente");
			return false;
		}

		this.saldo -= valor;
		return true;

	}

	public void depositar(float valor) {
		this.saldo += valor;
	}
	
	// Método para visualizar os dados da conta
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Invalido";
		}
		
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println("*                   DADOS DA CONTA                     *");
		System.out.println("********************************************************");
		System.out.println("" + Cores.TEXT_RESET);
		System.out.println("* NÚMERO DA CONTA: " + this.numero);
		System.out.println("* NÚMERO DA AGENCIA: " + this.agencia);
		System.out.println("* TIPO DA CONTA: " + tipo);
		System.out.println("* TITULAR DA CONTA: " + this.titular);
		System.out.println("* SALDO DA CONTA: " + nfMoeda.format(this.saldo));
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println("" + Cores.TEXT_RESET);
		System.out.println("\n");

		

	}

}
