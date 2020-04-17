using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DTL
{
    class User
    {
        int id;
        string username;
        string password;
        int roleId;
        int staffId;

        public User()
        {
        }

        public User(int id, string username, string password, int roleId, int staffId)
        {
            this.Id = id;
            this.Username = username;
            this.Password = password;
            this.RoleId = roleId;
            this.StaffId = staffId;
        }

        public int Id { get => id; set => id = value; }
        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public int RoleId { get => roleId; set => roleId = value; }
        public int StaffId { get => staffId; set => staffId = value; }
    }
}
