class Mainclass {
    public static void main(String[] args) {
    }
}

class TestingVariables {
    int x;
    int y;

    public int toTryParamsWith(int x, int y) {
        return x;
    }

    public int tryWithWeirdParams() {
        int y;
        return this.toTryParamsWith(x,y);
    }
}