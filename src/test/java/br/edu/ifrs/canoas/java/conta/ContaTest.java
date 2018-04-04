package br.edu.ifrs.canoas.java.conta;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	Conta contas[];
	
	@Before
	public void setup() {
		contas = new Conta[10];
	}
	
	@Test
	public void testaArrayDeContas() {
		contas[0] = new Conta(new Cliente(""));
		contas[0].setSaldo(100);
		contas[0].deposita(50);
		assertEquals("O saldo deve ser 100+50=150", 150, contas[0].getSaldo(),0);
	}
}
