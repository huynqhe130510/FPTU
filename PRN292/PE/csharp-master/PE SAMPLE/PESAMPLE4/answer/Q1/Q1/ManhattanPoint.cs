using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    class ManhattanPoint : My2DPoint
    {
        public override double Distance(My2DPoint target)
        {
            return Math.Abs(target.x - this.x) + Math.Abs(target.y - this.y);
        }
    }
}
