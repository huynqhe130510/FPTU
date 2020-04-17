<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Question3.aspx.cs" Inherits="Q3A.Hoe" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 308px">
    <form id="form1" runat="server">
        <asp:Label ID="Label1" runat="server" Text="Select ship:"></asp:Label>
        <asp:CheckBox ID="cbShip" runat="server" />
        <asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged" OnTextChanged="DropDownList1_TextChanged">
        </asp:DropDownList>
        <asp:Button ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="Search" />
        <p>
            <asp:Label ID="Label2" runat="server" Text="Number of rows: "></asp:Label>
            <asp:Label ID="lbOutCome" runat="server" Text="0"></asp:Label>
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </p>
    </form>
</body>
</html>
