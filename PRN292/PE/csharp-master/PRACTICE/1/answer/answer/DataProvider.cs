using System;
using System.Collections;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web.Configuration;
using System.Web.UI.WebControls;

//DELETE FROM table_name WHERE condition;

namespace answer
{
    class DataProvider
    {
        public DataProvider() { }
        string connStr = WebConfigurationManager.ConnectionStrings["DummyConnectionString"].ConnectionString;

        /**
         * Get list from database
         * Example: dataProvinder.LIST_STRING("select name from Student");
         */
        public ArrayList LIST_STRING(string query)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader dr = null;
            try
            {
                ArrayList list = new ArrayList();
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    list.Add(dr[0].ToString());
                }
                return list;
            }
            catch (Exception ex)
            {
                throw ex;
                return null;
            }
            finally
            {
                dr.Close();
                con.Close();
            }
        }

        /**
         * Add, update, delete
         * Example: dataProvinder.ADD_UPDATE_DELETE("INSERT INTO Person VALUES( @param1 , @param2 )", new object[] { tbName, tbAge });
         */
        public void ADD_UPDATE_DELETE(string query, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            try
            {
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Get list object
         * Example: DataTable dataTable = dataProvider.GET_LIST_OBJECT( "select * from Ships where name like @param1", new object[] { "%abc%" });
         */
        public DataTable GET_LIST_OBJECT(string query, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                return dataTable;
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to table
         * Example: dataProvider.GRIDVIEW("select * from Student where class = @param1", GridView1, new object[] { "SE1212" });
         */
        public void GRIDVIEW(string query, GridView gridView, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                gridView.DataSource = dataTable;
                gridView.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to listbox
         * Example: dataProvider.LIST_BOX("select * from Student", "name", "id", ListBox1);
         */
        public void LIST_BOX(string query, string columnTextField, string columnValueField, ListBox listBox, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                // clear list box
                if (listBox.Items.Count > 0)
                {
                    listBox.Items.Clear();
                }
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                listBox.DataSource = dataTable;
                listBox.DataTextField = columnTextField;
                listBox.DataValueField = columnValueField;
                listBox.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to check box list
         * Example: dataProvider.CHECK_BOX_LIST("select * from Student", "name", "id", CheckBoxList1);
         */
        public void CHECK_BOX_LIST(string query, string columnTextField, string columnValueField, CheckBoxList checkBoxList, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                // clear check box list
                if (checkBoxList.Items.Count > 0)
                {
                    checkBoxList.Items.Clear();
                }
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                checkBoxList.DataSource = dataTable;
                checkBoxList.DataTextField = columnTextField;
                checkBoxList.DataValueField = columnValueField;
                checkBoxList.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to dropdownlist
         * Example:  dataProvider.DROP_DOWN_LIST("select * from Student", "name", "id", DropDownList1);
         */
        public void DROP_DOWN_LIST(string query, string columnTextField, string columnValueField, DropDownList dropDownList, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                // clear drop down list
                if (dropDownList.Items.Count > 0)
                {
                    dropDownList.Items.Clear();
                }
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                dropDownList.DataSource = dataTable;
                dropDownList.DataTextField = columnTextField;
                dropDownList.DataValueField = columnValueField;
                dropDownList.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to bulleted list
         * Example:  dataProvider.BULLETED_LIST("select * from Student", "name", "id", BulletedList1);
         */
        public void BULLETED_LIST(string query, string columnTextField, string columnValueField, BulletedList bulletedList, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                // clear drop down list
                if (bulletedList.Items.Count > 0)
                {
                    bulletedList.Items.Clear();
                }
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                bulletedList.DataSource = dataTable;
                bulletedList.DataTextField = columnTextField;
                bulletedList.DataValueField = columnValueField;
                bulletedList.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }

        /**
         * Fill data to radio button list
         * Example:  dataProvider.RADIO_BUTTON_LIST("select * from Student", "name", "id", RadioButtonList1);
         */
        public void RADIO_BUTTON_LIST(string query, string columnTextField, string columnValueField, RadioButtonList radioButtonList, object[] parameter = null)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            DataTable dataTable = new DataTable();
            try
            {
                // clear drop down list
                if (radioButtonList.Items.Count > 0)
                {
                    radioButtonList.Items.Clear();
                }
                con = new SqlConnection(connStr);
                con.Open();
                cmd = new SqlCommand(query, con);
                if (parameter != null)
                {
                    string[] listParam = query.Split(' ');
                    int i = 0;
                    foreach (string item in listParam)
                    {
                        if (item.Contains('@'))
                        {
                            cmd.Parameters.AddWithValue(item, parameter[i]);
                            i++;
                        }
                    }
                }
                SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                adapter.Fill(dataTable);
                radioButtonList.DataSource = dataTable;
                radioButtonList.DataTextField = columnTextField;
                radioButtonList.DataValueField = columnValueField;
                radioButtonList.DataBind();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                con.Close();
            }
        }
    }
}