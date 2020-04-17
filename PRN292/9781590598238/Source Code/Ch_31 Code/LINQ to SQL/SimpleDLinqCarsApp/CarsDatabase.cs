using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Data.DLinq;

namespace SimpleDLinqCarsApp
{
    class CarsDatabase : DataContext
    {
        public Table<Inventory> Inventory;

        public CarsDatabase(string connectionString)
            : base(connectionString){}
    }
}
