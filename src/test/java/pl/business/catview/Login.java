package pl.business.catview;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

import org.junit.Before;
import org.junit.Test;

public class Login {

	@Before
	public void prepare() {
		setBaseUrl("http://locathost:8080/login");
	}
	
	@Test
	public void testLogin() {
		beginAt("/login");
		setTextField("", "Daniel");
		setTextField("", "P1c@t3");
		
	}
}
