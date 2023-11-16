package br.com.fiap.fincontrol.entiry;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Investimentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double valor;
	private Calendar dtInvestimento;
	private int cdUsuario;
	
	public Investimentos(int codigo, String nome, double valor, Calendar dtInvestimento, int cdUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dtInvestimento = dtInvestimento;
		this.cdUsuario = cdUsuario;
	}

	public Investimentos() {}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Investimentos [codigo=" + codigo
									+ ", nome= " + nome
									+ ", valor= " + valor
									+ ", dtInvesitmento= " + sdf.format(dtInvestimento.getTime())
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

	public Calendar getDtInvestimento() {
		return dtInvestimento;
	}

	public void setDtInvestimento(Calendar dtInvestimento) {
		this.dtInvestimento = dtInvestimento;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	
	

}
