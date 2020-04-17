using System;

namespace ch3_SE1315_02
{
    class Program
    {
        class Student
        {
            protected String name;
            int age;

            public void display()
            {
                int i = 0;
                Console.WriteLine("Name = {0}", i);
            }
        }

        class Gradurate : Student
        {
            int Salary;
            public Gradurate()
            {
                Salary = 100;
            }
        }
        static void Main(string[] args)
        {
            Student s = new Student();
            s.display();
        }
    }
}
