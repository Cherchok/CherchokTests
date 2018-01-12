
public class MethodClass {

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
    public int[] recursion(int[] array){
        for (int i = 0; i <array.length/2 ; i++) {
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        return array;
    }

    // concatenation method for arrays
    public int[] concatArray(int[] array1, int[] array2){

        if(array1==null){
            return array2;
        }
        if(array2==null){
            return array1;
        }
        int [] array12 = new int[array1.length + array2.length];
        System.arraycopy(array1,0,array12,0,array2.length);
        System.arraycopy(array2,0,array12, array1.length,array2.length);
        return array12;
    }

    // recursion method factorial
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

}
