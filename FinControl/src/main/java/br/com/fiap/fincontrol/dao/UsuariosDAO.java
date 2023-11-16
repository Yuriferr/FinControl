package br.com.fiap.fincontrol.dao;

import java.util.List;
import br.com.fiap.fincontrol.entiry.Usuarios;
import br.com.fiap.fincontrol.exception.DBException;


public interface UsuariosDAO {
	
	void gravar (Usuarios usuaios) throws DBException;
	
	List<Usuarios> getAll();
	
	Usuarios buscar(String email, String senha);
	
	void atualizar(Usuarios usuarios) throws DBException;
	
	void remover(int codigo) throws DBException;
	 
}