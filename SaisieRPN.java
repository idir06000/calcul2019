
import java.util.Scanner;

public class SaisieRPN 
{
	private Scanner sc = new Scanner(System.in);
	public MoteurRPN M;
	public final static int MAX_VALUE=100000000;
	public final static int MIN_VALUE=-100000000;
	
	public SaisieRPN(){
		M = new MoteurRPN();
	}
	
	public void saisie() {
		
		
		
		System.out.println("BIENVENUE DANS LA CALCULATRICE RPN");
		while (true) { 
			String str = sc.nextLine();
			try {
			forMoteurRPN(str);
			} catch (ArithmeticException | NumberFormatException incorrecte) {
				System.out.println(" saisie incorrecte : "+  incorrecte.getMessage());
				M.afficherOperandes();
			}
		}
	}
	
	
	private void forMoteurRPN(String str) throws ArithmeticException,NumberFormatException{
	
		switch (str) {
			
			case "+" : M.appliquerOperation(Operation.Plus); M.afficherOperandes(); break;
			case "-" : M.appliquerOperation(Operation.Moins); M.afficherOperandes(); break;
			case "*" : M.appliquerOperation(Operation.Mult); M.afficherOperandes(); break;
			case "/" : M.appliquerOperation(Operation.Div); M.afficherOperandes(); break;
			case "quiter" : System.exit(1); break;
			
		
			default:	double operande = Double.parseDouble(str);
						if(operande> MIN_VALUE && operande < MAX_VALUE){
						M.enregistrerOperande(operande);
						M.afficherOperandes();
						}
						else{					
							System.err.println( "\nintervale depasser danneé un nombre qui depasse pas 8 chifre  ");
						}
						
						break;
		}
	
	}
}