using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ch16_SE1315_01
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] driver = Directory.GetLogicalDrives();
            foreach (String s in driver)
            {
                Console.WriteLine("Driver " + s);
                try
                {
                    Directory.Delete(@"E:\3uTools");
                }
                catch (IOException e)
                {
                    Console.WriteLine(e.Message);
                }
                Console.ReadKey();
            }
        }
    }
}
