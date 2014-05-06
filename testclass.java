//Måste heta testclass om jtest ska fungera
class testclass {
    public static void main(String[] args) {
        long[] kek;
        EnKlass k;
        AnnanKlass ak;
        kek = (new EnKlass()).giveMeLong(new AnnanKlass());
        System.out.println(kek[3]);
    }
}

class EnKlass{
    public long[] giveMeLong(AnnanKlass kl){
        long[] l;
        l = new long[5];
        l[3] = 2;
        return l;
    }
}

class AnnanKlass{

}