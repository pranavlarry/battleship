import java.util.*;
import  java.util.regex.*;
public class Test {
    private static Game game=new Game();
    private static int noGuess=0;
    private static String guess,expectedResult;
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            int[] location=new int[3];
            String loc=new String();
            for(int j=0;j<3;j++){
                boolean valid=false;
                while(!valid){
                    System.out.println("Enter location no:"+(j+1)+" of ship "+(i+1)+":");
                    loc=scanner.nextLine();
                    valid=check(loc);
                    if(!valid){
                        System.out.println("Invalid location enter location in A1,B1 etc format!!");
                    }
                }
                location[j]=convertor(loc);
            }
            game.add(location);
        }
        while(true){
            System.out.println("Enter 'q' to quit testing");
            System.out.println("Enter guess: ");
            guess=scanner.nextLine();
            if(guess.equals("q")){
                break;
            }
            System.out.println("Enter expected output (HIT/HIT and KILL/MISSED): ");
            expectedResult=scanner.nextLine();
            guessTester(guess,expectedResult);
        }

    }

    public static void guessTester(String guess,String expectedResult){
        boolean valid = check(guess);
        if(valid){
            int numberGuess=convertor(guess);
            noGuess+=1;
            System.out.println("Expected result on guess : "+guess+" is : "+expectedResult+" on guess number : "+noGuess);
            System.out.println("Output from program is result is the following:-");
            game.fire(numberGuess,noGuess);
        }
        else {
            System.out.println("Invalid input try again!!");
        }
    }

    public static int convertor(String guess){
        String[] ipString=guess.split("(?!^)");
        ipString[0]=ipString[0].toUpperCase();
        char rowC=ipString[0].charAt(0);
        int col=Integer.parseInt(ipString[1]);
        int row=rowC-'A';
        return (row*10)+col;
    }

    public static boolean check(String ip){
        return Pattern.matches("[a-h|A-H][0-8]", ip);
    }
}
