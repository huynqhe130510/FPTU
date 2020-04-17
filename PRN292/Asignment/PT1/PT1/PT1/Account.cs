using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PT1
{
    class Account
    {
        private int accNum;

        public int AccNum
        {
            get { return accNum; }
            set { accNum = value; }
        }
        private double amount;

        public double Amount
        {
            get { return amount; }
            set { amount = value; }
        }

        public Account() { }
        
        public Account(int accNum, double amount)
        {
            this.accNum = accNum;
            this.amount = amount;
        }

        public void Deposit(double amount)
        {
            this.amount += amount;
        }

        public void Withdraw(double amount)
        {
            if (this.amount < amount)
            {

                throw new Exception(string.Format("Your withdraw amount {0} is larger than banlance {1}. No withdraw was recorded", amount, this.amount));

            }
            this.amount -= amount;

        }

    }
}
