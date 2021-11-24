public class Main {
  private static void measureExecutionTime() {
    byte[] message = "~".getBytes();
    long encryptionStartTime = System.nanoTime();
    byte[] encryptedMessage = RSA.encrypt(message);
    long encryptionEndTime = System.nanoTime();
    System.out.println("Encryption took: " + (encryptionEndTime - encryptionStartTime) + " nano seconds");

    long decryptionStartTime = System.nanoTime();
    byte[] recoveredMessage = RSA.decrypt(encryptedMessage);
    Long decryptionEndTime = System.nanoTime();
    System.out.println("Decryption took: " + (decryptionEndTime - decryptionStartTime) + "nano seconds");
  }

  public static void main(String[] args) {
    for (int i = 0; i < 11; i++)
      measureExecutionTime();
  }// end main
}
// ond Coutie