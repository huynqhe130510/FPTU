using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;
using System.Collections;

namespace ObjectInitializers
{
    #region The Point and Rectangle types

    public enum PointColor
    { LightBlue, BloodRed, Gold }

    public struct Point
    {
        public int xPos, yPos;       
        private PointColor c;

        public Point(PointColor color)
        {
            xPos = 0; yPos = 0;
            c = color;
        }

        public Point(int x, int y)
        {  
            xPos = x; yPos = y;
            c = PointColor.Gold;
        }

        public int X
        {
            get { return xPos; }
            set { xPos = value; }
        }
        public int Y
        {
            get { return yPos; }
            set { yPos = value; }
        }
        public override string ToString()
        { return string.Format("[{0}, {1}, Color = {2}]", xPos, yPos, c); }
    }

    public class Rectangle
    {
	    private Point topLeft = new Point();
	    private Point bottomRight = new Point();
         
	    public Point TopLeft 
        { 
            get { return topLeft; } 
            set { topLeft = value; } 
        }
	    public Point BottomRight 
        { 
            get { return bottomRight; } 
            set { bottomRight = value; } 
        }

        public override string ToString()
        {
            return string.Format("[TopLeft: {0}, {1}, BottomRight: {2}, {3}]", topLeft.X, 
                topLeft.Y, bottomRight.X, bottomRight.Y); 
        }
    }

    #endregion

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Object Initializers *****\n");

            // Make a Point by setting each property manually.
            Point firstPoint = new Point();
            firstPoint.X = 10;
            firstPoint.Y = 10;

            // Make a Point via custom constructor
            Point anotherPoint = new Point(20, 20);

            // Make a Point using object init syntax.
            var yetAnotherPoint = new Point { X = 30, Y = 30 };
            Point finalPoint = new Point { X = 30, Y = 30 };

            var p = new Point {xPos = 2, yPos = 3, X = 900};
            Console.WriteLine("Value of Point is: {0}", p);

            // Calling a custom constructor with init syntax.
            Point goldPoint = new Point(PointColor.Gold){ X = 90, Y = 20 };
            Console.WriteLine("Value of Point is: {0}", goldPoint);

            // Create and initialize a Rectangle.
            Rectangle myRect = new Rectangle 
            { 
                TopLeft = new Point { X = 10, Y = 10 },
                BottomRight = new Point { X = 200, Y = 200}
            };
            Console.WriteLine("Value of Rectangle is: {0}", myRect);

            // Init a standard array.
            int[] myArrayOfInts = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

            // Init a generic List<>.
            List<int> myGenericList = new List<int> { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

            // Error!  ArrayList does not implement ICollection<T>!
            // ArrayList myList = new ArrayList { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

            List<Point> myListOfPoints = new List<Point>
            {
                new Point { X = 2, Y = 2},
                new Point { X = 3, Y = 3},
                new Point { X = 4, Y = 4},
                new Point { X = 5, Y = 5},
                new Point { X = 6, Y = 6}
            };

            foreach (var pt in myListOfPoints)
            {
                Console.WriteLine(pt);
            }

            List<Rectangle> myListOfRects = new List<Rectangle>
            {
                new Rectangle {TopLeft = new Point { X = 10, Y = 10 },
                               BottomRight = new Point { X = 200, Y = 200}},
                new Rectangle {TopLeft = new Point { X = 2, Y = 2 },
                               BottomRight = new Point { X = 100, Y = 100}},
                new Rectangle {TopLeft = new Point { X = 5, Y = 5 },
                               BottomRight = new Point { X = 90, Y = 75}}
            };

            foreach (var r in myListOfRects)
            {
                Console.WriteLine(r);
            }
            Console.ReadLine();
        }
    }
}
