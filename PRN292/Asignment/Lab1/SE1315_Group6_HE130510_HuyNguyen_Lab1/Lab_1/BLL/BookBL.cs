using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1.BLL
{
    class BookBL
    {
        public static List<Book> addBook(List<Book> listBook, string bookNumber, string title, string author, string publisher)
        {
            Book b = new Book();
            b.BookNumber = bookNumber;
            b.Title = title;
            b.Author = author;
            b.Publisher = publisher;

            listBook.Add(b);

            return listBook;
        }
    }
}
