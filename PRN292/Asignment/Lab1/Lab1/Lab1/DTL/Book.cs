using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1
{
    class Book
    {
        string bookNumber;
        string title;
        string author;
        string publisher;
        List<BookCopies> BookCopies;

        public Book()
        {
        }

        public string BookNumber { get => bookNumber; set => bookNumber = value; }
        public string Title { get => title; set => title = value; }
        public string Author { get => author; set => author = value; }
        public string Publisher { get => publisher; set => publisher = value; }
        public List<BookCopies> Books_Copies { get => BookCopies; set => BookCopies = value; }

        public static List<Book> addBook(List<Book> listbook, string bookNumber, string title, string author, string publisher)
        {
            Book b = new Book();
            b.BookNumber = bookNumber;
            b.Title = title;
            b.Author = author;
            b.Publisher = publisher;
            listbook.Add(b);
            return listbook;
        }
    }
}
