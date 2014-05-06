//Måste heta testclass om jtest ska fungera
class testclass {
    public static void main(String[] args) {
        long[] kek;
        EnKlass k;
        AnnanKlass ak;
        k = new EnKlass();
        ak = new AnnanKlass();
        kek = k.giveMeLong(ak);
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