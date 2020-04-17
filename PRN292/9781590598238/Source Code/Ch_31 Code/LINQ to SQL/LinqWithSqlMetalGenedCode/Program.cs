using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;

using CarsDatabase;

namespace LinqWithSqlMetalGenedCode
{
    class Program
    {
        const string cnStr = "Data Source=localhost;Initial Catalog=Cars;uid='sa';pwd=";

        static void Main(string[] args)
        {
            Console.WriteLine("***** More Fun with DLinq *****\n");

            Cars carsDB = new Cars(cnStr);
            InvokeStoredProc(carsDB);
            PrintOrderForCustomer(carsDB);
            Console.ReadLine();
        }

        #region Print order details for customer
        private static void PrintOrderForCustomer(Cars carsDB)
        {
            int custID = 0;
            Console.Write("Enter customer ID: ");
            custID = int.Parse(Console.ReadLine());

            var customerOrders =
                from cust in carsDB.Customers
	            from o in cust.Orders
	            where cust.CustID == custID
	            select new { cust, o };

            Console.WriteLine("***** Order Info for Customer ID: {0}. *****", custID);
            foreach (var q in customerOrders)
            {
                Console.WriteLine("{0} {1} is order ID # {2}.",
                    q.cust.FirstName.Trim(),
                    q.cust.LastName.Trim(),
                    q.o.OrderID);
                Console.WriteLine("{0} bought Car ID # {1}.",
                    q.cust.FirstName.Trim(), q.o.CarID);
            }

            Console.WriteLine("\ncustomerOrders as a string: {0}", customerOrders);
        } 
        #endregion

        #region Invoke stored proc
        private static void InvokeStoredProc(Cars carsDB)
        {
            int carID = 0;
            string petName = "";
            Console.Write("Enter ID: ");
            carID = int.Parse(Console.ReadLine());

            // Invoke stored proc and print out the petname.
            carsDB.GetPetName(carID, ref petName);
            Console.WriteLine("Car ID {0} has the petname: {1}",
                carID, petName);
        } 
        #endregion
    }
}
