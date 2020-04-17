using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Data.DLinq;

namespace SimpleDLinqCarsApp
{
    [Table]
    public class Inventory
    {
        [Column]
        public string Make;
        [Column]
        public string Color;
        [Column]
        public string PetName;

        // Identify the primary key.
        [Column(Id = true)]
        public int CarID;

        public override string ToString()
        {
            return string.Format("ID = {0}; Make = {1}; Color = {2}; PetName = {3}",
                CarID, Make.Trim(), Color.Trim(), PetName.Trim());
        }
    }
}
