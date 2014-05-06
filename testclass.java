//Måste heta testclass om jtest ska fungera
class testclass {
    public static void main(String[] args) {
        Frick f;
        f = new Frick();
        System.out.println(f.fugg2(155L+15));
    }
}

class Frick{

    long[] fugger;

    public long fugg2(long fig){
        fugger = new long[5];
        fugger[3] = fig;
        return fugger[3];
    }

}
