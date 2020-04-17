using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class IncorectNameFormatException: Exception
    {
        public override string Message
        {
            get
            {
                return "Your input string is incorrect format.";
            }
        }
    }
}
