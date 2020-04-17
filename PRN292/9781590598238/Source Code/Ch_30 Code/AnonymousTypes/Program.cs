using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace AnonymousTypes
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Anonymous types *****\n");

            //// Make an anonymous object representing a car.
            //var myCar = new { Color = "Bright Pink", Make = "Saab", CurrentSpeed = 55 };
            //ReflectOverAnonymousType(myCar);

            //// We can now get and set each value using property syntax.
            //myCar.Color = "Black"; // Ugh! change the color!
            //Console.WriteLine("My car is the color {0}.", myCar.Color);

            //// Make another anonymous car.
            //var yourCar = new { Color = "Red", Make = "Saab", CurrentSpeed = 55 };
            //ReflectOverAnonymousType(yourCar);

            #region Equality tests.

            // Make 2 anonymous classes with identical name/value pairs.
            var firstCar = new { Color = "Bright Pink", Make = "Saab", CurrentSpeed = 55 };
            var secondCar = new { Color = "Bright Pink", Make = "Saab", CurrentSpeed = 55 };

            // Are they considered equal when using Equals()?
            if (firstCar.Equals(secondCar))
                Console.WriteLine("Same anonymous object!");
            else
                Console.WriteLine("Not the same anonymous object!");

            // Are they considered equal when using ==?
            if (firstCar == secondCar)
                Console.WriteLine("Same anonymous object!");
            else
                Console.WriteLine("Not the same anonymous object!");

            // Are these objects the same type?
            if (firstCar.GetType().Name == secondCar.GetType().Name)
                Console.WriteLine("We are both the same type!");
            else
                Console.WriteLine("We are different types!");

            // Show all the details.
            Console.WriteLine();
            ReflectOverAnonymousType(firstCar);
            ReflectOverAnonymousType(secondCar);

            #endregion

            // Make another anonymous object.
            var purchaseItem = new {TimeBought = DateTime.Now, 
                                    ItemBought = new {Color = "Red", Make = "Saab", CurrentSpeed = 55},
                                    Price = 34.000};
            ReflectOverAnonymousType(purchaseItem);
            Console.ReadLine();
        }

        #region Helper method to test details of anonymous types.
        static void ReflectOverAnonymousType(object obj)
        {
            Console.WriteLine("obj is an instance of: {0}", obj.GetType().FullName);
            Console.WriteLine("Base class of {0} is {1}",
                obj.GetType().Name,
                obj.GetType().BaseType);
            Console.WriteLine("obj.ToString() = {0}", obj.ToString());
            Console.WriteLine("obj.GetHashCode() = {0}", obj.GetHashCode());
            Console.WriteLine();
        }
        #endregion
    }
}
