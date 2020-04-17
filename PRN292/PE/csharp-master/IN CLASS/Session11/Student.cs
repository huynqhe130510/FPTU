using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter21
{
    
    class Student
    {
        public string fullName;
        public int age;
        public string classNumber;

        public Student (string studentName, int studentAge, string studentClassNumber)
        {
            fullName = studentName;
            age = studentAge;
            classNumber = studentClassNumber;
        }
    }
   
}
