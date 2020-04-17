using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    class Category
    {
        int id;
        int name;

        public Category()
        {
        }

        public Category(int id, int name)
        {
            this.Id = id;
            this.Name = name;
        }

        public int Id { get => id; set => id = value; }
        public int Name { get => name; set => name = value; }
    }
}
