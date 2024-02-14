import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Candice Lu, Maya Flynn
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");

    // Print out the block
    TBUtils.print(pen, block);

    // Exercise 2
    TextBlock block2 = new TextLine("This is a test.");
    TBUtils.print(pen,block2);

    TextBlock block3 = new TextLine("");

    // Exercise 3
    BoxedBlock boxBlock1 = new BoxedBlock(block2);
    TBUtils.print(pen, boxBlock1);
    BoxedBlock boxBlock2 = new BoxedBlock(boxBlock1);
    TBUtils.print(pen, boxBlock2);
    BoxedBlock boxBlock3 = new BoxedBlock(block3);
    TBUtils.print(pen, boxBlock3);

    // Exercise 4
    TextBlock hello = new TextLine("Hello");
    TextBlock bye = new TextLine("Goodbye");
    TextBlock grettings = new VComposition(hello, bye);
    BoxedBlock greetings = new BoxedBlock(grettings);
    TBUtils.print(pen, greetings);

    BoxedBlock helloBox = new BoxedBlock(hello);
    BoxedBlock byeBox = new BoxedBlock(bye);
    TextBlock separateGreetings = new VComposition(helloBox, byeBox);
    TBUtils.print(pen, separateGreetings);

    TextBlock helloGoodbye = new HComposition(helloBox, bye);
    TextBlock goodbyeHello = new HComposition(bye, helloBox);
    TBUtils.print(pen, helloGoodbye);
    TBUtils.print(pen, goodbyeHello);

    //Exercise 5
    /**
     * String row (int rownum) {
     *   return left.row(rownum) + right.row(rownum);
     * }
     *    
     * 
     * int width() {
     *   return left.width() + right.witdh();
     * }
     * 
     * int height() {
     *    return max(left.height(), right.height());
     * }
     * 
     * Our code didn't check to make sure i was valid. in addition, our code
     * didn't consider Blocks of different height
     * 
     */

    // Exercise 6
    /**
     * String row(int rownum) {
     * 
     * }
     * 
     * int width() {
     *  return max()
     * }
     */

    // tests for mini project 3
    TextBlock helloWorld = new TextLine("Hello World");
    BoxedBlock helloWorldBox = new BoxedBlock(helloWorld);
    Truncated truncate = new Truncated(helloWorldBox, 4);
    TBUtils.print(pen, truncate);
    
    Centered center = new Centered(helloWorldBox, 16);
    TBUtils.print(pen, center);
   
    RightJustified rightJustify = new RightJustified(helloWorldBox, 18);
    TBUtils.print(pen, rightJustify);

    HorizontallyFlipped hf = new HorizontallyFlipped(helloWorldBox);
    TBUtils.print(pen, hf);

    VerticallyFlipped vf = new VerticallyFlipped(helloWorldBox);
    VerticallyFlipped vfGreetings = new VerticallyFlipped(greetings);
    
    TBUtils.print(pen, vf);
    TBUtils.print(pen, vfGreetings);

    PrettyBlock prettyBox = new PrettyBlock(greetings);
    TBUtils.print(pen, prettyBox);

    TextBlock flip1 = new HorizontallyFlipped(helloWorldBox);
    TextBlock flip2 = new HorizontallyFlipped(flip1);
    pen.println(TBUtils.equal(vfGreetings, helloWorldBox));
    pen.println(vfGreetings.eqv(vf));
    pen.println(helloWorldBox.eqv(flip2));
    TBUtils.print(pen, helloWorldBox);
    TBUtils.print(pen, flip2);

    pen.println(TBUtils.eq(vfGreetings, helloWorldBox));
    pen.println(TBUtils.eq(vfGreetings, vf));
    pen.println(TBUtils.eq(helloWorldBox, flip2));
    pen.println(TBUtils.eq(vf, vf));

    Truncated truncating = new Truncated(helloWorldBox, 1);
    TBUtils.print(pen, truncating);

   
    //pen.println(TBUtils.equal(empty, new TextLine("")));

    TextBlock empty = new TextLine("");
    TBUtils.print(pen, new BoxedBlock(empty));
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
