/**
 * Query
 */
UPDATE table_name SET column1 = value1, column2 = value2 WHERE condition;
INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);
DELETE FROM table_name WHERE condition;


/**
 * GridView Selected Index Changed Coding
 */

GridViewRow gr = GridView1.SelectedRow;
Response.Redirect("ShowData.aspx?rollno="+gr.Cells[0].Text+"&sname="+ gr.Cells[1].Text+"&fname="+ gr.Cells[2].Text+"&mname="+ gr.Cells[3].Text);

/**
 * ShowData.aspx Page Coding
 */

TextBox1.Text = Request.QueryString["rollno"].ToString();
TextBox2.Text = Request.QueryString["sname"].ToString();
TextBox3.Text = Request.QueryString["fname"].ToString();
TextBox4.Text = Request.QueryString["mname"].ToString();

/**
 * Select row
 */

  GridView1.RowCommand += GridView1_RowCommand;

  private void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
{
    if (e.CommandName.Equals("Select"))
    {
        tbProjectName.Text = e.CommandArgument.ToString();
    }
}

/**
 * Paging
 */

 protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            GridView1.PageIndex = e.NewPageIndex;
            // load table
        }