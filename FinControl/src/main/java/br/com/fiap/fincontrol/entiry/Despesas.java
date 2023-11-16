package br.com.fiap.fincontrol.entiry;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Despesas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double valor;
	private Calendar dtPagamento;
	private int cdUsuario;
	
	public Despesas(int codigo, String nome, double valor, Calendar dtPagamento, int cdUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dtPagamento = dtPagamento;
		this.cdUsuario = cdUsuario;
	}

	public Despesas() {}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Despesas [codigo=" + codigo
									+ ", nome= " + nome
									+ ", valor= " + valor
									+ ", dtPagamento= " + sdf.format(dtPagamento.getTime())
									+ ", Codigo Usuario= " + cdUsuario
				+ "]";
							
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

	public Calendar getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
	

}
