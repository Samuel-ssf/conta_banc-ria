package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
		if ((this.getSaldo() + this.limite) < valor) {
			System.out.println("Saldo Insuficiente!");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	@Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar();
		System.out.println("* LIMITE DA CONTA: " + nfMoeda.format(this.limite));
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("********************************************************");
		System.out.println(Cores.TEXT_RESET);


	}

}
