using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace SimpleLambdaExpressions
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Lambda Expressions *****\n");

            //// Now, use a C# 3.0 lambda expression.
            //var evenNumbers = list.FindAll((i) => ((i % 2) == 0));
            //foreach (var evenNumber in evenNumbers)
            //{
            //    Console.WriteLine(evenNumber);
            //}

            // Make a list of integers using C# 3.0
            // collection initialization syntax. 
            var list = new List<int>() {20, 1, 4, 8, 9, 44};   

            // This time the lambda expression is build with a statement
            // block. 
            var justATest = list.FindAll(i => { 
                                                Console.WriteLine("Called by FindAll()!");
                                                Console.WriteLine("value of i is currently: {0}", i);
                                                bool isEven = ((i % 2) == 0);
                                                return isEven;
                                              }
                                         );

            Console.WriteLine("\nHere are the even numbers from your list:");
            foreach (var evenNumber in justATest)
	        {
		        Console.WriteLine(evenNumber);
	        }

            Console.ReadLine();
        }
    }
}


