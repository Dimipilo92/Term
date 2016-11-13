package term;

public class TermTest {

	public static void main (String args[]) {
		
		Term[] terms = new Term[13];
		terms[0] = new Term("3x^2"); // 3.0x2.0
		terms[1] = new Term("0.0"); // 0.0
		terms[2] = new Term("0y^10"); 
		terms[3] = new Term("-15.3333y^1");
		
		terms[4] = new Term("4x");
		terms[5] = new Term("y^4");
		
		terms[6] = new Term("w");
		terms[7] = new Term("3");
		terms[8] = new Term("333");
		terms[9] = new Term("9.3y^3.3");
		terms[10] = new Term("3x4");
		terms[11] = new Term(""); 
		terms[12] = new Term("-x");
		
		for (int i = 0; i < terms.length; i++){
			System.out.println(terms[i].toSimpleString());
		}
		
		Term[] errors = new Term[12];
		
		// Should throw "MalFormedTerm Exception"
		System.out.println("Test 1: ");
		terms[0] = new Term("adsf");
		System.out.println("Test 2: ");
		terms[1] = new Term("3xy"); // allowable in the future (3*x*y)
		System.out.println("Test 3: ");
		terms[2] = new Term("xy3"); // allowable in the future (x*y^3)
		System.out.println("Test 4: ");
		terms[3] = new Term("!3+");
		System.out.println("Test 5: ");
		terms[4] = new Term("-");
		System.out.println("Test 6: ");
		terms[5] = new Term(".x");
		System.out.println("Test 7: ");
		terms[6] = new Term("-.x");
		System.out.println("Test 8: ");
		terms[7] = new Term("x-");
		System.out.println("Test 9: ");
		terms[8] = new Term("x-.");
		System.out.println("Test 10: ");
		terms[9] = new Term("^"); // Does not throw error
		System.out.println("Test 11: ");
		terms[10] = new Term("x^"); // Does not throw error
		System.out.println("Test 12: ");
		terms[11] = new Term("^33"); // Does not throw error
		System.out.println("Test 13: ");
		terms[11] = new Term("0^33"); // Does not throw error
	}

}