using System;

namespace ch10_SE1315_01
{
    class Program
    {
        static void swap<T>(ref T a, ref T b)
        {
            T temp;
            temp = a;
            a = b;
            b = temp;
        }
        static void Main(string[] args)
        {
            int a, b;
            a = 10;
            b = 20;
            swap<int>(ref a, ref b);
            Console.WriteLine("After swaping a = {0}, b = {1}", a, b);

            string s1 = "hello";
            string s2 = "world";
            swap<string>(ref s1, ref s2);
            Console.WriteLine("After swaping s1 = {0}, s2 = {1}", s1, s2);

            Console.ReadLine();
        }
    }
}
