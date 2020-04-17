using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ch8_SE1315_01
{
    public delegate void Dop(int a, int b);
    class Program
    {
        static void add(int a, int b)
        {
            Console.WriteLine("{0} + {1} + {2}", a, b, a + b);
        }

        static void sub(int a, int b)
        {
            Console.WriteLine("{0} + {1} = {2}", a, b, a - b);
        }

        static void Main(string[] args)
        {
            int a, b;
            a = 10;
            b = 20;
            //add(a, b);

            //Tao object delegate tro toi ham add
            Dop od = new Dop(add);
            od += add;
            od += sub;

            od -= add;

            //goi cac ham duoc tro boi delegate od
            od(a, b);
            Console.ReadLine();
        }
    }
}
