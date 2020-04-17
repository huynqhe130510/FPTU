using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    class Product
    {
        int id;
        string name;
        int categoryId;
        string size;
        float price;
        string image;

        public Product()
        {
        }

        public Product(int id, string name, int categoryId, string size, float price, string image)
        {
            this.Id = id;
            this.Name = name;
            this.CategoryId = categoryId;
            this.Size = size;
            this.Price = price;
            this.Image = image;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public int CategoryId { get => categoryId; set => categoryId = value; }
        public string Size { get => size; set => size = value; }
        public float Price { get => price; set => price = value; }
        public string Image { get => image; set => image = value; }
    }
}
