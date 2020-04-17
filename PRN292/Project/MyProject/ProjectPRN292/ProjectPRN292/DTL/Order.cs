using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    class Order
    {
        int id;
        int staffId;
        DateTime date;

        public Order()
        {
        }

        public Order(int id, int staffId, DateTime date)
        {
            this.Id = id;
            this.StaffId = staffId;
            this.Date = date;
        }

        public int Id { get => id; set => id = value; }
        public int StaffId { get => staffId; set => staffId = value; }
        public DateTime Date { get => date; set => date = value; }
    }
}
