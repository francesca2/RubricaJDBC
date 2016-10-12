package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import model.Rubrica;
import model.Voce;

public class RubricaDao {
	
	public long getIdRubrica(String nome)
	{
		Connection con;
		ResultSet rst=null;
		PreparedStatement pst=null;
		long id=0;
		try {
			con = DataSource.getInstance().getConnection();


			String sql="Select * from rubrica2 where nome_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setString(1, nome);

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


	public Rubrica aggiungiRubrica(String nome)
	{
		Connection con;
		PreparedStatement pst=null;
		Rubrica r=null;

		try {
			con = DataSource.getInstance().getConnection();

			String sql="Insert into rubrica2(nome_rubrica)"+
					"values(?)";

			pst =con.prepareStatement(sql);
			pst.setString(1, nome);

			pst.executeUpdate();

			long id= getIdRubrica(nome);
			r=new Rubrica(id,nome);

		} catch (SQLException | IOException | PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return r;
	}


	public boolean eliminaRubrica(String nome)
	{
		Connection con;
		PreparedStatement pst=null;
		boolean i=false;
		long id=getIdRubrica(nome);
		try {
			con = DataSource.getInstance().getConnection();

			String sql="Delete from rubrica2 where id_rubrica=?";

			pst =con.prepareStatement(sql);
			pst.setLong(1, id);

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
