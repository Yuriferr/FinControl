package br.com.fiap.fincontrol.entiry;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Usuarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String email;
	private String senha;
	private long cpf;
	private Calendar dtNascimento;
	
	public Usuarios(int codigo, String nome, String email, String senha, long cpf, Calendar dtNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
	}
	
	public Usuarios() {}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public Calendar getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Usuario [codigo=" + codigo
									+ ", nome= " + nome
									+ ", email= " + email
									+ ", senha= " + senha
									+ ", cpf= " + cpf
									+ ", dtNascimento= " + sdf.format(dtNascimento.getTime())
				+ "]";
							
	}
	
	
	
}

