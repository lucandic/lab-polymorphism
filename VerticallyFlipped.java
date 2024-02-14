/**
 * A text block flipped vertically.
 *
 * @author Candice Lu, Maya Flynn
 */

public class VerticallyFlipped implements TextBlock{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box
   */
  public TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public VerticallyFlipped(TextBlock block) throws Exception{
    for (int i = block.height() - 1; i >= 0; i--) {
      TextBlock output = new TextLine(block.row(i));
      if (i == block.height() - 1) {
        this.contents = output;
      } else {
        this.contents = new VComposition(this.contents, output);
      }
    }
  } // VerticallyFlipped(block)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

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
    return (another instanceof VerticallyFlipped) &&
           (this.contents.eqv(((VerticallyFlipped) another).contents));
  } // eqv(TextBlock)

} // class VerticallyFlipped