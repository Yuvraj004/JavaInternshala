import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* hello to the world */
        System.out.println("Hello world!");
        //Lecture-1
        //JVM:java virtual machine:provides environment for code execution
        //JRE:java runtime environment={JVM+Libraries Set}:implementation of JVM
        //JDK:Java Development Kit={JRE+Development Tools+compiler+debugger}
        //compiler converts .java into .class(binary code),.class is a .exe file executed in JRE then JVM
        //Compile time: process of conversion from .java into .class
        //Runtime: process of running the .exe file using JVM,JRE.
        //minimum requirement to run your java application in a device: JRE
        //
        //
        //Lecture-2
        String name="India";
        int pop = 14134;
        float pop_D = 393.3f;
        double gdp =2.454;
        char curr ='\u20B9';// OR \u20B9
        boolean secular =true;
        System.out.println(name+" has population of "+pop);
        //float-4 byte,double-8 byte
        //type conversions:
        //smalerr dt into larger d.t.-->implicit
        //innveerse ->explicit
        //explicit conveersion:
        double dia=3.78;
        int idia= (int) dia;//synttaax
        long dial=235343455L;
        int ildia = (int) dial;
        //
        //
        //user input
        Scanner scanner=new Scanner(System.in);
//        name=scanner.next();//gives the output of only one word
        name=scanner.nextLine();
        pop=scanner.nextInt();//for int
        //.nextFloat();
        System.out.println("Enter the currency: ");
        curr = scanner.next().charAt(0);
        System.out.println(curr);
        System.out.println(name);
        scanner.close();


    }
}