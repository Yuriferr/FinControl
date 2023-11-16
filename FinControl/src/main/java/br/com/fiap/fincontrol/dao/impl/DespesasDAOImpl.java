package br.com.fiap.fincontrol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fincontrol.dao.DespesasDAO;
import br.com.fiap.fincontrol.entiry.Despesas;
import br.com.fiap.fincontrol.jdbc.ConnectionManager;

public class DespesasDAOImpl implements DespesasDAO {

	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Despesas despesas) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("INSERT INTO T_DESPESAS " + " (CD_DESPESA, NM_DESPESA, VALOR_DESPESA, DT_PAGAMENTO, T_USUARIO_CD_USUARIO)"
			+ "VALUES (SEQ_DESPESAS.NEXTVAL, ?, ?, ?, ?)");
			pstmt.setString(1, despesas.getNome());
			pstmt.setDouble(2, despesas.getValor());
			pstmt.setDate(3, new java.sql.Date(despesas.getDtPagamento().getTimeInMillis()));
			pstmt.setInt(4, despesas.getCdUsuario());
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
	
	public List<Despesas> getAll(int cdUsuario){
		List<Despesas> array = new ArrayList<Despesas>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_DESPESAS WHERE T_USUARIO_CD_USUARIO = ?");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_PAGAMENTO");
				Calendar dtRecebimento= Calendar.getInstance();
				dtRecebimento.setTimeInMillis(data.getTime());
				
				Despesas despesa = new Despesas(rs.getInt("CD_DESPESA"), rs.getString("NM_DESPESA"), rs.getDouble("VALOR_DESPESA"), 
						dtRecebimento, rs.getInt("T_USUARIO_CD_USUARIO"));
				
				array.add(despesa);
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

	public Despesas buscarTodosPorCodigo(int codigo) {
		Despesas despesa = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_DESPESAS WHERE CD_DESPESA = ?");
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_PAGAMENTO");
				Calendar dtPagamento= Calendar.getInstance();
				dtPagamento.setTimeInMillis(data.getTime());
				
				despesa = new Despesas(rs.getInt("CD_DESPESA"), rs.getString("NM_DESPESA"), rs.getDouble("VALOR_DESPESA"), dtPagamento, rs.getInt("T_USUARIO_CD_USUARIO"));
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
		return despesa;
	}

	@Override
	public void atualizar(Despesas despesa) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("UPDATE T_DESPESAS SET NM_DESPESA = ?, VALOR_DESPESA = ?, DT_PAGAMENTO = ?, T_USUARIO_CD_USUARIO = ? "
					+ "WHERE CD_DESPESA = ?");
			
			pstmt.setString(1, despesa.getNome());
			pstmt.setDouble(2, despesa.getValor());
			pstmt.setDate(3, new java.sql.Date(despesa.getDtPagamento().getTimeInMillis()));
			pstmt.setInt(4, despesa.getCdUsuario());
			pstmt.setInt(5, despesa.getCodigo());
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
			pstmt = conexao.prepareStatement("DELETE FROM T_DESPESAS WHERE CD_DESPESA = ?");
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
