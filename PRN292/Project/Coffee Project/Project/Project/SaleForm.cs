using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project
{
    public partial class SaleForm : Form
    {
        int curEmployee;
        List<ProductInOrder> prosInOr;
        public SaleForm()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;

        }
        public SaleForm(int curEmployee)
        {
            InitializeComponent();
            prosInOr = new List<ProductInOrder>();
            this.curEmployee = curEmployee;
            WindowState = FormWindowState.Maximized;

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timeShow.Start();
            Employee emp = Employee.getEmployeeByID(curEmployee);
            if (emp.Role.Equals("STAFF")) btnBack.Visible = false;
            lbEmpName.Text = emp.Name;

            //Initialize data for categories and products
            DataTable dt = DataAccess.getAllCategories();
            int count = 0;
            foreach (DataRow dr in dt.Rows)
            {
                Button x = new Button();
                x.Font = new Font("Microsoft Sans Serif", 12f);
                x.Text = dr["CategoryName"].ToString();
                x.Size = new Size(160, 90);
                x.Top = count * 100 + 5;
                x.Visible = true;
                x.BackColor = Color.Honeydew;
                panelCate.Controls.Add(x);
                count++;
                x.Click += categoryChange;
            }
            loadProductOfCate(dt.Rows[0]["CategoryName"].ToString());
            //Add column for gridviews
            dgvOrders.AutoGenerateColumns = false;
            dgvOrders.Columns.Add("pid", "ID");
            dgvOrders.Columns["pid"].Width = 40;
            dgvOrders.Columns["pid"].DataPropertyName = "ProductID";
            dgvOrders.Columns["pid"].Visible = false;

            dgvOrders.Columns.Add("pName", "Name");
            dgvOrders.Columns["pName"].Width = 150;
            dgvOrders.Columns["pName"].DataPropertyName = "ProductName";

            dgvOrders.Columns.Add("pSize", "Size");
            dgvOrders.Columns["pSize"].Width = 40;
            dgvOrders.Columns["pSize"].DataPropertyName = "Size";

            dgvOrders.Columns.Add("price", "Price");
            dgvOrders.Columns["price"].Width = 70;
            dgvOrders.Columns["price"].DataPropertyName = "Price";

            dgvOrders.Columns.Add("pQuant", "Quantity");
            dgvOrders.Columns["pQuant"].Width = 70;
            dgvOrders.Columns["pQuant"].DataPropertyName = "Quantity";

            DataGridViewButtonColumn addCol = new DataGridViewButtonColumn();
            addCol.Name = " ";
            addCol.Text = "+";
            addCol.Width = 29;
            addCol.DefaultCellStyle.BackColor = Color.Green;
            addCol.UseColumnTextForButtonValue = true;
            dgvOrders.Columns.Add(addCol);

            DataGridViewButtonColumn subCol = new DataGridViewButtonColumn();
            subCol.Name = " ";
            subCol.Text = "-";
            subCol.Width = 29;
            subCol.DefaultCellStyle.BackColor = Color.Yellow;
            subCol.UseColumnTextForButtonValue = true;
            dgvOrders.Columns.Add(subCol);

            dgvOrders.Columns.Add("cost", "Cost");
            dgvOrders.Columns["cost"].DataPropertyName = "Cost";

            DataGridViewButtonColumn delCol = new DataGridViewButtonColumn();
            delCol.Name = " ";
            delCol.Text = "X";
            delCol.Width = 30;
            delCol.DefaultCellStyle.BackColor = Color.Red;
            delCol.UseColumnTextForButtonValue = true;
            dgvOrders.Columns.Add(delCol);
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Login lg = new Login();
            lg.Show();
            this.Close();
            this.Dispose();
        }
        public void loadProductOfCate(string cateName)
        {
            lvPro.Items.Clear();
            DataTable dt = DataAccess.getAllProductByCateName(cateName);
            ImageList imgs = new ImageList();
            imgs.ImageSize = new Size(100, 100);
            lvPro.TileSize = new Size(230, 130);
            foreach (DataRow dr in dt.Rows)
            {
                string pic = dr["Picture"].ToString();
                try
                {
                    imgs.Images.Add(Image.FromFile(pic));
                }
                catch (Exception ex)
                {
                    imgs.Images.Add(Image.FromFile("Product_Picture/default.jpg"));
                }


            }
            lvPro.LargeImageList = imgs;
            int count = 0;
            foreach (DataRow dr in dt.Rows)
            {
                lvPro.Items.Add(dr["ProductName"].ToString(), count);
                string[] price = dr["Price"].ToString().Split('.');
                lvPro.Items[count].SubItems.Add("Price: " + price[0]);
                lvPro.Items[count].SubItems.Add("Size: " + dr["Size"].ToString());
                lvPro.Items[count].SubItems.Add(dr["ProductID"].ToString());
                lvPro.Items[count].SubItems.Add(price[0]);
                lvPro.Items[count].SubItems.Add(dr["Size"].ToString());
                count++;
            }
        }
        public void categoryChange(object sender, EventArgs e)
        {
            Button x = (Button)sender;
            loadProductOfCate(x.Text.Trim());
        }

        private void lvPro_MouseClick(object sender, MouseEventArgs e)
        {
            string idStr = lvPro.SelectedItems[0].SubItems[3].Text;
            int id = Convert.ToInt32(idStr);
            string priceStr = lvPro.SelectedItems[0].SubItems[4].Text;
            double price = Convert.ToDouble(priceStr);
            string size = lvPro.SelectedItems[0].SubItems[5].Text;
            string name = lvPro.SelectedItems[0].SubItems[0].Text;
            addNewProToList(new ProductInOrder(id, name, price, size, 1));
            dgvOrders.DataSource = null;
            dgvOrders.DataSource = prosInOr;
        }
        public void addNewProToList(ProductInOrder pIO)
        {
            bool duplicate = false;
            foreach (ProductInOrder p in prosInOr)
            {
                if (p.ProductID == pIO.ProductID)
                {
                    p.Quantity++;
                    p.Cost = p.Quantity * p.Price;
                    duplicate = true;
                }
            }
            if (!duplicate) prosInOr.Add(pIO);
            calculateCost();
        }
        public void calculateCost()
        {
            double sum = 0;
            foreach (ProductInOrder p in prosInOr)
            {
                sum += p.Cost;
            }
            string sumStr = sum.ToString();
            string disSum = "";
            int i;
            for (i = sumStr.Length - 1; i > 2; i = i - 3)
            {
                if (i == sumStr.Length - 1)
                {
                    disSum += sumStr.Substring(i - 2, 3);
                }
                else
                {
                    disSum = sumStr.Substring(i - 2, 3) + "." + disSum;
                }

            }
            disSum = sumStr.Substring(0, i + 1) + "." + disSum;
            lbTotal.Text = disSum + " VNĐ";
        }

        private void dgvOrders_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 8)
            {
                prosInOr.RemoveAt(e.RowIndex);
                calculateCost();
                dgvOrders.DataSource = null;
                dgvOrders.DataSource = prosInOr;
            }
            if (e.ColumnIndex == 6)
            {
                if (prosInOr[e.RowIndex].Quantity > 0)
                {
                    prosInOr[e.RowIndex].Quantity--;
                    prosInOr[e.RowIndex].Cost = prosInOr[e.RowIndex].Quantity * prosInOr[e.RowIndex].Price;
                    if (prosInOr[e.RowIndex].Quantity == 0) prosInOr.RemoveAt(e.RowIndex);
                }
                calculateCost();
                dgvOrders.DataSource = null;
                dgvOrders.DataSource = prosInOr;
            }
            if (e.ColumnIndex == 5)
            {
                prosInOr[e.RowIndex].Quantity++;
                prosInOr[e.RowIndex].Cost = prosInOr[e.RowIndex].Quantity * prosInOr[e.RowIndex].Price;
                calculateCost();
                dgvOrders.DataSource = null;
                dgvOrders.DataSource = prosInOr;
            }
        }

        private void btnChout_Click(object sender, EventArgs e)
        {
            DateTime today = DateTime.Now;
            DataAccess.addNewOrder(curEmployee, today);
            int addedOId = DataAccess.getMaxOrderId();
            foreach (ProductInOrder p in prosInOr)
            {
                DataAccess.addNewOrderDetail(addedOId, p.ProductID, p.Quantity);
            }
            if (prosInOr.Count <= 0)
            {
                MessageBox.Show("There is no order. You cannot checkout!");
            }
            else
            {
                prosInOr.RemoveRange(0, prosInOr.Count);
                dgvOrders.DataSource = null;
                dgvOrders.DataSource = prosInOr;

                formOrderDetail fOd = new formOrderDetail(addedOId);
                fOd.Show();
            }

        }

        private void btnOut_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void timeShow_Tick(object sender, EventArgs e)
        {
            lbTime.Text = DateTime.Now.ToLongTimeString();
            lbDate.Text = DateTime.Now.ToLongDateString();
        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            ManagerDisplay md = new ManagerDisplay(curEmployee);
            md.Show();
            this.Close();
        }

        private void btnViewInfo_Click(object sender, EventArgs e)
        {
            Profile prf = new Profile(curEmployee);
            prf.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Employee emp = Employee.getEmployeeByID(curEmployee);
            if (emp.Role.Equals("MANAGER"))
            {
                ListPro lp = new ListPro();
                lp.Show();
            }else
            {

            }
        }

        private void lbEmpName_Click(object sender, EventArgs e)
        {

        }

        private void dgvOrders_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void panelCate_Paint(object sender, PaintEventArgs e)
        {

        }

        private void lbDate_Click(object sender, EventArgs e)
        {

        }

        private void lbTime_Click(object sender, EventArgs e)
        {

        }

        private void lvPro_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void lbTotal_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}
