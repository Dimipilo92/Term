package term;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.DecimalFormat;
import java.lang.Math;

class Term {
	private Double coefficient;
	private Character variable;
	private Double power;
	
	public Term(){
		coefficient = 0.0;
		variable = '0';
		power = 0.0;
	}
	
	public Term(String term) {
		
		if (term.length() == 0)
		{
			coefficient = 0.0;
			variable = '0';
			power = 0.0;
			return;
		}
		
		Pattern p = Pattern.compile("([+-]?\\d*\\.?\\d*)" // sign,number,decimal,number
												+"([a-zA-Z]?)" // variable
												+"\\^?([+-]?\\d*?\\.?\\d*?)"); // sign, number, decimal, number
		// ^ 				// start of string
		// [+-]?  		// + or - (Optional - cannot be the only character)
		// \d*   			// any number of digits (Optional)
		// \.?   			// optional decimal (Optional if preceeded or followed by a decimal)
		// \d*  			// optional number of decimals
		// [a-zA-Z]? 	// a single alphabetic character (Optional)
		// \d*   			// any number of digits
		// \.?   			// optional decimal (Optional if preceeded or followed by a decimal)
		// \d*  			// optional number of decimals (Optional)
		// $ 				// end of string
		
		try {
			Matcher m = p.matcher(term);
			
			if (m.matches()) {
				
				if (m.group(1).equals("-") && (!m.group(2).isEmpty()))
					coefficient = -1.0;
				else if (!m.group(1).isEmpty() && m.group(1) != null)
					coefficient = Double.parseDouble(m.group(1));
				else
					coefficient = 1.0;
				
				if (!m.group(2).isEmpty() && m.group(2) != null)
					variable = m.group(2).charAt(0);
				else 
					variable = '0';
				
				if (!m.group(3).isEmpty() && m.group(3) != null)
					power = Double.parseDouble(m.group(3));
				else if (!m.group(2).isEmpty())
					power = 1.0;
				else
					power = 0.0;
			}
			else
				System.out.println("Throw MalformedTermException");
		}
		catch (IllegalStateException | NumberFormatException e) {
			//THROW MalformedTermException
			System.out.println("Throw MalformedTermException");
		}
	}
	
	public Boolean isZero() {
		return (coefficient == 0);
	}
	
	public String toSimpleString () {
		DecimalFormat coeff = new DecimalFormat("+#.##;-#");
		DecimalFormat pow = new DecimalFormat("(+#.##);-#");
		return ((Math.abs(coefficient) != 1.0 || power == 0.0)? coeff.format(coefficient) : // if there is a coefficient (coeff != 1) or a power (pow != 0), display the coefficient
						(coefficient < 1.0)? "-":"")																// if the coefficient = -1, display "-"
					+ ((power != 0.0 && coefficient != 0.0)? variable.toString()					// if the power and coeff != 0, display the variable
						+ ((power != 1.0)? "^" + pow.format(power) : "") : "");						// if the power != 1, display it
	}
	
	public String toString () {
		DecimalFormat coeff = new DecimalFormat("+#0.00;-#");
		DecimalFormat pow = new DecimalFormat("(+#0.00);-#");
		
		return coeff.format(coefficient)+variable.toString() + "^" + pow.format(power);
	}
}