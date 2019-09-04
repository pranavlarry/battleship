import java.util.Scanner;
public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static int guess;
    private static int noGuess;
    static Game game=new Game();
    public static void main(String[] args) {
        String status;

        game.setLocation();
        game.display();

        while(game.getKilledShip()!=3){
            System.out.println("Enter the coordinate in row column formate(RC):");
            guess=scanner.nextInt();
            noGuess+=1;
            fire(guess);
        }


//        game.display();
    }

    public static void fire(int guess){
        for(int i=0;i<3;i++){
            int currentHit=game.getHit(i);
            if(currentHit!=3){
                int[] pos=game.getPosition(i);
                for(int j=0;j<3;j++){
                    if(pos[j]==guess){
                        System.out.println("Its a hit!!!");
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
    }
}
