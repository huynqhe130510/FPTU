using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Entity
{
    public class User
    {
        public int id { get; set; }
        public string name { get; set; }
        public string avatar { get; set; }
        public bool gender { get; set; }
        public DateTime dob { get; set; }

        public override string ToString()
        {
            return name;
        }
    }
}
