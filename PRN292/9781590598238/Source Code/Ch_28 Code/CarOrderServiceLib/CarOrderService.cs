using System;
using System.Collections.Generic;
using System.Text;
using System.ServiceModel;

namespace CarOrderServiceLib
{
    public class CarOrderService : ICarOrder
    {
        private const int HardCodedOrderNumber = 10;

        public int PlaceOrder(string make, string color, double price)
        {
            // Simply print out the incoming data and return an order ID.
            Console.WriteLine("Thanks for buying a {0} {1} for the low, low price of ${2}.",
                color, make, price);

            return HardCodedOrderNumber;
        }

        public string CheckOrderStatus(int orderID)
        {
            if (orderID == HardCodedOrderNumber)
            {
                return "Your car has been shipped!";
            }
            else
            { 
                return "Sorry, we can't find your order ID.";
            }
        }

        public int PlaceOrder(CarOrderDetails order)
        {
            // Greedy sales person!
            if (order.SecondChoice.Price < 40000)
            {
                Console.WriteLine("Sorry, your first choice is not on our lot.");
                Console.WriteLine("We do however have a {0} {1}.",
                    order.SecondChoice.Color, order.SecondChoice.Make);
                Console.WriteLine("You will be charged {0}.", order.SecondChoice.Price);
            }
            else
            {
                // Simply print out the incoming data and return an order ID.
                Console.WriteLine("Thanks for buying a {0} {1} for the low, low price of ${2}.",
                    order.Color, order.Make, order.Price);
            }
            return HardCodedOrderNumber;
        }
    }
}
