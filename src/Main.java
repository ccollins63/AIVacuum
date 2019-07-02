// Course: CS4242
// Student name: Cameron Collins
// Student ID: 900579768
// Assignment #: #1
// Due Date: June 14, 2019
// Signature: Cameron M Collins
// Score: _________________

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        staticWorldExample();

        random();
    }

    public static void random() //Creates a random floor based on user width and height variables
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Floor width: ");

        int x = scan.nextInt();

        System.out.print("Enter Floor height: ");

        int y = scan.nextInt();

        Vacuum vac = new Vacuum();

        new Environment(vac, x, y);

        scan.close();

    }

    public static void staticWorldExample() //Creates a standard 3x3 floor
    {
        Square s1 = new Square(false);

        Square s2 = new Square(true);

        Square s3 = new Square(false);

        Square s4 = new Square(true);

        Square s5 = new Square(false);

        Square s6 = new Square(true);

        Square s7 = new Square(false);

        Square s8 = new Square(true);

        Square w2[][] = { { s1, s2, s3 }, { s4, null, s5 }, { s6, s7, s8 } };

        s1.setEast(s2);

        s2.setWest(s1);

        s2.setEast(s3);

        s3.setWest(s2);

        s1.setSouth(s4);

        s4.setNorth(s1);

        s3.setSouth(s5);

        s5.setNorth(s3);

        s6.setEast(s7);

        s7.setWest(s6);

        s7.setEast(s8);

        s8.setWest(s7);

        s6.setSouth(s4);

        s4.setNorth(s6);

        s5.setSouth(s8);

        s8.setNorth(s5);

        Vacuum vac = new Vacuum();

        new Environment(vac, w2);
    }
}