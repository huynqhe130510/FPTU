using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace FirstWS_01
{
    /// <summary>
    /// Summary description for ExchangeVNDtoUSD
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ExchangeVNDtoUSD : System.Web.Services.WebService
    {
        double USD_RATE = 23000;

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }
        [WebMethod]

        public double VND2USD(double dong)

        {

            return dong / USD_RATE;

        }
    }
}
