package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Comentario;
import Bean.Noticia;
import Service.ComentarioService;
import Service.NoticiaService;

@WebServlet("/News.do")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private final NoticiaService noticiaService = new NoticiaService();

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Noticia> listaNoticia = noticiaService.listar();
			
			for(Noticia noticia : listaNoticia) {
				
				response.getWriter().println("<h1>" + noticia.getTitulo() + "</h1>" + "<h4>" + noticia.getDescricao() + "</h4>" + "<p>" + noticia.getTexto() + "</p>");
				
				ComentarioService comentarioService = new ComentarioService();
					List<Comentario> listaComentario = comentarioService.listar(noticia.getId());
					HttpSession sessao= request.getSession();
						sessao.setAttribute("idComentario", noticia.getId());
							for(Comentario comentario : listaComentario) {
					
				response.getWriter().println("<hr/>"+"<h5> Nomee: " + comentario.getNome() + "</h5>" + "<p> Comentario: " + comentario.getComentario() + "</p>"+"<hr/>");
					
				}
				
				response.getWriter().println("<form method=\"post\" action=\"cadastraComentario.do\">"
											+"<br/>"+"<br/>" + "<p> Adicionar comentário: </p>"
											+"<p> Nome: </p>" + "<input type=\"text\" value=\"\" name=\"nome\" />"
										    +"<br/>" + "<br/>" + "<input type=\"text\" value=\"\" name=\"comentario\" />"
										    +"<input type=\"submit\" value=\"Comentar\" />"
											+"</form>");
			}
			
		}

}
