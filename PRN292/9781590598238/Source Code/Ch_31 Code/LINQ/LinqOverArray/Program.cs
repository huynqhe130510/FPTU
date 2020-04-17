using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace LinqOverArray
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with LINQ *****\n");

            QueryOverStrings();
            QueryOverInts();
            Console.ReadLine();
        }

        #region Query string array
        static void QueryOverStrings()
        {
            // Assume we have an array of strings.
            string[] currentVideoGames = {"Morrowind", "Dead Rising", 
                                  "Half Life 2: Episode 1", "F.E.A.R.",
                                  "Daxter", "System Shock 2"};

            // Build a query expression to represent the items in the array
            // which have more than 6 letters.
            var subset = from game in currentVideoGames 
                                 where game.Length > 6
                                 orderby game
                                 select game;

            // Print out the results.
            foreach (var s in subset)
                Console.WriteLine("Item: {0}", s);

            ReflectOverQueryResults(subset);
        } 
        #endregion

        #region Query int array
        static void QueryOverInts()
        {
            Console.WriteLine("\n***** Your Ints *****");
            int[] numbers = { 10, 20, 30, 40, 1, 2, 3, 8 };

            // Only print items less than 10.
            var subset = from i in numbers where i < 10 select i;

            // Print out the results.
            foreach (var i in subset)
                Console.Write("Item: {0} ", i);

            ReflectOverQueryResults(subset);
        } 
        #endregion

        static void ReflectOverQueryResults(object resultSet)
        {
            Console.WriteLine("\n\n***** Info about your query *****");
            Console.WriteLine("resultSet is of type: {0}", resultSet.GetType().Name);
            Console.WriteLine("resultSet location: {0}", resultSet.GetType().Assembly);
        }
    }
}
