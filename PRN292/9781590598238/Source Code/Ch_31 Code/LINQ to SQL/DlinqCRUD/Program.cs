using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

namespace DlinqCRUD
{
    class Program
    {    
        static void Main(string[] args)
        {
            Console.WriteLine("***** Even More Fun with DLinq *****");

            // *.config file automatically read within default ctor.
            CarsDataContext ctx = new CarsDataContext();

            // The current LINQ designers do not author code to 
            // automatically open the connection...
            ctx.Connection.Open();
            
            InsertNewCars(ctx);
            UpdateCar(ctx);
            DeleteCar(ctx);

            ctx.Connection.Close();
            Console.ReadLine();
        }

        #region Delete a car
        private static void DeleteCar(CarsDataContext ctx)
        {
            int carToDelete = 0;
            Console.Write("Enter ID of car to delete: ");
            carToDelete = int.Parse(Console.ReadLine());

            ctx.Inventories.Remove((from c in ctx.Inventories 
                                    where c.CarID == carToDelete
                                    select c).First());
            ctx.SubmitChanges();
        } 
        #endregion

        #region Update a car
        private static void UpdateCar(CarsDataContext ctx)
        {
            Console.WriteLine("\n***** Updating color of 'Betty' *****");

            // Update betty's color to light pink.
            var betty = (from c in ctx.Inventories
                         where c.PetName == "Betty" 
                         select c).First();
            betty.Color = "Green";
            ctx.SubmitChanges();
        } 
        #endregion

        #region Insert Cars
        private static void InsertNewCars(CarsDataContext ctx)
        {
            Console.WriteLine("\n***** Adding 2 Cars *****");
            int newCarID = 0;
            Console.Write("Enter ID for Betty: ");
            newCarID = int.Parse(Console.ReadLine());

            // Add a new row using 'long hand' notation.
            Inventory newCar = new Inventory();
            newCar.Make = "Yugo";
            newCar.Color = "Pink";
            newCar.PetName = "Betty";
            newCar.CarID = newCarID;
            ctx.Inventories.Add(newCar);
            ctx.SubmitChanges();

            // Add another row using object init syntax.
            Console.Write("Enter ID for Henry: ");
            newCarID = int.Parse(Console.ReadLine());

            newCar = new Inventory { Make = "BMW", Color = "Silver", 
                     PetName = "Henry", CarID = newCarID };

            ctx.Inventories.Add(newCar);
            ctx.SubmitChanges();
        }
        #endregion
    }
}
