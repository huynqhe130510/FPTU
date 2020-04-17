using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter11
{
    public class MiniVan : Car
    {
        public MiniVan() { }
        public MiniVan(string name, short max, short curr)
        : base(name, max, curr) { }
        public override void TurboBoost()
        {
            // Minivans have poor turbo capabilities!
            egnState = EngineState.engineDead;
            MessageBox.Show("Time to call AAA", "Your car is dead");
        }
    }
}
