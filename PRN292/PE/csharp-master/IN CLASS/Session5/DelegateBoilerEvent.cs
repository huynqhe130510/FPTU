using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter8
{
    class DelegateBoilerEvent
    {
        public delegate void BoilerLogHandler(string status);

        //dinh nghia su kien dua vao delegate tren
        public event BoilerLogHandler BoilerEventLog;

        public void LogProcess()
        {
            string remarks = "OK!";
            Boiler b = new Boiler(100, 12);
            int t = b.getTemp();
            int p = b.getPressure();
            if (t > 150 || t < 80 || p < 12 || p > 15)
            {
                remarks = "Can duy tri";
            }
            OnBoilerEventLog("Thong tin log:\n");
            OnBoilerEventLog("Nhiet do: " + t + "\nAp suat: " + p);
            OnBoilerEventLog("\nThong bao: " + remarks);
        }

        protected void OnBoilerEventLog(string message)
        {
            if (BoilerEventLog != null)
            {
                BoilerEventLog(message);
            }
        }
    }
}
