package ProductModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import entities.Agent;
import entities.Hotel;

public class HotelQuerry {
	public static void viewHotels(JTable table) throws Exception
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setRowCount(0);
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from hotel");
			ResultSet rs = ps.executeQuery();
			model.addRow(new Object[] {"destination", "name"});
			while(rs.next()) 
			{
				Agent c = new Agent();
				c.setUsername(rs.getString("destination"));
				c.setPassword(rs.getString("name"));
				model.addRow(new Object[] {c.getUsername(),c.getPassword()});
			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static boolean createHotel(Hotel c) throws Exception
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into hotel(destination, name) values (?,?)");
			if(checkDestination(c.getDestination())) {
					ps.setString(1, c.getDestination());
					ps.setString(2, c.getName());
			}
			else JOptionPane.showMessageDialog(null, "Destinatia nu exista!");
			if (ps.executeUpdate() < 0) {throw new Exception( "Hotelul nu a putut fi creat!");}
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
	}
	
	public static boolean updateHotel(Hotel c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("update hotel set name =? where destination = ?");
			ps.setString(1, c.getName());
			ps.setString(2, c.getDestination());
			if (ps.executeUpdate() < 0) 	JOptionPane.showMessageDialog(null, "Hotelul nu exista!");
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Hotelul nu a putut fi updatat!");
			return false;
		}
	}
	
	public static boolean deleteHotel(Hotel c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from hotel where name = ?");
			ps.setString(1, c.getName());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Hotelul nu exista");
			return false;
		}
	}
	
	public static boolean checkDestination(String u) throws Exception
	{
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from destinations where name = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if(rs == null) return false;
			else return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
			
		}
	}
}
