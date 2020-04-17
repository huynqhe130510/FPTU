using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Chapter14
{
    public class MyThread
    {
        public static void Thread1()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Thread1 {0}", i);
            }
        }

        public static void Thread2()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Thread2 {0}", i);
            }
        }
        public void Thread3()
        {
            for (int i = 0; i < 10; i++)
            {

                Thread thr = Thread.CurrentThread;
                Console.WriteLine(thr.Name + "=" + i);
                Thread.Sleep(1);
            }
        }
    }
}
