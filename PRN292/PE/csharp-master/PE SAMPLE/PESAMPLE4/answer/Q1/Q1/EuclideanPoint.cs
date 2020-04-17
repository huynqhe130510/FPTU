using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class EuclideanPoint : My2DPoint
    {
        public override double Distance(My2DPoint target)
        {
            return Math.Sqrt(Math.Pow((target.x - this.x), 2) + (Math.Pow((target.y - this.y), 2)));
        }
    }
}
