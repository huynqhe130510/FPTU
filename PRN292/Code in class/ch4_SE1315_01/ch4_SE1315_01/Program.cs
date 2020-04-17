using System;

namespace ch4_SE1315_01
{
    class Student{
        private string name;
        int age;

        public string Name { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Student s = new Student();
            s.Name = Console.ReadLine();
            Console.WriteLine("Name = {0}", s.Name);
            Console.ReadLine();
        }
    }
}
