import java.util.*;
import java.util.regex.*;
public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static String guess;
    private static int noGuess;
    static Game game=new Game();

    public static void main(String[] args) {
        int numberGuess;
        game.setLocation();
//        game.display();    //to display the actual locations
        boolean valid;
        game.dis(100,'-');
        while(game.getKilledShip()!=3){
            System.out.println("Enter the coordinate in row column formate(RC):");
            guess=scanner.nextLine();
            valid = Pattern.matches("[a-h|A-H][0-7]", guess);

            if(valid){
                boolean clicked;
                String[] ipString=guess.split("(?!^)");
                ipString[0]=ipString[0].toUpperCase();
                char rowC=ipString[0].charAt(0);
                int col=Integer.parseInt(ipString[1]);
                int row=rowC-'A';
                clicked=clickedCheck(row,col);
                if(clicked){
                    numberGuess=(row*10)+col;
                    noGuess+=1;
                    game.fire(numberGuess,noGuess);
                }
                else {
                    System.out.println("You already entered this value!! try a new one.");
                }
            }
            else {
                System.out.println("Invalid input try again!!");
            }

        }

    }

    //check if the input is already tried
    private static boolean clickedCheck(int row,int col){
        if(game.getDisplayGame()[row][col]=='-'){
            return true;
        }
        return false;
    }

}
