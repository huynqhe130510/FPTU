using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter8
{
    class Program
    {
        // Định nghĩa ra một delegate
        // đại diện cho các hàm có kiểu (int, int) -> (int)
        delegate int IntIntToInt(int a, int b);


        static void Main(string[] args)
        {
            // Tạo một đối tượng delegate. 
            // Truyền (pass) vào tham số là một hàm có cùng kiểu hàm với delegate.
            IntIntToInt iiToInt = new IntIntToInt(MathUtils.sum);

            // Khi bạn thực thi một delegate.
            // Nó sẽ gọi hàm (hoặc phương thức) mà nó đại diện.
            int value = iiToInt(10, 20); // 30

            Console.WriteLine("Value = {0}", value);

            // Gán giá trị khác cho delegate.
            iiToInt = new IntIntToInt(MathUtils.multiple);

            value = iiToInt(10, 20); // 200

            Console.WriteLine("Value = {0}", value);

            Console.Read();

            // Test Tax delegate
            float salary = 1000f;

            // Công thức tính thuế theo quốc gia Việt Nam.
            TaxFormulas.TaxFormula formula = TaxFormulas.GetSalaryFormula("VN");

            float tax = formula(salary);

            Console.WriteLine("Tax in Vietnam = {0}", tax);

            // Công thức tính thuế tại Canada
            formula = TaxFormulas.GetSalaryFormula("CA");

            tax = formula(salary);

            Console.WriteLine("Tax in Canada = {0}", tax);

            Console.ReadLine();
            Console.ReadLine();

            //Test event

            // Mô phỏng mở ứng dụng
            MyEvent myApp = new MyEvent();

            Console.WriteLine("User Click on Open Button ....");

            // Mô phỏng openButton bị click
            myApp.openButton.Clicked();

            Console.WriteLine("\n\n");
            Console.WriteLine("User Click on Save Button ....");

            // Mô phỏng saveButton bị click
            myApp.saveButton.Clicked();



            Console.Read();
        }
    }
}
