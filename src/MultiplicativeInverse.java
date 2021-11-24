public class MultiplicativeInverse {
  public static int getMultiplicativeInverse(int m, int b) {
    int Q, T1, T2, T3;

    int A1 = 1;
    int A2 = 0;
    int A3 = m;

    int B1 = 0;
    int B2 = 1;
    int B3 = b;

    while (true) {
      if (B3 == 0) {
        System.out.println("Returned A3");
        return A3;
      }

      if (B3 == 1) {
        System.out.println("Returned B2");
        return B2;
      }

      Q = Math.floorDiv(A3, B3);

      T1 = A1 - (Q * B1);
      T2 = A2 - (Q * B2);
      T3 = A3 - (Q * B3);

      A1 = B1;
      A2 = B2;
      A3 = B3;

      B1 = T1;
      B2 = T2;
      B3 = T3;
    }
  }

  private static void testExtendedEuclideanAlgorithm() {
    System.out.println(getMultiplicativeInverse(1759, 550));
    System.out.println(getMultiplicativeInverse(1701, 1250));
  }

  public static void main(String[] args) {
    testExtendedEuclideanAlgorithm();
    System.out.println(getMultiplicativeInverse(24, 5));
  }
}
