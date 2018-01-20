


public class HelloWorld {
    private int iValue;
    static void changeIt(HelloWorld value) {
        value.iValue = 10;
    }
    public static void main(String[] argvc)
    {
        HelloWorld hw = new HelloWorld();
        hw.iValue = 20;
        changeIt(hw);
        System.out.println("After changing : " +
                hw.iValue);
    }
}