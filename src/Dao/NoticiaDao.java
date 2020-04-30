package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Noticia;
import ConnectionFactory.ConnectionFactory;

public class NoticiaDao {

		private Connection conect;

			public NoticiaDao(){
				new ConnectionFactory();
				this.conect = ConnectionFactory.conectar();
			}

	public void insertNoticia(Noticia noticia) {

		String insert = 
				"INSERT INTO noticia (descricao,titulo,texto) " 
				+ "VALUES (?,?,?)";

		try (PreparedStatement ps = conect.prepareStatement(insert);) {

			ps.setString(1, noticia.getDescricao());
			ps.setString(2, noticia.getTitulo());
			ps.setString(3, noticia.getTexto());
			ps.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
				try {
					conect.rollback();
					
				} catch (SQLException ex) {
					
					System.out.println(ex.getStackTrace());
					
				}
				
				
			}
		
	}

	
	public List<Noticia> listNoticia() {

		String sqlSelect = "SELECT * FROM noticia";

		List<Noticia> listaNoticia = new ArrayList<>();

		try (PreparedStatement ps = conect.prepareStatement(sqlSelect);) {

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Noticia noticia = new Noticia();
				
				noticia.setTitulo(resultSet.getString("titulo"));
				
				noticia.setDescricao(resultSet.getString("descricao"));
				
				noticia.setTexto(resultSet.getString("texto"));
				
				noticia.setId(resultSet.getInt("id"));
				
				listaNoticia.add(noticia);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listaNoticia;
	}

	public void updateNoticia(Integer id, Noticia noticia) {

		String updateNoticia = 
				"UPDATE noticia " 
				+ "SET titulo = ?, "
				+ "descricao = ?, "
				+ "texto = ? " 
				+ " WHERE id = ? ";

		try (PreparedStatement ps = conect.prepareStatement(updateNoticia)) {

			ps.setString(1, noticia.getTitulo());
			ps.setString(2, noticia.getDescricao());
			ps.setString(3, noticia.getTexto());
			ps.setInt(4, id);

			ps.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel realização a modificação" + "a tabela noticia.");
				ex.printStackTrace();
		}
	}

	public void delete(Integer id) {

		String excluir = "DELETE FROM noticia " + " WHERE id = ? ";

		try (PreparedStatement pst = conect.prepareStatement(excluir)) {

			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException ex) {
			System.err.println("Não foi possivel realizar a exclusão " + "a noticia");
				ex.printStackTrace();
		}
	}

}