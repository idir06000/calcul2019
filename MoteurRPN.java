

import java.util.Stack;

public class MoteurRPN {
	// Liste des operandes

	private Stack<Double> ope;

	public MoteurRPN() {
		ope = new Stack<Double>();
	}

	public void enregistrerOperande(double val) {
		ope.add(val);
	}

	public Stack<Double> getOperandes() {
		return ope;
	}

	public void appliquerOperation(Operation Operation) {
		if (ope.size() >= 2) {

			double valeur_2 =  ope.pop();

			double valeur_1 =  ope.pop();

			ope.add(Operation.eval(valeur_1, valeur_2));
		}

		else
			System.err.println("Pas assez d'operandes");
	}

	public void afficherOperandes() {

		for (int i = 0; i < ope.size(); i++) {
			if (i == ope.size() - 1) {
				System.out.print(ope.get(i));
				break;
			}
			System.out.print(ope.get(i) + "||");
		}
		
//		System.out.print("]");
	}
}
