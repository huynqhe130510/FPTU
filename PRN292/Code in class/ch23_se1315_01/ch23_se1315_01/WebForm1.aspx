<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ch23_se1315_01.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="height: 268px">
            Book:
            <asp:DropDownList ID="DropDownList1" runat="server" Width="156px">
            </asp:DropDownList>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Search" />
            &nbsp;<br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="Title"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" Width="152px"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Title require" ForeColor="Red" ControlToValidate="TextBox1"></asp:RequiredFieldValidator>
            <br />
            List of copy:
            <asp:Label ID="Label1" runat="server" Text="0"></asp:Label>
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server" OnDataBound="GridView1_DataBound" OnRowDataBound="GridView1_RowDataBound">
            </asp:GridView>
        </div>
    </form>
</body>
</html>
