using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LAB1
{
    class Comparers
    {
    }
    class IDComparer : IComparer<Auto>
    {
        public int Compare(Auto e1, Auto e2)
        {
            return e1.id.CompareTo(e2.id);
        }
    }
    class BasePriceComparer : IComparer<Auto>
    {
        public int Compare(Auto e1, Auto e2)
        {
            return e1.basePrice.CompareTo(e2.basePrice);
        }
    }
    class GetPriceComparer : IComparer<Auto>
    {
        public int Compare(Auto e1, Auto e2)
        {
            return e1.getPrice().CompareTo(e2.getPrice());
        }
    }
}
