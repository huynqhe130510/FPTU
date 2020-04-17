using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q12
{
    class Program
    {
        static void Main(string[] args)
        {
            // Q1
            AbstractDistance distance = new MyDistance();
            Point p1 = new Point();
            p1.X = 2;
            p1.Y = 1;
            Point p2 = new Point();
            p2.X = 1;
            p2.Y = 2;
            Console.WriteLine(distance.GetDistance(p1,p2));

            // Q2
            ISeason ss = new Winter();
            ss.say();
            ss = new Summer();
            ss.say();
        }
    }
}
