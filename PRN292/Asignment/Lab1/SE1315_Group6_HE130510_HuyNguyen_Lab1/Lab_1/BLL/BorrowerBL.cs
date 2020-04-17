using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1.BLL
{
    class BorrowerBL
    {
        public static void addBorrower(List<Borrowers> listBorrower, string borrowNumber, string name, string sex, string address, string tel, string email)
        {
            Borrowers b = new Borrowers();
            b.BorrowNumber = borrowNumber;
            b.Name = name;
            b.Sex = sex;
            b.Address = address;
            b.Tel = tel;
            b.Email = email;

            listBorrower.Add(b);
        }
    }
}
