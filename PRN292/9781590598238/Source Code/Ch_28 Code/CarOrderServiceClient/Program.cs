using System;
using System.Collections.Generic;
using System.Text;

// Location of the proxy type.
using CarOrderServiceClient.localhost;

namespace CarOrderServiceClient
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create the proxy and call the members.
            using (CarOrderClient c = new CarOrderClient())
            {
                CarOrderDetails myOrder = new CarOrderDetails();
                myOrder.Color = "Green";
                myOrder.Make = "BMW";
                myOrder.Price = 15.221;

                CarOrderDetails backUpCar = new CarOrderDetails();
                backUpCar.Make = "Yugo";
                backUpCar.Color = "Pink";
                backUpCar.Price = 5000;
                myOrder.SecondChoice = backUpCar;

                int orderID = c.PlaceOrderWithDetails(myOrder);

                Console.WriteLine(c.CheckOrderStatus(orderID));
            }
            Console.ReadLine();
        }
    }
}
