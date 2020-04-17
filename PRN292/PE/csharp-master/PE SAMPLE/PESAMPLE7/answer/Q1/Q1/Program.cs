using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Student s = new Student("SE12067");
                s.InputInfor();
                Console.WriteLine(s.ToString());
            }
            catch (IncorectNameFormatException e)
            {
                Console.WriteLine(e.Message);
            }
            Console.ReadLine();
        }
    }
}
