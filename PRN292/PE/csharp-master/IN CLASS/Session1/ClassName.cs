using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class ClassName
    {
        private static int SoLop = 11;
        private string TenLop;

        public ClassName(string _TenLop) // hàm tạo ( Structor ) khai báo Public
        {
            TenLop = _TenLop;
            Console.WriteLine("Ten lop la:" + TenLop);
            SoLop++;
        }
        static ClassName() // Hàm tạo ( Structor ) được khai báo Static nên được chạy đầu tiên khi runtime
        {
            Console.WriteLine("Bat dau dang ky danh sach lop hoc ");
            SoLop = 0;
        }
        public void So_Lop_Dang_Ky()
        {
            Console.WriteLine("So lop dang ky la:" + SoLop);
        }
    }
}
