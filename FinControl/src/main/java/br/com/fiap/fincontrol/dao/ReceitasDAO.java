package br.com.fiap.fincontrol.dao;

import java.util.List;
import br.com.fiap.fincontrol.entiry.Receitas;
import br.com.fiap.fincontrol.exception.DBException;


public interface ReceitasDAO {
	
void gravar (Receitas receitas) throws DBException;
	
	List<Receitas> getAll(int cdUsuario);
	
	Receitas buscarTodosPorCodigo(int codigo) ;
	
	void atualizar(Receitas receitas) throws DBException;
	
	void remover(int codigo) throws DBException;

}
