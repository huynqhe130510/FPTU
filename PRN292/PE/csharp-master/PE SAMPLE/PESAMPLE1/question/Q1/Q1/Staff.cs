using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Q1
{
    class Staff
    {
        public String Name { get; set; }
        public DateTime Date_Of_Birth { get; set; }

        public Staff()
        {

        }

        public Staff(String Name, DateTime Date_Of_Birth)
        {
            this.Name = Name;
            this.Date_Of_Birth = Date_Of_Birth;
        }

        public virtual void Caculate_Salary()
        {
            Console.WriteLine("Staff cacullate salary");
        }
    }
}
