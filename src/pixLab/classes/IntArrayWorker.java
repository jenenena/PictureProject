package pixLab.classes;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal() //a for loop is good if you want to change things, and it tells you where you are using the interval counter
  {
   int total = 0;
   for (int row = 0; row < matrix.length; row++)
   {
     for (int col = 0; col < matrix[0].length; col++)
     {
       total = total + matrix[row][col];
     }
   }
   return total;
  }
  
  
  public int getLargest()
  {
	  int largest = Integer.MIN_VALUE;
	  for (int r = 0; r < matrix.length; r++)
	  {
		  for (int c = 0; c < matrix[0].length; c++)
		  {
			  if (matrix[r][c] > largest)
			  {
				  largest = matrix[r][c];
			  }
		  }
	  }
	  return largest;
  }
  
  public int getColTotal(int col) //if given a parameter in a test you should use it in the code 
  {
	  int colTotal = 0;
   	  for (int i = 0; i < matrix.length; i++)
   	  {
   		  colTotal = colTotal + matrix[i][col];
   	  }
   	  return colTotal;
  }
  
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested() //a for each loop is good for accumulators (totals) but you can't change anything inside matrix
  {
    int total = 0;
    for (int[] rowArray : matrix) //for each row in the matrix
    {
      for (int item : rowArray) //for each item in the row
      {
        total = total + item; //add the item to the total
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
  
  public int getCount(int numberToFind)
  {
	  int count = 0;
	  for(int[] row : matrix)
	  {
		  for(int item : row)
		  {
			  if(item == numberToFind)
			  {
				  count++;
			  }
		  }
	  }
	  //count = matrix[0].length;
	  return count;
  }
}