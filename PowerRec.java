class PowerRec {
    public static void main(String[] args) {
        power(3);
    }

    static public boolean power(double n) {
        if (n == 2) return true;
        if (n < 1) return false;
        return power(n / 2);
    }
}