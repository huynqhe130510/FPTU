using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab1_2
{
    public class Program
    {
        public static void Main(String[] args)
        {
            Staff personnel = new Staff();
            personnel.payday();
            Console.ReadKey();
        }
    }
    public class Staff
    {
        private StaffMember[] staffList;

        public Staff()
        {
            staffList = new StaffMember[3];
            staffList[0] = new Executive("Sam", "123 Main Line", "555-0469", "123-45-6789", 2423.07);
            staffList[1] = new Employee("Carla", "456 Off Line", "555-0101", "987-65-4321", 1246.15);
            staffList[2] = new Hourly("Woody", "789 Off Rocker", "555-0000", "010-20-3040", 10.55);
            ((Executive)staffList[0]).awardBonus(500.00);
            ((Hourly)staffList[2]).addHours(40);
        }

        public void payday()
        {
            double amount;

            for (int count = 0; count < staffList.Count(); count++)
            {
                Console.WriteLine(staffList[count].display());
                amount = staffList[count].pay();  // polymorphic
                if (amount == 0.0)
                    Console.WriteLine("Thanks!");
                else
                    Console.WriteLine("Paid: " + amount);
                Console.WriteLine("-----------------------------------");
            }
        }
    }


    abstract public class StaffMember
    {
        private String name;
        private String address;
        protected String phone;

        public String Name
        {
            get { return name; }
            set { name = value; }
        }

        public String Address
        {
            get { return address; }
            set { name = value; }
        }

        public StaffMember(String eName, String eAddress, String ePhone)
        {
            name = eName;
            address = eAddress;
            phone = ePhone;
        }

         virtual public String display()
        {
            String result = "Name: " + name + "\n";
            result += "Address: " + address + "\n";
            result += "Phone: " + phone;
            return result;
        }

        public abstract double pay();
    }

    public class Volunteer : StaffMember
    {
        public Volunteer(String eName, String eAddress, String ePhone)
             : base(eName, eAddress, ePhone)
        {
        }

        override public double pay()
        {
            return 0.0;
        }
    }

    public class Employee : StaffMember
    {
        protected String socialSecurityNumber;
        protected double payRate;
        public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate) : base(eName, eAddress, ePhone)

        {

            socialSecurityNumber = socSecNumber;
            payRate = rate;
        }
        override public String display()
        {
            String result = base.display() + "\nSocial Security Number: " + socialSecurityNumber;
            return result;
        }

        override public double pay()
        {
            return payRate;
        }
    }

    public class Executive : Employee
    {
        private double bonus;
        public Executive(String eName, String eAddress, String ePhone, String socSecNumber, double rate) : base(eName, eAddress, ePhone, socSecNumber, rate)
        {

            bonus = 0;
        }

        public void awardBonus(double execBonus)
        {
            bonus = execBonus;
        }

        override public double pay()
        {
            double payment = base.pay() + bonus;
            bonus = 0;
            return payment;
        }
    }

    public class Hourly : Employee
    {
        private int hoursWorked;
        public Hourly(String eName, String eAddress, String ePhone, String socSecNumber, double rate) : base(eName, eAddress, ePhone, socSecNumber, rate)
        {
            hoursWorked = 0;
        }
        public void addHours(int moreHours)
        {
            hoursWorked += moreHours;
        }

        override public double pay()
        {
            double payment = payRate * hoursWorked;
            hoursWorked = 0;
            return payment;
        }

        override public String display()
        {
            String result = base.display();
            result += "\nCurrent hours: " + hoursWorked;
            return result;
        }
    }

}
