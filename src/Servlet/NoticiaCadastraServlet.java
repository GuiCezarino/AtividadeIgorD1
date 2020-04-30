package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Noticia;
import Service.NoticiaService;

@WebServlet("/cadastrar.do")
public class NoticiaCadastraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NoticiaService noticiaService = new NoticiaService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noticia noticia = new Noticia();
			noticia.setTitulo(request.getParameter("titulo"));
				noticia.setDescricao(request.getParameter("descricao"));
					noticia.setTexto(request.getParameter("texto"));
		
						noticiaService.inserir(noticia);
	}

}
