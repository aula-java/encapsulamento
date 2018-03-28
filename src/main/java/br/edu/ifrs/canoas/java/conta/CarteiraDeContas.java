package br.edu.ifrs.canoas.java.conta;

public class CarteiraDeContas {

	public Conta minhasContas[];

	public boolean criaContas(int tamanho) {
		if (tamanho < 1)
			return false;
		
		minhasContas = new Conta[tamanho];
		
		for (int i = 0; i < minhasContas.length; i++) {
			minhasContas[i] = new Conta();
		}
		
		return true;
	}

	public boolean depositaNaConta(int posicao, double quantidade) {
		if (posicao < 0 || posicao >= minhasContas.length)
			return false;
		
		minhasContas[posicao].deposita(quantidade);
		return true;
	}

	public double getSaldoTotalDaCarteira() {
		double total=0;
		
		for (Conta conta : minhasContas) {
			total += conta.saldo;
		}
		return total;
	}

}
