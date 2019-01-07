package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("thruDoor.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed()
  {
	  Picture beach = new Picture("thruDoor.jpg");
	  beach.explore();
	  beach.zeroRed();
	  beach.explore();
  }
  
  public static void testZeroGreen()
  {
	  Picture beach = new Picture("thruDoor.jpg");
	  beach.explore();
	  beach.zeroRed();
	  beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVerticalRtoL()
  {
    Picture caterpillar = new Picture("jenny-red.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRtoL();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalLtoR()
  {
	  Picture caterpillar = new Picture("jenny-red.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorVerticalLtoR();
	  caterpillar.explore();
  }
  
  public static void testMirrorHorizontalTtoB()
  {
	  Picture caterpillar = new Picture("jenny-red.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontalTtoB();
	  caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("seagull.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(15);
    swan.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testZeroRed();
    //testZeroGreen();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVerticalRtoL();
    //testMirrorVerticalLtoR();
    //testMirrorHorizontalTtoB();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}