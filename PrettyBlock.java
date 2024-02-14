/**
 * A pretty textblock.
 *
 * @author Candice Lu, Maya Flynn
 */

public class PrettyBlock implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box
   */
  TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with contents _contents.
   */
  public PrettyBlock(TextBlock _contents) {
    this.contents = _contents;
  } // PrettyBlock(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    // The top and bottom of the box

    int lengthOfTildesLeft;
    int lengthOfTildesRight;
    if (this.contents.width() % 2 == 0){
      lengthOfTildesLeft = this.contents.width() / 2;
      lengthOfTildesRight = this.contents.width() / 2;
    } else {
      lengthOfTildesLeft = (this.contents.width() - 1) / 2;
      lengthOfTildesRight = ((this.contents.width() - 1) / 2) + 1;
    }

    if ((i == 0) || (i == h + 1)) {
      return "+ " + TBUtils.tildes(lengthOfTildesLeft) + "Pretty" + TBUtils.tildes(lengthOfTildesRight) + " +";
    }
    // Stuff within the box
    else if ((i > 0) && (i <= h)) {
      return ":)   " + this.contents.row(i - 1) + "   (:";
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    } // if else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 2 + this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return 10 + this.contents.width();
  } // width()

  /**
   * Check if the textblock is constructed in the same way as the other
   */
  public boolean eqv(TextBlock another) {
    return (another instanceof PrettyBlock) &&
           (this.contents.eqv(((PrettyBlock) another).contents));
  } // eqv(TextBlock)

} // class PrettyBlock


// Design notes

// Long textblock
//  + ~~~~~~~~~~~~~~~ Pretty ~~~~~~~~~~~~~~~~ +
//  :)   I am so cool and this line is long   (:
//  + ~~~~~~~~~~~~~~~ Pretty ~~~~~~~~~~~~~~~~ +

// Empty textblock
//  + Pretty +
//  :)      (:
//  + Pretty +

// Short textblock
//  + ~Pretty~ +
//  :)   hi   (:
//  + ~Pretty~ +