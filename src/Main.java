import java.util.*;
import java.util.regex.*;
public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static String guess;
    private static int noGuess;
    private static char[][] displayGame=new char[8][8];
    static Game game=new Game();
    public static void main(String[] args) {
        int numberGuess;
        for (char[] row: displayGame)
            Arrays.fill(row, '0');
//        Arrays.fill(displayGame, '0');
        game.setLocation();
        game.display();
        boolean valid;
        dis(100,'v');
        while(game.getKilledShip()!=3){
            System.out.println("Enter the coordinate in row column formate(RC):");
            guess=scanner.nextLine();
            valid = Pattern.matches("[a-h|A-H][0-8]", guess);
            if(valid){
                String[] ipString=guess.split("(?!^)");
                ipString[0]=ipString[0].toUpperCase();
                char rowC=ipString[0].charAt(0);
                int col=Integer.parseInt(ipString[1]);
                int row=rowC-'A';
                numberGuess=(row*10)+col;
                noGuess+=1;
                fire(numberGuess);
            }
            else {
                System.out.println("Invalid input try again!!");
            }

        }

    }

    public static void fire(int guess){
        for(int i=0;i<3;i++){
            int currentHit=game.getHit(i);
            if(currentHit!=3){
                int[] pos=game.getPosition(i);
                for(int j=0;j<3;j++){
                    if(pos[j]==guess){
                        System.out.println("Its a hit!!!");
                        dis(guess,'x');
                        currentHit+=1;
                        if(currentHit==3){
                            System.out.println("Ship killed!!");
                            System.out.println("On guess number:"+noGuess);
                            game.setKilledShip();
                        }
                        game.setHit(i,currentHit,j);
                        return;
                    }
                }
            }

        }
        System.out.println("YOU MISSED ;-)");
        dis(guess,'v');
    }

    public static void dis(int guess,char ch){
        if(guess!=100){
            int row=guess/10;
            int col=guess%10;
            displayGame[row][col]=ch;
        }
        System.out.println(" 'x' will be marked as hit, 'v' will be marked as miss");
        System.out.println("  0 1 2 3 4 5 6 7 ");
        for(int i=0;i<8;i++){
            char x='A';
            x+=i;
            for (int j=0;j<8;j++){
                if(j==0){
                    System.out.print(x +" ");
                }
                System.out.print(displayGame[i][j]+" ");
            }
            System.out.println();
        }
    }
}
