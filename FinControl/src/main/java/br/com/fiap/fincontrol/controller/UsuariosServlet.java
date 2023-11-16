package br.com.fiap.fincontrol.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fincontrol.dao.UsuariosDAO;
import br.com.fiap.fincontrol.entiry.Usuarios;
import br.com.fiap.fincontrol.exception.DBException;
import br.com.fiap.fincontrol.factory.DAOFactory;


@WebServlet("/UsuariosServlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuariosDAO dao;
    
    @Override
    public void init() throws ServletException{
    	super.init();
    	dao = DAOFactory.getUsuariosDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar":
    		Cadastrar(request, response);
    		break;
    	case "logar":
    		Logar(request, response);
    		break;
    	}
    }
    
    protected void Cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
    		String nome = request.getParameter("nome");
    		String email = request.getParameter("email");
    		String senha = request.getParameter("senha");
    		long cpf = Long.parseLong(request.getParameter("cpf"));
    		
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		Calendar data = Calendar.getInstance();
    		data.setTime(format.parse(request.getParameter("data")));
    		
    		Usuarios usuarios = new Usuarios(0, nome, email, senha, cpf, data );
    		dao.gravar(usuarios);
    		
    		request.setAttribute("msg", "Usuario cadastrado!!!");
    	}catch (DBException db) {
    		db.printStackTrace();
    	} catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, " + "valide os dados");
		}
    	request.getRequestDispatcher("cadastro-usuarios.jsp").forward(request, response);
    }
    
    protected void Logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuarios usuario = new Usuarios();
			
			if(email != null && senha != null) {
				usuario = dao.buscar(email, senha);
				
				if(usuario != null) {
					request.getSession().setAttribute("usuario", usuario);
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("login-usuarios.jsp").forward(request, response);
				}
			}else {
				request.getRequestDispatcher("login-usuarios.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
   

}
