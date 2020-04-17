using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Chapter14
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Before start thread");

            Thread tid1 = new Thread(new ThreadStart(MyThread.Thread1));
            Thread tid2 = new Thread(new ThreadStart(MyThread.Thread2));

            tid1.Start();
            tid2.Start();

            Console.WriteLine("Before end thread");

            tid1.Abort();
            tid2.Abort();

            Console.WriteLine("end thread");

            Console.ReadLine();

            Console.WriteLine("Before start new thread");

            MyThread thr3 = new MyThread();
            MyThread thr4 = new MyThread();

            Thread tid3 = new Thread(new ThreadStart(thr3.Thread3));
            Thread tid4 = new Thread(new ThreadStart(thr4.Thread3));

            tid3.Name = "Thread 3";
            tid4.Name = "Thread 4";

            tid3.Priority = ThreadPriority.Highest;
            tid4.Priority = ThreadPriority.Lowest;

            try
            {
                Console.WriteLine("start new thread");
                tid3.Start();
                tid4.Start();
            }
            catch (ThreadStateException te)
            {
                Console.WriteLine(te.ToString());
            }

            tid3.Abort();
            tid4.Abort();

            Console.WriteLine("End of Main");
            Console.ReadLine();
        }
    }
}
