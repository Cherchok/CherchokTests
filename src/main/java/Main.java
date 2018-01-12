import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(MethodClass.factorial(5));
        MethodClass methodClass = new MethodClass();
        int[] arr = new int[]{1,5,7,9};
        System.out.println(Arrays.toString(new int[]{methodClass.search(arr, 9)}));
    }
}
