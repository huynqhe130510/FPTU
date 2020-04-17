using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PT1
{
    public partial class CreateAccount : Form
    {
        Account a;
        public CreateAccount()
        {
            InitializeComponent();
            textBox3.Visible = false;
            textBox4.Visible = false;
            label3.Visible = false;
            label4.Visible = false;
            button2.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int accNum;
            double amount;

            
            accNum = int.Parse(textBox1.Text);
            amount = double.Parse(textBox2.Text);

            a = new Account(accNum, amount);

            lbl1.Text = "Account number: " + a.AccNum + ", Current balance : " + a.Amount;

            textBox1.Visible = false;
            textBox2.Visible = false;
            label1.Visible = false;
            label2.Visible = false;
            button1.Visible = false;

            textBox3.Visible = true;
            textBox4.Visible = true;
            label3.Visible = true;
            label4.Visible = true;
            button2.Visible = true;


        }

        private void button2_Click(object sender, EventArgs e)
        {
            double d_amt, w_amt;

            d_amt = double.Parse(textBox3.Text);
            w_amt = double.Parse(textBox4.Text);

            
            lbl1.Text = "Account number: " + a.AccNum + ", Current balance : " + a.Amount;
            lbl.Text = testAcount(d_amt, w_amt);
        }


        private string testAcount(double d_amt, double w_amt)
        {
            string msg;
            a.Deposit(d_amt);

            msg = "Transaction Succesful";
            try
            {
                a.Withdraw(w_amt);
            }
            catch (Exception ex)
            {
                msg = ex.Message;
            }

            return msg;
        }

    }
}
