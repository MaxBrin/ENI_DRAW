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
import fr.eni.enidraw.dal.GroupeDAO;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 27 juil. 2020
 */
public class GroupeDAOJDBCImpl implements GroupeDAO {
	private static final String SQLINSERT = "INSERT INTO dbo.Groupes VALUES (?,?)";
	private static final String SQLSELECTBYID = "SELECT idStagiaire,nom,prenom,sexe,cda,presentiel ,g.idGroupe,reference FROM Groupes g JOIN Stagiaires s ON s.idGroupe = g.idGroupe WHERE g.idGroupe=?";
	private static final String SQLSELECTALL = "SELECT idStagiaire,nom,prenom,sexe,cda,presentiel ,g.idGroupe,reference FROM Groupes g JOIN Stagiaires s ON s.idGroupe = g.idGroupe";
	private static final String SQLUPDATE = "UPDATE  Groupes SET reference = ? WHERE idGroupe = ? ";
	private static final String SQLDELETE = "DELETE FROM Groupes WHERE idGroupe =?";

	@Override
	public void insert(Groupe groupe) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLINSERT)) {
			stmt.setInt(1, groupe.getIdGroupe());
			stmt.setString(2, groupe.getReference());
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("Insert Groupe failed - ", e);
		}
	}

	@Override
	public List<Groupe> selectAll() throws DALException {
		List<Groupe> listGroupe = new ArrayList<Groupe>();
		try (Statement stmt = JdbcTools.getConnection().createStatement();) {
			ResultSet rs = stmt.executeQuery(SQLSELECTALL);
			Groupe groupe = null;
			while (rs.next()) {
				groupe = new Groupe(rs.getInt("idGroupe"), rs.getString("reference"));
				listGroupe.add(groupe);
			}
		} catch (Exception e) {
			throw new DALException("SelectAll failed - ", e);
		}
		return listGroupe;

	}

	@Override
	public Groupe selectById(int id) throws DALException {
		Groupe groupe = new Groupe();
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLSELECTBYID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// Recuperation d'un stagiaire
				Stagiaire stagiaire = new Stagiaire(rs.getInt("idStagiaire"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("sexe").charAt(0), rs.getBoolean("cda"),
						rs.getBoolean("presentiel"), new Groupe(rs.getInt("idGroupe"), rs.getString("reference")));
				// Creation du groupe
				groupe.setIdGroupe(rs.getInt("idGroupe"));
				groupe.setReference(rs.getString("reference"));
				// Ajout du stagiaire à la liste du groupe
				groupe.addStagiaire(stagiaire);

			}
		} catch (Exception e) {
			throw new DALException("selectById failed - ", e);
		}
		return groupe;
	}

	@Override
	public void update(Groupe groupe) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLUPDATE)) {
			stmt.setString(1, groupe.getReference());
			stmt.setInt(2, groupe.getIdGroupe());
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("Insert Groupe failed - ", e);
		}

	}

	@Override
	public void delete(int idGroupe) throws DALException {
		try (PreparedStatement stmt = JdbcTools.getConnection().prepareStatement(SQLDELETE);) {
			// FIXME
			stmt.setInt(1, idGroupe);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Delete failed - ", e);
		}

	}

}
