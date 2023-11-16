package br.com.fiap.fincontrol.dao;

import java.util.List;
import br.com.fiap.fincontrol.entiry.Investimentos;
import br.com.fiap.fincontrol.exception.DBException;


public interface InvestimentosDAO {
	
	void gravar (Investimentos investimentos) throws DBException;
	
	List<Investimentos> getAll(int cdUsuario);
	
	Investimentos buscarTodosPorCodigo(int codigo);
	
	void atualizar(Investimentos investimentos) throws DBException;
	
	void remover(int codigo) throws DBException;

}
