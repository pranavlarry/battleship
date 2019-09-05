public class Ship {
    private int[] pos;
    private int hit;

    public Ship(int[] test) {
        this.pos=test;
        hit=0;
    }

    public int[] getPosition() {
        return pos;
    }


    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void deletePos(int hitPos){
        this.pos[hitPos]=100;
    }
}
