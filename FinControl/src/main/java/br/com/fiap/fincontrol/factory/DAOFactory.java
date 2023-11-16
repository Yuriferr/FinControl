package br.com.fiap.fincontrol.factory;

import br.com.fiap.fincontrol.dao.DespesasDAO;
import br.com.fiap.fincontrol.dao.InvestimentosDAO;
import br.com.fiap.fincontrol.dao.MetasDAO;
import br.com.fiap.fincontrol.dao.ReceitasDAO;
import br.com.fiap.fincontrol.dao.UsuariosDAO;
import br.com.fiap.fincontrol.dao.impl.DespesasDAOImpl;
import br.com.fiap.fincontrol.dao.impl.InvestimentosDAOImpl;
import br.com.fiap.fincontrol.dao.impl.MetasDAOImpl;
import br.com.fiap.fincontrol.dao.impl.ReceitasDAOImpl;
import br.com.fiap.fincontrol.dao.impl.UsuariosDAOImpl;

public class DAOFactory {
	
	public static DespesasDAO getDespesasDAO() {
		return new DespesasDAOImpl();
	}
	
	public static InvestimentosDAO getInvestimentosDAO() {
		return new InvestimentosDAOImpl();
	}
	
	public static MetasDAO getMetasDAO() {
		return new MetasDAOImpl();
	}
	
	public static ReceitasDAO getReceitasDAO() {
		return new ReceitasDAOImpl();
	}
	
	public static UsuariosDAO getUsuariosDAO() {
		return new UsuariosDAOImpl();
	}

}
