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
	private static String SQL_SELECTALL_GROUPE = "SELECT idGroupe,reference FROM Groupes";
	private static String SQLSELECTBYIDSTAGIAIRE = "SELECT idStagiaire, nom, prenom, sexe, cda, presentiel, idGroupe FROM Stagiaires WHERE idStagiaire=?";
	private static String SQLSELECTBYIDGROUPE = "SELECT idStagiaire, nom, prenom, sexe, cda, presentiel, idGroupe FROM Stagiaires WHERE idGroupe=?";
	private static String SQLSELECTALL = "SELECT idStagiaire, nom, prenom, sexe, cda, presentiel, idGroupe FROM Stagiaires";
	private static final String SQLUPDATE = "UPDATE  Stagiaires SET idGroupe = ?,nom = ?, prenom = ?,sexe = ?, cda = ?, presentiel = ? WHERE idStagiaire = ? ";
	private static final String SQLDELETE = "DELETE FROM Stagiaires WHERE idStagiaire = ?";

	@Override
	public void insert(Stagiaire stagiaire) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLINSERT,
				Statement.RETURN_GENERATED_KEYS);
				Statement stmtSelectAllGroupe = JdbcTools.getConnection().createStatement();) {
			ResultSet rsGroupe = stmtSelectAllGroupe.executeQuery(SQL_SELECTALL_GROUPE);
			if (!(rsGroupe.next())) {
				DAOFactory.getGroupeDAO().insert(new Groupe(1, "First Team"));
			}
			stmt.setInt(1, 1);
			stmt.setString(2, stagiaire.getNom());
			stmt.setString(3, stagiaire.getPrenom());
			stmt.setString(4, stagiaire.getSexe() + "");
			stmt.setBoolean(5, stagiaire.isCda());
			stmt.setBoolean(6, stagiaire.isPresence());
			stmt.executeUpdate();
			stagiaire.setGroupe(DAOFactory.getGroupeDAO().selectById(1));
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				stagiaire.setIdStagiaire(rs.getInt(1));
			}

		} catch (Exception e) {
			throw new DALException("Insert Failed", e);
		}
	}

	@Override
	public List<Stagiaire> selectAll() throws DALException {
		List<Stagiaire> listStagiaire = new ArrayList<Stagiaire>();

		try (Statement stmt = JdbcTools.getConnection().createStatement();) {
			ResultSet rs = stmt.executeQuery(SQLSELECTALL);
			Stagiaire stagiaire = null;
			while (rs.next()) {
				// Recupération d'un stagiaire
				stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presentiel"),
						// Récupération d'un groupe
						DAOFactory.getGroupeDAO().selectById(rs.getInt("idGroupe")));
				// Ajout du stagiaire à la liste de tous les stagiaires
				listStagiaire.add(stagiaire);
			}
		} catch (Exception e) {
			throw new DALException("SelectAll failed - ", e);
		}
		return listStagiaire;
	}

	@Override
	public Stagiaire selectByIdStagiaire(int id) throws DALException {
		Stagiaire stagiaire = null;
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLSELECTBYIDSTAGIAIRE);) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// Recupération du stagiaire avec idStagiaire == id
				stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presentiel"),
						// Récupération du groupe de ce stagiaire
						DAOFactory.getGroupeDAO().selectById(rs.getInt("idGroupe")));
			}

		} catch (Exception e) {
			throw new DALException("SelectById failed - ", e);
		}
		return stagiaire;
	}

	@Override
	public List<Stagiaire> selectByIdGroupe(int id) throws DALException {
		Stagiaire stagiaire = null;
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLSELECTBYIDGROUPE);) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// Recuperation d'un stagiaire avec idGroupe==id
				stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("sexe").charAt(0), rs.getBoolean("cda"), rs.getBoolean("presentiel"),
						// Recuperation du groupe du stagiaire
						DAOFactory.getGroupeDAO().selectById(rs.getInt("idGroupe")));
				// Ajout d'un stagiaire à la liste du groupe avec idGroupe==id
				stagiaires.add(stagiaire);
			}

		} catch (Exception e) {
			throw new DALException("SelectById failed - ", e);
		}
		return stagiaires;
	}

	@Override
	public void update(Stagiaire stagiaire) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLUPDATE);) {
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
