using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace Project
{
    public class Product
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string Category { get; set; }
        public double Price { get; set; }
        public string Size { get; set; }
        public string Description { get; set; }
        public string Picture { get; set; }

        public Product()
        {

        }
        public Product(int id, string name, string category, double price, string size, string description, string picture )
        {
            ID = id;
            Name = name;
            Category = category;
            Price = price;
            Size = size;
            Description = description;
            Picture = picture;
        }

        public static List<Product> GetAllProduct()
        {
            List<Product> listPro = new List<Product>();
            DataTable dtable = DataAccess.getAllProducts();
            foreach (DataRow dr in dtable.Rows)
            {
                int pid = Convert.ToInt32(dr["ProductID"]);
                string name = dr["ProductName"].ToString();
                string cname = dr["CategoryName"].ToString();
                double price = Convert.ToDouble(dr["Price"]);
                string size = dr["Size"].ToString();
                string description = dr["Description"].ToString();
                string picture = dr["Picture"].ToString();
                listPro.Add(new Product(pid,name,cname,price,size,description,picture));
            }
            return listPro;
        }

        public static void deleteProduct(int pid)
        {
             DataAccess.deleteProduct(pid);
        }

        public static int updateProduct(int id, string name, int cateId, double price, string size, string description,string image)
        {
            int count = 0;
            count = DataAccess.editProduct(id, name, cateId, price, size, description,image);
            return count;
        }

        public static int addProduct( string name, int cateId, double price, string size, string description, string picture)
        {
            int count = 0;
            count = DataAccess.addProduct( name, cateId, price, size, description, picture);
            return count;
        }

        public static List<Product> getProductByCateID(string cName)
        {
            List<Product> listPro = new List<Product>();
            DataTable dbt = DataAccess.getProductsByCateName(cName);
            foreach (DataRow dr in dbt.Rows)
            {
                int pid = Convert.ToInt32(dr["ProductID"]);
                string name = dr["ProductName"].ToString();
                string cname = dr["CategoryName"].ToString();
                double uprice = Convert.ToDouble(dr["Price"]);
                string size = dr["Size"].ToString();
                string description = dr["Description"].ToString();
                string picture = dr["Picture"].ToString();
                listPro.Add(new Product(pid, name, cname, uprice,size,description,picture));
            }
            return listPro;
        }

        public static List<string> listCategory()
        {
            List<string> listName = new List<string>();
            listName.Add("All Category");
            DataTable dbt = DataAccess.getAllCateGory();
            foreach (DataRow dr in dbt.Rows)
            {
                string name = dr["CategoryName"].ToString();
                listName.Add(name);
            }
            return listName;
        }

        public static List<string> getAllCateGoryName()
        {
            List<string> listName = listCategory();
            listName.RemoveAt(0);
            return listName;
        }

    }
}
