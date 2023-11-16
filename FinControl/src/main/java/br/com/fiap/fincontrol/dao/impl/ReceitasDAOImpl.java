package br.com.fiap.fincontrol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fincontrol.dao.ReceitasDAO;
import br.com.fiap.fincontrol.entiry.Receitas;
import br.com.fiap.fincontrol.jdbc.ConnectionManager;

public class ReceitasDAOImpl implements ReceitasDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Receitas receitas) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("INSERT INTO T_RECEITAS " + " (CD_RECEITA, NM_RECEITA, VALOR_RECEITA, DT_RECEBIMENTO, T_USUARIO_CD_USUARIO)"
			+ "VALUES (SEQ_RECEITAS.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, receitas.getNome());
			pstmt.setDouble(2, receitas.getValor());
			pstmt.setDate(3, new java.sql.Date(receitas.getDtRecebimento().getTimeInMillis()));
			pstmt.setInt(4, receitas.getCdUsuario());
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
	
	public List<Receitas> getAll(int cdUsuario){
		List<Receitas> array = new ArrayList<Receitas>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_RECEITAS WHERE T_USUARIO_CD_USUARIO = ?");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_RECEBIMENTO");
				Calendar dtRecebimento= Calendar.getInstance();
				dtRecebimento.setTimeInMillis(data.getTime());
				
				Receitas receita = new Receitas(rs.getInt("CD_RECEITA"), rs.getString("NM_RECEITA"), rs.getDouble("VALOR_RECEITA"), 
						dtRecebimento, rs.getInt("T_USUARIO_CD_USUARIO"));
				
				array.add(receita);
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

		return array;
	}

	public Receitas buscarTodosPorCodigo(int codigo) {
		Receitas receita = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_RECEITAS WHERE CD_RECEITA = ?");
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_RECEBIMENTO");
				Calendar dtRecebimento= Calendar.getInstance();
				dtRecebimento.setTimeInMillis(data.getTime());
				
				receita = new Receitas(rs.getInt("CD_RECEITA"), rs.getString("NM_RECEITA"), rs.getDouble("VALOR_RECEITA"), dtRecebimento, rs.getInt("T_USUARIO_CD_USUARIO"));
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
		return receita;
	}

	@Override
	public void atualizar(Receitas receita) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("UPDATE T_RECEITAS SET NM_RECEITA = ?, VALOR_RECEITA = ?, DT_RECEBIMENTO = ?, T_USUARIO_CD_USUARIO = ? "
					+ "WHERE CD_RECEITA = ?");
			
			pstmt.setString(1, receita.getNome());
			pstmt.setDouble(2, receita.getValor());
			pstmt.setDate(3, new java.sql.Date(receita.getDtRecebimento().getTimeInMillis()));
			pstmt.setInt(4, receita.getCdUsuario());
			pstmt.setInt(5, receita.getCodigo());
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
			pstmt = conexao.prepareStatement("DELETE FROM T_RECEITAS WHERE CD_RECEITA = ?");
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

