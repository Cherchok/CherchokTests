


public class HelloWorld {
    private int iValue;
    private String sValue;

    static void changeIt(HelloWorld value) {
        value.iValue= 10;
    }

    static int change(int value) {
        value = 10;
        return value;
    }

    static void changeString(HelloWorld value){
        value.sValue = "Hi";
    }

    public static void main(String[] argvc) {
        HelloWorld hw = new HelloWorld();
        hw.iValue = 20;
        changeIt(hw);
        int ver = 30;
        change(ver);
        hw.sValue = "Help me";
        changeString(hw);
        System.out.println("After changing : " +
                hw.iValue);
        System.out.println("After changing : " +
                ver);
        System.out.println("After changing : " +
                hw.sValue);
    }
}