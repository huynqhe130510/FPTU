using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace ch14_SE1315_01
{

    class Add
    {
        int a;
        int b;

        public int A { get => a; set => a = value; }
        public int B { get => b; set => b = value; }

        public Add(int a, int b)
        {
            this.A = a;
            this.B = b;
        }
    }
    class Utility
    {
        public void add(Object o)
        {
            Thread.Sleep(10000);
            Add a = (Add)o;
            Console.WriteLine(string.Format("{0} + {1} = {2}", a.A, a.B, a.A + a.B));
        }

        public void PrintNumber()
        {
            lock (this)
            {
                //Display name of Thread running PrintNumber()
                Console.WriteLine(string.Format("Thread {0} is running PrintNumber", Thread.CurrentThread.Name));
                for (int i = 0; i < 10; i++)
                {
                    Console.Write(i + ", ");
                    Thread.Sleep(2000);
                }
                Console.WriteLine();
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Thread.CurrentThread.Name = "Primary";

            Console.WriteLine(string.Format("Thread {0} is running Main()", Thread.CurrentThread.Name));
            Utility u = new Utility();
            //u.PrintNumber();

            //Thread t = new Thread(new ThreadStart(u.PrintNumber));
            //Thread t = new Thread(new ParameterizedThreadStart(u.add));
            //t.Name = "Secondary";
            //t.IsBackground = true;
            //t.Start(new Add(1, 2));

            Thread[] lt = new Thread[10];
            for (int i = 0; i < 10; i++)
            {
                lt[i] = new Thread(new ThreadStart(u.PrintNumber));
                lt[i].Name = (i + 1).ToString();
                lt[i].Start();
            }

            Console.WriteLine("End of Main()");
            Console.ReadKey();
        }

    }
}
