//Hannah Chua, UOW 6276325
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.lang.IllegalArgumentException;

interface Shape
{
    public double area();
    //public double perimeter();
    //public double volume();
    public double getArea();
}

abstract class TwoD implements Shape
{
    protected int a;
    protected int b;
    protected int c;

    //radius
    public TwoD(int a)
    {
        this.a = a;
    }

    //rectangle
    public TwoD(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    //triangle
    public TwoD(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TwoD (TwoD td)
    {
        this (td.a, td.b, td.c);
    }

    //accessor methods
    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    //mutator methods
    //give value here or main?
    public void setA(int a)
    {
        this.a = a;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    public void setC(int c)
    {
        this.c = c;
    }

    public String toString()
    {
        return String.format("(%d %d %d)", a, b, c);
    }
}

//public abstract class
abstract class ThreeD implements Shape
{
    protected int a;

    //int a is height?
    public ThreeD(int a)
    {
        this.a = a;
    }

    public ThreeD (ThreeD td)
    {
        this (td.a);
    }

    //abstract method
    protected abstract double volume();

    //return a or volume or this.a
    public double getVolume()
    {
         //casting int to double
         return (double) (getArea() * a);
    }

    public String toString()
    {
        return String.format("Volume = %.3f", getVolume());
    }
}

//TwoD implements Shape, Circle that extends TwoD must also implement Shape?
class Circle extends TwoD 
{
    //public int radius;

    public Circle (int a)
    {
        super(a);
        //super.a = radius;
        //define radius? public Circle (int a)
    }

    @Override
    public double area()
    {
        return (double) (Math.PI * super.a * super.a);
    }

    @Override
    public double getArea()
    {
        return area();
    }

    @Override
    public String toString()
    {
        return String.format("Circle (2D (%d)) ==> Area = %.3f %n%s", super.a, getArea(), "I am a circle shape");
    }
}

class Rectangle extends TwoD 
{
    //public int length;
    //public int width;

    public Rectangle (int a, int b)
    {
        super(a,b);
        //super.a = length;
        //super.b = width; //not this.b
    }

    @Override
    public double area()
    {
        return (double) (super.a * super.b);
    }

    @Override
    public double getArea()
    {
        return area();
    }
    
    @Override
    public String toString()
    {
        return String.format("Rectangle (2D (%d, %d)) ==> Area = %.3f %n%s", super.a, super.b, getArea(), "I am a rectangle shape");
    }
}

class Triangle extends TwoD 
{
    public int a;
    public int b;
    public int c;

    public Triangle (int a, int b, int c)
    {
        super(a, b, c);
        //a, b, c is from super class
        //if ((super.a + super.b < super.c) && (super.a + super.c < super.b) && (super.b + super.c > super.a))
              //throw new IllegalArgumentException("This is not a triangle");
    }

    @Override
    public double area()
    {
        double s = (double) ((super.a + super.b + super.c) / 2.000);
        double x = (double) (Math.sqrt(s * (s - super.a) * (s - super.b) * (s - super.c)));  
        return x;
    }

    @Override
    public double getArea()
    {
        return area();
    }

    @Override
    public String toString()
    {
        return String.format("Triangle (2D (%d, %d, %d)) ==> Area = %.3f %n%s", super.a, super.b, super.c, getArea(), "I am a triangle shape");
        //a, b, c or super.toString or radius or super.a 
    }
}

//1 class can only extend 1 thing
class Sphere extends ThreeD
{
    public Sphere(int a)
    {
        super(a);
    }

    public double area()
    {
        return (double) (Math.PI * 4.000 * Math.pow(super.a, 2));
    } 

    public double getArea()
    {
        return area();
    }

    @Override
    protected double volume() //4.0/3.0 not 4/3
    {
        return (double) (Math.PI * (4.000 / 3.000) * Math.pow(super.a, 3)); 
    }

    @Override
    public double getVolume()
    {
        return volume();
    }

    @Override
    public String toString()
    {
        return String.format("Sphere (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f %n%s", super.a, getArea(), getVolume(), "I am a sphere shape");
    }
}

class Cube extends ThreeD
{
    public Cube(int a)
    {
        super(a);
    }

    public double area()
    {
        return (double) (Math.pow(super.a, 2));
    } 

    public double getArea()
    {
        return area();
    }

    @Override
    protected double volume()
    {
        return (double) (Math.pow(super.a, 3)); 
    }

    @Override
    public double getVolume()
    {
        return volume();
    }

    @Override
    public String toString()
    {
        return String.format("Cube (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f %n%s", super.a, getArea(), getVolume(), "I am a cube shape");
    }
}

class Tetrahedron extends ThreeD
{
    public Tetrahedron(int a)
    {
        super(a);
    }

    public double area()
    {
        return (double) (Math.sqrt(3.000) * Math.pow(super.a, 2));
    } 

    public double getArea()
    {
        return area();
    }

    @Override
    protected double volume()
    {
        return (double) (Math.pow(super.a, 3) / (6.000 * Math.sqrt(2.000))); 
    }

    @Override
    public double getVolume()
    {
        return volume();
    }

    @Override
    public String toString()
    {
        return String.format("Tetrahedron (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f %n%s", super.a, getArea(), getVolume(), "I am a tetrahedron shape");
    }
}

public class Hannah_33_A2 //public class can new in non public static void main(String[] args) method
{
    private static int getInt()
    {
        return (int) Math.floor (Math.random() * 10) + 1;
    }

    private static TwoD getTwoD()
    {
        TwoD td = null;
        Random rand = new Random();
        int num = rand.nextInt(3); //switch case
        boolean flag = true;        
        int a = getInt();
        int b = getInt();
        int c = getInt();

        switch (num)
        {
            case 0: 
            td = new Circle(getInt());
            break;

            //EPHRAIM YANYU GUO MADE THIS LOGICAL STATEMENT FOR TRIANGLE - CLASS NO. 60
            case 1: 
            do
            {
                if((a + b > c) && (c + b > a) && (a + c > b)){
                     td = new Triangle(a, b, c);   
                     flag = false;
                }
                else{
                    a = getInt();
                    b = getInt();
                    c = getInt();
                }
            } while (flag); 
            break;

            case 2:
            td = new Rectangle(getInt(), getInt());
            break;
        }
        return td;
    }

    private static ThreeD getThreeD()
    {
        //or return TwoD.toString() or TwoD.getArea(), abstract class cannot be instantiated, use inheritance
        ThreeD td = null;
        Random rand = new Random();
        int num = rand.nextInt(3); //switch case
        switch (num)
        {
            case 0: 
            td = new Tetrahedron(getInt());
            break;

            case 1: 
            td = new Sphere(getInt());
            break;

            case 2:
            td = new Cube(getInt());
            break;
        }
        return td;
    }
    
    private static void displayList(ArrayList <Shape> alist)
    {
        for (Shape s : alist)
        {
            System.out.println("[ " + alist.indexOf(s) +" ]" + "   " + s.toString());
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        ArrayList <Shape> alist = new ArrayList <Shape> ();

        for (int j = 0; j < 5; j++)
        {
            getTwoD();
            alist.add(getTwoD()); 
        }

        for (int k = 0; k < 5; k++)
        {
            getThreeD();
            alist.add(getThreeD()); 
        }

        displayList(alist);
    }
}


