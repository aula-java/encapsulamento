package br.edu.ifrs.canoas.java.conta;

public class Conta {
	private int numero;
	private double saldo;
	private double limite;
	private Cliente titular;
	
	public Conta(Cliente titular) {
		this.titular=titular;
	}

	boolean saca(double valor) {
		if (this.getSaldo() < valor) {
			return false;
		} else {
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
	}

	void deposita(double quantidade) {
		this.setSaldo(this.getSaldo() + quantidade);
	}

	boolean transfere(Conta destino, double valor) {
		boolean retirou = this.saca(valor);
		if (retirou == false) {
			// n??o foi poss??vel sacar
			return false;
		} else {
			destino.deposita(valor);
			return true;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
