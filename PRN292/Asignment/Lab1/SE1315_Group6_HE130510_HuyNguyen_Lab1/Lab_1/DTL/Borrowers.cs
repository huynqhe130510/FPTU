using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HE130510_HuyNguyen_Lab1
{
    class Borrowers
    {
        string borrowNumber;
        string name;
        string sex;
        string address;
        string tel;
        string email;

        public string BorrowNumber { get => borrowNumber; set => borrowNumber = value; }
        public string Name { get => name; set => name = value; }
        public string Sex { get => sex; set => sex = value; }
        public string Address { get => address; set => address = value; }
        public string Tel { get => tel; set => tel = value; }
        public string Email { get => email; set => email = value; }

        
    }
}
