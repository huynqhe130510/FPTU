using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q2
{
    class MyClient
    {
        public MyServer server { get; set; }
        public string message { get; set; }
        public MyClient()
        {

        }

        public MyClient(MyServer server)
        {
            this.server = server;
        }

        public void ExecuteCommand(string command)
        {
            this.message = command;
        }
        public void RaiseInvalidCommand(string command)
        {
            if (this.message.Contains("-truncate"))
            {
                Console.WriteLine("No event Raised");
            }
            else
            {
                Console.WriteLine("Event raised");
            }
        }
    }
}
