public class RSAInOne {
  private static int computePrime(int minRange, int maxRange) {
    boolean isPrime = false;
    int possiblePrime = 0;

    while (!isPrime) {
      possiblePrime = (int) ((Math.random() * (maxRange + 1 - minRange)) + minRange); // Random integers between minRange and square root of maxRange (inclusive)

      for (int i = 2; i <= (int) Math.sqrt(possiblePrime); i++) {
        if (possiblePrime % i == 0) {
          isPrime = false;
          break;
        }
        
        isPrime = true;
      }
    }

    return possiblePrime;
  }

  public static int gcd(int a, int b) {
      if (a == 0) {
          return b;
      }
        
      return gcd(b%a, a);
  }

  private static int computeEncryptionKey(int phi) {
    int minRange = 2;
    int maxRange = phi - 1;

    while (true) {
      int possibleKey = (int) ((Math.random() * (maxRange + 1 - minRange)) + minRange); // Random integers between 1 and phi (exclusive)

      if (gcd(possibleKey, phi) == 1) {
        return possibleKey;
      }
    }
  }

  private static int computeDecryptionKey(int phi, int encryptionKey) {
    for(int i = 2; i < phi; i++) {
      if ((encryptionKey * i) % phi == 1) {
        return i;
      }
    }
    return 2;
  }

  private static int[] encryptMessage(int[] message, int encriptionKey, int n) {
    int[] encriptedMessage = new int[message.length];

    for (int i = 0; i < message.length; i++) {
      System.out.print("message[" + i + "]: " + message[i] + message[i] + "\n");
      encriptedMessage[i] = modularExponentiation(message[i], encriptionKey, n);
      System.out.print("encrypted message[" + i + "]: " + encriptedMessage[i] + "\n");
    }

    return encriptedMessage;
  }

  private static int modularExponentiation(int base, int power, int modulus) {
    int result = base;

    for (int i = 0; i < power - 1; i++) {
      result = (result * base) % modulus;
    }

    return result;
  }

  private static int[] decryptMessage(int[] message, int decryptionKey, int n) {
    int[] decryptedMessage = new int[message.length];

    for (int i = 0; i < message.length; i++) {
      System.out.print("message[" + i + "]: " + message[i] + "\n");
      decryptedMessage[i] = modularExponentiation(message[i], decryptionKey, n);
      System.out.print("decrypted message[" + i + "]: " + decryptedMessage[i] + "\n");
    }

    return decryptedMessage;
  }

  public static void main(String[] args) {
    int p = computePrime(5, 100);
    int q = computePrime(5, 100);
    int n = p * q;
    int phi = (p-1) * (q-1);

    int encryptionKey = computeEncryptionKey(phi);
    int decryptionKey = computeDecryptionKey(phi, encryptionKey);
    System.out.println("p: " + p + " q: " + q + "\nn: " + n + "\nphi: " + phi + "\nEncryption Key: " + encryptionKey + "\nDecryption Key: " + decryptionKey);

    String message = "Texto de prueba";
    int[] asciiMessage = new int[message.length()];
    for (int i = 0; i < message.length(); i++) {
      asciiMessage[i] = message.charAt(i);
    }

    int[] encriptedMessage = encryptMessage(asciiMessage, encryptionKey, n);
    for (int i : encriptedMessage) {
      System.out.print((char) i);
    }

    int[] decryptedMessage = decryptMessage(encriptedMessage, decryptionKey, n);
    for (int i : decryptedMessage) {
      System.out.print((char) i);
    }

  }
}
