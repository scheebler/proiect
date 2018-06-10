package Test;

import static org.junit.jupiter.api.Assertions.*;

import BLL.ClientBll;
import ProductModel.ClientQuerry;
import entities.Client;

class Test {

	
	@org.junit.jupiter.api.Test
	void test() {
		Client c = new Client();
		c.setCnp("123");
		c.setAdress("Catalunia");
		c.setName("BG");
		c.setIdn("000000");
		ClientBll.createClient(c);
		assertTrue(ClientQuerry.clName(c.getCnp()));
	}
	
	@org.junit.jupiter.api.Test
	void test1() {
		Client c = new Client();
		c.setCnp("123");
		c.setAdress("Catalunia");
		c.setName("BG");
		c.setIdn("000000");
		ClientBll.deleteClient(c);
		assertTrue(ClientQuerry.clName(c.getCnp()));
	}

}
