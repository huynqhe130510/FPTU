<%-- 
    Document   : list
    Created on : Sep 25, 2019, 4:42:46 PM
    Author     : sonnt
--%>

<%@page import="model.Employee"%>
<%@page import="model.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>)request.getAttribute("depts");
            ArrayList<Employee> emps = (ArrayList<Employee>)request.getAttribute("emps");
            Integer did = (Integer)request.getAttribute("did");
            Integer id  = (Integer) request.getAttribute("id");
            Integer gender  = (Integer) request.getAttribute("gender");
            String name = (String) request.getAttribute("name");
            
        %>
    </head>
    <body>
        
        <form action="list" method="get" id="frm">
            id <input type="text" name="id" <%if(id !=0)%>value="<%= id%>">
            Name <input type="text" name ="name" value="<%= name%>">
            </br>
            <input type="radio" name="gender" value="1" > Male<br>
            <input type="radio" name="gender" value="0" > Female<br>
            <input type="radio" name="gender" value="2"  checked> Other
            <select name="did">
            <option value="0">---------ALL---------</option>
            <%for (Department d : depts) {
            %>
            <option <%=(d.getId()==did)?"selected":"" %> value="<%=d.getId()%>"><%=d.getName()%></option>
            <%}%>
            
            from <input type="date" name="fromm">
            
            to <input type="date" name="to">
            
            
        </select>  
        <input type="submit">
        </form>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Dob</td>
                <td>Gender</td>
                <td>Department</td>
                <td></td>
            </tr>
            <%for (Employee e : emps) {
            %>
             <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDob()%></td>
                <td>
                    <img src="img/<%=e.isGender()?"Male-Face-F5-icon.png":"browser-girl-firefox-icon.png" %>" alt=""/>
                </td>
                <td><%=e.getDept().getName()%></td>
                <td><a href="update?id=<%=e.getId()%>">Edit</a></td>
            </tr>
            <%}%>
        </table>    
        
        
    </body>
</html>
