	// https://www.hackerrank.com/challenges/tic-tac-toe
	
	import java.util.*;

	public class Solution { //This must change to "Solution"

	/* Complete the function below to print 2 integers separated by a single space which will be your next move 
	   Refer section <i>Output format</i> for more details
	*/
	  static void nextMove(String player, String [] board){
	    System.out.print(firstNum+" "+secondNum);
	  }
	  
	  private static int firstNum;
	  private static int secondNum;
	  private static char[][] rowBoard = new char[3][3];
	  
	  @SuppressWarnings("resource")
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String player;
	        String board[] = new String[3];

	        //If player is X, I'm the first player.
	        //If player is O, I'm the second player.
	        player = in.next();

	        //Read the board now. The board is a 3x3 array filled with X, O or _.
	        for(int i = 0; i < 3; i++) {
	            board[i] = in.next();
	        }
	        
		  String s;
		  
	      s = board[0];
	      char square00 = s.charAt(0);
	      char square01 = s.charAt(1);
	      char square02 = s.charAt(2);
	      char[] row1 = {square00, square01, square02};
	      
	      s = board[1];
	      char square10 = s.charAt(0);
	      char square11 = s.charAt(1);
	      char square12 = s.charAt(2);
	      char[] row2 = {square10, square11, square12};
	      
	      s = board[2];
	      char square20 = s.charAt(0);
	      char square21 = s.charAt(1);
	      char square22 = s.charAt(2);
	      char[] row3 = {square20, square21, square22};
	      
	      rowBoard[0] = row1;
	      rowBoard[1] = row2;
	      rowBoard[2] = row3;
	      
	      String otherPlayer;
	      char otherPlayerChar;
	      char playerChar;
	      if (player.equals("X"))
	      {
	    	  otherPlayer = "O";
	    	  otherPlayerChar = 'O';
	    	  playerChar = 'X';
	      }
	      else
	      {
	    	  otherPlayer = "X";
	    	  otherPlayerChar = 'X';
	    	  playerChar = 'O';
	      }
	        
	      if(row2[1] == '_'){
	    	  firstNum = 1;
	    	  secondNum = 1;
	      }
	      else if (canWinNext(player))
	      {
	      }
	      else if (canWinNext(otherPlayer))
	      {
	      }
	      else if (isTurnTwoO() && row2[1] == playerChar && ((row1[0] == otherPlayerChar && row3[2] == otherPlayerChar) || (row1[2] == otherPlayerChar && row3[0] == otherPlayerChar)))
	      {
	    	  firstNum = 0;
	    	  secondNum = 1;
	      }
	      else if (isTurnTwoO() && row2[1] == playerChar && (row1[1] == otherPlayerChar && row2[2] == otherPlayerChar)) {
	    	  firstNum = 0;
	    	  secondNum = 2;
	      }
	      else if (isTurnTwoO() && row2[1] == playerChar && (row1[1] == otherPlayerChar && row2[0] == otherPlayerChar)) {
	    	  firstNum = 0;
	    	  secondNum = 0;
	      }
	      else if (isTurnTwoO() && row2[1] == playerChar && (row2[0] == otherPlayerChar && row3[1] == otherPlayerChar)) {
	    	  firstNum = 2;
	    	  secondNum = 0;
	      }
	      else if (isTurnTwoO() && row2[1] == playerChar && (row2[2] == otherPlayerChar && row3[1] == otherPlayerChar)) {
	    	  firstNum = 2;
	    	  secondNum = 2;
	      }
	      else if (doubleAttack(player, otherPlayer))
	      {
	      }
	      else if (row1[0] == '_' || row1[2] == '_' || row3[0] == '_' || row3[2] == '_')
	      {
	    	  int rand = (int)Math.floor(Math.random()*4);
	    	  switch (rand)
	    	  {
	    		  case 0:
	    			  if (row1[0] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    		  case 1:
	    			  if (row1[2] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    		  case 2:
	    			  if (row3[0] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    		  case 3:
	    			  if (row3[2] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    		  default:
	    			  if (row1[0] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    			  if (row1[2] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    			  if (row3[0] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    			  if (row3[2] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    	  }
	    			  
	      }
	      else
	      {
	    	  int rand = (int)Math.floor(Math.random()*4);
	    	  switch (rand)
	    	  {
	    		  case 0:
	    			  if (row1[1] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 1;
	    				  break;
	    			  }
	    		  case 1:
	    			  if (row2[0] == '_')
	    			  {
	    				  firstNum = 1;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    		  case 2:
	    			  if (row2[2] == '_')
	    			  {
	    				  firstNum = 1;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    		  case 3:
	    			  if (row3[1] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 1;
	    				  break;
	    			  }
	    		  default:
	    			  if (row1[1] == '_')
	    			  {
	    				  firstNum = 0;
	    				  secondNum = 1;
	    				  break;
	    			  }
	    			  if (row2[0] == '_')
	    			  {
	    				  firstNum = 1;
	    				  secondNum = 0;
	    				  break;
	    			  }
	    			  if (row2[2] == '_')
	    			  {
	    				  firstNum = 1;
	    				  secondNum = 2;
	    				  break;
	    			  }
	    			  if (row3[1] == '_')
	    			  {
	    				  firstNum = 2;
	    				  secondNum = 1;
	    				  break;
	    			  }
	    	  }
	      }
	    	

	  		nextMove(player,board);	
	    
	    }
	  
	  private static boolean canWinNext(String player){
		  // Rows
		  if (checkLine(player, 0, 0, 0, 1))
		  {
		  }
		  else if (checkLine(player, 1, 0, 0, 1))
		  {
		  }
		  else if (checkLine(player, 2, 0, 0, 1))
		  { 
		  }
		  // Columns
		  else if (checkLine(player, 0, 0, 1, 0))
		  {
		  }
		  else if (checkLine(player, 0, 1, 1, 0))
		  {
		  }
		  else if (checkLine(player, 0, 2, 1, 0))
		  { 
		  }
		  // Diagonals
		  else if (checkLine(player, 0, 0, 1, 1))
		  {
		  }
		  else if (checkLine(player, 2, 0, -1, 1))
		  { 
		  }
		  else
		  {
			  return false;
		  }
		  
		  return true;
	  }
	  
	  /**
	   * 
	   * @param playerStr
	   * @param sr starting Row
	   * @param sc starting Column
	   * @param ri row Increment (0, 1, -1)
	   * @param ci column Increment (0, 1, -1)
	   * @return
	   */
	  private static boolean checkLine(String playerStr, int sr, int sc, int ri, int ci) {
		  char player = playerStr.charAt(0);
		  
		  if ((rowBoard[sr][sc] == player) && (rowBoard[sr + ri][sc + ci] == player) && (rowBoard[sr + 2*ri][sc + 2*ci] == '_'))
		  {
			  firstNum = sr + 2*ri;
		      secondNum = sc + 2*ci;
		      return true;
		  }
		  else if ((rowBoard[sr][sc] == player) && (rowBoard[sr + 2*ri][sc + 2*ci] == player) && (rowBoard[sr + ri][sc + ci] == '_'))
		  {
			  firstNum = sr + ri;
		      secondNum = sc + ci;
		      return true;
		  }
		  else if ((rowBoard[sr][sc] == '_') && (rowBoard[sr + 2*ri][sc + 2*ci] == player) && (rowBoard[sr + ri][sc + ci] == player))
		  {
			  firstNum = sr;
			  secondNum = sc;
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	  }
	  
	  private static boolean doubleAttack(String playerStr, String otherPlayerStr)
	  {
		  char player = playerStr.charAt(0);
		  char otherPlayer = otherPlayerStr.charAt(0);
		  if (rowBoard[1][1] == player)
		  {
			  if (isTurnTwo())
			  {
				  if (rowBoard[0][0] == otherPlayer)
				  {
					  firstNum = 2;
					  secondNum = 2;
					  return true;
				  }
				  else if (rowBoard[0][2] == otherPlayer)
				  {
					  firstNum = 2;
					  secondNum = 0;
					  return true;
				  }
				  else if (rowBoard[2][0] == otherPlayer)
				  {
					  firstNum = 0;
					  secondNum = 2;
					  return true;
				  }
				  else if (rowBoard[2][2] == otherPlayer)
				  {
					  firstNum = 0;
					  secondNum = 0;
					  return true;
				  }
				  else if (rowBoard[0][1] == otherPlayer)
				  {
					  firstNum = 2;
					  secondNum = 2;
					  return true;
				  }
				  else if (rowBoard[1][0] == otherPlayer)
				  {
					  firstNum = 2;
					  secondNum = 2;
					  return true;
				  }
				  else if (rowBoard[1][2] == otherPlayer)
				  {
					  firstNum = 0;
					  secondNum = 0;
					  return true;
				  }
				  else if (rowBoard[2][1] == otherPlayer)
				  {
					  firstNum = 0;
					  secondNum = 0;
					  return true;
				  }
			  }
		  }
		  
		  
		  return false;
	  }
	  
	  private static boolean isTurnTwo()
	  {
		  int xCount = 0;
		  int oCount = 0;
		  for (int i = 0; i < 3; i++)
		  {
			for (int j = 0; j < 3; j++)
			{
				if (rowBoard[i][j] == 'X')
				{
					xCount++;
				}
				else if (rowBoard[i][j] == 'O')
				{
					oCount++;
				}
			}
		  }
		  return ((xCount == 1) && (oCount == 1));
	  }
	  
	  private static boolean isTurnTwoO()
	  {
		  int xCount = 0;
		  int oCount = 0;
		  for (int i = 0; i < 3; i++)
		  {
			for (int j = 0; j < 3; j++)
			{
				if (rowBoard[i][j] == 'X')
				{
					xCount++;
				}
				else if (rowBoard[i][j] == 'O')
				{
					oCount++;
				}
			}
		  }
		  return ((xCount == 2) && (oCount == 1));
	  }

	  
	}
