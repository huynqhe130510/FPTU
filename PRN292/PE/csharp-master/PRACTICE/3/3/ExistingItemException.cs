using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LAB1
{
    class ExistingItemException : SystemException
    {
        public ExistingItemException(string Info) : base("Auto /" + Info + "/ already has been existed")
        {

        }
    }
}
