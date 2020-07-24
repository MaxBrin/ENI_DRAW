/**
 * 
 */
package fr.eni.enidraw.dal.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enidraw.bo.Stagiaire;
import fr.eni.enidraw.dal.StagiaireDAO;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
public class StagiaireDAOJDBCImpl implements StagiaireDAO {
	private static String SQLINSERT = "INSERT INTO Stagiaires VALUES (?,?,?,?,?)";

	private static String SQLSELECTALL = "SELECT idStagiaire, nom, prenom, sexe, cda, presence, idEquipe FROM Stagiaires";

	@Override
	public void insert(Stagiaire stagiaire) {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLINSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, stagiaire.getNom());
			stmt.setString(2, stagiaire.getPrenom());
			stmt.setString(3, stagiaire.getSexe() + "");
			stmt.setBoolean(4, stagiaire.isCda());
			stmt.setBoolean(5, stagiaire.isPresence());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			stagiaire.setIdStagiaire(rs.getInt(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Stagiaire> selectAll() {
		List<Stagiaire> listStagiaire = new ArrayList<Stagiaire>();

		try (Statement stmt = JdbcTools.getConnection().createStatement();) {
			ResultSet rs = stmt.executeQuery(SQLSELECTALL);
			Stagiaire stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presence"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Stagiaire selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Stagiaire stagiaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Stagiaire Stagiaire) {
		// TODO Auto-generated method stub

	}

}
