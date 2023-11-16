package br.com.fiap.fincontrol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fincontrol.dao.UsuariosDAO;
import br.com.fiap.fincontrol.entiry.Usuarios;
import br.com.fiap.fincontrol.jdbc.ConnectionManager;

public class UsuariosDAOImpl implements UsuariosDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Usuarios usuario) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("INSERT INTO T_USUARIO " + " (CD_USUARIO, NM_USUARIO, EMAIL, SENHA, CPF, DT_NASCIMENTO)"
			+ "VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setLong(4, usuario.getCpf());
			pstmt.setDate(5, new java.sql.Date(usuario.getDtNascimento().getTimeInMillis()));
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Usuarios> getAll (){
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_USUARIO");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_NASCIMENTO");
				Calendar dtNascimento= Calendar.getInstance();
				dtNascimento.setTimeInMillis(data.getTime());
				
				Usuarios usuario = new Usuarios(rs.getInt("CD_USUARIO"), rs.getString("NM_USUARIO"), rs.getString("EMAIL"), rs.getString("SENHA"),
						rs.getLong("CPF"), dtNascimento);
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return usuarios;
	}
	
	public Usuarios buscar(String email, String senha) {
		Usuarios usuario = new Usuarios();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE EMAIL = ? AND SENHA = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_NASCIMENTO");
				Calendar dtNascimento= Calendar.getInstance();
				dtNascimento.setTimeInMillis(data.getTime());
				
				usuario = new Usuarios(rs.getInt("CD_USUARIO"), rs.getString("NM_USUARIO"), rs.getString("EMAIL"), rs.getString("SENHA"),
						rs.getLong("CPF"), dtNascimento);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}
	
	@Override
	public void atualizar(Usuarios usuarios) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("UPDATE T_USUARIO SET NM_USUARIO = ?, EMAIL = ?, SENHA = ?, CPF = ?, DT_NASCIMENTO = ? "
					+ "WHERE CD_USUARIO = ?");
			
			pstmt.setString(1, usuarios.getNome());
			pstmt.setString(2, usuarios.getEmail());
			pstmt.setString(3, usuarios.getSenha());
			pstmt.setLong(4, usuarios.getCpf());
			pstmt.setDate(5, new java.sql.Date(usuarios.getDtNascimento().getTimeInMillis()));
			pstmt.setInt(6, usuarios.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remover(int codigo) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("DELETE FROM T_USUARIO WHERE CD_USUARIO = ?");
			pstmt.setInt(1, codigo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	
	
}

