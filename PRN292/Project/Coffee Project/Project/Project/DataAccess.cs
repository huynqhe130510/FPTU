using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;

namespace Project
{
    public class DataAccess
    {
        public static SqlConnection getConnection() //tao ket noi voi csdl
        {
            String conString = ConfigurationManager.ConnectionStrings["CSMSConnectionString"].ToString();
            SqlConnection myConnection = new SqlConnection(conString);
            myConnection.Open();
            return myConnection;
        }

        public static DataTable getDataUsingSql(string sql)
        {
            SqlCommand myCommand = new SqlCommand(sql, getConnection());
            SqlDataAdapter adapt = new SqlDataAdapter();
            adapt.SelectCommand = myCommand;
            DataSet ds = new DataSet();
            adapt.Fill(ds);
            return ds.Tables[0];
        }

        public static void executeSql(string sql)
        {
            SqlCommand command = new SqlCommand(sql, getConnection());
            command.Connection.Close();
            command.Connection.Open();
            command.ExecuteNonQuery();
            command.Connection.Close();
        }

        public static DataTable getEmployeeByUsername(string username)
        {
            string sql = "select * from Employee e, Account a " +
                "where e.EmployeeID = a.EmployeeID and a.Username = '" + username + "'";
            return getDataUsingSql(sql);
        }

        public static DataTable getEmployeeByID(int cid)
        {
            string sql = "select * from Employee e, Account a where e.EmployeeID = a.EmployeeID and e.EmployeeID = " + cid;
            return getDataUsingSql(sql);
        }

        public static DataTable getAllEmployee()
        {
            string sql = "select * from Employee e, Account a " +
                "where e.EmployeeID = a.EmployeeID and a.[Role] != 'OUT' order by e.EmployeeID";
            return getDataUsingSql(sql);
        }

        public static void UpdateEmployee(int eid, string name, string address, int phone, 
            DateTime doj, string password)
        {

            SqlCommand com = new SqlCommand();
            com.Connection = getConnection();
            string sql = "update Employee set [Name] = @name, [Address] = @address, " +
            "Phone = @phone, DateOfJoin = @doj where EmployeeID = @eid ";
            com.CommandText = sql;
            com.Parameters.Add("@name", SqlDbType.NVarChar);
            com.Parameters["@name"].Value = name;
            com.Parameters.Add("@address", SqlDbType.NVarChar);
            com.Parameters["@address"].Value = address;
            com.Parameters.Add("@phone", SqlDbType.Int);
            com.Parameters["@phone"].Value = phone;
            com.Parameters.Add("@doj", SqlDbType.DateTime);
            com.Parameters["@doj"].Value = doj;
            com.Parameters.Add("@eid", SqlDbType.Int);
            com.Parameters["@eid"].Value = eid;
            com.ExecuteNonQuery();

            string sql1 = "update Account set [Password] = @password where EmployeeID = @eid1 ";
            com.CommandText = sql1;
            com.Parameters.Add("@password", SqlDbType.NVarChar);
            com.Parameters["@password"].Value = password;
            
            com.Parameters.Add("@eid1", SqlDbType.Int);
            com.Parameters["@eid1"].Value = eid;
            com.ExecuteNonQuery();

            com.Connection.Close();


        }

        public static void UpdateSalaryAndRole(int eid, double salary, string role)
        {

            SqlCommand com = new SqlCommand();
            com.Connection = getConnection();
            string sql = "update Employee set Salary = @salary where EmployeeID = @eid ";
            com.CommandText = sql;
            com.Parameters.Add("@salary", SqlDbType.Money);
            com.Parameters["@salary"].Value = salary;
            
            com.Parameters.Add("@eid", SqlDbType.Int);
            com.Parameters["@eid"].Value = eid;
            com.ExecuteNonQuery();

            string sql1 = "update Account set [Role] = @role where EmployeeID = @eid1 ";
            com.CommandText = sql1;
            com.Parameters.Add("@role", SqlDbType.VarChar);
            com.Parameters["@role"].Value = role;

            com.Parameters.Add("@eid1", SqlDbType.Int);
            com.Parameters["@eid1"].Value = eid;
            com.ExecuteNonQuery();

            com.Connection.Close();


        }

        public static void UpdataAvatar(int eid, string path)
        {
            SqlCommand com = new SqlCommand();
            com.Connection = getConnection();
            string sql = "update Employee set Photo = @path where EmployeeID = @eid ";
            com.CommandText = sql;
            com.Parameters.Add("@path", SqlDbType.NVarChar);
            com.Parameters["@path"].Value = path;
            com.Parameters.Add("@eid", SqlDbType.Int);
            com.Parameters["@eid"].Value = eid;
            com.ExecuteNonQuery();

            com.Connection.Close();
        }

        public static int getMaxEmployeeID()
        {
            DataTable dt = getDataUsingSql("select Max(EmployeeID)'MaxID' from Employee");
            return Convert.ToInt32(dt.Rows[0]["MaxID"]);
        }

        public static void AddEmployee(string name, string address,DateTime bd, string photo, int phone,
            double salary, DateTime doj, string gender)
        {
            SqlCommand com = new SqlCommand();
            com.Connection = getConnection();
            string sql = "insert into Employee values(@name,@address,@bd,@photo,@phone,@salary,@doj,@gender)";
            com.CommandText = sql;
            com.Parameters.Add("@name", SqlDbType.NVarChar);
            com.Parameters["@name"].Value = name;
            com.Parameters.Add("@address", SqlDbType.NVarChar);
            com.Parameters["@address"].Value = address;
            com.Parameters.Add("@bd", SqlDbType.DateTime);
            com.Parameters["@bd"].Value = bd;
            com.Parameters.Add("@photo", SqlDbType.VarChar);
            com.Parameters["@photo"].Value = photo;
            com.Parameters.Add("@phone", SqlDbType.Int);
            com.Parameters["@phone"].Value = phone;
            com.Parameters.Add("@salary", SqlDbType.Money);
            com.Parameters["@salary"].Value = salary;
            com.Parameters.Add("@doj", SqlDbType.DateTime);
            com.Parameters["@doj"].Value = doj;
            com.Parameters.Add("@gender", SqlDbType.NChar);
            com.Parameters["@gender"].Value = gender;

            com.ExecuteNonQuery();
            com.Connection.Close();

        }

        public static void addAccount(string username, string pass, string role, int eid)
        {
            SqlCommand com = new SqlCommand();
            com.Connection = getConnection();
            string sql = "insert into Account values(@username,@pass,@role,@eid)";
            com.CommandText = sql;
            com.Parameters.Add("@username", SqlDbType.NVarChar);
            com.Parameters["@username"].Value = username;
            com.Parameters.Add("@pass", SqlDbType.NVarChar);
            com.Parameters["@pass"].Value = pass;
            com.Parameters.Add("@role", SqlDbType.NVarChar);
            com.Parameters["@role"].Value = role;
            com.Parameters.Add("@eid", SqlDbType.Int);
            com.Parameters["@eid"].Value = eid;

            com.ExecuteNonQuery();
            com.Connection.Close();
        }

        public static void AddFullEmployee(string name, string address, DateTime bd, string photo, int phone,
            double salary, DateTime doj, string gender, string username, string pass, string role)
        {
            AddEmployee(name, address, bd, photo, phone, salary, doj,gender);
            int eid = getMaxEmployeeID();
            addAccount(username, pass, role, eid);
        }

        public static bool isExistUsername(string us)
        {
            DataTable dt = getDataUsingSql("select * from Account where Username in ('"+us+"')");
            if(dt.Rows.Count == 0)
            {
                return false;
            }
            return true;
        }

        public static void DeleteEmployee(int eid)
        {
            executeSql("update Account set [Role] = 'OUT' where EmployeeID = " + eid);
        }

        //quan
        public static DataTable getAllCategories()
        {
            string sql = "SELECT * FROM Category";
            return getDataUsingSql(sql);
        }
        public static DataTable getAllProductByCateName(string cateName)
        {
            string sql = "SELECT Product.*, Category.CategoryName FROM Category INNER JOIN Product ON Category.CategoryID = Product.CategoryID WHERE Category.CategoryName ='" + cateName + "'";
            return getDataUsingSql(sql);
        }

        public static int getMaxOrderId()
        {
            DataTable dt = getDataUsingSql("SELECT MAX(OrderID) as 'MaxOrder' FROM [Order]");
            int max = Convert.ToInt32(dt.Rows[0]["MaxOrder"].ToString());
            return max;
        }
        public static void addNewOrder(int eID, DateTime OrderDate)
        {
            string sql = "INSERT INTO [Order] VALUES(@eid,@date)";
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = getConnection();
            cmd.CommandText = sql;
            cmd.Parameters.Add("@eid", SqlDbType.Int);
            cmd.Parameters["@eid"].Value = eID;
            cmd.Parameters.Add("@date", SqlDbType.DateTime);
            cmd.Parameters["@date"].Value = OrderDate;
            cmd.ExecuteNonQuery();
            cmd.Connection.Close();
        }
        public static DataTable getEmployee(string user, string pass)
        {
            string sql = "Select * from Employee e, Account a Where a.EmployeeID = e.EmployeeID and a.Username ='" + user + "' AND a.Password = '" + pass + "'";
            return getDataUsingSql(sql);
        }
        public static void addNewOrderDetail(int oID, int pID, int quant)
        {
            string sql = "INSERT INTO [OrderDetail] VALUES(@oid,@pid,@quant)";
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = getConnection();
            cmd.CommandText = sql;
            cmd.Parameters.Add("@pid", SqlDbType.Int);
            cmd.Parameters["@pid"].Value = pID;
            cmd.Parameters.Add("@oid", SqlDbType.Int);
            cmd.Parameters["@oid"].Value = oID;
            cmd.Parameters.Add("@quant", SqlDbType.Int);
            cmd.Parameters["@quant"].Value = quant;
            cmd.ExecuteNonQuery();
            cmd.Connection.Close();
        }

        //Le duc
        public static DataTable getAllProducts()
        {
            string sql = "SELECT Product.ProductID, Product.ProductName, Category.CategoryName, Product.Price, Product.Size, Product.Description, Product.Picture FROM Product INNER JOIN Category ON Product.CategoryID = Category.CategoryID";
            return getDataUsingSql(sql);
        }

        public static void deleteProduct(int pId)
        {
             executeSql("DELETE From [OrderDetail] WHERE ProductID = " + pId);
             executeSql("DELETE From [Product] WHERE ProductID = " + pId);
        }

        public static int getCateIdByName(string cateName)
        {
            string sql = "SELECT CategoryID,CategoryName From Category WHERE CategoryName= '" + cateName + "' ";
            DataTable dbt = getDataUsingSql(sql);
            int cateId = 1;
            DataRow dr = dbt.Rows[0];
            cateId = Convert.ToInt32(dr["CategoryID"]);
            return cateId;
        }

        public static int editProduct(int proId, string name, int cateID, double price, string size, string description, string image)
        {

            string sql = "update Product set ProductName =@name, CategoryID=@cateID, Price = @price, Size = @size, Description = @description, Picture = @picture where ProductID= @id";
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = getConnection();
            cmd.CommandText = sql;

            cmd.Parameters.Add("@name", SqlDbType.NVarChar);
            cmd.Parameters["@name"].Value = name;

            cmd.Parameters.Add("@id", SqlDbType.Int);
            cmd.Parameters["@id"].Value = proId;

            cmd.Parameters.Add("@cateID", SqlDbType.Int);
            cmd.Parameters["@cateID"].Value = cateID;

            cmd.Parameters.Add("@price", SqlDbType.Money);
            cmd.Parameters["@price"].Value = price;

            cmd.Parameters.Add("@size", SqlDbType.NVarChar);
            cmd.Parameters["@size"].Value = size;

            cmd.Parameters.Add("@description", SqlDbType.NVarChar);
            cmd.Parameters["@description"].Value = description;

            cmd.Parameters.Add("@picture", SqlDbType.NVarChar);
            cmd.Parameters["@picture"].Value = image;

            int count = cmd.ExecuteNonQuery();
            cmd.Connection.Close();
            return count;
        }

        public static int addProduct(string name, int cateID, double price, string size, string description, string picture)
        {
            string sql = "insert into Product values(@productName,@categoryName,@Price,@Size,@Description,@Picture)";
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = getConnection();
            cmd.CommandText = sql;
            cmd.Parameters.Add("@productName", SqlDbType.NVarChar);
            cmd.Parameters["@productName"].Value = name;
            cmd.Parameters.Add("@categoryName", SqlDbType.Int);
            cmd.Parameters["@categoryName"].Value = cateID;
            cmd.Parameters.Add("@Price", SqlDbType.Money);
            cmd.Parameters["@Price"].Value = price;
            cmd.Parameters.Add("@Size", SqlDbType.NVarChar);
            cmd.Parameters["@Size"].Value = size;
            cmd.Parameters.Add("@Description", SqlDbType.NVarChar);
            cmd.Parameters["@Description"].Value = description;
            cmd.Parameters.Add("@Picture", SqlDbType.NVarChar);
            cmd.Parameters["@Picture"].Value = picture;

            int count = cmd.ExecuteNonQuery();
            cmd.Connection.Close();
            return count;
        }

        public static DataTable getProductsByCateName(string cName)
        {
            string sql = "SELECT Product.ProductID, Product.ProductName, Category.CategoryName, Product.Price, Product.Size, Product.Description, Product.Picture FROM  Product INNER JOIN Category ON Product.CategoryID = Category.CategoryID";
            if (!cName.Equals("All Category")) sql += " WHERE CategoryName = '" + cName + "'";
            return getDataUsingSql(sql);
        }

        public static DataTable getAllCateGory()
        {
            string sql = "SELECT * From Category";
            return getDataUsingSql(sql);
        }

        //luat cube
        public static DataTable getOrderFromDate(DateTime dt1, string type)
        {
            string sql = "";
            if (type.Equals("D"))
            {
                sql = "SELECT Employee.Name, [Order].OrderID, [Order].OrderDate, SUM(OrderDetail.Quantity * Product.Price) as Total"
                      + " FROM Employee INNER JOIN"
                      + " [Order] ON Employee.EmployeeID = [Order].EmployeeID INNER JOIN"
                      + " OrderDetail ON[Order].OrderID = OrderDetail.OrderID INNER JOIN"
                      + " Product ON OrderDetail.ProductID = Product.ProductID"
                      + " GROUP BY   Employee.Name, [Order].OrderID, [Order].OrderDate"
                      + " HAVING DAY('" + dt1 + "')= DAY(OrderDate) AND MONTH('" + dt1 + "')= MONTH(OrderDate) AND YEAR('" + dt1 + "')= YEAR(OrderDate)";
            }
            else if (type.Equals("M"))
            {
                sql = "SELECT Employee.Name, [Order].OrderID, [Order].OrderDate, SUM(OrderDetail.Quantity * Product.Price) as Total"
                         + " FROM Employee INNER JOIN"
                         + " [Order] ON Employee.EmployeeID = [Order].EmployeeID INNER JOIN"
                         + " OrderDetail ON[Order].OrderID = OrderDetail.OrderID INNER JOIN"
                         + " Product ON OrderDetail.ProductID = Product.ProductID"
                         + " GROUP BY   Employee.Name, [Order].OrderID, [Order].OrderDate"
                         + " HAVING MONTH('" + dt1 + "')= MONTH(OrderDate) AND YEAR('" + dt1 + "')= YEAR(OrderDate)";
            }
            else
            {
                sql = "SELECT Employee.Name, [Order].OrderID, [Order].OrderDate, SUM(OrderDetail.Quantity * Product.Price) as Total"
                         + " FROM Employee INNER JOIN"
                         + " [Order] ON Employee.EmployeeID = [Order].EmployeeID INNER JOIN"
                         + " OrderDetail ON[Order].OrderID = OrderDetail.OrderID INNER JOIN"
                         + " Product ON OrderDetail.ProductID = Product.ProductID"
                         + " GROUP BY   Employee.Name, [Order].OrderID, [Order].OrderDate"
                         + " HAVING YEAR('" + dt1 + "')= YEAR(OrderDate)";
            }
            //string sql = "SELECT Employee.Name, [Order].OrderID, [Order].OrderDate, SUM(OrderDetail.Quantity * Product.Price) as Total"
            //          + " FROM Employee INNER JOIN"
            //          + " [Order] ON Employee.EmployeeID = [Order].EmployeeID INNER JOIN"
            //          + " OrderDetail ON[Order].OrderID = OrderDetail.OrderID INNER JOIN"
            //          + " Product ON OrderDetail.ProductID = Product.ProductID"
            //          + " GROUP BY   Employee.Name, [Order].OrderID, [Order].OrderDate"
            //          + " HAVING '" + dt1 + "'= OrderDate";
            return getDataUsingSql(sql);
        }
        public static DataTable getOrderDetail(int orderId)
        {
            string sql = "SELECT * FROM Employee INNER JOIN"
              + " [Order] ON Employee.EmployeeID = [Order].EmployeeID INNER JOIN"
                        + " OrderDetail ON[Order].OrderID = OrderDetail.OrderID INNER JOIN"
                        + " Product ON OrderDetail.ProductID = Product.ProductID"
                        + " WHERE[Order].OrderID =" + orderId;
            DataTable dt = getDataUsingSql(sql);
            dt.Columns.Add("Total", typeof(double));
            foreach (DataRow row in dt.Rows)
            {
                //need to set value to NewColumn column
                row["Total"] = Convert.ToDouble(row["Price"].ToString()) * Convert.ToDouble(row["Quantity"].ToString());   // or set it to some other value
            }
            return dt;
        }

    }
}
