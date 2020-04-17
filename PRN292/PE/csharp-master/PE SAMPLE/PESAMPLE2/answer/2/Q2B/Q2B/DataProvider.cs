using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Q2B
{
    class DataProvider
    {
        public DataProvider() { }
        string connStr = System.Configuration.ConfigurationManager.ConnectionStrings["Database"].ConnectionString;
        /**
         * Fill data to combobox
         */
        public void COMBOBOX(string query, ComboBox combobox)
        {
            SqlConnection con = null;
            SqlCommand cmd = null;
            SqlDataReader dr = null;
            try
            {
                con = new SqlConnection(connStr);
                con.Open();
                if (combobox.Items.Count > 0)
                {
                    combobox.Items.Clear();
                }
                cmd = new SqlCommand(query, con);
                dr = cmd.ExecuteReader();
                while (dr.Read())
                {
                    combobox.Items.Add(dr[0].ToString());
                }
                combobox.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                dr.Close();
                con.Close();
            }
        }

        /**
         * Get list from database
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
         * Example:
         * string query = "INSERT INTO Person VALUES( @param1 , @param2 )";
           dataProvinder.ADD(query, new object[] { tbName, tbAge });
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
                    cmd.ExecuteNonQuery();
                }
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
         * Example:
         * string query = "select * from Ships where name like @param1";
           DataTable dataTable = dataProvider.GET_LIST_OBJECT(query, new object[] { "%abc%" });
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
                    SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                    adapter.Fill(dataTable);
                }
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
         */

        public void DATAGRIDVIEW(string query, DataGridView dataGridView, object[] parameter = null)
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
                    SqlDataAdapter adapter = new SqlDataAdapter(cmd);
                    adapter.Fill(dataTable);
                }
                dataGridView.DataSource = dataTable;
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