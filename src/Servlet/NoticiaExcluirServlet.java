package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.NoticiaService;

@WebServlet("/excluir.do")
public class NoticiaExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final NoticiaService noticiaService = new NoticiaService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		
		noticiaService.excluir(idNoticia);
	}

}
