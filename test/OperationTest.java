package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.MoteurRPN;
import main.Operation;

public class OperationTest {
	private MoteurRPN M ;
	@Before
	public void initialize() {
		M = new MoteurRPN();
		
	}
		
	//On test si Operation fait bien le calcul
	@Test
	public void testPlus() {
		
		double val1=3,val2=4;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Plus);
		
		assertEquals(M.getOperandes().get(0), 7.0);
		
	}
	
	@Test
	public void testMoins() {
		double val1=3,val2=4;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Moins);
		
		assertEquals(M.getOperandes().get(0), -1.0);
		
	}
	
	@Test
	public void testMult() {
		double val1=3,val2=4;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Mult);
		
		assertEquals(M.getOperandes().get(0), (double)12);
		
	}
	@Test 
	public void TestDivision(){
		
		double val1=20,val2=5;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Div);
		
		assertEquals(M.getOperandes().get(0), (double)4);
		
	}
	// On test si Operation lance bien une Exception
	@Test (expected = ArithmeticException.class)
	public void TestDivisionSurZero(){
		
		double val1=3,val2=0;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Div);
		
		
	}
	
	//On test le constructeur Operation && getSymbol
		@Test 
		public void TestOperation(){
			
			Operation O = Operation.Plus;
			assertEquals(O.getSymbol(),'+');
			
		}
		

}
