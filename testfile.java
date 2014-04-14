/*
*test
 */

class bla {
  public static void main(String[] args) {
    int x;
    int[] y;
    boolean b;
    long l;
    long[] la;
    kek k;
    l = 23l;
    x = 3;
    y = new int[5];
    la = new long[5];
    y[3] = 5;
    b = 3<2;
    b = x < y[3];
    b = l<x;
    l = x;
    la[2] = x;
    b = true && false;
    b = b || true;
    k = new kek();
    x = k.lol(10);
    b = k.truer();
  }
}

class kek {
    int x;
    int y;

    public int lol(int i){
        int k;
        k = i;
        return k;

    }

    public boolean truer() {
        return true;
    }

    public boolean kek(int pop) {
        kek a;
        boolean b;
        a = new kek();
        b = a.truer();
        x = 3;
        pop = 4;
        x = pop;
        pop = x;
        return (true && this.truer());
    }
}
