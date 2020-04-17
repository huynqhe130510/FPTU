<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="User_Manage.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>

            <asp:GridView ID="grUser" runat="server"  DataKeyNames="id" AutoGenerateColumns="False" EnableModelValidation="True" ForeColor="#333333" GridLines="None" OnPageIndexChanging="grUser_PageIndexChanging">
                <AlternatingRowStyle BackColor="White" />
                <EditRowStyle BackColor="#2461BF" />
                <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#EFF3FB" />
                <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />


                <Columns>


                    <asp:TemplateField HeaderText="Information">
                        <ItemTemplate>
                            <table>

                                <tr>
                                    <td>
                                        <asp:Image ID="Image1" runat="server" ImageUrl='<%# Bind("avatar") %>' Width="100px" Height="100px" /></td>
                                    <td>Name:
                                        <asp:Label ID="lblName" runat="server" Text='<%# Bind("name") %>'></asp:Label><br>
                                        Gender:
                                        <asp:Label ID="lblgender" runat="server" Text='<%# ((bool)Eval("gender")) ? "Female" : "Male" %>'></asp:Label><br>
                                        DOB: 
                                        <asp:Label ID="lbldob" runat="server" Text='<%# Eval("dob", "{0:dd - MMM - yyyy}") %>'></asp:Label><br>
                                        <asp:Button ID="btnDelete" runat="server" Text="Delete" OnClick="BtnDelete_Click"></asp:Button>
                                    </td>

                                </tr>
                            </table>
                        </ItemTemplate>
                    </asp:TemplateField>

                </Columns>

            </asp:GridView>
        </div>
    </form>
</body>
</html>
