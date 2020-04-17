using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter4
{
    class Polymorphism_sample
    {
        public void print(int i)
        {
            Console.WriteLine("Print interger: {0}", i);
        }
        public void print(double f)
        {
            Console.WriteLine("Print floatc: {0}", f);
        }
        public void print(string s)
        {
            Console.WriteLine("Pint string: {0}", s);
        }
    }
}
