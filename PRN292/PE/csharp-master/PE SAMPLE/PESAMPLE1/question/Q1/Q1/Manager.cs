using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Q1
{
    class Manager:Staff
    {
        public int age { get; set; }

        public Manager()
        {

        }

        public Manager(String Name, DateTime Date_Of_Birth, int age) : base(Name, Date_Of_Birth)
        {
            this.Name = Name;
            this.Date_Of_Birth = Date_Of_Birth;
            this.age = age;
        }

        public override void Caculate_Salary()
        {
            Console.WriteLine("Manager cacullate salary");
        }
    }
}
