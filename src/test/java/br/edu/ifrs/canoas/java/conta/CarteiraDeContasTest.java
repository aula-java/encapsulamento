package br.edu.ifrs.canoas.java.conta;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CarteiraDeContasTest {
	CarteiraDeContas carteira;
	
	@Before
	public void setup() {
		carteira = new CarteiraDeContas();
	}

	@Test
	public void testCriaContasCom10() {
		carteira.criaContas(10);
		assertEquals("Foi criada uma carteira com 10 contas", 10, 
				carteira.getMinhasContas().length);
	}
	
	@Test
	public void testCriaContasComNegativo() {
		carteira.criaContas(-1);
		assertNull("O tamanho eh NULL pois n�o foi criado o array "
				+ "com valor negativo",carteira.getMinhasContas());
	}
	

	@Test
	public void testCriaContasComZero() {
		assertFalse("Deve retornar Falso pois nao eh possivel criar contas com Zero", carteira.criaContas(0));
		assertNull("O tamanho eh NULL pois n�o foi criado o array com valor Zero",
				carteira.getMinhasContas());
	}

	@Test(expected = NullPointerException.class)
	public void testAtualizaSaldoContaComContaNula() {
		carteira.depositaNaConta(0, 500);
	}
	
	@Test
	public void testAtualizaSaldoContaCom100() {
		carteira.criaContas(5);
		assertTrue("Eh possivel adicionar 100 na conta 0", carteira.depositaNaConta(0, 100));
		assertEquals("O saldo da posicao 0 deve ser 100", 100, carteira.getMinhasContas()[0].getSaldo(),0);
		assertTrue("Eh possivel adicionar -5 na conta 0", carteira.depositaNaConta(0, -5));
		assertEquals("O saldo da posicao 0 deve ser 100", 95, carteira.getMinhasContas()[0].getSaldo(),0);
		assertFalse("N�o eh possivel sacar mais que o limite", carteira.getMinhasContas()[0].saca(100));
		assertTrue("Eh possivel sacar ate o limite", carteira.getMinhasContas()[0].saca(95));
	}
	
	@Test
	public void testAtualizaSaldoCompoPosicaoInvalida() {
		carteira.criaContas(5);
		assertFalse("N�o eh depositar em posicao invalida", carteira.depositaNaConta(5, 100));	
	}
	
	@Test
	public void testNaoEhPossivelAtualizarSaldoForaDoLimiteDoArray() {
		carteira.criaContas(5);
		assertFalse("Nao eh possivel depositar em uma posicao invalida do array", carteira.depositaNaConta(5, 100));
		assertFalse("Nao eh possivel depositar em uma posicao invalida do array", carteira.depositaNaConta(-1, 100));
	}
	
	@Test
	public void testGetSaldoTotalDaCarteira() {
		carteira.criaContas(5);
		carteira.depositaNaConta(0, 100);
		carteira.depositaNaConta(0, 100);
		carteira.depositaNaConta(1, 300);
		assertEquals("O saldo da carteira eh 500", 500, carteira.getSaldoTotalDaCarteira(),0);
		carteira.depositaNaConta(-1, 100);
		assertEquals("O saldo da carteira eh 500", 500, carteira.getSaldoTotalDaCarteira(),0);
	}

}
