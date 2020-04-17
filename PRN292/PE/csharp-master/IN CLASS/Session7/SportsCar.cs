using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter11
{
    public class SportsCar : Car
    {
        public SportsCar() { }
        public SportsCar(string name, short max, short curr)
        : base(name, max, curr) { }
        public override void TurboBoost()
        {
            MessageBox.Show("Ramming speed!", "Faster is better...");
        }
    }
}
