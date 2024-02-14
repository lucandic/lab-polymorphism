/**
 * A text block truncated to the given width.
 *
 * @author Candice Lu, Maya Flynn
 */

public class Truncated implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box
   */
  public TextBlock contents;

  /**
   * Width of final outcome
   */
  int maxWidth;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Truncated(TextBlock block, int maxWidth) throws Exception {
    this.maxWidth = maxWidth;
    if (maxWidth > block.width()) {
      System.err.println("Too much space in truncated.");
      System.exit(1);
    }
    for (int i = 0; i < block.height(); i++) {
      String substring = "";
      for (int j = 0; j < maxWidth; j++) {
        
        substring += block.row(i).charAt(j);
      }     
      TextBlock output = new TextLine(substring);
      if (i == 0) {
        this.contents = output;
      } else {
        this.contents = new VComposition(this.contents, output);
      } // if else
    } // for loop
  } // Truncated(block, maxWidth)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i > this.maxWidth || i < 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.contents.row(i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return maxWidth;
  } // width()

  /**
   * Check if the textblock is constructed in the same way as the other
   */
  public boolean eqv(TextBlock another) {
    return (another instanceof Truncated) &&
           (this.contents.eqv(((Truncated) another).contents));
  } // eqv(TextBlock)

} // class Truncated