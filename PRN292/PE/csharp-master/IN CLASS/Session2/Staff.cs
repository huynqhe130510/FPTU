using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter4
{
    class Staff:Employee
    {
        // Salespeople need to know their number of sales.
        private int numberOfSales;
        public int NumbSales
        {
            get { return numberOfSales; }
            set { numberOfSales = value; }
        }
        public void DisplayStatus()
        {
            Console.WriteLine("numberOfSales: {0} ", this.NumbSales);
        }
    }
}
