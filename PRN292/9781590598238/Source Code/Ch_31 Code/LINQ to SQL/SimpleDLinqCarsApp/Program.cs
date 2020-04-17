using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;
using System.Configuration;

namespace SimpleDLinqCarsApp
{
    class Program
    {
        // Offloading this to an app.config file would be ideal...
        const string cnStr = "Data Source=localhost;Initial Catalog=Cars;uid='sa';pwd=";

        static void Main(string[] args)
        {
            Console.WriteLine("***** Linq to SQL Sample App *****\n");

            #region Without strongly typed DataContext
            //// Create a DataContext object.
            //DataContext db = new DataContext(cnStr);

            //// Now create a Table<> type.
            //Table<Inventory> invTable = db.GetTable<Inventory>();

            //// Show all data.
            //Console.WriteLine("-> Contents of Inventory Table from Cars database:\n");
            //foreach (var car in from c in invTable select c)
            //    Console.WriteLine(car.ToString());
            //Console.ReadLine(); 
            #endregion

            // Create a DataContext object.
            CarsDatabase db = new CarsDatabase(cnStr);

            // Show all data.
            Console.WriteLine("-> Contents of Inventory Table from Cars database:\n");

            foreach (var car in from c in db.Inventory select c)
                Console.WriteLine(car.ToString());

            ShowOnlyBimmers(db);
            Console.ReadLine();
        }

        #region Only Sliver Cars
        private static void ShowOnlyBimmers(CarsDatabase db)
        {
            Console.WriteLine("\n***** Only BMWs *****");
        
            // Now use a lambda expression to get only the silver cars.
            var bimmers = from s in db.Inventory 
                   where s.Make == "BMW" 
                   orderby s.CarID
                   select s;

            foreach (var x in bimmers)
                Console.WriteLine(x.ToString());
        }
        #endregion
    }
}