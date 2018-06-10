package BLL;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Connection.Conn;
import ProductModel.DestinationQuerry;
import ProductModel.Subject;
import entities.Destination;

public class DestinationBll {

	public static void viewDest(JTable table) throws Exception
	{
		DestinationQuerry.findAll(table);
	}
	
	public static boolean findDestination(JTable table, String cod)
	{
		return DestinationQuerry.findDestination(table, cod);
	}
	
	public static boolean findD(String s)
	{
		return DestinationQuerry.findD(s);
	}
	
	public static int destPrice(String s)
	{
		return DestinationQuerry.destPrice(s);
	}
	
	public static boolean createDestination(Destination c)
	{
		return DestinationQuerry.createDestination(c);
	}
	
	public static boolean updateDestination(Destination c)
	{
		return DestinationQuerry.updateDestination(c);
	}
	
	public static boolean deleteDestination(String c)
	{
		return DestinationQuerry.deleteDestination(c);
	}
	
	public static void addComment(String s)
	{
		Subject.setState(s);
	}
}
