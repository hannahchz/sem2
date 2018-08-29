import java.util.Scanner;
import java.lang.*;

enum TriangleType {NOT, SCALENE, ISOCELES, EQUILATERAL, TRIANGLE};

class Triangle
{
   private int i1;
   private int i2;
   private int i3;
   private TriangleType type;
   int n = 1;

   //constructor
   public Triangle()
   {
   }

   //copy constructor
   public Triangle (int i1, int i2, int i3, TriangleType type)
   {
       this.i1 = i1;
       this.i2 = i2;
       this.i3 = i3;
       this.type = type;
   }

   //other constructor
   //accessor
   //mutator

   public void printInfo()
   {
       System.out.println("<" + i1 + i2 + i3 + ">" + " is " + type + " triangle");
   }

}

class oopl4
{
    private static TriangleType getType (int i1, int i2, int i3) //TriangleType
    {
        TriangleType type;
        type = TriangleType.TRIANGLE;
        int n = 1;

        if ((i1 + i2 > i3) && (i2 + i3 > i1) && (i1 + i3 > i2)){
            type = TriangleType.TRIANGLE;

           if ((i1 == i2) && (i2 == i3)){
               type = TriangleType.EQUILATERAL;
           }

           else if (((i1 == i2) && (i2 != i3)) || ((i2 == i3) && (i3 != i1)) || ((i3 == i1) && (i1 != i2))){
               type = TriangleType.ISOCELES;
           }

           if ((i1 != i2) && (i2 != i3) && (i3 != i1)){
               type = TriangleType.SCALENE;
           }
        
        } else {
            type = TriangleType.NOT;
        }

        return type;

    }

    private static void moreInfo (int i1, int i2, int i3, TriangleType type)
    {
        switch(type)
        {
            case NOT: System.out.println("This is not a triangle.");
            break;

            case SCALENE: System.out.println("This is a scalene triangle.");
            break;

            case EQUILATERAL: System.out.println("This is an equilateral triangle.");

            case ISOCELES: System.out.println("This is an isoceles triangle.");

            default: System.out.println("This is a triangle.");
            
        }
    }

    public static void main(String[] args)
    {
        int i1;
        int i2;
        int i3;
        TriangleType type;

        Scanner input = new Scanner (System.in);
        System.out.println("Type 3 integers Eg: 8 8 8");
        i1 = input.nextInt();
        i2 = input.nextInt();
        i3 = input.nextInt();

        type = getType(i1, i2, i3); //main class
        Triangle mt = new Triangle(i1, i2, i3, type);
        mt.printInfo(); //from earlier class 1
        moreInfo(i1, i2, i3, type);

    }
}