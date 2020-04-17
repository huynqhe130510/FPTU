using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LAB1
{
    class Program
    {
        static void OnLengthChangedHandler(int length)
        {
            Console.WriteLine("Length of collection changed to " + length.ToString());
        }
        static void OnOrderedChangedHandler()
        {
            Console.WriteLine("Order changed");
        }
        static void Main(string[] args)
        {
            AutoCollection MyCol = new AutoCollection();
            MyCol.LengthChanged += OnLengthChangedHandler;
            MyCol.OrderChanged += OnOrderedChangedHandler;
            MyCol.DemoUsingEmpCollection();
            Console.ReadLine();
        }
    }
}
