using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ch7_SE1315_01
{
    class sortByName: IComparer
    {
        int IComparer.Compare(object x, object y)
        {
            Student s1 = (Student)x;
            Student s2 = (Student)y;
            return (string.Compare(s1.Name, s2.Name));
        }
    }
}
