package br.com.fiap.fincontrol.entiry;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receitas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double valor;
	private Calendar dtRecebimento;
	private int cdUsuario;
	
	public Receitas(int codigo, String nome, double valor, Calendar dtRecebimento, int cdUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dtRecebimento = dtRecebimento;
		this.cdUsuario = cdUsuario;
	}

	public Receitas() {
		
	}

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(Calendar dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Receitas [codigo=" + codigo
									+ ", nome= " + nome
									+ ", valor= " + valor
									+ ", dtNascimento= " + sdf.format(dtRecebimento.getTime())
									+ ", Codigo Usuario= " + cdUsuario
				+ "]";
							
	}
	
	

}

