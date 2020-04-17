using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1
{
    class Book
    {
        string bookNumber;
        string title;
        string author;
        string publisher;
        List<BookCopies> listCopies;

        public string BookNumber { get => bookNumber; set => bookNumber = value; }
        public string Title { get => title; set => title = value; }
        public string Publisher { get => publisher; set => publisher = value; }
        public string Author { get => author; set => author = value; }
        internal List<BookCopies> ListCopies { get => listCopies; set => listCopies = value; }

        
    }
}
