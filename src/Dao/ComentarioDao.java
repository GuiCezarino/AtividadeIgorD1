package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Comentario;
import ConnectionFactory.ConnectionFactory;

public class ComentarioDao {

	private Connection conect;

		public ComentarioDao() {
			new ConnectionFactory();
			this.conect = ConnectionFactory.conectar();
		}
	
	public void insert(Comentario comentario) {

		String insert = 
				"INSERT INTO comentario "
				+ "(nome,texto, fk_noticia_id) " 
				+ "VALUES (?,?,?)";

		try (PreparedStatement ps = conect.prepareStatement(insert);) {

			ps.setString(1, comentario.getNome());
			
			ps.setString(2, comentario.getComentario());
			ps.setInt(3, comentario.getidComentario());
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

	public List<Comentario> listComentario(Integer id) {

		String sqlSelect = 
				"SELECT * FROM comentario "
				+ "WHERE fk_noticia_id = ?";

		List<Comentario> listaComentario = new ArrayList<>();

		try (PreparedStatement ps = conect.prepareStatement(sqlSelect);) {
			
				ps.setInt(1, id);
				ResultSet resultSet = ps.executeQuery();

					while (resultSet.next()) {
						Comentario comentarioModel = new Comentario();
						
						comentarioModel.setNome(resultSet.getString("nome"));
						
						comentarioModel.setComentario(resultSet.getString("texto"));
						
						listaComentario.add(comentarioModel);
					}
					
		} catch (SQLException e) { e.printStackTrace(); }
		
			return listaComentario;
	
	}
	
	
}