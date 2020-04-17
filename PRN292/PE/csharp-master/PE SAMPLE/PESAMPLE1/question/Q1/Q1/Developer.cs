using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Q1
{
    class Developer : Staff
    {
        public String code { get; set; }

        public Developer()
        {

        }

        public Developer(String Name, DateTime Date_Of_Birth, String code) : base(Name,Date_Of_Birth)
        {
            this.Name = Name;
            this.Date_Of_Birth = Date_Of_Birth;
            this.code = code;
        }

        public override void Caculate_Salary()
        {
            Console.WriteLine("Developer cacullate salary");
        }
    }
}
