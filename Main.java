import java.util.Random;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    static int playerScore =0;
    static int computerScore =0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        final char [][] gameBoard = {{' ','|' , ' ','|',' '},
    {'-','+' , '-','+','-'},
    {' ','|' , ' ','|',' '},
    {'-','+' , '-','+','-'},
    {' ','|' , ' ','|',' '}};

    
    printBoard(gameBoard);
    boolean playAgain =true;
    boolean gameOver = false;

    while (playAgain) {
        
    while (!gameOver) {
        playerMove(gameBoard);
        gameOver = isGaveOver(gameBoard);
        if(gameOver){
            break;
        }

        computerMove(gameBoard);
        gameOver = isGaveOver(gameBoard);
        if(gameOver){
            break;
        }
    }
    System.out.println("PlayerScore: "+playerScore);
    System.out.println("ComputerScore: "+computerScore);
    System.out.println("DO you want to play again press Y or N");
    scanner.nextLine();
    final String input = scanner.nextLine().toUpperCase();
    switch (input) {
        case "Y":
        playAgain=true;
        resetBoard(gameBoard);
        gameOver=false;
        printBoard(gameBoard);
            break;
        case "N":
            playAgain =false;
            break;
        default:
            break;
    }
    
    }
}

    public static void printBoard(final char[][] gameBoard) {
        for(final char[] row: gameBoard){
            for(final char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void updateBoard(final int position , final int player , final char[][] gameBoard) {
        char character;

        if(player==1){
            character ='X';
        }else{
            character ='O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[4][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[4][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[4][4] = character;
                printBoard(gameBoard);
                break;
        
            default:
            System.out.println("Enter a valid input");
                break;
        }
    }
    public static void playerMove(final char[][] gameBoard) {
        System.out.println("Please make a move.(1-9)");
        

        int move = scanner.nextInt();

        boolean result = isValidMove(move, gameBoard);

        while (!result) {
            System.out.println("Sorry! invalid Move");
            move = scanner.nextInt();
            result = isValidMove(move, gameBoard);
        }
        System.out.println("player moved at posiiyon: " + move);
        updateBoard(move, 1, gameBoard);
    }

    public static void computerMove(final char[][] gameBoard) {

        // final Random rand = new Random();
        // int move = rand.nextInt(9)+1;
        int move = scanner.nextInt();

        boolean result = isValidMove(move, gameBoard);

        while(!result){
            // move = rand.nextInt(9)+1;
            move = scanner.nextInt();
            result = isValidMove(move, gameBoard);
        }
        System.out.println("CPU moved at position: "+ move);
        updateBoard(move, 2, gameBoard);
        
    }

    public static boolean isValidMove(final int move , final char[][] gameBoard) {
        switch (move) {
            case 1:
                if(gameBoard[0][0]==' '){
                    return true;
                }else{
                    return false;
                }
            case 2:
                if(gameBoard[0][2]==' '){
                    return true;
                }else{
                    return false;
                }
            case 3:
                if(gameBoard[0][4]==' '){
                    return true;
                }else{
                    return false;
                }
            case 4:
                if(gameBoard[2][0]==' '){
                    return true;
                }else{
                    return false;
                }
            case 5:
                if(gameBoard[2][2]==' '){
                    return true;
                }else{
                    return false;
                }
            case 6:
                if(gameBoard[2][4]==' '){
                    return true;
                }else{
                    return false;
                }
            case 7:
                if(gameBoard[4][0]==' '){
                    return true;
                }else{
                    return false;
                }
            case 8:
                if(gameBoard[4][2]==' '){
                    return true;
                }else{
                    return false;
                }
            case 9:
                if(gameBoard[4][4]==' '){
                    return true;
                }else{
                    return false;
                }

            default:
                return false;
        }
    }

    public static boolean isGaveOver(final char[][] gameBoard) {
        
        if(gameBoard[0][0] =='X' && gameBoard[0][2] =='X' && gameBoard[0][4] =='X'){
            System.out.println("Player wins");
            playerScore++;
            return true;
        }
        if(gameBoard[2][0] =='X' && gameBoard[2][2] =='X' && gameBoard[2][4] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }
        if(gameBoard[4][0] =='X' && gameBoard[4][2] =='X' && gameBoard[4][4] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }

        if(gameBoard[0][0] =='X' && gameBoard[2][0] =='X' && gameBoard[4][0] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }
        if(gameBoard[0][2] =='X' && gameBoard[2][2] =='X' && gameBoard[4][2] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }
        if(gameBoard[0][4] =='X' && gameBoard[2][4] =='X' && gameBoard[4][4] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }

        if(gameBoard[0][0] =='X' && gameBoard[2][2] =='X' && gameBoard[4][4] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }
        if(gameBoard[0][4] =='X' && gameBoard[2][2] =='X' && gameBoard[4][0] =='X'){
            System.out.println("Player wins");
            playerScore++;

            return true;
        }
        if(gameBoard[0][0] =='O' && gameBoard[0][2] =='O' && gameBoard[0][4] =='O'){
            System.out.println("Computer wins");
            computerScore++;
            return true;
        }
        if(gameBoard[2][0] =='O' && gameBoard[2][2] =='O' && gameBoard[2][4] =='O'){
            System.out.println("Computer wins");
            return true;
        }
        if(gameBoard[4][0] =='O' && gameBoard[4][2] =='O' && gameBoard[4][4] =='O'){
            System.out.println("Computer wins");
            computerScore++;
            return true;
        }

        if(gameBoard[0][0] =='O' && gameBoard[2][0] =='O' && gameBoard[4][0] =='O'){
            System.out.println("Computer wins");
            computerScore++;
            return true;
        }
        if(gameBoard[0][2] =='O' && gameBoard[2][2] =='O' && gameBoard[4][2] =='O'){
            System.out.println("Computer wins");
            computerScore++;

            return true;
        }
        if(gameBoard[0][4] =='O' && gameBoard[2][4] =='O' && gameBoard[4][4] =='O'){
            System.out.println("Computer wins");
            computerScore++;

            return true;
        }
        if(gameBoard[0][0] =='O' && gameBoard[2][2] =='O' && gameBoard[4][4] =='O'){
            System.out.println("Computer wins");
            computerScore++;

            return true;
        }
        if(gameBoard[0][4] =='O' && gameBoard[2][2] =='O' && gameBoard[4][0] =='O'){
            System.out.println("Computer wins");
            computerScore++;

            return true;
        }
        

        if(gameBoard[0][0]!=' ' && gameBoard[0][2]!=' ' && gameBoard[0][4]!=' ' && gameBoard[2][0]!=' ' && gameBoard[2][2]!=' ' && gameBoard[2][4]!=' ' && gameBoard[4][0]!=' ' && gameBoard[4][2]!=' ' && gameBoard[4][4]!=' '){
            System.out.println("Its a Draw"); 
            return true;
        }
        return false;
    }

    public static void resetBoard(final char [][] gameBoard) {
        gameBoard[0][0] =' ';
        gameBoard[0][2] =' ';
        gameBoard[0][4] =' ';
        gameBoard[2][0] =' ';
        gameBoard[2][2] =' ';
        gameBoard[2][4] =' ';
        gameBoard[4][0] =' ';
        gameBoard[4][2] =' ';
        gameBoard[4][4] =' ';
    }
}