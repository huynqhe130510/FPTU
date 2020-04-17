using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Person
    {
        public string fullName;
        public int age;
        /// <summary>
        /// 
        /// </summary>
        /// <param name="n"></param>
        /// <param name="a"></param>
        public Person(string n, int a)
        {
            fullName = n;
            age = a;
        }
        public Person() { }
        public void PrintInfo()
        {
            Console.WriteLine("{0} is {1} years old", fullName, age);
        }
    }
}
