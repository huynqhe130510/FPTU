using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    public class OrderDetail
    {
        int id;
        int orderID;
        int productId;
        string productName;
        int quantity;
        string size;
        float price;
        float cost;

        public OrderDetail()
        {
        }

        public OrderDetail(int productId, string productName,  int quantity, string size, float price)
        {
            this.productId = productId;
            this.productName = productName;
            this.size = size;
            this.quantity = quantity;
            this.price = price;
            this.cost = price * quantity;
        }

        public int Id { get => id; set => id = value; }
        public int OrderID { get => orderID; set => orderID = value; }
        public int ProductId { get => productId; set => productId = value; }
        public string ProductName { get => productName; set => productName = value; }
        public string Size { get => size; set => size = value; }
        public int Quantity { get => quantity; set => quantity = value; }
        public float Price { get => price; set => price = value; }
        public float Cost { get => cost; set => cost = value; }     
    }
}
