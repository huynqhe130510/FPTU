<%@ Page Title="List of books" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="BookGUI.aspx.cs" Inherits="Group6_Lab4.GUI.BookGUI" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
    <style type="text/css">
        .auto-style2 {
            width: 362px;
        }

        .auto-style5 {
            width: 120px;
        }

        .auto-style1 {
            width: 268435456px;
        }

        .auto-style3 {
            height: 21px;
            width: 120px;
        }

        .auto-style4 {
            width: 268435456px;
            height: 21px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <asp:Label ID="Label1" runat="server" Text="List of book" Font-Bold="True" Font-Size="Larger"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            <asp:Label ID="lblError" runat="server" ForeColor="Red"></asp:Label>
    <br />
    <asp:Label ID="Label3" runat="server" Text="Title"></asp:Label>
    &nbsp;&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="txtSearchTitle" runat="server"></asp:TextBox>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnFilter" runat="server" Text="Filter" Width="165px" OnClick="btnFilter_Click" />
    <br />
    <br />
    <asp:Label ID="Label4" runat="server" Text="The number of books:"></asp:Label>
    &nbsp;&nbsp;&nbsp;
            <asp:Label ID="lblNumberOfBooks" runat="server" Text="0"></asp:Label>
    <br />
    <table style="width: 100%; height: 189px;">
        <tr>
            <td class="auto-style2" rowspan="4">
                <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True" DataSourceID="ObjectDataSource1" OnDataBound="GridView1_DataBound" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" DataKeyNames="bookNumber">
                    <Columns>
                        <asp:CommandField ShowDeleteButton="True" ShowSelectButton="True" />
                    </Columns>
                    <SelectedRowStyle BackColor="#FFCC00" />
                </asp:GridView>
            </td>
            <td class="auto-style5">&nbsp;</td>
            <td class="auto-style1"></td>
        </tr>
        <tr>
            <td class="auto-style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <asp:Label ID="Label6" runat="server" Text="Title:"></asp:Label>
            </td>
            <td class="auto-style4">
                <asp:TextBox ID="txtTitle" runat="server" Width="196px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td class="auto-style5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Label ID="Label7" runat="server" Text="Authors:"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtAuthors" runat="server" Width="193px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td class="auto-style5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Label ID="Label8" runat="server" Text="Publisher:"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtPublisher" runat="server" Width="194px"></asp:TextBox>
            </td>
        </tr>
    </table>
    <asp:ObjectDataSource ID="ObjectDataSource1" runat="server" DeleteMethod="Delete" FilterExpression="title" InsertMethod="Insert" SelectMethod="GetDataTable" TypeName="Group6_Lab4.DAL.BookDAO" UpdateMethod="Update">
        <DeleteParameters>
            <asp:Parameter Name="bookNumber" Type="Int32" />
        </DeleteParameters>
        <FilterParameters>
            <asp:ControlParameter ControlID="txtSearchTitle" Name="title" PropertyName="Text" />
        </FilterParameters>
        <InsertParameters>
            <asp:Parameter Name="title" Type="String" />
            <asp:Parameter Name="authors" Type="String" />
            <asp:Parameter Name="publisher" Type="String" />
        </InsertParameters>
        <UpdateParameters>
            <asp:Parameter Name="title" Type="String" />
            <asp:Parameter Name="authors" Type="String" />
            <asp:Parameter Name="publisher" Type="String" />
            <asp:Parameter Name="bookNumber" Type="Int32" />
        </UpdateParameters>
    </asp:ObjectDataSource>
    <br />
    <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnAdd" runat="server" Text="Add" OnClick="btnAdd_Click" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnEdit" runat="server" Text="Edit" OnClick="btnEdit_Click" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnCopies" runat="server" Text="Copies" OnClick="btnCopies_Click" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnCancel" runat="server" Text="Cancel" />
</asp:Content>
