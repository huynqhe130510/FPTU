using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Chapter16
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***** Fun with Directory(Info) *****\n");
            DirectoryInfo dir = new DirectoryInfo(@"D:\My Project");
            // Dump directory information.
            Console.WriteLine("***** Directory Info *****");
            Console.WriteLine("FullName: {0} ", dir.FullName);
            Console.WriteLine("Name: {0} ", dir.Name);
            Console.WriteLine("Parent: {0} ", dir.Parent);
            Console.WriteLine("Creation: {0} ", dir.CreationTime);
            Console.WriteLine("Attributes: {0} ", dir.Attributes);
            Console.WriteLine("Root: {0} ", dir.Root);
            Console.WriteLine("**************************\n");
            Console.ReadLine();
            
            // kiem tra file
            string filePath = "C:/test/test.txt";

            // Kiểm tra đường dẫn này có tồn tại hay không?
            if (File.Exists(filePath))
            {
                // Xóa file
                File.Delete(filePath);

                // Kiểm tra lại xem file còn tồn tại không.
                if (!File.Exists(filePath))
                {
                    Console.WriteLine("File deleted...");
                }

            }
            else
            {
                Console.WriteLine("File test.txt does not yet exist!");
            }

            Console.ReadKey();
            // rename
            if (File.Exists(filePath))
            {
                Console.WriteLine(filePath + " exist");
                Console.WriteLine("Please enter a new name for this file:");
                // Một String mà người dùng nhập vào.
                // Ví dụ: C:/test/test2.txt
                string newFilename = Console.ReadLine();
                if (newFilename != String.Empty)
                {
                    // Đổi tên file:
                    // Có thể bao gồm, chuyển file tới một thư mục cha khác, và đổi tên file. 
                    // Phải đảm bảo rằng thư mục cha mới tồn tại.
                    // (nếu không ngoại lệ DirectoryNotFoundException sẽ được ném ra).
                    File.Move(filePath, newFilename);
                    if (File.Exists(newFilename))
                    {
                        Console.WriteLine("The file was renamed to " + newFilename);
                    }
                }
            }
            else
            {
                Console.WriteLine("Path " + filePath + " does not exist.");
            }

            Console.ReadLine();

            String dirPath = "C:/test/CSharp";

            // Kiểm tra xem đường dẫn thư mục tồn tại không.
            bool exist = Directory.Exists(dirPath);

            // Nếu không tồn tại, tạo thư mục này.
            if (!exist)
            {
                Console.WriteLine(dirPath + " does not exist.");
                Console.WriteLine("Create directory: " + dirPath);

                // Tạo thư mục.
                Directory.CreateDirectory(dirPath);
            }

            Console.WriteLine("Directory Information " + dirPath);

            // In ra các thông tin thư mục trên. 
            // Thời điểm tạo thư mục.
            Console.WriteLine("Creation time: " + Directory.GetCreationTime(dirPath));

            // Thời điểm cuối cùng thư mục có sự thay đổi.
            Console.WriteLine("Last Write Time: " + Directory.GetLastWriteTime(dirPath));

            // Thư mục cha.
            DirectoryInfo parentInfo = Directory.GetParent(dirPath);

            Console.WriteLine("Parent directory: " + parentInfo.FullName);


            Console.Read();

            // Nếu đường dẫn này tồn tại.
            if (!Directory.Exists(dirPath))
            {
                Console.WriteLine(dirPath + " does not exist.");
                Console.Read();

                return;
            }

            Console.WriteLine(dirPath + " exist");


            Console.WriteLine("Please enter a new name for this directory:");
            Console.ReadLine();
            // String mà người dùng nhập vào.
            // Ví dụ: C:/test2/Java
            string newDirname = Console.ReadLine();

            if (newDirname == String.Empty)
            {
                Console.WriteLine("You not enter new directory name. Cancel rename.");
                Console.Read();

                return;
            }

            // Nếu đường dẫn mà người dùng nhập vào là tồn tại. 
            if (Directory.Exists(newDirname))
            {
                Console.WriteLine("Cannot rename directory. New directory already exist.");
                Console.Read();

                return;
            }

            // Thư mục cha.
           // DirectoryInfo parentInfo = Directory.GetParent(newDirname);

            // Tạo thư mục cha của thư mục mà người dùng nhập vào.
            Directory.CreateDirectory(parentInfo.FullName);
            Console.ReadLine();

            // Bạn có thể đổi đường dẫn (path) của một thư mục.
            // nhưng phải đảm bảo đường dẫn cha của đường dẫn mới phải tồn tại.
            // (Nếu không ngoại lệ DirectoryNotFoundException sẽ được ném ra).
            Directory.Move(dirPath, newDirname);

            if (Directory.Exists(newDirname))
            {
                Console.WriteLine("The directory was renamed to " + newDirname);
            }


            Console.ReadLine();
        }
    }
}
