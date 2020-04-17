<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="Q3.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <asp:Label ID="lbResult" runat="server"></asp:Label>
    
    </div>
        <p>
            <asp:Label ID="Label1" runat="server" Text="Student ID: "></asp:Label>
            <asp:TextBox ID="tbStudentID" runat="server" Enabled="False"></asp:TextBox>
        </p>
        <p>
            <asp:Label ID="Label2" runat="server" Text="Student Name: "></asp:Label>
            <asp:TextBox ID="tbStudentName" runat="server"></asp:TextBox>
            <asp:Label ID="lbError" runat="server" ForeColor="#CC0000"></asp:Label>
        </p>
        <p>
            <asp:Label ID="Label3" runat="server" Text="Sex: "></asp:Label>
            <asp:RadioButton ID="rdbMale" runat="server" OnCheckedChanged="rdbMale_CheckedChanged" Text="Male" GroupName="sex" />
            <asp:RadioButton ID="rdbFemale" runat="server" OnCheckedChanged="rdbFemale_CheckedChanged" Text="Male" GroupName="sex"/>
        </p>
        <p>
            <asp:Label ID="Label4" runat="server" Text="Subject: "></asp:Label>
            <asp:ListBox ID="ListBox1" runat="server"></asp:ListBox>
        </p>
        <p>
            <asp:Label ID="Label5" runat="server" Text="Time: "></asp:Label>
            <asp:DropDownList ID="ddlTime" runat="server" Height="16px" Width="88px">
            </asp:DropDownList>
        </p>
        <p>
            <asp:Label ID="Label6" runat="server" Text="Note: "></asp:Label>
            <asp:TextBox ID="tbNote" runat="server" Height="49px" Width="187px"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="btnSubmit" runat="server" OnClick="btnSubmit_Click" Text="Submit" />
        </p>
    </form>
</body>
</html>
