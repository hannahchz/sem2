//Hannah Chua, UOW 6276325
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

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
        return String.format("Circle (2D (%d)) ==> Area = %.3f", super.a, getArea());
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
        return String.format("Rectangle (2D (%d, %d)) ==> Area = %.3f", super.a, super.b, getArea());
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
        return String.format("Triangle (2D (%d, %d, %d)) ==> Area = %.3f", super.a, super.b, super.c, getArea());
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
        return String.format("Sphere (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f", super.a, getArea(), getVolume());
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
        return String.format("Cube (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f", super.a, getArea(), getVolume());
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
        return String.format("Tetrahedron (3D (%d)) ==> Surface Area = %.3f, Volume = %.3f", super.a, getArea(), getVolume());
    }
}

class Hannah_33_A2copy
{
    private static int getInt()
    {
        return (int) Math.floor (Math.random() * 10) + 1;
    }

    /*private static TwoD getTwoD(Object obj1, TwoD td1)
    {
        return obj1.toString(); //td
    }

    private static ThreeD getThreeD(Object obj2, TwoD td2)
    {
        return obj2.toString(); //or return TwoD.toString() or TwoD.getArea(), abstract class cannot be instantiated, use inheritance
    }*/
    
    private static void displayList(ArrayList <Shape> alist)
    {
        for (Shape s : alist)
        {
            s.getArea();
        }
    }
    public static void main(String[] args)
    {
        ArrayList <Shape> alist = new ArrayList <Shape> ();
        
        Triangle s1 = new Triangle(getInt(), getInt(), getInt());
        Sphere s2 = new Sphere(getInt());
        Circle s3 = new Circle(getInt());
        Tetrahedron s4 = new Tetrahedron(getInt());
        Rectangle s5 = new Rectangle(getInt(), getInt());
        Cube s6 = new Cube (getInt());
        Triangle s7 = new Triangle(getInt(), getInt(), getInt());
        Tetrahedron s8 = new Tetrahedron(getInt());
        Rectangle s9 = new Rectangle (getInt(), getInt());

        alist.add(s1);
        alist.add(s2);
        alist.add(s3);
        alist.add(s4);
        alist.add(s5);
        alist.add(s6);
        alist.add(s7);
        alist.add(s8);
        alist.add(s9);

        displayList(alist);

        //Shape imp; Implementation of Shape Interface

        for (Shape s : alist)
        {
            if (s instanceof Circle)
			{
                //instanceof, downcasting, create object
                System.out.printf("%n%s%n", ((Circle) s).toString());
            }

            else if (s instanceof Triangle)
            {
                System.out.printf("%n%s%n", ((Triangle) s).toString());
            }

            else if (s instanceof Rectangle)
            {
                System.out.printf("%n%s%n", ((Rectangle) s).toString());
            }
        
            else if (s instanceof Sphere)
            {
                System.out.printf("%n%s%n", ((Sphere) s).toString());
            }

            else if (s instanceof Cube)
            {
                System.out.printf("%n%s%n", ((Cube) s).toString()); //downcasting
            }

            else if (s instanceof Tetrahedron)
            {
                System.out.printf("%n%s%n", ((Tetrahedron) s).toString());
            }
        }
    }
}


