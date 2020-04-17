using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1
{
    class BookCopies
    {
        string copyNumber;
        string sequenceNumber;
        string type;
        float price;
        string bookNumber;

        public string CopyNumber { get => copyNumber; set => copyNumber = value; }
        public string SequenceNumber { get => sequenceNumber; set => sequenceNumber = value; }
        public string Type { get => type; set => type = value; }
        public float Price { get => price; set => price = value; }
        public string BookNumber { get => bookNumber; set => bookNumber = value; }

        
    }
}
