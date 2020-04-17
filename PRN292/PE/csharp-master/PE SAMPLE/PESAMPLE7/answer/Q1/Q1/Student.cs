using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class Student
    {
        private string code;
        private string name;

        public Student()
        {

        }

        public Student(string c)
        {
            this.Code = c;
        }

        public string Code
        {
            get
            {
                return code;
            }

            set
            {
                code = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        public void InputInfor()
        {
            Console.WriteLine("Input name for student, please. Student name must be less than 15 characters.");
            this.Name = Console.ReadLine();
            if(this.Name.Length > 15)
            {
                throw new IncorectNameFormatException();
            }
        }

        public override string ToString()
        {
            return "Student Information: Code: " + this.Code + " - Name: " + this.Name;
        }
    }
}
