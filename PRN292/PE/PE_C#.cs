//-------------------------DAO
public class DAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["PRN292_20Spr_TrialConnectionString"].ConnectionString;
        static public DataTable GetDataTable(string sqlSelect)
        {
            try
            {
                SqlConnection conn = new SqlConnection(strConn);
                SqlDataAdapter da = new SqlDataAdapter(sqlSelect, conn);
                DataSet ds = new DataSet();
                da.Fill(ds);
                return ds.Tables[0];
            }
            catch
            {
                return null;
            }
        }
        static public bool UpdateTable(SqlCommand cmd)
        {
            try
            {
                SqlConnection conn = new SqlConnection(strConn);
                cmd.Connection = conn;
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;

            }
            catch
            {
                return false;
            }

        }

        public static void executeSql(string sql)
        {
            SqlConnection conn = new SqlConnection(strConn);
            SqlCommand command = new SqlCommand(sql, conn);
            command.Connection.Close();
            command.Connection.Open();
            command.ExecuteNonQuery();
            command.Connection.Close();
        }
    }

//------------------------appConfig below configuration
<connectionStrings>
    <add name="PRN292_20Spr_TrialConnectionString" connectionString="Data Source=localhost;Initial Catalog=PRN292_20Spr_Trial;Integrated Security=True" providerName="System.Data.SqlClient"/>
  </connectionStrings>
  
//------------------------GetDataTable 
public static DataTable GetDataTable()
        {
            string cmd = "select * from Book";
            return DAO.GetDataTable(cmd);
        }
		
//------------------------Insert
public static bool Insert(string title, string authors, string publisher)
        {
            SqlCommand cmd = new SqlCommand("insert into book(title, authors, publisher)" +
                    "values (@title, @authors, @publisher)");
            cmd.Parameters.AddWithValue("@title", title);
            cmd.Parameters.AddWithValue("@authors", authors);
            cmd.Parameters.AddWithValue("@publisher", publisher);
            return DAO.UpdateTable(cmd);
        }
		
//-----------------------Update
        public static bool Update(string title, string authors, string publisher, int bookNumber)
        {
            SqlCommand cmd = new SqlCommand("update Book set title=@title, authors = @authors, publisher = @publisher where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            cmd.Parameters.AddWithValue("@title", title);
            cmd.Parameters.AddWithValue("@authors", authors);
            cmd.Parameters.AddWithValue("@publisher", publisher);
            return DAO.UpdateTable(cmd);
        }

//----------------------Delete
        public static Boolean Delete(int bookNumber)
        {
            SqlCommand cmd = new SqlCommand("delete Book where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            return DAO.UpdateTable(cmd);
        }		
		
		
//---------------------------------------------------WinForm-------------------------------------------

//--------------------DataGridView
getValueByRowAndColumn: dataGridView1.SelectedRows[0].Cells["Id"].Value == null;

CellClick: 
private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            txtProductId.Text = dataGridView1.Rows[e.RowIndex].Cells["Id"].Value.ToString();
            txtName.Text = dataGridView1.Rows[e.RowIndex].Cells["Name"].Value.ToString();

            cbCategory.DataSource = CategoryDAO.getAllCateGoryName();
            cbCategory.SelectedIndex = int.Parse(dataGridView1.Rows[e.RowIndex].Cells["CategoryId"].Value.ToString());

            txtSize.Text = dataGridView1.Rows[e.RowIndex].Cells["Size"].Value.ToString();
            txtPrice.Text = dataGridView1.Rows[e.RowIndex].Cells["Price"].Value.ToString();

            string image = dataGridView1.Rows[e.RowIndex].Cells["image"].Value.ToString();
            try
            {
                pictureBox1.Image = Image.FromFile(image);
            }
            catch
            {
                pictureBox1.Image = Image.FromFile(errorPath);
            }
            btnSaveAdd.Visible = false;
        }
		
////--------------------------------------------------------WebForm---------------------------------
//-----------------------DropDownList
DataTable dt1 = DAO.GetDataTable("select * from region");
                DropDownList1.DataSource = dt1;
                DropDownList1.DataValueField = "region_no";
                DropDownList1.DataTextField = "region_name";
                DropDownList1.DataBind();	

//-----------------------Filter
string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
            SqlConnection conn = new SqlConnection(strConn);
            SqlCommand cmd = new SqlCommand("select copy.*, title from copy, book where copy.bookNumber = book.bookNumber", conn);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);
            dt.Columns[0].ColumnName = "Number";

            DataView dv = new DataView(dt);
            string filter = "Title like '*" + TextBox1.Text + "*'";
            if (int.Parse(DropDownList1.SelectedValue) != -1)
                filter += "BookNumber = " + DropDownList1.SelectedValue;

            dv.RowFilter = filter;
            GridView1.DataSource = dv;
            GridView1.DataBind();				
		