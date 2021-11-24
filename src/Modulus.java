public class Modulus {
    public static int powerfulModulus(int base, int power, int modulo) {
        int result = base % modulo;

        for (int i = 1; i < power; i++){
            result = (result * base) % modulo;
        }

        return result;
    }

    private static void testPowerfulModulus() {
        System.out.println(powerfulModulus(11, 13, 53)); // 52
        System.out.println(powerfulModulus(14, 5, 21)); // 14
        System.out.println(powerfulModulus(11, 1, 53)); // 11
    }

    public static void main(String[] args) {
            testPowerfulModulus();
        }// end main
    }
