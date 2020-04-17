using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1.BLL
{
    class BookCopiesBL
    {
        public static List<BookCopies> addBookCopies(List<BookCopies> listCopies, string copyNumber, string sequenceNumber, string type, float price, string bookNumber)
        {
            BookCopies bc = new BookCopies();
            bc.CopyNumber = copyNumber;
            bc.SequenceNumber = sequenceNumber;
            bc.Type = type;
            bc.Price = price;
            bc.BookNumber = bookNumber;
            listCopies.Add(bc);

            return listCopies;
        }
    }
}
