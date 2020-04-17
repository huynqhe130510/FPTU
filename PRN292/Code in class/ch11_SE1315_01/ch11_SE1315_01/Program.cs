using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StudentLibrary;

namespace ch11_SE1315_01
{
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student("Nguyen Quang Huy", 9);
            Console.WriteLine(student.ToString());
            Console.ReadLine();
        }
    }
}
