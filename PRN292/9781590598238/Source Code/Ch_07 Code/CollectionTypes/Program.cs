﻿#region Using directives

using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;

#endregion

namespace CollectionTypes
{
    class Program
    {
        public static void WashCar(Car c)
        {
            Console.WriteLine("Cleaning {0}", c.PetName);
        }

        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with System.Collections *****");

            #region ArrayList usage
            Console.WriteLine("\n***** ArrayList *****");
            // Create ArrayList and fill with some initial values.
            ArrayList carArList = new ArrayList();
            carArList.AddRange(new Car[] { new Car("Fred", 90, 10),
                new Car("Mary", 100, 50), new Car("MB", 190, 11)});
            Console.WriteLine("Items in carArList: {0}", carArList.Count);

            // Print out current values.
            foreach (Car c in carArList)
                Console.WriteLine("Car pet name: {0}", c.PetName);

            Console.WriteLine("\n->Inserting new Car.");
            // Insert a new item.
            carArList.Insert(2, new Car("TheNewCar", 0, 12));
            Console.WriteLine("Items in carArList: {0}", carArList.Count);

            // Get object array from ArrayList and print again.
            object[] arrayOfCars = carArList.ToArray();
            for (int i = 0; i < arrayOfCars.Length; i++)
            {
                Console.WriteLine("Car pet name: {0}",
                     ((Car)arrayOfCars[i]).PetName);
            }
            #endregion

            #region Queue usage
            Console.WriteLine("\n***** Queue *****");
            // Make a Q with three items.
            Queue carWashQ = new Queue();
            carWashQ.Enqueue(new Car("FirstCar", 0, 1));
            carWashQ.Enqueue(new Car("SecondCar", 0, 2));
            carWashQ.Enqueue(new Car("ThirdCar", 0, 3));

            // Peek at first car in Q.
            Console.WriteLine("First in Q is {0}",
                 ((Car)carWashQ.Peek()).PetName);

            // Remove each item from Q.
            WashCar((Car)carWashQ.Dequeue());
            WashCar((Car)carWashQ.Dequeue());
            WashCar((Car)carWashQ.Dequeue());

            // Try to de-Q again?
            try
            { WashCar((Car)carWashQ.Dequeue()); }
            catch (Exception e)
            { Console.WriteLine("Error!! {0}", e.Message); } 
            #endregion

            #region Stack usage
            Console.WriteLine("\n***** Stack *****");
            Stack stringStack = new Stack();
            stringStack.Push("One");
            stringStack.Push("Two");
            stringStack.Push("Three");

            // Now look at the top item, pop it and look again.
            Console.WriteLine("Top item is: {0}", stringStack.Peek());
            Console.WriteLine("Popped off {0}", stringStack.Pop());
            Console.WriteLine("Top item is: {0}", stringStack.Peek());
            Console.WriteLine("Popped off {0}", stringStack.Pop());
            Console.WriteLine("Top item is: {0}", stringStack.Peek());
            Console.WriteLine("Popped off {0}", stringStack.Pop());

            try
            {
                Console.WriteLine("Top item is: {0}", stringStack.Peek());
                Console.WriteLine("Popped off {0}", stringStack.Pop());
            }
            catch (Exception e)
            { Console.WriteLine("Error!! {0}", e.Message); } 
            #endregion

            Console.ReadKey();
        }
    }
}
