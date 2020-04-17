using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter4
{
    class Program
    {
        // Interact with the public interface of the Employee class type
        static void Main(string[] args)
        {
            //Encapsulation with properties (tính đóng gói)
            Student s = new Student();
            // Set the value.
            s.Name = "Pham Ngoc Ha";
            // Get the value.
            Console.WriteLine("Person Name is: {0} ", s.Name);
            // Get the value.
            s.Pay = (float)5000.5 ;
            Console.WriteLine("ScholarShip is: {0} ", s.ScholarShip());
            Console.ReadLine();

            Console.WriteLine("***** The Employee Type at Work *****\n");
            Employee e = new Employee("Joe", 80, 30000);
            e.GiveBonus(200);
            e.DisplayStatus();
            Employee e2;
            e2 = new Employee("Beth", 81, 50000);
            e2.GiveBonus(1000);
            e2.DisplayStatus();
            Console.ReadLine();


            //// Make a salesperson.
            //SalesPerson stan = new SalesPerson();
            //// These members are inherited from the Employee base class.
            //stan.empID = 100;
            //stan.fullName = "Stan";
            //// This is defined by the SalesPerson class.
            //stan.NumbSales = 42;
            //stan.DisplayStatus();
            //Console.ReadLine();

            // Make a salesperson.
            Staff st = new Staff();
            // These members are inherited from the Employee base class.
            st.empID = 100;
            st.fullName = "Stan";
            // This is defined by the Staff class.
            st.NumbSales = 42;
            st.DisplayStatus();
            Console.ReadLine();

            // Polymorphism sample (đa hình)
            Console.WriteLine("Polymorphism in C#");
            Console.WriteLine("--------------------------");
            //tao doi tuong TestCsharp
            Polymorphism_sample p = new Polymorphism_sample();

            // goi ham print()
            p.print(5);
            p.print(500.263);
            p.print("Hoc C# co ban va nang cao");
            Console.ReadKey();

     


        }
        public class Manager : Employee
        {
            // Managers need to know their number of stock options.
            private ulong numberOfOptions;
            public ulong NumbOpts
            {
                get { return numberOfOptions; }
                set { numberOfOptions = value; }
            }
        }
        public class SalesPerson : Employee
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

}
