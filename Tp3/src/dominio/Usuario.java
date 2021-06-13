package dominio;

import exceptions.NomeIncompletoException;

public abstract class Usuario {
	private int id;
	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private int idade;

	public Usuario() {
		nome = null;
		idade = 0;
	}
	
	public Usuario(int idade) {
		this();
		this.idade = idade;
	}
	
	public Usuario(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}
	
	public abstract void imprimir() throws Exception;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial, posFinal).trim();
		this.ultimoNome = nome.substring(posFinal).trim();
	}
	
	public StringBuilder getNome() throws NomeIncompletoException {
		
		if(ultimoNome == null || nome == null || sobrenome == null) {
			throw new NomeIncompletoException("Preenchimento do nome invalido.");
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(" ");
		sb.append(sobrenome);
		sb.append(" ");
		sb.append(ultimoNome);

		return sb;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
	
