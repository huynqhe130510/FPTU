using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q2
{
    class Program
    {
        static void Main(string[] args)
        {
            MyServer server = new MyServer();
            MyClient client = new MyClient(server);
            server.MaliciousAlarm += client.RaiseInvalidCommand;
            client.ExecuteCommand("Nothig happends");
            client.ExecuteCommand("-truncate Something happend");
            Console.ReadKey();
        }
    }
}
