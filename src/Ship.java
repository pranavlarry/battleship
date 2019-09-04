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

//    public void setPosition(int[] position) {
//        this.pos = position;
//    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
