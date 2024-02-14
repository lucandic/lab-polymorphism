import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.Double;

/**
 * A few simple experiments with our utilities.
 *
 * @author Samuel A. Rebelsky
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    pen.println("The squareroot of 5.5 is: " + MathUtils.squareRoot((float)5.5));
    pen.println("The squareroot of 5.5 is: " + MathUtils.squareRoot((double)5.5));
    pen.println("The squareroot of 5 is: " + MathUtils.squareRoot(BigInteger.valueOf(5)));
    pen.println("The squareroot of 4 is: " + MathUtils.squareRoot(BigDecimal.valueOf(4)));
    pen.println("The squareroot of 4 is: " + MathUtils.squareRoot(Double.valueOf(4)));
    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
