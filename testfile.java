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

    public boolean kek() {
        kek a;
        boolean b;
        a = new kek();
        b = a.truer();
        return (true && this.truer());
    }
}
