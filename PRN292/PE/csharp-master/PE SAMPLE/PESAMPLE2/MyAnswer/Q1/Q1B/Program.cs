using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Q1B
{
    class Person
    {
        protected string name;
        protected int age;

        public Person(string name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public string Display()
        {
            return "name: " + name + ", age: " + age;
        }


    }
    class Student : Person
    {
        public delegate void MarksHandler(string msg);
        public event MarksHandler LowMarks;


        double marks;

        public Student(string name, int age, double marks)
            : base(name, age)
        {
            this.marks = marks;
        }

        public string Display()
        {
            return "name: " + name + ", age: " + age +", marks: " + marks;
        }

        public void Check(double lowestMarks)
        {
            if (marks < lowestMarks)
                LowMarks(Display() +" is failed!");

        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Student[] ls = new Student[3];
            ls[0] = new Student("A", 20, 6.5);
            ls[1] = new Student("B", 19, 4);
            ls[2] = new Student("C", 20, 5);

            foreach (Student s in ls)
            {
                s.LowMarks += (s_LowMarks);
                s.Check(6);

            }
            Console.ReadKey();
        }

        static void s_LowMarks(string msg)
        {
            Console.WriteLine(msg);
        }
    }

}
