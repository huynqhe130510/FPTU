using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Project
{
    public class ProductInOrder
    {
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public double Price { get; set; }
        public string Size { get; set; }
        public int Quantity { get; set; }
        public double Cost { get; set; }
        public ProductInOrder()
        {
                
        }
        public ProductInOrder(int productID, string productName, double price, string size, int quantity)
        {
            ProductID = productID;
            ProductName = productName;
            Price = price;
            Size = size;
            Quantity = quantity;
            Cost = Quantity * Price;
        }

    }
}
