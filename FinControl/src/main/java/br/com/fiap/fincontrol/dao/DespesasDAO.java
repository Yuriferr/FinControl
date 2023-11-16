package br.com.fiap.fincontrol.dao;

import java.util.List;
import br.com.fiap.fincontrol.entiry.Despesas;
import br.com.fiap.fincontrol.exception.DBException;


public interface DespesasDAO {

	void gravar (Despesas despesas) throws DBException;
	
	List<Despesas> getAll(int ccdUsuario) ;
	
	Despesas buscarTodosPorCodigo(int codigo);
	
	void atualizar(Despesas despesas) throws DBException;
	
	void remover(int codigo) throws DBException;

}
