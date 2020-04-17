using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q12
{
    class MyDistance : AbstractDistance, ISeason
    {
        public override double GetDistance(Point p1, Point p2)
        {
            return Math.Sqrt(Math.Pow(p2.X - p1.X, 2) + (p2.Y - p1.Y));
        }

        public void say()
        {
            throw new NotImplementedException();
        }
    }
}
