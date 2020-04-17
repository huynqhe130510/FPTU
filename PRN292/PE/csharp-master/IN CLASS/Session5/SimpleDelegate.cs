﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter8
{
    class SimpleDelegate
    {
        Name[] names = new Name[5];

        public SimpleDelegate()
        {
            names[0] = new Name("Joe", "Mayo");
            names[1] = new Name("John", "Hancock");
            names[2] = new Name("Jane", "Doe");
            names[3] = new Name("John", "Doe");
            names[4] = new Name("Jack", "Smith");
        }
        // observe  the delegate parameter
        public void Sort(Comparer compare)
        {
            object temp;

            for (int i = 0; i < names.Length; i++)
            {
                for (int j = i; j < names.Length; j++)
                {
                    // using delegate "compare" just like
                    // a normal method
                    if (compare(names[i], names[j]) > 0)
                    {
                        temp = names[i];
                        names[i] = names[j];
                        names[j] = (Name)temp;
                    }
                }
            }
        }
        // print name
        public void PrintNames()
        {
            Console.WriteLine("Names: \n");

            foreach (Name name in names)
            {
                Console.WriteLine(name.ToString());
            }
        }
    }
}
