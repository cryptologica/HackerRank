import java.util.Random;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tic-tac-toe
 * @author JT
 */
public class Solution {

    private static char player;
    private static String[] board;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _player;
        String _board[] = new String[29];

        _player = in.next();

        for(int i = 0; i < 29; i++) {
            _board[i] = in.next();
        }

        player = _player.charAt(0);
        board = _board;
        
        nextMove();
    }
    
    static int getTurn(){
        int turn = 1;
        for(int i=0; i<29; i++){
            for(int j=0; j<29; j++){
                if(board[i].charAt(j) == player){
                    turn++;
                }
            }
        }
        return turn;
    }

    static int getQuadrant(int coord1, int coord2){
        //  |1|2|
        //  |3|4|
        int quadrant;
        if(coord1 <= 15 ){
            if(coord2 <= 15){
                quadrant = 1;
            }
            else{
                quadrant = 2;
            }
        }
        else{
            if(coord2 <=15){
                quadrant = 3;
            }
            else{
                quadrant = 4;
            }
        }
        return quadrant;
    }
    
    static void nextMove(){

        int row = 2;
        int col = 1;
        
        int[] result = replicatorGen(row, col);  
        
        int result1 = 0;
        int result2 = 0;
        
        if(result[2] == 0){
            result = replicatorGen(23, 4);
        }
        if(result[2] == 0){
            result = replicatorGen(2, 15);
        }
        if(result[2] == 0){
            result = defaultRand();
        }

        result1 = result[0];
        result2 = result[1];
               
        System.out.print(result1+" "+result2);
   }
    
    static int[] replicatorGen(int row, int col){
        
        int[] result = new int[3];
        int[] horOff = {0, 1, 2, 3, 4, 5, 7, 8, 11, 11, 9, 8, 7, 6, 4, 3, 0};
        int[] vertOff ={0, 0, 0, 0, 0, 0, 0, 0 ,0, -1, -1, -1, -1, -1, -1, -1, -1};
        
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
        
        for (int i = 0; i < 17; i++)
        {
            if(board[row+vertOff[i]].charAt(col+horOff[i]) == '-'){
                result[0] = row + vertOff[i];
                result[1] = col + horOff[i];
                result[2] = 1; 
                break;
            }
        }

        return result;
    }
        
    static int[] defaultRand(){
    	Random rand = new Random();
        int firstNum = rand.nextInt(10);
        int secondNum = rand.nextInt(10);
        int[] result = new int[3];
        
        boolean flag = true;
            while(flag){
                if(board[firstNum].charAt(secondNum) != '-'){
                    firstNum = rand.nextInt(10);
                    secondNum = rand.nextInt(10);
                }
                else{
                    flag = false;
                }
        }
        result[0] = firstNum;
        result[1] = secondNum;
        result[2] = 1;
        
        return result;
    }
        
}
