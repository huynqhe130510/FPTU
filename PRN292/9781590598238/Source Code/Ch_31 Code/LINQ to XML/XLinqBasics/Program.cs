using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;
using System.Xml;

namespace XLinqBasics
{
    class Car
    {
        public string PetName;
        public int ID;
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with XLinq *****\n");

            // CreateFunctionalXmlElement();
            // CreateFunctionalXmlDoc();
            // LoadExistingXml();
            CreateXmlDocFromArray();
        }

        #region XML from array
        private static void CreateXmlDocFromArray()
        {
            // Create an anonymous array of types.
            var data = new [] {
	            new Car { PetName = "Melvin", ID = 10 },
	            new Car { PetName = "Pat", ID = 11 },
	            new Car { PetName = "Danny", ID = 12 },
	            new Car { PetName = "Clunker", ID = 13 }
            };

            // Now enumerate over the array to build
            // an XElement.
            XElement vehicals =
	            new XElement("Inventory",
                    from c in data 
		            select new XElement("Car",
			            new XAttribute("ID", c.ID),
			            new XElement("PetName", c.PetName)
		            )
                );
            Console.WriteLine(vehicals);
        }
        #endregion

        #region Load existing XML
        private static void LoadExistingXml()
        {
            // Build an XElement from string.
            string myElement = 
            @"<Car ID ='3'>
              <Color>Yellow</Color>
              <Make>Yugo</Make>    
            </Car>";
            XElement newElement = XElement.Parse(myElement);
            Console.WriteLine(newElement);
            Console.WriteLine();

            // Load the SimpleInventory.xml file.
            XDocument myDoc = XDocument.Load("SimpleInventory.xml");
            Console.WriteLine(myDoc);
        }
        #endregion

        #region Create doc with XDocument.
        private static void CreateFunctionalXmlDoc()
        {
            XDocument inventoryDoc =
                new XDocument(
                    new XDeclaration("1.0", "utf-8", "yes"),
                    new XComment("Current Inventory of Cars"),
                        new XElement("Inventory",
                            new XElement("Car", new XAttribute("ID", "1"),
                                new XElement("Color", "Green"),
                                new XElement("Make", "BMW"),
                                new XElement("PetName", "Stan")
                            ),
                            new XElement("Car", new XAttribute("ID", "2"),
                                new XElement("Color", "Pink"),
                                new XElement("Make", "Yugo"),
                                new XElement("PetName", "Melvin")
                            )
                        )
                    );
            // Display the document.
            Console.WriteLine(inventoryDoc);

            inventoryDoc.Save("SimpleInventory.xml");
        }
        #endregion

        #region Create functional element.
        private static void CreateFunctionalXmlElement()
        {
            // A 'functional' approach to build an 
            // XML document in memory.
            XElement inventory = 
                new XElement("Inventory",
                    new XElement("Car", new XAttribute("ID", "1"),
                        new XElement("Color", "Green"),
                        new XElement("Make", "BMW"),
                        new XElement("PetName", "Stan")
                    )
                );
            // Call ToString() on our XElement. 
            Console.WriteLine(inventory);
        }
        #endregion
    }
}
