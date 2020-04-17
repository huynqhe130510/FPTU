using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter4
{
    class Employee
    {
        // Field data.
        public string fullName;
        public int empID;
        public float currPay;
        // Constructors.
        public Employee() { }
        public Employee(string fullName, int empID, float currPay)
        {
            // Self-Reference in C# Using this
            this.fullName = fullName;
            this.empID = empID;
            this.currPay = currPay;
        }
        // Bump the pay for this employee.
        public void GiveBonus(float amount)
        { currPay += amount; }
        // Show current state of this object.
        public void DisplayStatus()
        {
            Console.WriteLine("Name: {0} ", fullName);
            Console.WriteLine("Pay: {0} ", currPay);
            Console.WriteLine("ID: {0} ", empID);
        }
       
    }
}
