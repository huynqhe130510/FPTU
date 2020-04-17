using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Q3.DTL
{
    public class ProjectMember
    {
        int employeeId;
        int projectId;
        string position;
        bool isFullTime;
        DateTime date;

        public ProjectMember()
        {
        }

        public ProjectMember(int employeeId, int projectId, string position, bool isFullTime, DateTime date)
        {
            this.EmployeeId = employeeId;
            this.ProjectId = projectId;
            this.Position = position;
            this.IsFullTime = isFullTime;
            this.Date = date;
        }

        public int EmployeeId { get => employeeId; set => employeeId = value; }
        public int ProjectId { get => projectId; set => projectId = value; }
        public string Position { get => position; set => position = value; }
        public bool IsFullTime { get => isFullTime; set => isFullTime = value; }
        public DateTime Date { get => date; set => date = value; }
    }
}