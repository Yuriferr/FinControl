package br.com.fiap.fincontrol.dao;

import java.util.List;
import br.com.fiap.fincontrol.entiry.Metas;
import br.com.fiap.fincontrol.exception.DBException;


public interface MetasDAO {
	
void gravar (Metas metas) throws DBException;
	
	List<Metas> getAll(int cdUsuario);
	
	Metas buscarTodosPorCodigo(int codigo);
	
	void atualizar(Metas metas) throws DBException;
	
	void remover(int codigo) throws DBException;
	

}