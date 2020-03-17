import java.util.Scanner;
//added a comment just for the sake of the change
public class ConnectFour {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int row = input.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int column = input.nextInt();
        char[][] array = new char[row][column];
        printBoard(array);

        System.out.println("\nPlayer 1: x\nPlayer 2: o\n");
        int x = 0;
        int columnOne, columnTwo;
        int rownumOne, rownumTwo;

        System.out.print("Player 1: Which column would you like to choose? ");
        columnOne = input.nextInt();
        rownumOne = insertChip(array, columnOne, 'x');
        printBoard(array);

        System.out.print("\nPlayer 2: Which column would you like to choose? ");
        columnTwo = input.nextInt();
        rownumTwo= insertChip(array, columnTwo, 'o');
        printBoard(array);

        while (x < 1) {
            System.out.print("\nPlayer 1: Which column would you like to choose? ");
            columnOne = input.nextInt();
            rownumOne = insertChip(array, columnOne, 'x');
            printBoard(array);

            if (checkIfWinner(array, columnOne, rownumOne, 'x')){
                System.out.println("\nPlayer 1 won the game!");
                break;
            }

            System.out.print("\nPlayer 2: Which column would you like to choose? ");
            columnTwo = input.nextInt();
            rownumTwo= insertChip(array, columnTwo, 'o');
            printBoard(array);

            if (checkIfWinner(array, columnTwo, rownumTwo, 'o')){
                System.out.println("\nPlayer 2 won the game!");
                break;
            }
            int drawCheck = 0;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    if (array[i][j] == '-'){
                        drawCheck = drawCheck + 1;
                    }
                }
            }
            if (drawCheck < 1){
                System.out.println("\nDraw. Nobody wins.");
                break;
            }
        }
    }

    public static void printBoard(char[][] array){
        initializeBoard(array);
        int column = array[0].length;
        int row = array.length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void initializeBoard(char[][] array){
        int column = array[0].length;
        int row = array.length;
        for (int i = (row -1); i >= 0; i--){
            for (int j = 0; j < column; j++){
                if (array[i][j] != 'o' && array[i][j] != 'x' ){
                    array[i][j] = '-';
                }
            }
        }
    }
    public static int insertChip(char[][] array, int col, char chipType){
        int row = array.length;
        int num = 0;
        for (int i = (row-1); i >= 0; i--){
            if (array[i][col] == '-'){
                array[i][col] = chipType;
                num = i;
                break;
            }
        }
        return num;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        int rowLength = array.length;
        int columnLength = array[0].length;
        int x =0, y =0;
        for (int i = row ; i < rowLength - 1; i++){
            if (array[i][col]== array[i+1][col] && array[i][col] == chipType){
                x = x + 1;
            }
        }
        for (int j = 0; j < columnLength - 1; j++){
            if(array[row][j] == array[row][j+1] && array[row][j] == chipType){
                y = y +1;
            }
        }
        if (x >= 3 || y >= 3) {
            return true;
        }
        else {
            return false;
        }
    }
}
