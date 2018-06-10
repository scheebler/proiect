package ProductModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.Conn;
import entities.Agent;

public class AgentQuerry{

	private static AgentQuerry instance = new AgentQuerry();

	public static AgentQuerry getInstance(){
	      return instance;
	   }
	public AgentQuerry()
	{
		
	}

	public void viewAgents(JTable table) throws Exception
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setRowCount(0);
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from agents");
			ResultSet rs = ps.executeQuery();
			model.addRow(new Object[] {"username", "password"});
			while(rs.next()) 
			{
				Agent c = new Agent();
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				model.addRow(new Object[] {c.getUsername(),c.getPassword()});
			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public boolean createAgent(Agent c) throws Exception
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("insert into agents(username, password) values (?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			if (ps.executeUpdate() < 0) {throw new Exception( "Contul nu a putut fi creat!");}
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
	}
	
	public boolean updateAgent(Agent c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("update agents set password =? where username = ?");
			ps.setString(1, c.getPassword());
			ps.setString(2, c.getUsername());
			if (ps.executeUpdate() < 0) 	JOptionPane.showMessageDialog(null, "Clientul nu exista!");
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Contul nu a putut fi updatat!");
			return false;
		}
	}
	
	public boolean deleteAgent(Agent c)
	{
		try {
			PreparedStatement ps = Conn.getConnection().clientPrepareStatement("delete from agents where username = ?");
			ps.setString(1, c.getUsername());
			return ps.executeUpdate() > 0;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Clientul nu exista");
			return false;
		}
	}
	
	public boolean checkAgent(String u, String p) throws Exception
	{
		try {
			
			PreparedStatement ps = Conn.getConnection().prepareStatement("select * from agents where username = ? AND password = ?");
			ps.setString(1, u);
			ps.setString(2, p);
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
