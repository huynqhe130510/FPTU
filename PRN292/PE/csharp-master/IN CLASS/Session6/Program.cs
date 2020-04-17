using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Chapter10
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Vi du minh hoa Generic trong C#");
            Console.WriteLine("-------------------------------------");

            //khai bao mot mang cac so nguyen
            GenericSample<int> intArray = new GenericSample<int>(5);
            //thiet lap cac gia tri
            for (int c = 0; c < 5; c++)
            {
                intArray.setItem(c, c * 5);
            }

            //lay va hien thi cac gia tri
            for (int c = 0; c < 5; c++)
            {
                Console.Write(intArray.getItem(c) + " ");
            }

            Console.WriteLine();

            //khai bao mot mang ky tu
            GenericSample<char> charArray = new GenericSample<char>(5);

            //thiet lap gia tri
            for (int c = 0; c < 5; c++)
            {
                charArray.setItem(c, (char)(c + 97));
            }
            
            //lay va hien thi cac gia tri
            for (int c = 0; c < 5; c++)
            {
                Console.Write(charArray.getItem(c) + " ");
            }
            Console.WriteLine();

            Console.ReadKey();

        }
    }
}
