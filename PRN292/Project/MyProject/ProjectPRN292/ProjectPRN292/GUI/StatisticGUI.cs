using ProjectPRN292.DAL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class StatisticGUI : Form
    {
        public StatisticGUI()
        {
            InitializeComponent();
        }

        private void btnView_Click(object sender, EventArgs e)
        {
            string from = dateTimePicker1.Value.ToString();
            string to = dateTimePicker2.Value.ToString();
            DataTable dt = StatisticDAO.statistic(from, to);
            dt.Columns.Add("Total Cost");
            float totalCost = 0;
            float total = 0;
            int count = 0;
            foreach (DataRow dr in dt.Rows)
            {
                float price = float.Parse(dr["Price"].ToString());
                int quantity = int.Parse(dr["Quantity"].ToString());
                totalCost = price * quantity;
                total += totalCost;
                dr["Total Cost"] = totalCost;
                count++;
            }
            
            lblTotal.Text = total.ToString("c2").Remove(0,1) + " VND";
            DataView dv = new DataView(dt);
            dataGridView1.DataSource = dv;
        }
    }
}
