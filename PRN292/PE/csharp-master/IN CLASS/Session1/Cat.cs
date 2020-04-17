using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Cat
    {
        private int SoMeo = -6;
        private string TenMeo;
        public Cat(string T)
        {
            TenMeo = T;
            Console.WriteLine("WOAW!!!! {0} day!", TenMeo);
            SoMeo++;
        }
        public Cat()
        {
            Console.WriteLine("Bat dau lam thit meo !!!!");
            SoMeo = 0;
        }
        public void HowManyCats()
        {
            Console.WriteLine("Dang lam thit {0} con meo!", SoMeo);
        }
    }
}
