package br.com.caelum.agiletickets.acceptance;

public class ReservaTest {
	
	private WebDriver browser;
	
	@Before void setUp() throws Exception {
		browser = new FirefoxDriver();
	}

	@After
	public void tearDown(){
		brower.close();
	}
}
