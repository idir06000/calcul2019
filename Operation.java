public enum Operation {
	
	Plus('+') { 
		public double eval(double a,double b) {
			
			
			return a + b;
		}
	},
	Moins('-') {
		public double eval(double a,double b) {
			return a - b;
		}
	},
	Mult('*') {
		public double eval(double a,double b) {
			return a * b;
			
		}
	},
	Div('/') {
		public double eval(double a,double b) {
			double c = 0;
			if (b == 0)
				System.err.println("Division par 0");
			else
				c= a / b;
			return c;
		}
	};
	
	private char symbole;
	

	
	Operation(char symbole){
	
		String symboles = "+-*/";
		if (symboles.indexOf(symbole)==-1)
			throw new IllegalArgumentException();
		
		else
			
			this.symbole = symbole;
	}

	public char getSymbol(){
		return symbole;
	}
	
	public abstract double eval(double val1, double val2) throws ArithmeticException;
}
