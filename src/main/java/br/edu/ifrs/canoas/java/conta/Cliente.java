package br.edu.ifrs.canoas.java.conta;

public class Cliente {
	private String nome;
	private String sobrenome;
	private String cpf;
	private int identificador;
	private static int contador;
	
	public Cliente(String cpf) {
		identificador = Cliente.contador+ 1;
		
		if (this.validaCpf(cpf)) 
			this.cpf=cpf;
	}
	
	private boolean validaCpf(String cpf) {
		return (cpf != null && cpf.length()==11);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public static int getContador() {
		return Cliente.contador;
	}


}
