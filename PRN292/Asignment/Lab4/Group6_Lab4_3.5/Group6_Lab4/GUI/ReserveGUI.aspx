<%@ Page Title="Reserve book" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ReserveGUI.aspx.cs" Inherits="Group6_Lab4.GUI.Reserve" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">

        .auto-style2 {
            width: 178px;
        }
        .auto-style1 {
            width: 180px;
        }
        .auto-style3 {
            width: 193px;
        }
        .auto-style5 {
            width: 361px;
        }
        .auto-style4 {
            margin-right: 8px;
        }
        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <div>
    <asp:Label ID="Label1" runat="server" Text="Reserve book:" Font-Bold="True" Font-Size="Larger"></asp:Label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
</div>
<table style="width:100%;">
    <tr>
        <td class="auto-style2">Borrower number:</td>
        <td class="auto-style1">
            <asp:TextBox ID="txtBorrowerNumber" runat="server"></asp:TextBox>
                    </td>
        <td class="auto-style3">
                    Name:<asp:TextBox ID="txtName" runat="server" Width="131px"></asp:TextBox>
        </td>
        <td>
            <asp:Button ID="btnCheckMember" runat="server" Text="Check member" Width="137px" OnClick="btnCheckmember_Click" />
        </td>
    </tr>
    <tr>
        <td class="auto-style2">Book number:</td>
        <td class="auto-style1">
            <asp:TextBox ID="txtBookNumber" runat="server"></asp:TextBox>
                    </td>
        <td class="auto-style3">
                    Title:&nbsp;&nbsp;
            <asp:TextBox ID="txtTitle" runat="server" Width="133px"></asp:TextBox>
        </td>
        <td>
            <asp:Button ID="btnCheckCondition" runat="server" Text="Check condition" OnClick="btnCheckCondition_Click" />
        </td>
    </tr>
</table>
        The number of reserved book:
    <asp:Label ID="lblNumber" runat="server"></asp:Label>
<p>
    <asp:GridView ID="GridView1" runat="server">
    </asp:GridView>
    <br />
    <table style="width:100%;">
        <tr>
            <td class="auto-style5">Reserve date:</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td class="auto-style5">
                <asp:Calendar ID="Calendar1" runat="server" CssClass="auto-style4" Height="220px" Width="400px" BackColor="White" BorderColor="Black" DayNameFormat="Shortest" Font-Names="Times New Roman" Font-Size="10pt" ForeColor="Black" NextPrevFormat="FullMonth" TitleFormat="Month">
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
            <td>
                <asp:Button ID="btnReserve" runat="server" Text="Reserve" OnClick="btnReserve_Click" />
            </td>
        </tr>
    </table>
</p>
<p>
            &nbsp;</p>
</asp:Content>
