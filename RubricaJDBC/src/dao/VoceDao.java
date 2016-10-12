package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import model.Voce;


public class VoceDao {

	public long getIdVoce(String nome, String cognome, long idRubrica)
	{
		Connection con;
		ResultSet rst=null;
		PreparedStatement pst=null;
		long id=0;
		try {
			con = DataSource.getInstance().getConnection();


			String sql="Select * from voce where nome=? and cognome=? and id_Rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setLong(3,idRubrica);

			rst= pst.executeQuery();

			if(rst.next())
			{
				id= rst.getInt(1);
			}

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return id;
	}

	public Map<String,Voce> getTutteLeVoce(long idRubrica)
	{
		Connection con;
		ResultSet rst=null;
		PreparedStatement pst=null;
		Map<String,Voce> mappa= new TreeMap<String,Voce>();

		try {
			con = DataSource.getInstance().getConnection();

			String sql="Select * from voce where id_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setLong(1, idRubrica);

			rst= pst.executeQuery();

			while(rst.next())
			{
				long id_Utente= rst.getInt(1);
				String nome=rst.getString(2);
				String cognome=rst.getString(3);
				String telefono= rst.getString(4);

				Voce v= new Voce(id_Utente, nome, cognome, telefono, idRubrica);
				mappa.put(nome + " " + cognome, v);
			}

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return mappa;
	}

	public Voce trovaVoce(String nome, String cognome, long idRubrica)
	{
		Connection con;
		ResultSet rst=null;
		PreparedStatement pst=null;
		Voce v=null;
		long id= getIdVoce(nome,cognome,idRubrica);
		try {
			con = DataSource.getInstance().getConnection();

			String sql="Select * from voce where nome=? and cognome=? and id_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setLong(3, idRubrica);

			rst= pst.executeQuery();

			if(rst.next())
			{
				String telefono= rst.getString(4);
				v=new Voce(id,nome, cognome,telefono,idRubrica);
			}

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return v;
	}

	public Voce aggiungiVoce(String nome, String cognome, String telefono,long idRubrica)
	{
		Connection con;
		PreparedStatement pst=null;
		Voce v=null;

		try {
			con = DataSource.getInstance().getConnection();

			String sql="Insert into voce(nome,cognome,telefono,id_rubrica)"+
					"values(?,?,?,?)";

			pst =con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setLong(4, idRubrica);

			pst.executeUpdate();

			long id= getIdVoce(nome,cognome,idRubrica);
			v=new Voce(id,nome, cognome,telefono,idRubrica);



		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return v;
	}

	public Voce aggiornaVoce(String nome,String nuovoNome, String cognome,String nuovoCognome ,String telefono,long idRubrica)
	{
		Connection con;
		PreparedStatement pst=null;
		Voce v=null;
		long id=getIdVoce(nome,cognome,idRubrica);
		try {
			con = DataSource.getInstance().getConnection();

			String sql="Update voce set nome=?, cognome=?, telefono=? where id_voce=? and id_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setString(1, nuovoNome);
			pst.setString(2, nuovoCognome);
			pst.setString(3, telefono);
			pst.setLong(4, id);
			pst.setLong(5, idRubrica);

			int n=pst.executeUpdate();

			if(n>0){
				v=new Voce(id,nome, cognome,telefono,idRubrica);
			}

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return v;
	}

	public boolean eliminaVoce(String nome,String cognome,long idRubrica)
	{
		Connection con;
		PreparedStatement pst=null;
		boolean i=false;
		long id=getIdVoce(nome,cognome, idRubrica);
		try {
			con = DataSource.getInstance().getConnection();

			String sql="Delete from voce where id_voce=? and id_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setLong(1, id);
			pst.setLong(2, idRubrica);

			int n=pst.executeUpdate();

			if(n>0){
				i=true;
			}

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return i;
	}

}
