import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int i = 300; // неявное приведение типов
        long l = i; // неявное приведение типов
        double d = i; // неявное приведение типов
        short s = (short) i; // явное приведение типов
        System.out.println("int "+i+" long "+l+" double "+d +"short "+s);
        System.out.println(MethodClass.factorial(5));
        MethodClass methodClass = new MethodClass();
        int[] arr = new int[]{1,5,7,9,8};
        System.out.println(Arrays.toString(new int[]{methodClass.search(arr, 9)}));
        System.out.println(methodClass.Sum());

        String str = "Hi friends. You dont expect me!))";
        methodClass.changeIt(str);
        System.out.println(str);
        System.out.println(methodClass.changeIt(str));
        int[] arr2 = new int[]{1,5,7,8,9,12,13,14,15,16};
        System.out.println(Arrays.toString(arr2));
       // methodClass.DelElArr(arr2,7);
        System.out.println(methodClass.ArrSearch(arr2,13));
        System.out.println(Arrays.binarySearch(arr2, 13));
        EnumExample season = EnumExample.SUMMER;
        System.out.println(season);
        
    }
}
