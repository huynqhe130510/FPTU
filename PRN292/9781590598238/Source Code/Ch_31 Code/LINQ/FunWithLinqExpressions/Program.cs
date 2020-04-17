using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace FunWithLinqExpressions
{
    #region Simple Car Type
    class Car
    {
        public string PetName;
        public string Color;
        public int Speed;
        public string Make;
        
        public override string ToString()
        {
            return string.Format("Make={0}, Color={1}, Speed={2}, PetName={3}",
                Make, Color, Speed, PetName);
        }
    }

    #endregion

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Query Expressions *****\n");

            // This array of Cars is the target for our LINQ queries.
            Car[] myCars = new []{
                new Car{ PetName = "Henry", Color = "Silver", Speed = 100, Make = "BMW"},
                new Car{ PetName = "Daisy", Color = "Tan", Speed = 90, Make = "BMW"},
                new Car{ PetName = "Mary", Color = "Black", Speed = 55, Make = "VW"},
                new Car{ PetName = "Clunker", Color = "Rust", Speed = 5, Make = "Yugo"},
                new Car{ PetName = "Hank", Color = "Tan", Speed = 0, Make = "Ford"},
                new Car{ PetName = "Sven", Color = "White", Speed = 90, Make = "Ford"},
                new Car{ PetName = "Mary", Color = "Black", Speed = 55, Make = "VW"},
                new Car{ PetName = "Zippy", Color = "Yellow", Speed = 55, Make = "VW"},
                new Car{ PetName = "Melvin", Color = "White", Speed = 43, Make = "Ford"}
            };

            // Comment / uncomment each method call to test.

            // BasicSelection(myCars);
            // GetSubsets(myCars);
            // ReversedSelection(myCars);
            // OrderedResults(myCars);
            ResultsAsArray(myCars);
            Console.ReadLine();
        }

        #region Basic selection statements
        private static void BasicSelection(Car[] myCars)
        {
            // Get everything.
            Console.WriteLine("All cars:");
            var subset = from c in myCars select c;
            foreach (var c in subset)
            {
                Console.WriteLine(c.ToString());
            }

            // Now get only the names of the cars.
            Console.WriteLine("\nAll PetNames:");
            var names = from c in myCars select c.PetName;
            foreach (var n in names)
            {
                Console.WriteLine("Name: {0}", n);
            }

            // Get all Makes, but don't show repeats.
            Console.WriteLine("\nAll Makes:");
            var makes = from c in myCars select c.Make;
            foreach (var m in makes.Distinct<string>())
            {
                Console.WriteLine("Make: {0}", m);
            }
        } 
        #endregion        

        #region Obtain subsets
        private static void GetSubsets(Car[] myCars)
        {
            // Now get only the BMWs.
            Console.WriteLine("Only BMWs:");
            var onlyBMWs = from c in myCars where c.Make == "BMW" select c;

            foreach (Car c in onlyBMWs)
            {
                Console.WriteLine(c.ToString());
            }

            // Get BMWs going at least 100 MPH.
            Console.WriteLine("\nOnly fast BMWs:");
            var onlyFastBMWs = from c in myCars
                               where c.Make == "BMW" && c.Speed >= 100 
                               select c;

            foreach (Car c in onlyFastBMWs)
            {
                Console.WriteLine(c.ToString());
            }

            // Now get structured data which only accounts for the 
            // Make and Color of each item.
            Console.WriteLine("\nMakes and Color:");
            var makesColors = from c in myCars select new {c.Make, c.Color};
            foreach (var o in makesColors)
            {
                // Could also use Make and Color properties directly.
                Console.WriteLine(o.ToString());
            }
        }        
        #endregion

        #region Reverse selection
        private static void ReversedSelection(Car[] myCars)
        {
            // Get everything in reverse.
            Console.WriteLine("All cars in reverse:");
            var subset = (from c in myCars select c).Reverse<Car>();
            foreach (Car c in subset)
            {
                Console.WriteLine(c.ToString());
            }
        } 
        #endregion

        #region Ordering the results
        private static void OrderedResults(Car[] myCars)
        {
            // Order the cars by PetName.
            var subset = from c in myCars 
                orderby c.PetName select c;

            Console.WriteLine("Ordered by PetName:");
            foreach (Car c in subset)
            {
                Console.WriteLine(c.ToString());
            }

            // Now find the cars which are going less than 55 MPH, 
            // and order by descending PetName.
            subset = from c in myCars where c.Speed > 55 orderby c.PetName descending select c;
            Console.WriteLine("\nCars going faster than 55, ordered by PetName:");
            foreach (Car c in subset)
            {
                Console.WriteLine(c.ToString());
            }
        }        
        #endregion

        #region Transform results into CLR array
        private static void ResultsAsArray(Car[] myCars)
        {
            // Get all cars going faster than 55.
            // var subset = from c in myCars 
            //    where c.Speed > 55 select c;

            var subset = (from c in myCars 
                where c.Speed > 55 select c).ToArray<Car>();

            Console.WriteLine("Initial query:");
            foreach (Car c in subset)
            {
                Console.WriteLine("{0} is going {1} MPH", c.PetName, c.Speed);
            }

            // Now change the speed of the 1st item.
            myCars[0].Speed = 5;

            Console.WriteLine("\nSecond query:");
            foreach (Car c in subset)
            {
                Console.WriteLine("{0} is going {1} MPH", c.PetName, c.Speed);
            }
        } 
        #endregion
    }
}
