using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace LinqOverCustomObjects
{
    #region Simple Car class
    //class Car
    //{
    //    public string PetName;
    //    public string Color;
    //    public int Speed;
    //    public string Make;
    //}
    #endregion

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** More fun with LINQ Expressions *****\n");

            // Make an anonymous type using object init syntax.
            var myCars = new[] { 
                new { PetName = "Henry", Color = "Silver", Speed = 100, Make = "BMW"},
                new { PetName = "Daisy", Color = "Tan", Speed = 90, Make = "BMW"},
                new { PetName = "Mary", Color = "Black", Speed = 55, Make = "VW"},
                new { PetName = "Clunker", Color = "Rust", Speed = 5, Make = "Yugo"},
                new { PetName = "Melvin", Color = "White", Speed = 43, Make = "Ford"}
            };

            // Create a query expression. 
            var fastCars = from c in myCars where 
                c.Speed > 90 && c.Make == "BMW" select c;

            foreach (var car in fastCars)
            {
                Console.WriteLine("{0} is going too fast!", car.PetName);
            }
        }
    }
}
