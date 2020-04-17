using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Tire
    {
        public readonly static Tire GoodStone = new Tire(90);
        public readonly static Tire FireYear = new Tire(1000);
        public int manufactureID;
        public Tire() { }
        public Tire(int ID)
        { manufactureID = ID; }
    }
}
