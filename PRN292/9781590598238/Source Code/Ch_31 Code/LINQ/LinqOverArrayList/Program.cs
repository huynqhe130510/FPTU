using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

using System.Collections;

namespace LinqOverArrayList
{
    class Car
    {
        public string PetName;
        public string Color;
        public int Speed;
        public string Make;
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** LINQ over ArrayList *****\n");

            // Here is a non-generic collection of cars.
            ArrayList myCars = new ArrayList();  
            myCars.Add(new Car{ PetName = "Henry", Color = "Silver", Speed = 100, Make = "BMW"});
            myCars.Add(new Car{ PetName = "Daisy", Color = "Tan", Speed = 90, Make = "BMW"});
            myCars.Add(new Car{ PetName = "Mary", Color = "Black", Speed = 55, Make = "VW"});
            myCars.Add(new Car{ PetName = "Clunker", Color = "Rust", Speed = 5, Make = "Yugo"});
            myCars.Add(new Car { PetName = "Melvin", Color = "White", Speed = 43, Make = "Ford" });

            // Transform ArrayList into an IEnumerable<T> compatible type.
            IEnumerable<Car> myCarsEnum = myCars.OfType<Car>();

            // Create a query expression. 
            var fastCars = from c in myCarsEnum where c.Speed > 55 select c;

            foreach (var car in fastCars)
            {
                Console.WriteLine("{0} is going too fast!", car.PetName);
            }

            // Extract the ints from the ArrayList.
            ArrayList myStuff = new ArrayList();
            myStuff.AddRange(new object[] { 10, 400, 8, false, new Car(), "string data" });
            IEnumerable<int> myInts = myStuff.OfType<int>();
            
            // Prints out 10, 400 and 8.
            foreach (int i in myInts)
            {
                Console.WriteLine("Int value: {0}", i);
            }
        }
    }
}
