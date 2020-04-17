using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class Program
    {
        static void Main(string[] args)
        {
            My2DPoint target = new ManhattanPoint()
            {
                x = 10,
                y = 10
            };

            My2DPoint manhattan = new ManhattanPoint()
            {
                x = 1,
                y = 1
            };

            My2DPoint euclidean = new EuclideanPoint()
            {
                x = 1,
                y = 1
            };

            Console.WriteLine("Manhattan: " + manhattan.Distance(target));
            Console.WriteLine("Euclidean: " + euclidean.Distance(target));
            Console.ReadKey();
        }
    }
}
