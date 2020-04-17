using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Q3.DTL
{
    public class Project
    {
        int id;
        string name;

        public Project()
        {
        }

        public Project(int id, string name)
        {
            this.Id = id;
            this.Name = name;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
    }
}