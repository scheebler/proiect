package ProductModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import entities.Agent;
import entities.Client;
import entities.Destination;

public class DestinationQuerry extends Observer{

	public DestinationQuerry(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	public static void findAll(JTable table) throws Exception
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setRowCount(0);
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from destinations");
			ResultSet rs = ps.executeQuery();
			model.addRow(new Object[] {"name", "price"});
			while(rs.next()) 
			{
				Destination c = new Destination();
				c.setName(rs.getString("name"));
				c.setPrice(rs.getInt("price"));
				System.out.println(c.getName()+"  "+c.getPrice());
				model.addRow(new Object[] {c.getName(),c.getPrice()});
			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static boolean findDestination(JTable table, String cod)
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setRowCount(0);
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from destinations where name = ?");
			ps.setString(1, cod);
			ResultSet rs = ps.executeQuery();
			model.addRow(new Object[] {"name", "price"});
			while(rs.next()) 
			{
				Destination c = new Destination();
				c.setName(rs.getString("name"));
				c.setPrice(rs.getInt("price"));
				model.addRow(new Object[] {c.getName(), c.getPrice()});
			}
			return true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Detinatia nu exista!");
			return false;
		}
	}
	
	public static boolean findD(String cod)
	{
		
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from destinations where name = ?");
			ps.setString(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs == null) return false;
			else return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public static int destPrice(String cod)
	{
		try {
			Destination c = new Destination();
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from destinations where name = ?");
			ps.setString(1, cod);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				
				c.setPrice(rs.getInt("price"));
			}
			return c.getPrice();
		}catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public static boolean createDestination(Destination c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into destinations(name,price) values (?,?)");
			ps.setString(1, c.getName());
			ps.setDouble(2, c.getPrice());
			if (ps.executeUpdate() < 0)  {throw new Exception( "Destinatioa nu a putut fi creata!");}
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
	}
	
	public static boolean updateDestination(Destination c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("update destinations set price =? where name = ?");
			ps.setDouble(1, c.getPrice());
			ps.setString(2, c.getName());
			if (ps.executeUpdate() < 0) 	JOptionPane.showMessageDialog(null, "Clientul nu exista!");
			return true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Contul nu a putut fi updatat!");
			return false;
		}
	}
	
	public static boolean deleteDestination(String c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from destinations where name = ?");
			ps.setString(1, c);
			return  ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Clientul nu exista");
			return false;
		}
	}

	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into destinations(comments) values(?)");
			ps.setString(1, s);
			if (ps.executeUpdate() < 0) 	JOptionPane.showMessageDialog(null, "Destinatia nu exista!");
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Clientul nu exista");
		}
	}
}
