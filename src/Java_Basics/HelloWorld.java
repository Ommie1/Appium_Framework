public class HelloWorld {

    //Make method static if decleare outside the class
    public static String text_outside = "Hi";
    private static String prv_str= "HI2";
    static int a = 10;


    public static void main(String[] args)
    {
        //Must declare variable inside class method
        String text="Hello World";

        System.out.println(text_outside);
        System.out.println(text);
        System.out.println(a);
        System.out.println(prv_str);
    }
}
