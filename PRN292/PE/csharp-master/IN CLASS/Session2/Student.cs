using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter4
{
    // Encapsulation with properties (tính đóng gói)
    class Student
    {
        private int empID;
        private float currPay;
        private string fullName;
        // Property for empID.
        public int ID
        {
            get { return empID; }
            set
            {
                // You are still free to investigate (and possibly transform)
                // the incoming value before making an assignment.
                empID = value;
            }
        }
        // Property for fullName.
        public string Name
        {
            get { return fullName; }
            set { fullName = value; }
        }
        // Property for currPay.
        public float Pay
        {
            get { return currPay; }
            set { currPay = value; }
        }
        public float ScholarShip()
        {
            return currPay * 100;
        }
    }


}
