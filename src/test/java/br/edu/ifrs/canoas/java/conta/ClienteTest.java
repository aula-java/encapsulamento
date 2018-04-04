package br.edu.ifrs.canoas.java.conta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente;
	
	@BeforeClass
	public static void testaPrimeiroIdComoUm() {
		assertEquals(Cliente.getContador(),0);
	}
	
	@Before
	public void given() {
		cliente = new Cliente("");
	}
	
	@Test
	public void testId1() {
		//Given
		int id = cliente.getIdentificador();
		
		//when
		cliente = new Cliente("11111111111");
		
		//then
		assertEquals(id++, cliente.getIdentificador());
		
	}
	
	@Test
	public void testId2() {
		//Given
		int id = cliente.getIdentificador();
		
		//when
		cliente = new Cliente("1111111111");
		
		//then
		assertEquals(id++, cliente.getIdentificador());
		
	}
	
	@Test
	public void testClienteComCpfNulo() {
		//Given
		
		//when
		cliente = new Cliente(null);
		
		//then
		assertNull(cliente.getCpf());
		
	}
	
	@Test
	public void testClienteComCpfVazio() {
		//Given
		
		//when
		cliente = new Cliente("");
		
		//then
		assertNull(cliente.getCpf());
		
	}
	
	@Test
	public void testClienteComCpfUm() {
		//Given
		
		//when
		cliente = new Cliente("1");
		
		//then
		assertNull(cliente.getCpf());
		
	}
	@Test
	public void testClienteComCpfValido() {
		//Given
		String cpf = "11111111111";
		//when
		cliente = new Cliente(cpf);
		
		//then
		assertEquals(cpf, cliente.getCpf());
		
	}

}
