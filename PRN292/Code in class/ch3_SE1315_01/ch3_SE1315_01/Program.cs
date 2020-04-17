using System;

namespace ch3_SE1315_01
{
    class Program
    {
        static int Main(string[] args)
        {
            for (int i = 0; i < args.Length; i++)
            {
                Console.WriteLine("Argument #{0}: {1}", i + 1, args[i]);
            }

            // OS running this app?
            Console.WriteLine("Current OS: {0} ", Environment.OSVersion);
            // Directory containing this app?
            Console.WriteLine("Current Directory: {0} ",
            Environment.CurrentDirectory);
            // List the drives on this machine.
            string[] drives = Environment.GetLogicalDrives();
            for (int i = 0; i < drives.Length; i++)
                Console.WriteLine("Drive {0} : {1} ", i, drives[i]);
            // Which version of the .NET platform is running this app?
            Console.WriteLine("Executing version of .NET: {0} ",
            Environment.Version);
            Console.WriteLine("Hello SE1315");
            Console.ReadLine();
            return 0;
        }
    }
}
