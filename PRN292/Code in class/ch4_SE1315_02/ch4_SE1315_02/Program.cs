using System;

namespace ch4_SE1315_02
{
    class People
    {
        string name;
        int age;

        public People(String name)
        {
            this.name = name;
        }

        public People(string name, int age) : this(name)
        {
            this.age = age;
        }

        virtual public string Display()
        {
            return "Name = " + name + "Age: " + age;
        }
    }

    class Student : People
    {
        int mark;

        public Student(string name, int age, int mark) : base(name, age)
        {
            this.mark = mark;
        }

        public override string Display()
        {
            return base.Display() + ",Mark = " + mark;
        }
    }

    class Gradurate : Student
    {
        int salary;

        public Gradurate(string name, int age, int marks, int salary):base(name, age, marks)
        {
            this.salary = salary;
        }

         new public string Display()
        {
            return base.Display() + ", Salary = " + salary;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            People[] p = new People[4];
            p[0] = new People("A", 35);
            p[1] = new Student("B", 20, 9);
            p[2] = new People("C", 40);
            p[3] = new Student("D", 19, 8);
            foreach (var pl in p)
                Console.WriteLine(pl.Display());
            Gradurate g = new Gradurate("G", 22, 8, 1000);
            Console.WriteLine(g.Display());
            Console.WriteLine(((Student)g).Display());
            Console.ReadLine();
        }
    }
}
