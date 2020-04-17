using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProjectPRN292.DAL;
using ProjectPRN292.DTL;

namespace ProjectPRN292.DAL
{
    class ProductDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public static DataTable getAllProductByCateName(string name)
        {
            string sql;
            if (name == "Category")
            {
                sql = "select p.*, c.Name as cName from Product p, Category c where p.CategoryId = c.Id";
            }else
            sql = "select p.*, c.Name as cName from Product p, Category c where p.CategoryId = c.Id and c.Name = '" + name + "'";
            return DAO.GetDataTable(sql);
        }

        public static DataTable getProductsByCateName(string cName)
        {
            string sql = "select p.Id, p.Name, p.Size, p.Price, c.Name as CategoryName, p.[Image] from Category c, Product p where c.Id = p.CategoryId";
            if (!cName.Equals("All Category")) sql += " and c.Name = '" + cName + "'";
            return DAO.GetDataTable(sql);
        }

        public static List<Product> getProductByCateName(string cName)
        {
            List<Product> listPro = new List<Product>();
            DataTable dbt = getProductsByCateName(cName);
            foreach (DataRow dr in dbt.Rows)
            {
                int pid = Convert.ToInt32(dr["ID"]);
                string name = dr["Name"].ToString();
                string category = dr["CategoryName"].ToString();
                float price = float.Parse(dr["Price"].ToString());
                string size = dr["Size"].ToString();
                string image = dr["Image"].ToString();
                listPro.Add(new Product(pid, name, CategoryDAO.getCategoryIdByName(category), size, price, image));
            }
            return listPro;
        }

        public static DataTable getAllProducts()
        {
            string sql = "select p.Id, p.Name, p.Size, p.Price, c.Name as CategoryName, p.[Image] from Category c, Product p where c.Id = p.CategoryId";
            return DAO.GetDataTable(sql);
        }
        public static List<Product> GetAllProduct()
        {
            List<Product> listPro = new List<Product>();
            DataTable dtable = getAllProducts();
            foreach (DataRow dr in dtable.Rows)
            {
                int pid = Convert.ToInt32(dr["ID"]);
                string name = dr["Name"].ToString();
                string category = dr["CategoryName"].ToString();
                float price = float.Parse(dr["Price"].ToString());
                string size = dr["Size"].ToString();
                string image = dr["Image"].ToString();
                listPro.Add(new Product(pid, name, CategoryDAO.getCategoryIdByName(category), size, price, image));
            }
            return listPro;
        }

        public static void deleteProduct(int pId)
        {
            DAO.executeSql("DELETE From [OrderDetail] WHERE ProductID = " + pId);
            DAO.executeSql("DELETE From [Product] WHERE ID = " + pId);
        }

        public static bool Update(Product p)
        {
            SqlCommand cmd = new SqlCommand("update Product set name=@name, categoryId = @categoryId, size = @size, price=@price, image = @image where id=@id");
            cmd.Parameters.AddWithValue("@name", p.Name);
            cmd.Parameters.AddWithValue("@categoryId", p.CategoryId);
            cmd.Parameters.AddWithValue("@size", p.Size);
            cmd.Parameters.AddWithValue("@price", p.Price);
            cmd.Parameters.AddWithValue("@image", p.Image);
            cmd.Parameters.AddWithValue("@id", p.Id);
            return DAO.UpdateTable(cmd);
        }

        public static int selectMaxProId()
        {
            string sql = "select MAX(id) as maxId from Product";
            DataTable dt = DAO.GetDataTable(sql);

            return int.Parse(dt.Rows[0]["maxId"].ToString());
        }

        public static bool Insert(Product p)
        {
            SqlCommand cmd = new SqlCommand("Insert into Product (id, name, categoryId, size, price, image) values (@id, @name, @categoryId, @size, @price, @image)");
            cmd.Parameters.AddWithValue("@name", p.Name);
            cmd.Parameters.AddWithValue("@categoryId", p.CategoryId);
            cmd.Parameters.AddWithValue("@size", p.Size);
            cmd.Parameters.AddWithValue("@price", p.Price);
            cmd.Parameters.AddWithValue("@image", p.Image);
            cmd.Parameters.AddWithValue("@id", p.Id);
            return DAO.UpdateTable(cmd);
        }

    }
}
