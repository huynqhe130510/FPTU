using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

using System.Reflection;
using MyUtilities;

namespace ExtensionMethods
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Extension Methods *****\n");

            // The int has assumed a new identity!
            int myInt = 12345678;
            myInt.DisplayDefiningAssembly();

            // So does this DataSet!
            System.Data.DataSet d = new System.Data.DataSet();
            d.DisplayDefiningAssembly();

            // And this MediaPlayer!
            System.Media.SoundPlayer sp = new System.Media.SoundPlayer();
            sp.DisplayDefiningAssembly();

            // Use new integer functionality.
            Console.WriteLine("Value of myInt: {0}", myInt);
            Console.WriteLine("Reversed digits of myInt: {0}", myInt.ReverseDigits());
            myInt.Foo();
            myInt.Foo("Ints that Foo?  Who would have thought it!");

            // Error!  Booleans don’t have the Foo() method!
            //bool b2 = true;
            //b2.Foo();

            // Remember!  Extension methods can be called as normal static
            // methods. 
            MyExtensions.DisplayDefiningAssembly(false);
        }
    }
}
