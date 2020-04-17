using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ch7_SE1315_01
{
    interface IDisplay
    {
        void Display();
    }
    interface IDisplay3D
    {
        void Display();
    }
    class Student:IDisplay,IDisplay3D, IComparable
    {
        string name;
        int mark;

        public string Name { get => name; set => name = value; }

        public Student(string name, int mark)
        {
            this.Name = name;
            this.mark = mark;
        }
        public void Display()
        {
            Console.WriteLine(string.Format("Name = {0}, Mark = {1}", Name, mark));
        }
        void IDisplay.Display()
        {
            Console.WriteLine(string.Format("Name = {0}", Name));
        }
        void IDisplay3D.Display()
        {
            Console.WriteLine(string.Format("Mark = {0}", mark));
        }

        int IComparable.CompareTo(object obj)
        {
            Student o = (Student)obj;
            if (this.mark > o.mark) return 1;
            else if (this.mark < o.mark) return -1;
            else return 0;
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            Student s = new Student("A", 9);
            s.Display();
            if(s is IDisplay)
            {
                ((IDisplay)s).Display();
            }
            if(s is IDisplay3D)
            {
                ((IDisplay3D)s).Display();
            }

            Student[] sl = new Student[4];
            sl[0] = new Student("A", 9);
            sl[1] = new Student("D", 5);
            sl[2] = new Student("B", 4);
            sl[3] = new Student("C", 6);
            Console.WriteLine("List of students");
            foreach(Student o in sl)
            {
                o.Display();
            }

            Array.Sort(sl);
            Console.WriteLine("List of students ordered by marks");
            foreach (Student o in sl)
            {
                o.Display();
            }

            Array.Sort(sl, new sortByName());
            Console.WriteLine("List of students ordered by name");
            foreach (Student o in sl)
            {
                o.Display();
            }
            Console.ReadLine();
        }
    }
}
