/**
 * A text block flipped horizontally.
 *
 * @author Candice Lu, Maya Flynn
 */

public class HorizontallyFlipped implements TextBlock{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * Textblock with some (or none) contents
   */
  public TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public HorizontallyFlipped(TextBlock block) throws Exception{
    for (int i = 0; i < block.height(); i++) {
      String substring = "";
      for (int j = block.width() - 1; j >= 0; j--) {
        substring += block.row(i).charAt(j);
      }
      TextBlock output = new TextLine(substring);
      if (i == 0) {
        this.contents = new TextLine(substring);
      } else {
        this.contents = new VComposition(this.contents, output);
      } //  if else
    } // for loop
  } // HorizontallyFlipped(block)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   */
    public String row(int i) throws Exception {
    if (i > this.contents.width() || i < 0) {
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
    return this.contents.width();
  } // width()

  /**
   * Check if the textblock is constructed in the same way as the other
   */
  public boolean eqv(TextBlock another) {
    return (another instanceof HorizontallyFlipped) &&
           (this.contents.eqv(((HorizontallyFlipped) another).contents));
  } // eqv(TextBlock)

} // class HorizontallyFlipped
