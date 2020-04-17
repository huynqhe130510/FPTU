using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DTL
{
    class Reservation
    {
        int id;
        int borrowerNumber;
        int bookNumber;
        DateTime date;
        string status;

        public Reservation()
        {
        }

        public Reservation(int id, int borrowerNumber, int bookNumber, DateTime date, string status)
        {
            this.Id = id;
            this.BorrowerNumber = borrowerNumber;
            this.BookNumber = bookNumber;
            this.Date = date;
            this.Status = status;
        }

        public int Id { get => id; set => id = value; }
        public int BorrowerNumber { get => borrowerNumber; set => borrowerNumber = value; }
        public int BookNumber { get => bookNumber; set => bookNumber = value; }
        public DateTime Date { get => date; set => date = value; }
        public string Status { get => status; set => status = value; }
    }
}
