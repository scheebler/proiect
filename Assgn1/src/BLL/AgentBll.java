package BLL;

import javax.swing.JTable;

import ProductModel.AgentQuerry;
import entities.Agent;

public class AgentBll {

	private static AgentQuerry agentQuerry = AgentQuerry.getInstance();
	public static void viewAgents(JTable table) throws Exception
	{
		agentQuerry.viewAgents(table);
	}
	
	public static boolean createAgent(Agent c) throws Exception
	{
		if(c.getUsername().equals("")) {
			throw new Exception("username cannot be null");
		}
		if(c.getPassword().equals("")) {
			throw new Exception("password cannot be null");
		}
		
		return agentQuerry.createAgent(c);
	}
	
	public static boolean updateAgent(Agent c)
	{
		return agentQuerry.updateAgent(c);
	}
	
	public static boolean deleteAgent(Agent c)
	{
		return agentQuerry.deleteAgent(c);
	}
	
	public static boolean checkAgent(String u, String p) throws Exception
	{
		return agentQuerry.checkAgent(u, p);
	}
}
