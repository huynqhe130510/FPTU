<%@ Page Title="Return a copy" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="ReturnGUI.aspx.cs" Inherits="Group6_Lab4.GUI.Return" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">

        .auto-style2 {
            height: 23px;
        }
        .auto-style3 {
            margin-left: 0px;
        }
        .auto-style5 {
            height: 23px;
            width: 319px;
        }
        .auto-style6 {
            width: 319px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <asp:Label ID="Label2" runat="server" Font-Bold="True" Font-Size="Larger" Text="Return a copy"></asp:Label>
    &nbsp;
    <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
    <br />
<table style="width: 100%;">
    <tr>
        <td class="auto-style2">Borrower number:</td>
        <td class="auto-style2">
            <asp:TextBox ID="txtBorrowerNumber" runat="server" Width="170px"></asp:TextBox>
            <asp:Button ID="btnMember" runat="server" CssClass="auto-style3" Text="Check member" Width="203px" OnClick="btnMember_Click" />
        </td>
        <td class="auto-style2">&nbsp;</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>
            <asp:TextBox ID="txtName" runat="server" Width="166px"></asp:TextBox>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
</table>
        The number of borrower copies:
        <asp:Label ID="lblNumOfBorCopies" runat="server">0</asp:Label>
    <br />
    <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True">
        <SelectedRowStyle BackColor="#FFCC00" />
    </asp:GridView>
<br />Return date:<table style="width:100%;">
            <div class="auto-style4">
                <tr>
                    <td class="auto-style5">
                        <asp:Calendar ID="Calendar1" runat="server" Width="400px" BackColor="White" BorderColor="Black" DayNameFormat="Shortest" Font-Names="Times New Roman" Font-Size="10pt" ForeColor="Black" Height="220px" NextPrevFormat="FullMonth" TitleFormat="Month">
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
                    <td class="auto-style2"></td>
    </tr>
    <tr>
        <td class="auto-style6">Fine amount:</td>
        <td>
            <asp:TextBox ID="txtFineAmount" runat="server"></asp:TextBox>
        </td>
                </div>
            </tr>
</table>
<asp:Button ID="btnFine" runat="server" Text="Confirm fine" OnClick="btnFine_Click" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnReturn" runat="server" Text="Return" OnClick="btnReturn_Click" />
</asp:Content>
