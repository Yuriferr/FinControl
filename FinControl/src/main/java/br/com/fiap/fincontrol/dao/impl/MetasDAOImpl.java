package br.com.fiap.fincontrol.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fincontrol.dao.MetasDAO;
import br.com.fiap.fincontrol.entiry.Metas;
import br.com.fiap.fincontrol.jdbc.ConnectionManager;


public class MetasDAOImpl implements MetasDAO {
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Metas metas) {
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("INSERT INTO T_METAS " + " (CD_META, NM_META, DESCRICAO_META , VALOR_META, DT_ALCANCAR_META, T_USUARIO_CD_USUARIO)"
			+ "VALUES (SEQ_METAS.NEXTVAL, ?, ?, ?, ?, ?)");
			pstmt.setString(1, metas.getNome());
			pstmt.setString(2, metas.getDescricao());
			pstmt.setDouble(3, metas.getValor());
			pstmt.setDate(4, new java.sql.Date(metas.getDtMeta().getTimeInMillis()));
			pstmt.setInt(5, metas.getCdUsuario());
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
	
	public List<Metas> getAll(int cdUsuario){
		List<Metas> array = new ArrayList<Metas>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_METAS WHERE T_USUARIO_CD_USUARIO = ?");
			pstmt.setInt(1, cdUsuario);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_ALCANCAR_META");
				Calendar dtMeta= Calendar.getInstance();
				dtMeta.setTimeInMillis(data.getTime());
				
				Metas meta = new Metas(rs.getInt("CD_META"), rs.getString("NM_META"), rs.getString("DESCRICAO_META"), 
						rs.getDouble("VALOR_META"), dtMeta, rs.getInt("T_USUARIO_CD_USUARIO"));
				
				array.add(meta);
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

	public Metas buscarTodosPorCodigo(int codigo) {
		Metas meta = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("SELECT * FROM T_METAS WHERE CD_META = ?");
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				java.sql.Date data = rs.getDate("DT_ALCANCAR_META");
				Calendar dtMeta = Calendar.getInstance();
				dtMeta.setTimeInMillis(data.getTime());
				
				meta = new Metas(rs.getInt("CD_META"), rs.getString("NM_META"), rs.getString("DESCRICAO_META"), 
						rs.getDouble("VALOR_META"), dtMeta, rs.getInt("T_USUARIO_CD_USUARIO"));
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
		return meta;
	}

	@Override
	public void atualizar(Metas meta) {
		try {
			conexao = ConnectionManager.getInstance().getConnetion();
			pstmt = conexao.prepareStatement("UPDATE T_METAS SET NM_META = ?, DESCRICAO_META = ?, VALOR_META = ?, "
					+ "DT_ALCANCAR_META = ?, "+ "T_USUARIO_CD_USUARIO = ? " 
					+ "WHERE CD_META = ?");
			
			pstmt.setString(1, meta.getNome());
			pstmt.setString(2, meta.getDescricao());	
			pstmt.setDouble(3, meta.getValor());
			pstmt.setDate(4, new java.sql.Date(meta.getDtMeta().getTimeInMillis()));
			pstmt.setInt(5, meta.getCdUsuario());
			pstmt.setInt(6, meta.getCodigo());
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
			pstmt = conexao.prepareStatement("DELETE FROM T_METAS WHERE CD_META = ?");
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

