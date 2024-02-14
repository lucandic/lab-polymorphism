/**
 * A text block centered within the given width.
 *
 * @author Candice Lu, Maya Flynn
 */

public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * Textblock with some (or none) contents
   */  
  public TextBlock contents;
  
  /**
   * Width of final outcome
   */
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Centered(TextBlock block, int width) {
    this.width = width;
    if (block.width() > width) {
      System.err.println("Too little space in centered.");
      System.exit(1);
    } else {
      int totalSpace = width - block.width();
      if (totalSpace % 2 == 0) {
        TextBlock spacesBlock = new TextLine(TBUtils.spaces(totalSpace / 2));
        HComposition leftSide = new HComposition(spacesBlock, block);
        TextBlock toReturn = new HComposition(leftSide, spacesBlock);
        this.contents = toReturn;
      } else {
        TextBlock leftSpacesBlock = new TextLine(TBUtils.spaces((totalSpace + 1) / 2));
        TextBlock rightSpacesBlock = new TextLine(TBUtils.spaces(((totalSpace + 1) / 2) - 1));
        HComposition leftSide = new HComposition(leftSpacesBlock, block);
        TextBlock toReturn = new HComposition(leftSide, rightSpacesBlock);
        this.contents = toReturn;
      } // if else
    } // if else
  } // centered(TextBlock, int)


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
    return (another instanceof Centered) &&
           (this.contents.eqv(((Centered) another).contents));
  } // eqv(TextBlock)

} // class Centered