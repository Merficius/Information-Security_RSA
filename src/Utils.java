public class Utils {
    public static void printByteToArrayInHexadecimal(byte[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.println(String.format("%02X\t", arr[i]));
            System.out.println(String.format("%02X\t", arr[arr.length - 1]));
        }
    }

    public static void printByteArrayInDecimal(byte[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println((arr[i] & 0xff) + "\t");
        }
        System.out.println("----------------------------");
    }

    public static void printInArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("----------------------------");
    }

    public static byte[] XorByteArrays(byte[] arrA, byte[] arrB){
        if (arrA.length != arrB.length){
            return null;
        }

        byte[] result = new byte[arrA.length];
        for (int i = 0; i < arrA.length; i++){
            result[i] = (byte)((arrA[i] ^ arrB[i]) & 0xff);
        }
        return result;
    }

    public static void swap(int[] arr, int firstValue, int secondValue){
        int temporalValue = arr[firstValue];
        arr[firstValue] = arr[secondValue];
        arr[secondValue] = temporalValue;
    }

    public static void swap(int[] arrA, int arrAValue, int[] arrB, int arrBValue){
        int temporalValue = arrA[arrAValue];
        arrA[arrAValue] = arrB[arrBValue];
        arrB[arrBValue] = temporalValue;
    }

    public static void main(String[] args) {
        byte[] byteA = new byte[]{(byte) 0x88};
        byte[] byteB = new byte[]{(byte) 0x88};
        printByteArrayInDecimal(byteA);
        byte[] result = XorByteArrays(byteA, byteB);
        printByteArrayInDecimal(result);
    }
}
