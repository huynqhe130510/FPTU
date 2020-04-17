<%@ Page Title="Borrow a copy" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="BorrowGUI.aspx.cs" Inherits="Group6_Lab4.GUI.Borrow" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">

        .auto-style1 {
            width: 206px;
        }
        .auto-style2 {
            width: 249px;
        }
        .auto-style8 {
            width: 100%;
            height: 289px;
        }
        .auto-style9 {
            width: 343px;
            height: 4px;
        }
        .auto-style10 {
            width: 177px;
            height: 4px;
        }
        .auto-style11 {
            height: 4px;
        }
        .auto-style12 {
            width: 343px;
            height: 120px;
        }
        .auto-style13 {
            width: 177px;
            height: 120px;
        }
        .auto-style14 {
            height: 120px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <asp:Label ID="Label1" runat="server" Text="Borrow a copy" Font-Bold="True" Font-Size="Larger"></asp:Label>
        &nbsp;
            <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
<br />
<br />
<table style="width: 100%;">
    <tr>
        <td class="auto-style1">Borrower number:</td>
        <td class="auto-style2">
            <asp:TextBox ID="txtBorrowerNumber" runat="server"></asp:TextBox>
        </td>
        <td>
            <asp:Button ID="btnCheckMember" runat="server" Text="Check member" Width="147px" OnClick="btnCheckBorrower_Click" />
        </td>
    </tr>
    <tr>
        <td class="auto-style1">Name:</td>
        <td class="auto-style2">
            <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td class="auto-style1">Copy number:</td>
        <td class="auto-style2">
            <asp:TextBox ID="txtCopyNumber" runat="server"></asp:TextBox>
        </td>
        <td>
            <asp:Button ID="btnCheckCondition" runat="server" Text="Check condition" Width="144px" OnClick="btnCheckCondition_Click" />
        </td>
    </tr>
</table>
&nbsp;&nbsp;
    <br />
    Number of borrowed copies:
    <asp:Label ID="lblNumber" runat="server"></asp:Label>
    <br />
<asp:GridView ID="GridView1" runat="server">
</asp:GridView>
<table class="auto-style8">
    <tr>
        <td class="auto-style9">Borrower date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Label ID="lblDate" runat="server"></asp:Label>
        </td>
        <td class="auto-style10">Due date:</td>
        <td class="auto-style11">
            <asp:TextBox ID="txtDueDate" runat="server"></asp:TextBox>
        </td>
    </tr>
    <tr>
        <td class="auto-style12">
            <asp:Calendar ID="Calendar1" runat="server" Height="220px" Width="400px" BackColor="White" BorderColor="Black" DayNameFormat="Shortest" Font-Names="Times New Roman" Font-Size="10pt" ForeColor="Black" NextPrevFormat="FullMonth" TitleFormat="Month" OnSelectionChanged="Calendar1_SelectionChanged">
                <DayHeaderStyle BackColor="#CCCCCC" Font-Bold="True" Font-Size="7pt" ForeColor="#333333" Height="10pt" />
                <DayStyle Width="14%" />
                <NextPrevStyle Font-Size="8pt" ForeColor="White" />
                <OtherMonthDayStyle ForeColor="#999999" />
                <SelectedDayStyle BackColor="#CC3333" ForeColor="White" />
                <SelectorStyle BackColor="#CCCCCC" Font-Bold="True" Font-Names="Verdana" Font-Size="8pt" ForeColor="#333333" Width="1%" />
                <TitleStyle BackColor="Black" Font-Bold="True" Font-Size="13pt" ForeColor="White" Height="14pt" />
                <TodayDayStyle BackColor="#CCCC99" />
            </asp:Calendar>
        </td>
        <td class="auto-style13">
            <asp:Button ID="btnBorrow" runat="server" Text="Borrow" Width="86px" OnClick="btnBorrow_Click" />
        </td>
        <td class="auto-style14"></td>
    </tr>
</table>
</asp:Content>
