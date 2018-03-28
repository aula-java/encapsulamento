package br.edu.ifrs.canoas.java.conta;

public class Conta {
	int numero;
	double saldo;
	double limite;
	Cliente titular;

	boolean saca(double valor) {
		if (this.saldo < valor) {
			return false;
		} else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}

	void deposita(double quantidade) {
		this.saldo += quantidade;
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

}
