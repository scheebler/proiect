package BLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import ProductModel.HotelQuerry;
import entities.Agent;
import entities.Hotel;

public class HotelBll {

	public static void viewHotels(JTable table) throws Exception
	{
		HotelQuerry.viewHotels(table);
	}
	
	public static boolean createHotel(Hotel c) throws Exception
	{
		return HotelQuerry.createHotel(c);
	}
	
	public static boolean updateHotel(Hotel c)
	{
		return HotelQuerry.updateHotel(c);
	}
	
	public static boolean deleteHotel(Hotel c)
	{
		return HotelQuerry.deleteHotel(c);
	}
}
