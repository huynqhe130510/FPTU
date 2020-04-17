using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentLibrary
{
    public class Student
    {
        string name;
        int marks;

        public Student(string name, int marks)
        {
            this.name = name;
            this.marks = marks;
        }

        public override string ToString()
        {
            return string.Format("Name = {0}, Marks = {1}", name, marks);
        }


    }
}
