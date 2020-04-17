using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// this is the delegate declaration
public delegate int Comparer(object obj1, object obj2);

namespace Chapter8
{
    class Name
    {
        public string FirstName = null;
        public string LastName = null;

        public Name(string first, string last)
        {
            FirstName = first;
            LastName = last;
        }

        // this is the delegate method handler
        public static int CompareFirstNames(object name1, object name2)
        {
            string n1 = ((Name)name1).FirstName;
            string n2 = ((Name)name2).FirstName;
            
            if (String.Compare(n1, n2) > 0)
            {
                return 1;
            }
            else if (String.Compare(n1, n2) < 0)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        public override string ToString()
        {
            return FirstName + " " + LastName;
        }
    }
}
