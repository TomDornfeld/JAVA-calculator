package tom.dornfeld;

public class Calculator {
	
	
	double operand1;
	double operand2;
	char operator;
	
	private boolean isOp1Set = false;
	private boolean isOp2Set = false;
	private boolean isOperatorSet = false;
	private char operatorLater = ' ';
	private char operandLater = ' ';
	
	
	protected double add(double Num1, double Num2) {
		return Num1+ Num2;
	}
	
	protected double sub(double Num1, double Num2) {
		return Num1- Num2;
	}
	
	protected double mul(double Num1, double Num2) {
		return Num1* Num2;
	}
	
	protected double div(double Num1, double Num2) {
		return Num1/ Num2;
	}
	
	protected double neg(double Num1, double Num2) {
		return -Num1;
	}
	
	
	public void operand(double num) {
		if( !isOp1Set ) {
			this.operand1 = num;
			this.isOp1Set = true;
		} 
		else if ( !isOp2Set ) {
			this.operand2 = num;
			this.isOp2Set = true;
		}
	}	
 
	
	public void operator(char op) {	
		
		if ( isOperatorSet ) {
			if (op == '+' || op == '-' && op == '*' || op == '/') {
				doLater();
				calculate();
			} else {
				calculate();
			}
		}
		
	
		
		this.operator = op;
		isOperatorSet = true;			
	}
	
	public void clear() {
		isOp1Set = false;
		isOp2Set = false;
		isOperatorSet = false;
		operand1 = 0;
		operand2 = 0;
		
		
	}
	
	public void doLater() {
		if (operatorLater == '+' || operatorLater == '-') {
			operand1 = operandLater;
		}
	}
	
	
	
	public double equals() {
		
		return calculate();
	}

	
	protected double calculate() {
		
		double result = 0.0; 
		
		switch (operator) {
		case '+':
			result = add(operand1, operand2);
			break;
		case '-':
			result = sub(operand1, operand2);			
			break;
		case '*':
			result = mul(operand1, operand2);
			break;
		case '/':
			result = div(operand1, operand2);
			break;
		}

		this.operand1 = result;
		isOp1Set = true;

		operand2 = 0.0;
		isOp2Set = false;
		
		operator = 0;
		isOperatorSet = false;

		return result;
	}

}
