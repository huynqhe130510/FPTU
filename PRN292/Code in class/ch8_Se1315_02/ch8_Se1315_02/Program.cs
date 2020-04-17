using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ch8_Se1315_02
{
    class Student
    {
        public delegate void LowMarkHandle(string msg);
        public event LowMarkHandle lowMark;

        string name;
        int mark;

        public Student(string name, int mark)
        {
            this.name = name;
            this.mark = mark;
        }

        public void CheckMark()
        {
            if (mark < 5)
            {
                lowMark(string.Format("Student: name = {0}, mark = {1}", name, mark));
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Student[] ls = new Student[4];
            ls[0] = new Student("A", 9);
            ls[1] = new Student("B", 5);
            ls[2] = new Student("C", 4);
            ls[3] = new Student("D", 7);
            int no = 0;
            foreach (Student s in ls)
            {
                //s.lowMark += new Student.LowMarkHandle(S_LowMark);
                s.lowMark += delegate (string msg)
                {
                    no++;
                    Console.WriteLine(no);
                    Console.WriteLine("Message from Student:" + msg);
                };
                s.CheckMark();
            }
            Console.ReadLine();
        }

        /*static void S_LowMark(string msg)
        {
            Console.WriteLine("Message from Student:" + msg);
        }*/
    }
}
