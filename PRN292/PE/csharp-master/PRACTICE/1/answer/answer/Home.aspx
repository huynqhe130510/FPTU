<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="answer.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="master_id" DataSourceID="SqlDataSource1" EnableModelValidation="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" Width="458px">
            <Columns>
                <asp:BoundField DataField="master_id" HeaderText="Master ID" ReadOnly="True" SortExpression="master_id" />
                <asp:BoundField DataField="master_name" HeaderText="Master Name" SortExpression="master_name" />
                <asp:CommandField ShowSelectButton="True" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:DummyConnectionString %>" SelectCommand="SELECT [master_id], [master_name] FROM [DummyMaster]"></asp:SqlDataSource>
    </form>
</body>
</html>
