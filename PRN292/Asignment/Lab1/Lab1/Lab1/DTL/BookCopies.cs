using System.Collections.Generic;

namespace Lab1
{
    class BookCopies
    {
        string copyNumber;
        string sequenceNumber;
        string type;
        float price;
        string bookNumber;

        public string CopieNumber { get => copyNumber; set => copyNumber = value; }
        public string SequenceNumber { get => sequenceNumber; set => sequenceNumber = value; }
        public string Type { get => type; set => type = value; }
        public float Price { get => price; set => price = value; }
        public string BookNumber { get => bookNumber; set => bookNumber = value; }

        public static List<BookCopies> addCopy(List<BookCopies> listCopies, string copyNumber, string sequenceNumber, string type, float price, string bookNumber)
        {
            BookCopies bc = new BookCopies();
            bc.CopieNumber = copyNumber;
            bc.SequenceNumber = sequenceNumber;
            bc.Type = type;
            bc.Price = price;
            bc.BookNumber = bookNumber;
            listCopies.Add(bc);
            return listCopies;
        }


    }
}
