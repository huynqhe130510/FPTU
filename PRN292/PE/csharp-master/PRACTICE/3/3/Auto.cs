using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LAB1
{
    class Auto
    {
        public int id { get; set; }
        public double basePrice { get; set; }
        public int year { get; set; }

        public Auto()
        {

        }
        public Auto(int i, double n, int k)
        {
            id = i;
            basePrice = n;
            year = k;
        }
        public override string ToString()
        {
            return "id: " + id.ToString() + "|base Price: " + basePrice + "|year" + year.ToString();
        }
        public virtual double getPrice()
        {
            return basePrice;
        }
        public override bool Equals(object obj)
        {
            Auto a = (Auto)obj;
            return this.id.Equals(a.id);
        }
        public int CompareTo(Object o)
        {
            Auto a = (Auto)o;
            return id.CompareTo(a.id);
        }
    }
    class Truck : Auto
    {
        public int weight { get; set; }
        public double addedPrice { get; set; }
        public Truck(int i, int n, int k) : base(i, n, k)
        {

        }
        public Truck(int i, int n, int k, int p, double q) : base(i, n, k)
        {
            weight = p;
            addedPrice = q;

        }
        public override string ToString()
        {
            return base.ToString() + "|weight: " + weight.ToString() + "|added price : " + getPrice();

        }
        public override double getPrice()
        {
            return base.getPrice() + addedPrice;
        }
        

    }
    class Car : Auto
    {
        public int numberOfPassenger { get; set; }
        public double pricePerPass { get; set; }
        public Car(int i, int n, int k) : base(i, n, k)
        {

        }
        public Car(int i, int n, int k, int e, double s) : base(i, n, k)
        {
            numberOfPassenger = e;
            pricePerPass = s;

        }
        public override string ToString()
        {
            return base.ToString() + "|Number of Passanger: " + numberOfPassenger.ToString() + "|Price Per Pass : " + getPrice();

        }
        public override double getPrice()
        {
            return base.getPrice() + numberOfPassenger * pricePerPass;
        }
    }
}
