using Q3.DTL;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Q3.DAL
{
    public class ProjectMemberDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["EmployeeDBConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public static DataTable getProjectMemberByProjectId(int projectId)
        {
            string cmd = "select e.name as eName, p.id as pId, e.id as eId, position, isFulltime, [date] "
                        + "from Employee e, Project p, ProjectMember pm "
                        + "where e.id = pm.employeeId and p.id = pm.projectId and p.id = " + projectId;
            return DAO.GetDataTable(cmd);
        }
        public static bool Add(ProjectMember pm)
        {
            SqlCommand cmd = new SqlCommand("insert into ProjectMember(employeeID, projectID, position, isFulltime, date)" +
                     "values (@employeeID, @projectID, @position, @isFulltime, @date)");
            cmd.Parameters.AddWithValue("@employeeID", pm.EmployeeId);
            cmd.Parameters.AddWithValue("@projectID", pm.ProjectId);
            cmd.Parameters.AddWithValue("@position", pm.Position);
            cmd.Parameters.AddWithValue("@isFulltime", pm.IsFullTime);
            cmd.Parameters.AddWithValue("@date", pm.Date);
            return DAO.UpdateTable(cmd);

        }
    }
}