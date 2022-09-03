package br.com.bancodedados.lancheria;

public class Cliente {

	private int Id;
	private String CPF;
	private String Nome;

	public Cliente() {

	}

	public Cliente(String cPF, String nome) {
		CPF = cPF;
		Nome = nome;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

}
