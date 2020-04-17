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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            chart.Titles.Add("Income Chart");
            comboBoxReport.SelectedIndex = 0;

            dataGridView.AutoGenerateColumns = false;

            dataGridView.Columns.Add("Name", "Name");
            dataGridView.Columns["Name"].DataPropertyName = "Name";
            dataGridView.Columns["Name"].Width = 130;

            dataGridView.Columns.Add("OrderID", "OrderID");
            dataGridView.Columns["OrderID"].DataPropertyName = "OrderID";

            dataGridView.Columns.Add("OrderDate", "OrderDate");
            dataGridView.Columns["OrderDate"].DataPropertyName = "OrderDate";
            dataGridView.Columns["OrderDate"].Width = 130;


            dataGridView.Columns.Add("Total", "Total");
            dataGridView.Columns["Total"].DataPropertyName = "Total";


        }

        private void dateTimePickerFrom_ValueChanged(object sender, EventArgs e)
        {
            if (dateTimePickerFrom.Value > DateTime.Now)
                dateTimePickerFrom.Value = DateTime.Now;
            if (comboBoxReport.SelectedIndex == 0)
            {
                //  dateTimePickerTo.Value= new DateTime(dateTimePickerFrom.Value.Year, dateTimePickerFrom.Value.Month, dateTimePickerFrom.Value.Day); 
            }

        }



        private void ButtonView_Click(object sender, EventArgs e)
        {
            chart.Series["Income"].Points.Clear();
            dataGridView.DataSource = null;
            if (comboBoxReport.SelectedIndex == 0)
            {
                DataTable dt = DataAccess.getOrderFromDate(dateTimePickerFrom.Value, "D");
                if (dt.Rows.Count > 0)
                {
                    foreach (var series in chart.Series)
                    {
                        series.Points.Clear();
                    }
                    double[] totalChart = new double[25];
                    foreach (DataRow row in dt.Rows)
                    {
                        DateTime time = Convert.ToDateTime(row["OrderDate"]);
                        double total = Convert.ToDouble(row["Total"]);
                        totalChart[time.Hour] += total;
                    }
                    for (int i = 1; i <= 24; i++)
                    {
                        chart.Series["Income"].Points.AddXY(i, totalChart[i]);
                    }
                    dataGridView.DataSource = dt;
                }
                else
                {
                    MessageBox.Show("There is no order!");
                }
            }
            else if (comboBoxReport.SelectedIndex == 1)
            {
                DataTable dt = DataAccess.getOrderFromDate(dateTimePickerFrom.Value, "M");
                if (dt.Rows.Count > 0)
                {
                    double[] totalChart = new double[32];
                    foreach (DataRow row in dt.Rows)
                    {
                        DateTime time = Convert.ToDateTime(row["OrderDate"]);
                        double total = Convert.ToDouble(row["Total"]);
                        totalChart[time.Day] += total;
                    }
                    for (int i = 1; i <= 31; i++)
                    {
                        chart.Series["Income"].Points.AddXY(i, totalChart[i]);
                    }
                }
                else
                {
                    MessageBox.Show("There is no order!");
                }
                dataGridView.DataSource = dt;
            }
            else
            {
                DataTable dt = DataAccess.getOrderFromDate(dateTimePickerFrom.Value, "Y");
                if (dt.Rows.Count > 0)
                {
                    double[] totalChart = new double[31];
                    foreach (DataRow row in dt.Rows)
                    {
                        DateTime time = Convert.ToDateTime(row["OrderDate"]);
                        double total = Convert.ToDouble(row["Total"]);
                        totalChart[time.Month] += total;
                    }
                    for (int i = 1; i <= 12; i++)
                    {
                        chart.Series["Income"].Points.AddXY(i, totalChart[i]);
                    }
                }
                else
                {
                    MessageBox.Show("There is no order!");
                }
                dataGridView.DataSource = dt;
            }

        }

        private void comboBoxReport_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBoxReport.SelectedIndex == 0)
            {
                dateTimePickerFrom.Format = DateTimePickerFormat.Custom;
                dateTimePickerFrom.CustomFormat = "yyyy/MM/dd";

                dateTimePickerFrom.Value = new DateTime(DateTime.Now.Year, DateTime.Now.Month, DateTime.Now.Day, 0, 0, 0);

            }
            else if (comboBoxReport.SelectedIndex == 1)
            {
                dateTimePickerFrom.Format = DateTimePickerFormat.Custom;
                dateTimePickerFrom.CustomFormat = "MM / yyyy";
            }
            else
            {
                dateTimePickerFrom.Format = DateTimePickerFormat.Custom;
                dateTimePickerFrom.CustomFormat = "yyyy";

            }

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }


        private void dataGridView_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            DataTable dt = (DataTable)dataGridView.DataSource;
            int orderId = Convert.ToInt32(dt.Rows[e.RowIndex][1].ToString());
            formOrderDetail nf = new formOrderDetail(orderId);
            nf.Show();


        }

        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int n;
            string type = "Y";
            if (comboBoxReport.SelectedIndex == 0) type = "D";
            else if (comboBoxReport.SelectedIndex == 1) type = "M";
            DataTable dt = DataAccess.getOrderFromDate(dateTimePickerFrom.Value, type);
            string detailName = textBox1.Text.ToUpper();
            bool isNumeric = int.TryParse(detailName, out n);
            if (dt != null)
                if (dt.Rows.Count > 0)
                {
                    foreach (DataRow dr in dt.Rows)
                    {
                        if (isNumeric)
                        {
                            string OrderID = dr["OrderID"].ToString();
                            if (!OrderID.Contains(n.ToString())) dr.Delete();
                        }
                        else
                        {
                            string name = dr["Name"].ToString();
                            if (!name.Contains(detailName)) dr.Delete();
                        }
                    }
                   // dt.AcceptChanges();
                    dataGridView.DataSource = dt;
                }
        }

        private void panel3_Paint(object sender, PaintEventArgs e)
        {

        }

        private void panel3_Click(object sender, EventArgs e)
        {

            this.Close();
        }
    }
}
