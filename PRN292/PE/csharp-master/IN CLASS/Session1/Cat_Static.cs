using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Cat_Static
    {
        private static int SoMeo = -6;
        private string TenMeo;
        public Cat_Static(string T)
        {
            TenMeo = T;
            Console.WriteLine("WOAW!!!! {0} day!", TenMeo);
            SoMeo++;
        }
        public Cat_Static()
        {
            Console.WriteLine("Bat dau lam thit meo !!!!");
            SoMeo = 0;
        }
        public static void HowManyCats()
        {
            Console.WriteLine("Dang lam thit {0} con meo!", SoMeo);
        }
    }
}
