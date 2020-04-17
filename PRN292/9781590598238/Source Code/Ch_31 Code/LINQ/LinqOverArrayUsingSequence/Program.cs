using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace LinqOverArrayUsingSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Various Ways to Build Query Expressions *****\n");

            QueryStringWithOperators();
            QueryStringsWithSequenceAndLambdas();
            QueryStringsWithAnonymousMethods();
            VeryComplexQueryExpression.QueryStringsWithRawDelegates();
            Console.ReadLine();
        }

        #region Query with operators
        private static void QueryStringWithOperators()
        {
            Console.WriteLine("***** Using Query Operators *****");

            // Assume we have an array of strings.
            string[] currentVideoGames = {"Morrowind", "Dead Rising", 
                          "Half Life 2: Episode 1", "F.E.A.R.",
                          "Daxter", "System Shock 2"};

            // Build a query expression to represent the items in the array
            // which have more than 6 letters.
            var subset = from g in currentVideoGames 
                      where g.Length > 6 orderby g select g;

            // Print out the results.
            foreach (var s in subset)
                Console.WriteLine("Item: {0}", s);
            Console.WriteLine();
        } 
        #endregion

        #region Query with sequence / lambdas
        static void QueryStringsWithSequenceAndLambdas()
        {
            Console.WriteLine("***** Using Sequence / Lambda Expressions *****");

            string[] currentVideoGames = {"Morrowind", "Dead Rising", 
                                  "Half Life 2: Episode 1", "F.E.A.R.",
                                  "Daxter", "System Shock 2"};

            // This time, we are making use of the extension methods
            // granted the Array via the Sequence type.
            //var subset = currentVideoGames.Where(game => game.Length > 6)
            //    .OrderBy(game => game).Select(game => game);


            var subset = Sequence.Where(currentVideoGames, game => game.Length > 6)
                .OrderBy(game => game).Select(game => game);

            // Print out the results.
            foreach (var game in subset)
                Console.WriteLine("Item: {0}", game);
            Console.WriteLine();
        } 
        #endregion

        #region Query with anonymous methods
        static void QueryStringsWithAnonymousMethods()
        {
            Console.WriteLine("***** Using Anonymous Methods *****");

            string[] currentVideoGames = {"Morrowind", "Dead Rising", 
                                  "Half Life 2: Episode 1", "F.E.A.R.",
                                  "Daxter", "System Shock 2"};

            // Build the necessary Func<> delegates using anonymous methods.
            Func<string, bool> searchFilter = delegate(string game) { return game.Length > 6; };
            Func<string, string> itemToProcess = delegate(string s) { return s; };

            // Pass the delegates into the methods of Sequence.
            var subset = currentVideoGames
                .Where(searchFilter).OrderBy(itemToProcess).Select(itemToProcess);

            // Print out the results.
            foreach (var game in subset)
                Console.WriteLine("Item: {0}", game);
            Console.WriteLine();
        } 
        #endregion
    }
}
