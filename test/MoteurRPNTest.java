package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.MoteurRPN;
import main.Operation;

public class MoteurRPNTest {
	private MoteurRPN M;

	@Test
	public void testOperande() {
		M = new MoteurRPN();
		assertTrue(M.getOperandes().isEmpty());
	}

	@Before
	public void initialize() {
		M = new MoteurRPN();
	}

	// On test si appliquerOperation lance bien une Exception
	@Test(expected = ArithmeticException.class)
	public void testappliquerOperationException() {
		M.appliquerOperation(Operation.Plus);
	}

	// On test si le Moteur fait bien le calcul
	@Test
	public void testAppliquerOperation() {

		double val1 = 3, val2 = 4;
		M.enregistrerOperande(val1);
		M.enregistrerOperande(val2);
		M.appliquerOperation(Operation.Plus);

		assertEquals(M.getOperandes().get(0), 7.0);
	}

	// On test si le Moteur verifie bien qu'on a pas assez d'operandes
	@Test(expected = ArithmeticException.class)
	public void testEnregistrerOperandeException() {

		double val1 = 3;
		M.enregistrerOperande(val1);

		M.appliquerOperation(Operation.Plus);

	}

	// On teste si le Moteur enregistre bien les operandes
	@Test
	public void testEnregistrerOperande() {
		double val1 = 3;
		M.enregistrerOperande(val1);

		assertEquals(M.getOperandes().size(), 1);
	}

}
