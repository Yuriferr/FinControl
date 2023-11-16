package br.com.fiap.fincontrol.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fincontrol.dao.DespesasDAO;
import br.com.fiap.fincontrol.entiry.Despesas;
import br.com.fiap.fincontrol.exception.DBException;
import br.com.fiap.fincontrol.factory.DAOFactory;

/**
 * Servlet implementation class DespesasServlet
 */
@WebServlet("/DespesasServlet")
public class DespesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public DespesasDAO dao;
    
    @Override
    public void init() throws ServletException{
    	super.init();
    	dao = DAOFactory.getDespesasDAO();

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar":
    		cadastrar(request, response);
    		break;
    	case "editar":
    		editar(request, response);
    		break;
    	case "excluir":
    		excluir(request, response);
    		break;
    	}
    }
    
    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	int cdUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
    	
    	try {
            String nome = request.getParameter("nome");
            double valor = Double.parseDouble(request.getParameter("valor"));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		Calendar data = Calendar.getInstance();
    		data.setTime(format.parse(request.getParameter("data")));
    		
    		Despesas despesa = new Despesas(0, nome, valor, data, cdUsuario);
    		dao.gravar(despesa);
    		
    		request.setAttribute("msg", "Despesa cadastrada!!!");
    	}catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao cadastrar");
    	}catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, " + "valide os dados");
		}
    	
    	listar(request, response, cdUsuario);
    	
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
        int cdUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
    	
    	try {
    		int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nome = request.getParameter("nome");
            double valor = Double.parseDouble(request.getParameter("valor"));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		Calendar data = Calendar.getInstance();
    		data.setTime(format.parse(request.getParameter("data")));
    		
    		Despesas despesa = new Despesas(codigo, nome, valor, data, cdUsuario);
    		dao.atualizar(despesa);
    		
    		request.setAttribute("msg", "Despesa atualizada!!!");
    	}catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao atualizar");
    	}catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, " + "valide os dados");
		}
    	listar(request, response, cdUsuario);
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        int cdUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
        
        try {
        	dao.remover(codigo);
        	request.setAttribute("msg", "Despesa removida!!!");
        }catch(DBException e) {
        	e.printStackTrace();
        	request.setAttribute("erro", "Erro ao atualizar");
        }
        
        listar(request, response, cdUsuario);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String codigoUsuarioParam = request.getParameter("codigoUsuario");
        String acao = request.getParameter("acao");

            	switch(acao) {
            	case "listar":
                    int codigoUsuario = Integer.parseInt(codigoUsuarioParam);
                    listar(request, response, codigoUsuario);
                    break;
                    
            	case "abrir-form-edicao":
            		int id = Integer.parseInt(request.getParameter("codigo"));
            		Despesas despesa = dao.buscarTodosPorCodigo(id);
            		request.setAttribute("despesa", despesa);
            		request.getRequestDispatcher("edicao-despesa.jsp").forward(request, response);
            		break;
            	}

    }

	private void listar(HttpServletRequest request, HttpServletResponse response, int codigoUsuario)
			throws ServletException, IOException {
		
		List<Despesas> lista = dao.getAll(codigoUsuario);
		request.setAttribute("codigoUsuario", codigoUsuario);
		request.setAttribute("despesas", lista);
		request.getRequestDispatcher("despesas.jsp").forward(request, response);
		
	}

}
