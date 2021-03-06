
public class MethodClass {
    private int a;
    private int b;
    private int c;

    // попрактикуемся с конструктором,  что это для чего он нужен.
    // он нужен для инициализации полей
    MethodClass() {
        a = 10;
        b = 10;
        c = 100;
    }

    // создадим метод для конструктора
    protected int Sum() {
        return a * b * c;
    }

    // search method for arrays
    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // visa versa method for arrays
    public int[] recursion(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    // concatenation method for arrays
    public int[] concatArray(int[] array1, int[] array2) {

        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }
        int[] array12 = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, array12, 0, array2.length);
        System.arraycopy(array2, 0, array12, array1.length, array2.length);
        return array12;
    }

    // recursion method factorial
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // метод менающий строку
    public String changeIt(String str) {
        str = "Hello";
        return str;
    }

    // delete element of array
    public int[] DelElArr(int[] arr, int searchKey) {
        int numEl = arr.length;
        int i;
        for (i = 0; i < numEl; i++) {
            if (arr[i] == searchKey) {
                break;
            }
        }
        for (i = 0; i < numEl; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    // binary search
    public int ArrSearch(int[] arr, int searchKey) {
        int curIn;
        int numEl = arr.length;
        int down = 0;
        int up = numEl - 1;

        while (true) {
            curIn = (down + up) / 2;
            if (arr[curIn] == searchKey) {

                return curIn;
            }
            else if (down > up) {
                return numEl;
            } else {
                if (arr[curIn] < searchKey) {
                     down = curIn + 1;
                }
                else
                    up = curIn - 1;
            }
        }
    }

}

