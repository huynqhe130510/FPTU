using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter8
{

    class MyEvent
    {

        public Button openButton;
        public Button saveButton;
        private string fileName;

        // Mô phỏng một ứng dụng và có các Button.
        public MyEvent()
        {
            // Thêm 1 Button vào giao diện.
            this.openButton = new Button("Open File");

            // Thêm 1 Button vào giao diện.
            this.saveButton = new Button("Save File");

            // Thêm một phương thức vào sự kiện của button 'Open Button'.
            // (Tính năng Multicasting của Delegate)
            this.openButton.OnButtonClick += this.OpenButtonClicked;

            // Thêm một phương thức vào sự kiện của button 'Save Button'.
            // (Tính năng Multicasting của Delegate)
            this.saveButton.OnButtonClick += this.SaveButtonClicked;
        }

        private void OpenButtonClicked(Button source, int x, int y)
        {
            // Mô phỏng mở ra một cửa sổ để chọn File để mở.
            Console.WriteLine("Open Dialog to Select a file");
            // 
            this.fileName = "File" + x + "_" + y + ".txt";
            Console.WriteLine("Openning file: " + this.fileName);
        }

        private void SaveButtonClicked(Button source, int x, int y)
        {
            if (this.fileName == null)
            {
                Console.WriteLine("No file to save!");
                return;
            }
            // Save File
            Console.WriteLine("Saved file: " + this.fileName);
        }


    }
}
