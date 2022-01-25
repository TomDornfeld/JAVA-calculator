package tom.dornfeld;

public class Calculator {
	
	double operand1;
	double operand2;
	char operator;
	
	
	public double add(double Num1, double Num2) {
		return Num1+ Num2;
	}
	
	public double sub(double Num1, double Num2) {
		return Num1- Num2;
	}
	
	public double mul(double Num1, double Num2) {
		return Num1* Num2;
	}
	
	public double div(double Num1, double Num2) {
		return Num1/ Num2;
	}
	
	public double neg(double Num1, double Num2) {
		return -Num1;
	}
	
	
	public void operand1(double num) {	
		this.operand1 = num;
	}
	
	public void operand2(double num) {	
		this.operand2 = num;		
	}
	

	public void operator(char op) {
		this.operator = op;
	}

	//	public void add() {
//	}
//	
//	public void sub() {
//	}
//	
//	public void mul() {
//	}
//	
//	public void div() {
//	}
	
	public double equals() {
		
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
		return result;
	}

}
