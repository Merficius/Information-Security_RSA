public class GCD {
    public static int recursiveGCD(int firstValue, int secondValue) {
        if (secondValue == 0) {
            return firstValue;
        } else {
            int newValue = firstValue % secondValue;
            return recursiveGCD(secondValue, newValue);
        }
    }
    
    public static int iterativeGCD(int firstValue, int secondValue) {
        while (true) {
            if (secondValue == 0) {
                return firstValue;
            }
            int residue = firstValue % secondValue;
            firstValue = secondValue;
            secondValue = residue;
        }
    }

    private static void testGCD() {
        System.out.println(recursiveGCD(1970, 1066));
        System.out.println(iterativeGCD(1970, 1066));
    }

    public static void main(String[] args) {
        testGCD();
    }
}