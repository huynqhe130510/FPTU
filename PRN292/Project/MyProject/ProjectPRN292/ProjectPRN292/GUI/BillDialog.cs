using ProjectPRN292.DTL;
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
    public partial class BillDialog : Form
    {
        int orderId;
        List<OrderDetail> orderDetails;
        string staffName;
        float total;
        public BillDialog()
        {
            InitializeComponent();
        }

        public BillDialog(int orderId, List<OrderDetail> orderDetails, string staffName, float total)
        {
            InitializeComponent();
            this.orderId = orderId;
            this.orderDetails = orderDetails;
            this.staffName = staffName;
            this.total = total;
            loadData();
        }

        public void loadData()
        {
            lblOrderId.Text = orderId.ToString();
            lblStaffName.Text = staffName;
            lblTime.Text = DateTime.Now.ToString();
            lblTotal.Text = total.ToString("c2").Remove(0, 1) + " VND";
            dataGridView1.DataSource = orderDetails;
            dataGridView1.Columns[0].Visible = false;
            dataGridView1.Columns[1].Visible = false;
            dataGridView1.Columns[2].Visible = false;
            dataGridView1.Columns[4].Width = 35;
            dataGridView1.Columns[5].Width = 50;
            dataGridView1.Columns[6].Width = 40;
            dataGridView1.Columns[7].Width = 55;
            dataGridView1.AdvancedCellBorderStyle.All = DataGridViewAdvancedCellBorderStyle.None;
        }

        private void label8_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
