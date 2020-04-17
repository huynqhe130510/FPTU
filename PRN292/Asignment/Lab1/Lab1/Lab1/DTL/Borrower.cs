using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1
{
    class Borrower
    {
        string borrowNumber;
        string name;
        string sex;
        string address;
        string tel;
        string email;

        public Borrower()
        {
        }

        public Borrower(string borrowNumber, string name, string sex, string address, string tel, string email)
        {
            this.borrowNumber = borrowNumber;
            this.name = name;
            this.Sex = sex;
            this.Address = address;
            this.Tel = tel;
            this.Email = email;
        }

        public string BorrowNumber { get => borrowNumber; set => borrowNumber = value; }
        public string Name { get => name; set => name = value; }
        public string Sex { get => sex; set => sex = value; }
        public string Address { get => address; set => address = value; }
        public string Tel { get => tel; set => tel = value; }
        public string Email { get => email; set => email = value; }

        public static void addBorrower(List<Borrower> list, string borrowNumber, string name, string sex, string address, string tel, string email)
        {
            Borrower b = new Borrower();

            b.BorrowNumber = borrowNumber;
            b.Name = name;
            b.Sex = sex;
            b.Address = address;
            b.Tel = tel;
            b.Email = email;

            list.Add(b);
        }
    }
}
