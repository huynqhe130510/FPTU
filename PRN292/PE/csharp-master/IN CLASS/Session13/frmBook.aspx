<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="frmBook.aspx.cs" Inherits="Chapter_24.frmBook" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    </head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
    <div>
    
        <strong>
        Book&nbsp; Information<br />
        </strong><br />
    
    </div>
        Title&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtTitle" runat="server" Width="289px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <br />
        <br />
        Author&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtAuthor" runat="server" Width="357px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
&nbsp;<br />
        Publisher&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtPublisher" runat="server" Width="293px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Number&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="txtNumber" runat="server" Width="104px"></asp:TextBox>
        <br />
        <strong><em>
        <br />
        <br />
        Book List&nbsp;&nbsp; </em&nbsp;
        <br />
        <br />
        <br />
        <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" CellPadding="4" EnableModelValidation="True" ForeColor="#333333" GridLines="None" Height="144px" PageSize="3" Width="708px">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
            <Columns>
                <asp:BoundField DataField="Title" HeaderText="Title of Book" />
                <asp:BoundField DataField="Author" HeaderText="Author of Book" />
                <asp:BoundField DataField="BookNumber" HeaderText="Number of Book" />
            </Columns>
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        </asp:GridView>
        <br />
        <br />
        <br />
        <asp:Button ID="btnAddNew" runat="server" Text="Add New" />
        <br />
        </em></strong>
    </form>
</body>
</html>
