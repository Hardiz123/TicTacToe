import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 */
public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
    static Scanner scanner = new Scanner(System.in);
    static boolean bool = true;
    static char [][] gameBoard = {{' ','|' , ' ','|',' '},
    {'-','+' , '-','+','-'},
    {' ','|' , ' ','|',' '},
    {'-','+' , '-','+','-'},
    {' ','|' , ' ','|',' '}};
    public static void main(String[] args) {

    printGameBoard(gameBoard);

    while(bool){
        
    System.out.println("Enter your placements (1-9):");

    int playerPos = scanner.nextInt();

    while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)){
        System.out.println("position taken! Enter a correct position");
        playerPos = scanner.nextInt();
    }

    placePiece(gameBoard, playerPos, "player");
    printGameBoard(gameBoard);
    String result = checkWinner();
    

    if(result.length() >0){
        // printGameBoard(gameBoard);
        System.out.println(result);
        bool = playAgain();
        
    }
    
    Random rand = new Random();

    int cpuPos = rand.nextInt(9)+1;

    while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
        cpuPos = rand.nextInt(9)+1;
    }
    System.out.println("CPU tern");
    placePiece(gameBoard, cpuPos, "cpu");

    result = checkWinner();
    if(result.length() >0){
        System.out.println(result);
        bool = playAgain();
        
    }
    printGameBoard(gameBoard);
    
    }
    scanner.close();

    }
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
        
    }

    public static void placePiece(char [] [] gameBoard , int pos ,String user){

        char symbol = ' ';

        if(user.equals("player")){
            symbol = 'X';
            playerPosition.add(pos);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPosition.add(pos);
        }

        switch(pos){
            case 1:
                gameBoard[0][0]= symbol;
                break;
            case 2:
                gameBoard[0][2]= symbol;
                break;
            case 3:
                gameBoard[0][4]= symbol;
                break;
            case 4:
                gameBoard[2][0]= symbol;
                break;
            case 5:
                gameBoard[2][2]= symbol;
                break;
            case 6:
                gameBoard[2][4]= symbol;
                break;
            case 7:
                gameBoard[4][0]= symbol;
                break;
            case 8:
                gameBoard[4][2]= symbol;
                break;
            case 9:
                gameBoard[4][4]= symbol;
                break;
            default:
                break;
        }

    }
    public static String checkWinner(){

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftcol = Arrays.asList(1,4,7);
        List midcol = Arrays.asList(2,5,8);
        List rightcol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>(); 
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerPosition.containsAll(l)){
                return "Congratulation you won!";
            }else if(cpuPosition.containsAll(l)){
                return "Cpu Wins! Sorry";
            }else if(playerPosition.size()+ cpuPosition.size() == 9){
                return "Board full";
            }
        }
        return "";
    }

    public static boolean playAgain() {
        System.out.println("Want to play again?? press Y/N");

        String input = scanner.nextLine().toUpperCase();
        if(input.equals("Y")){
            gameBoard =  clearBoard(gameBoard);
            return true;
        }else if(input.equals("N")){
            gameBoard =  clearBoard(gameBoard);
            return false;
        }
        else{
            return false;
        }
        
    }

    public static char[][] clearBoard(char[][] gameBoard) {
    
    char[][] gamebord1 =  {{' ','|' , ' ','|',' '},{'-','+' , '-','+','-'},{' ','|' , ' ','|',' '},{'-','+' , '-','+','-'},{' ','|' , ' ','|',' '}};
    playerPosition.clear();
    cpuPosition.clear();
    printGameBoard(gameBoard);
    return gamebord1;
        
    }
}