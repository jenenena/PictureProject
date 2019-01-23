package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.util.Random;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  
//  public void negate()
//  {
//	  Pixel[][] pixels  = this.getPixels2D();
//	  for (int row = 0; row < pixels.length; row++)
//	  {
//		  for (int col = 0; col < pixels[0].length; col++)
//		  {
//			  Pixel current = pixels[row][col];
//			  int red = current.getRed()
//			  current.setColor()
//		  }
//	  }
//  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalLtoR()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRtoL()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < width; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontalTtoB()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int col = 0; col < pixels[0].length; col++)
	  {
		  for(int row = 0; row < height / 2; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - row - 1][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  
  public void chromokey(Picture replacement, Color changeColor)
  {
	 Pixel [][] mainPixels = this.getPixels2D();
	 Pixel [][] replacementPixels = replacement.getPixels2D();
	 
	 for(int row = 0; row < mainPixels.length; row++)
	 {
		 for(int col = 0; col < mainPixels[0].length; col++)
		 {
		 		if(mainPixels[row][col].colorDistance(changeColor) < 10)
		 		{
		 			mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
		 		}
		 }
	 }
  }
  
  public void shiftLeftRight(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount;
	  int width = pixels[0].length;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  shiftedValue = (col + amount) % width;
			  copied[row][col].setColor(pixels[row][shiftedValue].getColor());
		  }
	  }
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setColor(copied[row][col].getColor());
		  }
	  }
	  
  }
  
  public void shiftUpDown(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount;
	  int height = pixels.length;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  shiftedValue = (row + amount) % height;
			  copied[row][col].setColor(pixels[shiftedValue][col].getColor());
		  }
	  }
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setColor(copied[row][col].getColor());
		  }
	  }
  }
  
  public void glitchy()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = pixels.length;
	  int width = pixels[0].length;
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
	  
	  int random1 = (int)(Math.random() * (height - 20));
	  int random2 = (int)(Math.random() * (width - 40));
	  
	  int mirrorPoint = (int)(Math.random() * width);
	  int mirrorPoint2 = (int)(Math.random() * width);
	  
	  int random3 = (int)(Math.random() * height);
	  int random4 = (int)(Math.random() * width);
	  
	  //TO REFLECT AND MAKE IT MAGENTA
//	  for(int row = 0; row < height; row++)
//	  {
//		  for(int col = 0; col < width; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  pastePixel = pixels[row][width - 1 - col];
//			  pastePixel.setColor(copyPixel.getColor());
//			  pastePixel.setBlue(100);
//			  pastePixel.setGreen(pastePixel.getRed() / 2);
//			  
//		  }
//	  }
	  
	  //TO REFLECT WITH 1/2 OPACITY
	  for(int row = 0; row < height; row++)
	  {
		  for(int col = 0; col < width; col++)
		  {
			  copyPixel = pixels[row][col];
			  pastePixel = pixels[row][width - 1 - col];
			  pastePixel.setBlue((pastePixel.getBlue() + copyPixel.getBlue()) / 2);
			  pastePixel.setGreen((pastePixel.getGreen() + copyPixel.getGreen()) / 2);
			  pastePixel.setRed((pastePixel.getRed() + copyPixel.getRed()) / 2);
			  
		  }
	  }
	  
	  //TO COPY PASTE RANDOMLY WITH ZERO BLUE
//	  for(int row = random1; row < random1 + 20; row++)
//	  {
//		  for(int col = random2; col < random2 + 40; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  copyPixel.setBlue(0);
//			  pastePixel = pixels[row][mirrorPoint2 - col + mirrorPoint2];
//			  pastePixel.setColor(copyPixel.getColor());
//			  
//		  }
//		  
//	  }
	  
	  //TO REFLECT A SECTION WITH ZERO GREEN
//	  for(int row = 36; row < 300; row++)
//	  {
//		  for(int col = 56; col < 239; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  copyPixel.setGreen(0);
//			  pastePixel = pixels[row][mirrorPoint - col + mirrorPoint];
//			  pastePixel.setColor(copyPixel.getColor());
//			  
//		  }
//		  
//	  }
//	  
  }
  
  public void mirrorGull()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int basePoint = 483;
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
	  Pixel pastePixel2 = null;
	  for(int row = 225; row < 335; row++)
	  {
		  for(int col = 225; col < 335; col++)
		  {
			  copyPixel = pixels[row][col];
			  pastePixel = pixels[row][col + 200];
			  pastePixel2 = pixels[row - 200][col];
			  pastePixel.setColor(copyPixel.getColor());
			  pastePixel2.setColor(copyPixel.getColor());
		  }
	  }
	  
  }
  
  public void crazyGull()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("palm.jpg");
    Picture flower2 = new Picture("goat.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,1000);
    this.copy(flower1,200,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    //this.mirrorVerticalLtoR();
    this.write("collage.jpg");
  }
  
  
  
  
  
  
  // GOAT!	GOAT!	GOAT!	GOAT!	GOAT!	GOAT!	GOAT!	GOAT!	GOAT!
  
  
  
  
  public void goatArt(Picture fromPic, int startRow, int startCol)
  {
	  Picture palm = new Picture("palm.jpg");
	  for(int i = 1; i < 7; i++)
	  {
		  this.copy(palm, (int)(Math.random()*200), (int)(Math.random()*600));
	  }
	  
	  Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPic.getPixels2D();
	    for (int fromRow = 830, toRow = startRow; 
	         fromRow < 1000 &&
	         toRow < (startRow + 170); 
	         fromRow++, toRow++)
	    {
	      for (int fromCol = 380, toCol = startCol; 
	           fromCol < 650 &&
	           toCol < (startCol + 270);  
	           fromCol++, toCol++)
	      {
	        fromPixel = fromPixels[fromRow][fromCol];
	        toPixel = toPixels[toRow][toCol];
	        toPixel.setColor(fromPixel.getColor());
	      }
	    }   
	    this.write("goatArt.jpg");
  }
  
  
  
  
  
  
  
  
  
  
  
  
  public void hidePicture(Picture message)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] hiddenPixels = message.getPixels2D();
	  
	  for(int row = 0; row < pixels.length && row < hiddenPixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length && row < hiddenPixels[0].length; col++)
		  {
			  if (hiddenPixels[row][col].colorDistance(Color.WHITE) > 5)
			  {
				  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)  
				  {
					  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
				  }
			  }
			  else if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() - 1);
			  }
		  }
	  }
  }
  
  public void revealPicture()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  //there is a message to reveal!
			  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 != 1)
			  {
				  pixels[row][col].setColor(Color.CYAN);
			  }
			  else if(pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 == 1)
			  {
				  pixels[row][col].setColor(Color.MAGENTA);
			  }
			  else if(pixels[row][col].getRed() == 0)
			  {
				  pixels[row][col].setColor(Color.WHITE);
			  }
		  }
	  }
	  
  }
  
  public void havingFun()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  if(pixels[row][col].getGreen() > 200)
			  {
				  pixels[row][col].setColor(Color.GREEN);
			  }
			  else if(pixels[row][col].getRed() > 200)
			  {
				  pixels[row][col]
			  }
		  }
	  }
	                   
	                   
	                   
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
