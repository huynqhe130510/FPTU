using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q2
{
    class MyServer
    {
        public string name { get; set; }
        public delegate void NotifyDelegate(string message);
        public event NotifyDelegate MaliciousAlarm;

        public MyServer()
        {

        }

        public MyServer(string name)
        {
            this.name = name;
        }


    }
}
