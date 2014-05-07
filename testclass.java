class testclass {
    public static void main(String[] args) {
        boolkek b;
        b = new boolkek();

        if(true && b.inc()){

        }
        System.out.println(b.getInt());

        if(false || b.inc()){

        }
        System.out.println(b.getInt());

        if(true || true){
            System.out.println(10);
        }
        if(true || false){
            System.out.println(11);
        }
        if(false || true){
            System.out.println(12);
        }
        if(false || false){
            System.out.println(13);
        }
    }
}

class boolkek {
    int kekbool;

    public boolean inc(){
        kekbool = kekbool + 1;
        return true;
    }

    public int getInt(){
        return kekbool;
    }
}


