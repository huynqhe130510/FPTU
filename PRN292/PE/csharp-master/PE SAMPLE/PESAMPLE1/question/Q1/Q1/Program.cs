using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Q1
{
    class Program
    {
        static void Main(string[] args)
        {
            Staff staff = new Staff("Pham Ngoc Hoa", new DateTime(1998, 03, 20));
            staff.Caculate_Salary();
            Manager manager = new Manager("Do Quang Hiep", new DateTime(1997, 03, 20), 22);
            manager.Caculate_Salary();
            Developer developer = new Developer("Trang Quang Nhat", new DateTime(1998, 02, 22), "javascript");
            developer.Caculate_Salary();
        }
    }
}
