using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter8
{
    class TaxFormulas
    {
        // Một Delegate đại diện cho các hàm kiểu (float) -> (float).
        public delegate float TaxFormula(float salary);

        // Công thức tính thuế của Mỹ (10% lương).
        public static float UsaFormula(float salary)
        {
            return 10 * salary / 100;
        }

        // Công thức tính thuế của Vietnam (5% lương).
        public static float VietnamFormula(float salary)
        {
            return 5 * salary / 100;
        }

        // Công thức tính thuế mặc định (7% lương).
        public static float DefaultFormula(float salary)
        {
            return 7 * salary / 100;
        }

        // Trả về một hàm tính thuế dựa trên mã Quốc gia. (VN, USA, ..)
        public static TaxFormula GetSalaryFormula(string countryCode)
        {
            if (countryCode == "VN")
            {
                return TaxFormulas.VietnamFormula;
            }
            else if (countryCode == "USA")
            {
                return TaxFormulas.UsaFormula;
            }
            return TaxFormulas.DefaultFormula;
        } 

    }
}
