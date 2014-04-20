class Mainclass {
    public static void main(String[] args) {
    }
}

class TestingVariables {
    int x;
    int y;

    public int toTryParamsWith(int x, int y, boolean z) {
        return x;
    }

    public int tryWithWeirdParams() {
        int y;
        return this.toTryParamsWith(x,y,true);
    }

    public int tryOtherWeirdParams() {
        boolean b;
        if(x < y && y > x && b && b) {
            System.out.println(x < y && y < b);
            //System.out.println(x);
        }
        return 3;
    }
}

class otherclass {
    public boolean functionThatDoesNotReturnInt() {
        return true;
    }
}