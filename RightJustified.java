/**
 * A text block right justified within the given width.
 *
 * @author Candice Lu, Maya Flynn
 */

public class RightJustified implements TextBlock {
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
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public RightJustified(TextBlock block, int width) {
    this.width = width;
    if (block.width() > width) {
      System.err.println("Too little space in centered.");
      System.exit(1);
    } else {
      int totalSpace = width - block.width();
      TextBlock spacesBlock = new TextLine(TBUtils.spaces(totalSpace));
      HComposition toReturn = new HComposition(spacesBlock, block);
      this.contents = toReturn;
    } // if else
  } // RightJustified(TextBlock, int)

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
    if (i > this.width || i < 0) {
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
    return this.width;
  } // width()

  /**
   * Check if the textblock is constructed in the same way as the other
   */
  public boolean eqv(TextBlock another) {
    return (another instanceof RightJustified) &&
           (this.contents.eqv(((RightJustified) another).contents));
  } // eqv(TextBlock)

} // class RightJustified