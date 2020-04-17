using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Person_Object
    {
        public Person_Object(string fname, string lname, string s, byte a)
        {
            firstName = fname;
            lastName = lname;
            SSN = s;
            age = a;
        }
        public Person_Object() { }
        // The state of a person.
        public string firstName;
        public string lastName;
        public string SSN;
        public byte age;
    }
}
