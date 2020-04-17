using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DTL
{
    class Borrower
    {
        int borrowerNumber;
        string name;
        string sex;
        string address;
        string telephone;
        string email;

        public Borrower()
        {
        }

        public Borrower(int borrowerNumber, string name, string sex, string address, string telephone, string email)
        {
            this.BorrowerNumber = borrowerNumber;
            this.Name = name;
            this.Sex = sex;
            this.Address = address;
            this.Telephone = telephone;
            this.Email = email;
        }

        public int BorrowerNumber { get => borrowerNumber; set => borrowerNumber = value; }
        public string Name { get => name; set => name = value; }
        public string Sex { get => sex; set => sex = value; }
        public string Address { get => address; set => address = value; }
        public string Telephone { get => telephone; set => telephone = value; }
        public string Email { get => email; set => email = value; }
    }
}
