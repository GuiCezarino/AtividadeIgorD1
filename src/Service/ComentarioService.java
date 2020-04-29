package Service;

import java.util.List;

import Bean.Comentario;
import Dao.ComentarioDao;

	public class ComentarioService {
	
		private ComentarioDao comentarioDao;
			
			public ComentarioService() {
				this.comentarioDao = new ComentarioDao();
			}
			
			
				public List<Comentario> listar(Integer id){
					return comentarioDao.listComentario(id);	
				}
			
				
					public void inserir(Comentario comentario) {
						comentarioDao.insert(comentario);
					}
			
					
					
	}
