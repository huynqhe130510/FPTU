using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DTL
{
    class Book
    {
        int bookNumber;
        string title;
        string authors;
        string publisher;

        public Book(int bookNumber, string title, string authors, string publisher)
        {
            this.bookNumber = bookNumber;
            this.title = title;
            this.authors = authors;
            this.publisher = publisher;
        }

        public int BookNumber { get => bookNumber; set => bookNumber = value; }
        public string Title { get => title; set => title = value; }
        public string Authors { get => authors; set => authors = value; }
        public string Publisher { get => publisher; set => publisher = value; }
    }
}
