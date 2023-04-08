import java.util.Scanner;
import Area.Area;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        double l,b,r,s;int select=0;
        System.out.println("Select the serial number for the shape you want to use for calculatign area: ");
        System.out.println("1.Reactangle\n2.Square\n3. Circle");
        Scanner scanner = new Scanner(System.in);
        select =scanner.nextInt();
        Area A = new Area();
        switch (select) {
            case 1:
                System.out.println("Enter the length: ");
                l=scanner.nextDouble();
                System.out.println("Enter the breadth: ");
                b=scanner.nextDouble();
                System.out.print("Area is: ");
                System.out.println(A.Rectangle(l, b));
                break;
            case 2:
                System.out.println("Enter the side: ");
                s=scanner.nextDouble();
                System.out.print("Area is: ");
                System.out.println(A.Square(s));
                break;
            case 3:
                System.out.println("Enter the radius: ");
                r=scanner.nextDouble();
                System.out.print("Area is: ");
                System.out.println(A.Circle(r));
            default:
                break;
        }
        scanner.close();
    }
}
//naming convention
//data types
//type of variables
              //Starts With          Example
// class      Upper case & noun     String, Employee, Student, Rectangle, ArrayList, HashMap
// interface  Upper case             Runnable, OnClickListener, ActionListener, Remote
// method     Lower case & verb      main(), print(), goAhead(), getResult()
// variable   Lower case             name, id, firstName, employeeld, isAlive, length
// package    All in lower case      java.util, com.internshala.app
// constants  All in upper case      MAX_VALUE, PI

