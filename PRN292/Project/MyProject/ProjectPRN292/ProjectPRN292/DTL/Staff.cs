using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    class Staff
    {
        int id;
        string name;
        string gender;
        DateTime dob;
        string address;
        string phoneNumber;
        DateTime dateOJoin;
        float salary;
        string image;

        public Staff()
        {

        }

        public Staff(int id, string name, string gender, DateTime dob, string address, string phoneNumber, DateTime dateOJoin, float salary, string image)
        {
            this.Id = id;
            this.Name = name;
            this.Gender = gender;
            this.Dob = dob;
            this.Address = address;
            this.PhoneNumber = phoneNumber;
            this.dateOJoin = dateOJoin;
            this.Salary = salary;
            this.Image = image;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Gender { get => gender; set => gender = value; }
        public DateTime Dob { get => dob; set => dob = value; }
        public string Address { get => address; set => address = value; }
        public string PhoneNumber { get => phoneNumber; set => phoneNumber = value; }
        public DateTime DateOJoin { get => dateOJoin; set => dateOJoin = value; }
        public float Salary { get => salary; set => salary = value; }
        public string Image { get => image; set => image = value; }
    }
}
