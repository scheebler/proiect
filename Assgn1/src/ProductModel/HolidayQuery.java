package ProductModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import entities.Cruise;
import entities.Holiday;
import entities.Stay;
import entities.Strategy;
import entities.Tour;

public class HolidayQuery {

	public static void viewHoliday( JTable table) throws Exception
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		try {
			
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("select * from tour");
			ResultSet rs = ps.executeQuery();
			
			PreparedStatement ps1 = Conn.getConnection().clientPrepareStatement("select * from stay");
			ResultSet rs1 = ps1.executeQuery();
			
			PreparedStatement ps2 = Conn.getConnection().clientPrepareStatement("select * from cruise");
			ResultSet rs2 = ps2.executeQuery();
			model.addRow(new Object[] {"destination", "deadline", "no_persons", "payment", "client", "hotel", "type"});
			while(rs.next()) 
			{
				Tour c = new Tour();
				c.setDestination(rs.getString("destination"));
				c.setHotel1(rs.getString("hotel"));
				c.setDeadline(rs.getString("deadline"));
				c.setNo_persons(rs.getInt("no_persons"));
				c.setPayment(rs.getInt("payment"));
				c.setClient(rs.getString("client"));
				model.addRow(new Object[] {c.getDestination(), c.getDeadline(), c.getNo_persons(), c.getPayment(), c.getClient(), c.getHotel(),"Tour"});
			
			}
			
			while(rs1.next()) 
			{
				Stay c = new Stay();
				c.setDestination(rs1.getString("destination"));
				c.setDeadline(rs1.getString("deadline"));
				c.setHotel1(rs1.getString("hotel"));
				c.setNo_persons(rs1.getInt("no_persons"));
				c.setPayment(rs1.getInt("payment"));
				c.setClient(rs1.getString("client"));
				model.addRow(new Object[] {c.getDestination(), c.getDeadline(), c.getNo_persons(), c.getPayment(), c.getClient(), c.getHotel(), "Stay"});
			
			}
			
			while(rs2.next()) 
			{
				Cruise c = new Cruise();
				c.setDestination(rs2.getString("destination"));
				c.setDeadline(rs2.getString("deadline"));
				c.setNo_persons(rs2.getInt("no_persons"));
				c.setHotel1(rs2.getString("hotel"));
				c.setPayment(rs2.getInt("payment"));
				c.setClient(rs2.getString("client"));
				model.addRow(new Object[] {c.getDestination(), c.getDeadline(), c.getNo_persons(), c.getPayment(), c.getClient(), c.getHotel(), "Cruise"});
			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static boolean deleteTour(Tour c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from tour where destination = ? and client = ?");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getClient());
			return (ps.executeUpdate() > 0);			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Vacanta nu exista");
			return false;
		}
	}
	
	public static boolean deleteStay(Stay c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from tour where destination = ? and client = ?");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getClient());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Vacanta nu exista");
			return false;
		}
	}
	
	public static boolean deleteCruise(Cruise c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from tour where destination = ? and client = ?");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getClient());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Vacanta nu exista");
			return false;
		}
	}
	public static boolean reserveTour(Tour c) throws SQLException, Exception
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into tour (destination, hotel, deadline, no_persons, payment, client) values (?,?,?,?,?,?)");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getHotel());
			ps.setString(3, c.getDeadline());
			ps.setInt(4, c.getNo_persons());
			ps.setInt(5, c.getPayment());
			ps.setString(6, c.getClient());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Rezervarea nu a putut fi facuta!");
			return false;
		}
	}
	
	public static boolean reserveStay(Stay c) throws SQLException, Exception
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into stay (destination, hotel, deadline, no_persons, payment, client) values (?,?,?,?,?,?)");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getHotel());
			ps.setString(3, c.getDeadline());
			ps.setInt(4, c.getNo_persons());
			ps.setInt(5, c.getPayment());
			ps.setString(6, c.getClient());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Rezervarea nu a putut fi facuta!");
			return false;
		}
	}
	
	public static boolean reserveCruise(Cruise c) throws SQLException, Exception
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into cruise (destination, hotel, deadline, no_persons, payment, client) values (?,?,?,?,?,?)");
			ps.setString(1, c.getDestination());
			ps.setString(2, c.getHotel());
			ps.setString(3, c.getDeadline());
			ps.setInt(4, c.getNo_persons());
			ps.setInt(5, c.getPayment());
			ps.setString(6, c.getClient());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Rezervarea nu a putut fi facuta!");
			return false;
		}
	}
	
	
	
}
