using System;
using System.Collections.Generic;
using System.Text;
using System.ServiceModel;
using System.Runtime.Serialization;

namespace CarOrderServiceLib
{
    [DataContract]
    public class CarOrderDetails
    {
        [DataMember]
        public string Make;
        [DataMember]
        public string Color;
        [DataMember]
        public double Price;
        [DataMember]
        public CarOrderDetails SecondChoice;
    }

    [ServiceContract(Namespace = "http://IntertechTraining.com")]
    public interface ICarOrder
    {
        // Allows caller to place and order and obtain
        // an order ID.
        [OperationContract]
        int PlaceOrder(string make, string color, double price);

        // This version takes a CarOrderDetails object.
        [OperationContract(Name = "PlaceOrderWithDetails")]
        int PlaceOrder(CarOrderDetails order);

        // Allows caller to get current status of the order.
        [OperationContract]
        string CheckOrderStatus(int orderID);
    }
}
