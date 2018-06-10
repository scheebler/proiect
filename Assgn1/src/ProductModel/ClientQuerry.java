package ProductModel;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import entities.Client;

public class ClientQuerry extends Observer{

	private static FileWriter fileWriter; //create csv file
	
	public ClientQuerry(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	public static void findAll(JTable table) throws Exception
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setRowCount(0);
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from client");
			ResultSet rs = ps.executeQuery();
			model.addRow(new Object[] {"CNP", "Name", "IDN", "Adress"});
			while(rs.next()) 
			{
				Client c = new Client();
				c.setAdress(rs.getString("address"));
				c.setCnp(rs.getString("cnp"));
				c.setName(rs.getString("name"));
				c.setIdn(rs.getString("idn"));
				model.addRow(new Object[] {c.getCnp(),c.getName(), c.getIdn(), c.getAdress()});
			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static Client findClient(JTable table, String cod)
	{
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Client c = new Client();
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from client where cnp = ?");
			ps.setString(1, cod);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				c.setAdress(rs.getString("adress"));
				c.setCnp(rs.getString("cnp"));
				c.setName(rs.getString("nume"));
				c.setIdn(rs.getString("idn"));
				model.addRow(new Object[] {c.getCnp(),c.getName(), c.getIdn(), c.getAdress()});
			}
			if (c.getCnp() == null) 	JOptionPane.showMessageDialog(null, "Clientul nu exista!");

			return c;
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public static boolean createClient(Client c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into client(cnp,name,idn,address) values (?,?,?,?)");
			ps.setString(1, c.getCnp());
			ps.setString(2, c.getName());
			ps.setString(3, c.getIdn());
			ps.setString(4, c.getAdress());
			if (ps.executeUpdate() < 0) JOptionPane.showMessageDialog(null, "Contul nu a putut fi creat!");
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
	}
	
	public static boolean updateClient(Client c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("update client set name = ?, idn =?, address = ? where cnp = ?");
			ps.setString(1, c.getName());
			ps.setString(2, c.getIdn());
			ps.setString(3, c.getAdress());
			ps.setString(4, c.getCnp());
			if (ps.executeUpdate() < 0) 	JOptionPane.showMessageDialog(null, "Clientul nu exista!");
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Contul nu a putut fi updatat!");
			return false;
		}
	}
	
	public static boolean deleteClient(Client c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from client where cnp = ?");
			ps.setString(1, c.getCnp());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Clientul nu exista");
			return false;
		}
	}
	
	public static boolean clName(String cod)
	{
		try {
			
			Client c = new Client();
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from client where cnp = ?");
			ps.setString(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs == null) return false;
			else return true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Clientul nu exista!");
			return false;
		}
	}

	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		try {
			fileWriter = new FileWriter("src//comments.txt");
			fileWriter.append(s);
			try {
				PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select comments from destinations");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) 
				{
					fileWriter.append(rs.getString("comments"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
}
