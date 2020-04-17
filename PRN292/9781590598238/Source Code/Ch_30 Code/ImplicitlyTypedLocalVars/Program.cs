using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;
           
namespace ImplicitlyTypedLocalVars
{
    #region Types just for testing purposes...
    class SportsCar {}
    class MiniVan { }
    /*
    class ThisWillNeverCompile
    {
        // Error! var cannot be used on field data!
        private var myInt = 10;

        // Error!  var cannot be used as return values
        // or parameter types!
        public var MyMethod(var x, var y){}
    }
    */
    #endregion

    class Program
    {
        static void Main()
        {
            Console.WriteLine("***** Fun with Implicit Typing *****\n");

            // Compiler error!
            // int var = 10;
            // var myObj = null;

            // Implicitly typed local variables. 
            var myInt = 0;
            var myBool = true;
            var myString = "Time, marches on…";
            var evenNumbers = new int[] { 2, 4, 6, 8 };
            var myMinivans = new List<MiniVan>();
            var myCar = new SportsCar();

            // Print out the underlying type. 
            Console.WriteLine("myInt is a: {0}", myInt.GetType().Name);
            Console.WriteLine("myBool is a: {0}", myBool.GetType().Name);
            Console.WriteLine("myString is a: {0}", myString.GetType().Name);
            Console.WriteLine("evenNumbers is a: {0}", evenNumbers.GetType().Name);
            Console.WriteLine("myMinivans is a: {0}", myMinivans.GetType().Name);
            Console.WriteLine("myCar is a: {0}", myCar.GetType().Name);
            Console.WriteLine();

            // Use 'var' in a for each loop.
            foreach (int item in evenNumbers)
            {
                Console.WriteLine("Item value: {0}", item);
            }
            Console.WriteLine();

            #region Some implicitly types arrays.
            // b is really int[]
            var a = new [] { 1, 10, 100, 1000 };
            Console.WriteLine(a.ToString());

            // b is really double[]
            var b = new [] { 1, 1.5, 2, 2.5 };
            Console.WriteLine(b.ToString());

            // c is really string[]
            var c = new [] { "hello", null, "world" };
            Console.WriteLine(c.ToString());

            var myCars = new [] { new SportsCar(), new SportsCar() };
            Console.WriteLine(myCars.ToString());

            // Error!  Mixed types!
            //var d = new[] { 1, "one", 2, "two" };
            #endregion

            // Error!  The compiler knows myVar is a string, not an integer!
            var s = "This variable can only hold string data!";
            s = "This is fine…";
            // This is not!
            // s = 44; 

            Console.ReadLine();
        }
    }
}
