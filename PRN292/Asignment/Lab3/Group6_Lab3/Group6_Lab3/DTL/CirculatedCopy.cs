using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DTL
{
    class CirculatedCopy
    {
        int id;
        int copyNumber;
        int borrowerNumber;
        string borrowedDate;
        string dueDate;
        DateTime returnedDate;
        double fineAmount;

        public CirculatedCopy()
        {

        }

        public CirculatedCopy(int copyNumber, int borrowerNumber, string borrowedDate, string dueDate)
        {
            this.CopyNumber = copyNumber;
            this.BorrowerNumber = borrowerNumber;
            this.BorrowedDate = borrowedDate;
            this.DueDate = dueDate;
        }

        public int CopyNumber { get => copyNumber; set => copyNumber = value; }
        public int BorrowerNumber { get => borrowerNumber; set => borrowerNumber = value; }
        public string BorrowedDate { get => borrowedDate; set => borrowedDate = value; }
        public string DueDate { get => dueDate; set => dueDate = value; }
        public DateTime ReturnedDate { get => returnedDate; set => returnedDate = value; }
        public double FineAmount { get => fineAmount; set => fineAmount = value; }
        public int Id { get => id; set => id = value; }
    }
}
