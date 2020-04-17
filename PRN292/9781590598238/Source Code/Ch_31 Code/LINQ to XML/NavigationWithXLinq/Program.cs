using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace NavigationWithXLinq
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with XLinq *****\n");

            // Load the Inventory.xml document into memory.
            XElement doc = XElement.Load("Inventory.xml");

            // We will author each of these next...
            PrintAllPetNames(doc);
            Console.WriteLine();
            GetAllFords(doc);
            Console.WriteLine(); 
            AddNewElements(doc);
        }

        #region LINQ queries against XML
        private static void PrintAllPetNames(XElement doc)
        {
            var petNames = from pn in doc.Descendants("PetName")
                           select pn.Value;

            foreach (var name in petNames)
                Console.WriteLine("Name: {0}", name);
        }

        private static void GetAllFords(XElement doc)
        {
            var fords = from pn in doc.Descendants("Make")
                        where pn.Value == "Ford" 
                        select pn;

            foreach (var f in fords)
                Console.WriteLine("Name: {0}", f);
        } 
        #endregion

        #region Add new elements
        private static void AddNewElements(XElement doc)
        {
            // Add 5 new purple Fords to the incoming document.
            for (int i = 0; i < 5; i++)
            {
                // Create a new XElement
                XElement newCar =
                    new XElement("Car", new XAttribute("ID", i + 1000),
                      new XElement("Color", "Green"),
                      new XElement("Make", "Ford"),
                      new XElement("PetName", "")
                );

                // Add to doc.
                doc.Add(newCar);
            }
            // Show the updates.
            Console.WriteLine(doc);
        } 
        #endregion 
    }
}
