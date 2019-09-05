import java.util.*;
public class Game {
    private ArrayList<Ship> ship;
    private int killedShip;
    int[] test=new int[3];

    public Game() {
        this.ship = new ArrayList<>();
        this.killedShip = 0;
    }

    public void setLocation(){
        int[] posDir;
        boolean flag;
        for(int i=0;i<3;i++){
            flag=true;
            while(flag){
                int[] loc=new int[3];
                posDir=randomPos();
                if(posDir[0]==0 && posDir[2]==0){
                    //vertical 1st row
                    loc[0]=(posDir[0]*10)+posDir[1];
                    loc[1]=loc[0]+10;
                    loc[2]=loc[1]+10;
                }
                else if(posDir[0]==7 && posDir[2]==0) {
                    //vertical last st row
                    loc[0]=(posDir[0]*10)+posDir[1];
                    loc[1]=loc[0]-10;
                    loc[2]=loc[1]-10;
                }
                else if(posDir[1]==0 && posDir[2]==1){
                    //horizontal 1st col
                    loc[0]=(posDir[0]*10)+posDir[1];
                    loc[1]=loc[0]+1;
                    loc[2]=loc[1]+1;
                }
                else if(posDir[1]==7 && posDir[2]==1){
                    //horizontal last st col
                    loc[0]=(posDir[0]*10)+posDir[1];
                    loc[1]=loc[0]-1;
                    loc[2]=loc[1]-1;
                }
                else if(posDir[2]==0){
                    //vertical
                    loc[1]=(posDir[0]*10)+posDir[1];
                    loc[0]=loc[1]-10;
                    loc[2]=loc[1]+10;
                }
                else {
                    //horizontal
                    loc[1]=(posDir[0]*10)+posDir[1];
                    loc[0]=loc[1]-1;
                    loc[2]=loc[1]+1;
                }

                flag=hadShip(loc);
                if(flag==false){
//                    System.out.println("Saving location of:"+i);
                    add(loc);
                }
            }
        }
    }

    private boolean hadShip(int[] loc){
        int[] checkLoc;
        for(int i=0;i<ship.size();i++){
            checkLoc=ship.get(i).getPosition();
            for(int j=0;j<3;j++){
                for (int k=0;k<3;k++){
                    if(loc[j]==checkLoc[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void add(int[] test){
        Ship obj=new Ship(test);
        ship.add(obj);
    }

    public void display(){
        for(int i=0;i<ship.size();i++) {
            System.out.println("Display"+i);
            for (int j=0;j<3;j++){
                System.out.println(ship.get(i).getPosition()[j]);
            }

        }
    }

    private int[] randomPos() {
        Random random = new Random();
        int rand = random.nextInt(64);
        int row=rand/8;
        int col=rand%8;
        int[] pos=new int[3];
        pos[0]=row;
        pos[1]=col;
        pos[2]= random.nextInt(2);
        return pos;
    }

    public int getHit(int i){
        return this.ship.get(i).getHit();
    }

    public void setHit(int i,int hit,int pos){
        this.ship.get(i).setHit(hit);
        this.ship.get(i).deletePos(pos);
    }

    public int[] getPosition(int i) {
        return this.ship.get(i).getPosition();
    }

    public void setKilledShip() {
        this.killedShip=this.killedShip+1 ;
    }

    public int getKilledShip(){
        return this.killedShip;
    }
}
