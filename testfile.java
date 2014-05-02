class kek {
    public static void main(String[] args) {

    }
}

class dubbelkek {
    trippelkek a;

    public int init () {
        a = new trippelkek().kvadruppelkek();
        return 1;
    }

    public dubbelkek fu() {
        return new dubbelkek();
    }
}

class trippelkek {
    dubbelkek b;

    public int init() {
        b = new dubbelkek().fu();
        return 1;
    }

    public trippelkek kvadruppelkek() {
        return new trippelkek();
    }
}