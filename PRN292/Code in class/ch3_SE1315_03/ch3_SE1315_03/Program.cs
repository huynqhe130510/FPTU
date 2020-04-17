using System;

namespace ch3_SE1315_03
{
    class Program
    {
        static void add(int a, int b, ref int c)
        {
            c = a + b;
        }

        static void swap(ref int a, ref int b)
        {
            int temp;
            temp = a;
            a = b;
            b = temp;
        }

        static void Main(string[] args)
        {
            int a, b, c = 0;
            a = 10;
            b = 20;
            add(a, b, ref c);
            Console.WriteLine("{0} + {1} = {2}", a, b, c);
            swap(ref a, ref b);
            Console.WriteLine("After swaping a = {0}, b = {1}", a, b);
            Console.ReadLine();
        }
    }
}
