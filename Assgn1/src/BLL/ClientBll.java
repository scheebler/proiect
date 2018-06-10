package BLL;

import javax.swing.JTable;

import ProductModel.ClientQuerry;
import entities.Client;

public class ClientBll {

	public static void findAll(JTable table) throws Exception
	{
		ClientQuerry.findAll(table);
	}
	
	public static Client findClient(JTable table, String cod)
	{
		return ClientQuerry.findClient(table, cod);
	}
	
	public static boolean createClient(Client c)
	{
		return ClientQuerry.createClient(c);
	}
	
	public static boolean updateClient(Client c)
	{
		return ClientQuerry.updateClient(c);
	}
	
	public static boolean deleteClient(Client c)
	{
		return ClientQuerry.deleteClient(c);
	}
	
	public static boolean clName(String s)
	{
		return ClientQuerry.clName(s);
	}
}
