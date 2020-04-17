using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter21
{
    public partial class BuyNewCarcs : Form
    {
        public BuyNewCarcs()
        {
            InitializeComponent();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void btnOrder_Click(object sender, EventArgs e)
        {
            // Build a string to display information.
            string orderInfo = "";
            if (checkFloorMats.Checked) { 
                orderInfo += "You want floor mats.\n";
            }
            if (radioRed.Checked) { 
                orderInfo += "You want a red exterior.\n";
            }
            if (radioYellow.Checked) { 
                orderInfo += "You want a yellow exterior.\n";
            }
            if (radioGreen.Checked) { 
                orderInfo += "You want a green exterior.\n";
            }
            if (radioPink.Checked)
            {
                orderInfo += "Why do you want a PINK exterior?\n";
            }

            listOrderStatus.Items.Add(orderInfo);

            // For each item in the CheckedListBox:
            for (int i = 0; i < checkedBoxRadioOptions.Items.Count; i++)
            {
                // Is the current item checked?
                if (checkedBoxRadioOptions.GetItemChecked(i))
                {
                    orderInfo = "";
                    // Get text of checked item and append to orderinfo string.
                    orderInfo += "Radio Item: ";
                    orderInfo += checkedBoxRadioOptions.Items[i].ToString();
                    orderInfo += "\n";
                    listOrderStatus.Items.Add(orderInfo);
                }
            }

            // Send this string to the Label.
            infoLabel.Text = orderInfo;

            

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
