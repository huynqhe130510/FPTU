using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Q1
{
    abstract class My2DPoint
    {
        public double x { get; set; }
        public double y { get; set; }
        public My2DPoint()
        {

        }

        public My2DPoint(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public abstract double Distance(My2DPoint target);
    }
}
