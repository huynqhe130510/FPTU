using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Lab2
{
    class Utility
    {
        public static string getString(string msg)
        {
            Console.WriteLine();
            Console.Write(msg);
            return Console.ReadLine();
        }

        public static double getDouble(string msg)
        {
            bool loop = false;
            double d = 0;
            do
            {
                Console.WriteLine();
                Console.Write(msg);
                string l = Console.ReadLine();
                try
                {
                    d = Double.Parse(l);
                    loop = false;
                }
                catch
                {
                    loop = true;
                }
            } while (loop);
            return d;
        }

        public static int getInt(string msg)
        {
            bool loop = false;
            int i = 0;
            do
            {
                Console.WriteLine();
                Console.Write(msg);
                string l = Console.ReadLine();
                try
                {
                    i = int.Parse(l);
                    loop = false;
                }
                catch
                {
                    loop = true;
                }
            } while (loop);
            return i;
        }

        public static char getSex(string msg)
        {
            bool loop = false;
            string l;
            do
            {
                Console.WriteLine();
                Console.Write(msg);
                l = Console.ReadLine();
                if (l.Length != 1) loop = true;
                else if (l[0] != 'F' && l[0] != 'f' && l[0] != 'M' && l[0] != 'm') loop = true;
                else loop = false;

            } while (loop);
            return l[0];

        }

        public static char getYesNo(string msg)
        {
            bool loop = false;
            string l;
            do
            {
                Console.WriteLine();
                Console.Write(msg);
                l = Console.ReadLine();
                if (l.Length != 1) loop = true;
                else if (l[0] != 'Y' && l[0] != 'y' && l[0] != 'N' && l[0] != 'n') loop = true;
                else loop = false;

            } while (loop);
            return l[0];

        }

    }
}
