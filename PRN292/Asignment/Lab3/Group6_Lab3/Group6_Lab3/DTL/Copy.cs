using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DTL
{
    class Copy
    {
        int copyNumber;
        int bookNumber;
        int sequenceNumber;
        string type;
        double price;

        public Copy()
        {
        }

        public Copy(int bookNumber, int copyNumber, int sequenceNumber, string type, double price)
        {
            this.CopyNumber = copyNumber;
            this.BookNumber = bookNumber;
            this.SequenceNumber = sequenceNumber;
            this.Type = type;
            this.Price = price;
        }

        public int CopyNumber { get => copyNumber; set => copyNumber = value; }
        public int BookNumber { get => bookNumber; set => bookNumber = value; }
        public int SequenceNumber { get => sequenceNumber; set => sequenceNumber = value; }
        public string Type { get => type; set => type = value; }
        public double Price { get => price; set => price = value; }
    }
}
