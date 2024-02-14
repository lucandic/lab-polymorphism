/**
 * Tests for textblocks.
 *
 * @author Candice Lu, Maya Flynn
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TextBlockTests{

  //Truncated

  @Test
  public void truncatedNormal() throws Exception{
    TextBlock top = new VComposition (new TextLine("+--"), new TextLine("|He"));
    TextBlock compare = new VComposition (top, new TextLine("+--"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new Truncated(hello, 3)));
  } //  truncatedNormal


  @Test
  public void truncatedSameWidth() throws Exception{
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    TextBlock test = new Truncated(hello, 7);
    assertEquals("|Hello|", test.row(1));
  } //  truncatedLong

  @Test
  public void truncatedWithZero() throws Exception{
    TextBlock top = new VComposition (new TextLine(""), new TextLine(""));
    TextBlock compare = new VComposition (top, new TextLine(""));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new Truncated(hello, 0)));
  } //  truncatedNormal

  @Test
  public void truncatedEmpty() throws Exception{
    TextBlock top = new VComposition (new TextLine(""), new TextLine(""));
    TextBlock compare = new VComposition (top, new TextLine(""));
    BoxedBlock hello = new BoxedBlock(new TextLine(""));
    assertEquals(true, TBUtils.equal(compare, new Truncated(hello, 0)));
  } //  truncatedEmpty

  // Centered
  @Test
  public void centeredNormal() throws Exception{
    TextBlock top = new VComposition (new TextLine("   +-----+   "), new TextLine("   |Hello|   "));
    TextBlock compare = new VComposition (top, new TextLine("   +-----+   "));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new Centered(hello, 13)));
  } //  centeredNormal
  
  @Test
  public void centeredEmpty() throws Exception{
    TextBlock hello = new TextLine("");
    TextBlock test = new Centered(hello, 3);
    assertEquals("   ", test.row(0));
  } //  centeredEmpty

  @Test
  public void centeredWithSameLength() throws Exception{
    TextBlock top = new VComposition (new TextLine("+-----+"), new TextLine("|Hello|"));
    TextBlock compare = new VComposition (top, new TextLine("+-----+"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new Centered(hello, 7)));
  } //  centeredWithSameLength

  @Test
  public void centeredOddSpaces() throws Exception{
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    TextBlock test = new Centered(hello, 10);
    assertEquals("  |Hello| ", test.row(1));
  } //  centeredOddSpaces

// RightJustified

  @Test
  public void rightJustifiedNormal() throws Exception{
    TextBlock top = new VComposition (new TextLine("   +-----+"), new TextLine("   |Hello|"));
    TextBlock compare = new VComposition (top, new TextLine("   +-----+"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new RightJustified(hello, 10)));
  } //  rightJustifiedNormal
  
  @Test
  public void rightJustifiedEmpty() throws Exception{
    TextBlock top = new VComposition (new TextLine("++"), new TextLine("||"));
    TextBlock compare = new VComposition (top, new TextLine("++"));
    BoxedBlock hello = new BoxedBlock(new TextLine(""));
    assertEquals(true, TBUtils.equal(compare, new RightJustified(hello, 2)));
  } //  rightJustifiedEmpty

  @Test
  public void rightJustifiedWithSameLength() throws Exception{
    TextBlock top = new VComposition (new TextLine("+-----+"), new TextLine("|Hello|"));
    TextBlock compare = new VComposition (top, new TextLine("+-----+"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertEquals(true, TBUtils.equal(compare, new RightJustified(hello, 7)));
  } //  rightJustifiedWithSameLength

  //Horizontally Flipped
  @Test
  public void hFlipNormal() throws Exception{
    TextBlock top = new VComposition (new TextLine("+-----+"), new TextLine("|olleH|"));
    TextBlock compare = new VComposition (top, new TextLine("+-----+"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    HorizontallyFlipped hFlip = new HorizontallyFlipped(hello);
    assertEquals(true, TBUtils.equal(compare, hFlip));
  } // hFlipNormal

  @Test
  public void hFlipEmpty() throws Exception{
    TextBlock compare = new TextLine("");
    TextBlock empty = new TextLine("");
    HorizontallyFlipped hFlip = new HorizontallyFlipped(empty);
    assertEquals(true, TBUtils.equal(compare, hFlip));
  } //  hFlipEmpty

  @Test
  public void hFlipSmall() throws Exception{
    TextBlock compare = new TextLine("retupmoCdiputS");
    TextBlock words = new TextLine("StupidComputer");
    HorizontallyFlipped hFlip = new HorizontallyFlipped(words);
    assertEquals(true, TBUtils.equal(compare, hFlip));
  } // hFlipSmall

@Test
  public void hFlipLonger() throws Exception{
    TextBlock words = new BoxedBlock (new TextLine("retupmoCdiputS"));
    TextBlock compare = new TextLine("|StupidComputer|");
    HorizontallyFlipped hFlip = new HorizontallyFlipped(words);
    assertEquals(compare.row(0), hFlip.row(1));
  } // hFlipLonger

  //Vertically Flipped
@Test
  public void vFlipNormal() throws Exception{
    TextBlock greeting = new VComposition (new TextLine("Goodbye"), new TextLine("Hello"));
    TextBlock words = new BoxedBlock (greeting);
    TextBlock compare = new TextLine("|Goodbye|");
    VerticallyFlipped vFlip = new VerticallyFlipped(words);
    assertEquals(compare.row(0), vFlip.row(2));
  } // hFlipLonger

  @Test
  public void vFlipSmall() throws Exception{
    TextBlock greeting = new TextLine("Goodbye");
    TextBlock compare = new TextLine("Goodbye");
    VerticallyFlipped vFlip = new VerticallyFlipped(greeting);
    assertEquals(compare.row(0), vFlip.row(0));
  } // hFlipLonger

  @Test
  public void vFlipEmpty() throws Exception{
    TextBlock empty = new TextLine("");
    TextBlock compare = new TextLine("");
    VerticallyFlipped vFlip = new VerticallyFlipped(empty);
    assertEquals(compare.row(0), vFlip.row(0));
  } // hFlipLonger

  

  // PrettyBlock

  @Test
  public void prettyBlockNormal() throws Exception{
    TextBlock prettyBlock = new TextLine("Goodbye!");
    TextBlock words = new PrettyBlock (prettyBlock);
    String[] compare = {"+ ~~~~Pretty~~~~ +", ":)   Goodbye!   (:"};
    assertEquals(compare[0], words.row(0));
    assertEquals(compare[1], words.row(1));
    assertEquals(compare[0], words.row(2));
  } // prettyBlockNormal

  @Test
  public void prettyBlockShort() throws Exception{
    TextBlock prettyBlock = new TextLine("AB");
    TextBlock words = new PrettyBlock (prettyBlock);
    String[] compare = {"+ ~Pretty~ +", ":)   AB   (:"};
    assertEquals(compare[0], words.row(0));
    assertEquals(compare[1], words.row(1));
    assertEquals(compare[0], words.row(2));
  } // prettyBlockShort

  @Test
  public void prettyBlockShortAndUneven() throws Exception{
    TextBlock prettyBlock = new TextLine("A");
    TextBlock words = new PrettyBlock (prettyBlock);
    String[] compare = {"+ Pretty~ +", ":)   A   (:"};
    assertEquals(compare[0], words.row(0));
    assertEquals(compare[1], words.row(1));
    assertEquals(compare[0], words.row(2));
  } // prettyBlockShortAndUneven

  @Test
  public void prettyBlockWithOddSpaces() throws Exception{
    TextBlock prettyBlock = new TextLine("Goodbye");
    TextBlock words = new PrettyBlock (prettyBlock);
    String[] compare = {"+ ~~~Pretty~~~~ +", ":)   Goodbye   (:"};
    assertEquals(compare[0], words.row(0));
    assertEquals(compare[1], words.row(1));
    assertEquals(compare[0], words.row(2));
  } // prettyBlockWithOddSpaces

  @Test
  public void prettyBlockEmpty() throws Exception{
    TextBlock prettyBlock = new TextLine("");
    TextBlock words = new PrettyBlock (prettyBlock);
    String[] compare = {"+ Pretty +", ":)      (:"};
    assertEquals(compare[0], words.row(0));
    assertEquals(compare[1], words.row(1));
    assertEquals(compare[0], words.row(2));
  } // prettyBlockEmpty

  
                                                                                                                                                                                                                                                                                                                                                                        
    //equal

  @Test
  public void equalSameDifConstruct() throws Exception{
    TextBlock top = new VComposition (new TextLine("+-----+"), new TextLine("|Hello|"));
    TextBlock compare = new VComposition (top, new TextLine("+-----+"));
    BoxedBlock hello = new BoxedBlock(new TextLine("Hello"));
    assertTrue(TBUtils.equal(compare, hello));
  } // equalSameDifConstruct

  @Test
  public void equalSameSameConstruct() throws Exception{
    TextBlock text = new TextLine("Hello");
    TextBlock text2 = new TextLine("Hello");
    assertTrue(TBUtils.equal(text, text2));
  } // equalSameSameConstruct

  @Test
  public void equalSameAddress() throws Exception{
    TextBlock text = new TextLine("Hello");
    assertTrue(TBUtils.equal(text, text));
  } // equalSameAddress
  
  @Test
  public void equalEmpty() throws Exception{        
      TextBlock text = new TextLine("");
      TextBlock text2 = new TextLine("");
      assertTrue(TBUtils.equal(text, text2));
  } // equalEmpty


  @Test
  public void equalNotTheSame() throws Exception{
    TextBlock text = new TextLine("");
      TextBlock text2 = new TextLine("Hello");
          assertFalse(TBUtils.equal(text, text2));
  } // equalNotTheSame



    //eqv

  @Test
  public void eqvOriginalAndTwoFlips() throws Exception{
    TextBlock text = new TextLine("Hello");
    TextBlock flip1 = new HorizontallyFlipped(text);
    TextBlock flip2 = new HorizontallyFlipped(flip1);
    assertEquals(false, flip2.eqv(text));
  } // eqvOriginalAndTwoFlips

  @Test
  public void eqvTwoFlipsAndFourFlips() throws Exception{
    TextBlock text = new TextLine("Hello");
    TextBlock flip1 = new HorizontallyFlipped(text);
    TextBlock flip2 = new HorizontallyFlipped(flip1);
    assertEquals(false, flip2.eqv(text));
  } // eqvTwoFlipsAndFourFlips

  @Test
  public void eqvSameAddress() throws Exception{
    TextBlock text = new TextLine("Hello");
    assertEquals(text, text);
  } // eqvSameAddress
              
  @Test
  public void eqvExactSameThing() throws Exception{
    TextBlock text = new TextLine("Hello");
    TextBlock flip = new HorizontallyFlipped(text);
    assertEquals(true, flip.eqv(flip));
  } // eqvExactSameThing

  @Test
  public void eqvExactSameFlips() throws Exception{
    TextBlock text = new TextLine("Hello");
    TextBlock text2 = new TextLine("Hello");
    TextBlock flip1_1 = new HorizontallyFlipped(text);
    TextBlock flip1_2 = new HorizontallyFlipped(flip1_1);
    TextBlock flip2_1 = new HorizontallyFlipped(text2);
    TextBlock flip2_2 = new HorizontallyFlipped(flip2_1);
    assertEquals(true, flip1_2.eqv(flip2_2));
  } // eqvOriginalAndTwoFlips

  @Test
  public void eqvNotTheSameAtAll() throws Exception{
    TextBlock hello = new PrettyBlock(new TextLine("Hello"));
    TextBlock goodbye = new PrettyBlock(new TextLine("Goodb"));
    assertEquals(false, hello.eqv(goodbye));
  } // eqvNotTheSameAtAll

  @Test
  public void eqSame() throws Exception{
    TextBlock text = new TextLine("Hello");
    assertEquals(true, TBUtils.eq(text, text));
  } // eqSame

  @Test
  public void eqEmptyButSame() throws Exception{
    TextBlock text = new TextLine("");
    assertEquals(true, TBUtils.eq(text, text));
  } // eqSame

  @Test
  public void eqNotTheSame() throws Exception{
    TextBlock text = new TextLine("Hi");
    TextBlock textDuplicate = new TextLine("Hi");
    assertEquals(false, TBUtils.eq(text, textDuplicate));
  } // eqSame

} // class TextBlockTests