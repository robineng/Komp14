//Måste heta testclass om jtest ska fungera
class testclass {
    public static void main(String[] args) {
        long l;
        Frick f;
        int[] kek;
        int frigg;
        kek = new int[5];
        frigg = kek.length;
        System.out.println(frigg);
        f = new Frick();
        System.out.println(1L<=1);
        System.out.println(1L<=2);
        System.out.println(1L<=0);
        l = 1;
        System.out.println(l);
        System.out.println(f.getSetl());
    }
}

class Frick{
    long l;

    public long getSetl(){
        l = 2;
        return l;
    }

}
