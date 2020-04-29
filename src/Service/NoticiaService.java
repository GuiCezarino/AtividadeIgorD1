package Service;

import java.util.List;

import Bean.Noticia;
import Dao.NoticiaDao;

public class NoticiaService {
	
	private NoticiaDao noticiaDao =  new NoticiaDao();
	
		public void inserir(Noticia noticia) {
			noticiaDao.insertNoticia(noticia);
		}
	
		
			public List<Noticia> listar(){
				
				return noticiaDao.listNoticia();
			}
			
			
				public void alterar(Integer id, Noticia noticia) {
					
					noticiaDao.updateNoticia(id, noticia);
				}
				
				
					public void excluir(Integer id) {
						
						noticiaDao.delete(id);
					}
					
}

