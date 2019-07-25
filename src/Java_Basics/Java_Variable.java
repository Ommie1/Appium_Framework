public class Java_Variable {

    public static int a = 10; // its Static method every method can use it
    public int c=50; // Its Instance variable

    public void localvariable()
    {
        // Its local variable
        int b=20;
        System.out.println("This is static variable in methodA"+a);
        System.out.println("This is local variable"+b);
        System.out.println("This is instance variable"+c);
    }

    public void localvariableinnewmthod()
    {
        System.out.println("This is static variable in methodB"+a);
        System.out.println("This is instance variable in methodB"+c);
    }

    public static void main(String[] args)
    {
        Java_Variable jv =new Java_Variable();
        jv.localvariable();
        jv.localvariableinnewmthod();
    }
}

/**
 * 1) Local Variable
 * A variable declared inside the body of the method is called local variable. You can use this variable only within that method and the other methods in the class aren't even aware that the variable exists.
 * A local variable cannot be defined with "static" keyword.
 * Cannot access local variable of a method in other method
 *
 * 2) Instance Variable
 * A variable declared inside the class but outside the body of the method, is called instance variable. It is not declared as static.
 * It is called instance variable because its value is instance specific and is not shared among instances.
 *
 * 3) Static variable
 * A variable which is declared as static is called static variable. It cannot be local. You can create a single copy of static variable and share among all the instances of the class. Memory allocation for static variable happens only once when the class is loaded in the memory.
 **/