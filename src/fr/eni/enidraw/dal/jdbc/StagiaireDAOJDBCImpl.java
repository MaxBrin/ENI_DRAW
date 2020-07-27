/**
 * 
 */
package fr.eni.enidraw.dal.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enidraw.bo.Groupe;
import fr.eni.enidraw.bo.Stagiaire;
import fr.eni.enidraw.dal.DALException;
import fr.eni.enidraw.dal.DAOFactory;
import fr.eni.enidraw.dal.StagiaireDAO;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
public class StagiaireDAOJDBCImpl implements StagiaireDAO {
	private static String SQLINSERT = "INSERT INTO dbo.Stagiaires VALUES (?,?,?,?,?,?)";
	private static String SQLSELECTBYID = "SELECT idStagiaire, nom, prenom, sexe, cda, presentiel, idGroupe FROM Stagiaires WHERE idStagiaire=?";
	private static String SQLSELECTALL = "SELECT idStagiaire, nom, prenom, sexe, cda, presentiel, idGroupe FROM Stagiaires";
	private static final String SQLUPDATE = "UPDATE  Stagiaires SET idGroupe = ?,nom = ?, prenom = ?,sexe = ?, cda = ?, presence = ? WHERE idStagiaire = ? ";
	private static final String SQLDELETE = "DELETE FROM Stagiaires WHERE idStagiaire = ?";

	@Override
	public void insert(Stagiaire stagiaire) {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLINSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			if (!(DAOFactory.getGroupeDAO().selectAll().isEmpty())) {
				DAOFactory.getGroupeDAO().insert(new Groupe(1, "First Team"));
			}
			stmt.setInt(1, stagiaire.getGroupe().getIdGroupe());
			stmt.setString(2, stagiaire.getNom());
			stmt.setString(3, stagiaire.getPrenom());
			stmt.setString(4, stagiaire.getSexe() + "");
			stmt.setBoolean(5, stagiaire.isCda());
			stmt.setBoolean(6, stagiaire.isPresence());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				stagiaire.setIdStagiaire(rs.getInt(1));
			}

		} catch (Exception e) {
		}
	}

	@Override
	public List<Stagiaire> selectAll() throws DALException {
		List<Stagiaire> listStagiaire = new ArrayList<Stagiaire>();

		try (Statement stmt = JdbcTools.getConnection().createStatement();) {
			ResultSet rs = stmt.executeQuery(SQLSELECTALL);
			Stagiaire stagiaire = null;
			if (rs.next()) {
				stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presentiel"));
			}
			listStagiaire.add(stagiaire);

		} catch (Exception e) {
			throw new DALException("SelectAll failed - ", e);
		}
		return listStagiaire;
	}

	@Override
	public Stagiaire selectById(int id) throws DALException {
		Stagiaire stagiaire = null;
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLSELECTBYID)) {
			stmt.setInt(0, id);
			ResultSet rs = stmt.executeQuery();
			stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presentiel"));

		} catch (Exception e) {
			throw new DALException("SelectById failed - ", e);
		}
		return stagiaire;
	}

	@Override
	public void update(Stagiaire stagiaire) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLUPDATE)) {
			stmt.setInt(1, stagiaire.getGroupe().getIdGroupe());
			stmt.setString(2, stagiaire.getNom());
			stmt.setString(3, stagiaire.getPrenom());
			stmt.setString(4, stagiaire.getSexe() + "");
			stmt.setBoolean(5, stagiaire.isCda());
			stmt.setBoolean(6, stagiaire.isPresence());
			stmt.setInt(7, stagiaire.getIdStagiaire());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update failed - ", e);
		}

	}

	@Override
	public void delete(int idStagiaire) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLDELETE);) {
			stmt.setInt(1, idStagiaire);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Delete failed - ", e);
		}

	}

}
