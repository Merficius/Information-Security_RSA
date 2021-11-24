import java.math.BigInteger;

public class RSA {
    static final int P = 11;
    static final int Q = 13;
    static final int N = P * Q; // 143
    static final int PHI_N = (P - 1) * (Q - 1);
    static final int E = 23;
    static final int D = 47;

    public static byte[] encrypt(byte[] input) {
        byte[] result = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = encrypt(input[i]);
        }
        return result;
    }

    private static byte encrypt(byte input) {
        return (byte) Modulus.powerfulModulus(input & 0xff, E, N);
    }

    public static byte[] decrypt(byte[] input) {
        byte[] result = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = decrypt(input[i]);
        }
        return result;
    }

    public static byte decrypt(byte input){
        return (byte) Modulus.powerfulModulus(input & 0xff, D, N);
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" !\"$%&'()*+,-./0123456789:;<=>?@");
        stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`");
        stringBuilder.append("abcdefghijklmnopqrstuvwz{|}~");

        byte[] message = stringBuilder.toString().getBytes();
        byte[] messageEncrypted = RSA.encrypt(message);
        byte[] messageObtained = RSA.decrypt(messageEncrypted);

        assert messageObtained.length == message.length;

        for (int i = 0; i < messageObtained.length; i++){
            assert messageObtained[i] == message[i];
        }
        System.out.println("Encryption and Decryption working.");
    }
}