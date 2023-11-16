package br.com.fiap.fincontrol.entiry;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Metas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private String descricao;
	private double valor;
	private Calendar dtMeta;
	private int cdUsuario;
	
	public Metas(int codigo, String nome, String descricao, double valor, Calendar dtMeta, int cdUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.dtMeta = dtMeta;
		this.cdUsuario = cdUsuario;
	}

	public Metas() {}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Metas [codigo=" + codigo
									+ ", nome= " + nome
									+ ", descricao= " + descricao
									+ ", valor= " + valor
									+ ", dtMeta= " + sdf.format(dtMeta.getTime())
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDtMeta() {
		return dtMeta;
	}

	public void setDtMeta(Calendar dtMeta) {
		this.dtMeta = dtMeta;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
	

}

