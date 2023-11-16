package br.com.fiap.fincontrol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fincontrol.dao.InvestimentosDAO;
import br.com.fiap.fincontrol.entiry.Investimentos;
import br.com.fiap.fincontrol.jdbc.ConnectionManager;

public class InvestimentosDAOImpl implements InvestimentosDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Investimentos investimnetos) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("INSERT INTO T_INVESTIMENTOS " + " (CD_INVESTIMENTO, NM_INVESTIMENTO, VALOR_INVESTIMENTO, DT_INVESTIMENTO, T_USUARIO_CD_USUARIO)"
			+ "VALUES (SEQ_INVESTIMENTOS.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, investimnetos.getNome());
			pstmt.setDouble(2, investimnetos.getValor());
			pstmt.setDate(3, new java.sql.Date(investimnetos.getDtInvestimento().getTimeInMillis()));
			pstmt.setInt(4, investimnetos.getCdUsuario());
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
	
	public List<Investimentos> getAll(int cdUsuario){
		List<Investimentos> array = new ArrayList<Investimentos>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTOS WHERE T_USUARIO_CD_USUARIO = ?");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar dtInvestimento= Calendar.getInstance();
				dtInvestimento.setTimeInMillis(data.getTime());
				
				Investimentos investimento = new Investimentos(rs.getInt("CD_INVESTIMENTO"), rs.getString("NM_INVESTIMENTO"), 
						rs.getDouble("VALOR_INVESTIMENTO"), dtInvestimento, rs.getInt("T_USUARIO_CD_USUARIO"));
				
				array.add(investimento);
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

	public Investimentos buscarTodosPorCodigo(int codigo) {
		Investimentos investimento = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTOS WHERE CD_INVESTIMENTO = ?");
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar dtInvestimento= Calendar.getInstance();
				dtInvestimento.setTimeInMillis(data.getTime());
				
				investimento = new Investimentos(rs.getInt("CD_INVESTIMENTO"), rs.getString("NM_INVESTIMENTO"), rs.getDouble("VALOR_INVESTIMENTO"), 
						dtInvestimento, rs.getInt("T_USUARIO_CD_USUARIO"));
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
		return investimento;
	}

	@Override
	public void atualizar(Investimentos investimento) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("UPDATE T_INVESTIMENTOS SET NM_INVESTIMENTO = ?, VALOR_INVESTIMENTO = ?, DT_INVESTIMENTO = ?, T_USUARIO_CD_USUARIO = ? "
					+ "WHERE CD_INVESTIMENTO = ?");
			
			pstmt.setString(1, investimento.getNome());
			pstmt.setDouble(2, investimento.getValor());
			pstmt.setDate(3, new java.sql.Date(investimento.getDtInvestimento().getTimeInMillis()));
			pstmt.setInt(4, investimento.getCdUsuario());
			pstmt.setInt(5, investimento.getCodigo());
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
			pstmt = conexao.prepareStatement("DELETE FROM T_INVESTIMENTOS WHERE CD_INVESTIMENTO = ?");
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
