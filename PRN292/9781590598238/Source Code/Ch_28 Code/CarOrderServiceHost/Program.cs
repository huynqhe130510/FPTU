using System;
using System.Collections.Generic;
using System.Text;
using CarOrderServiceLib;
using System.ServiceModel;
using System.Configuration;

namespace CarOrderServiceHost
{
    class Program
    {
        static void Main(string[] args)
        {
            // Get the address from the *.config file.
            Uri baseAddress = new Uri(ConfigurationManager.AppSettings["baseAddress"]);

            // Create a ServiceHost, specifying the type information of the service and the base address.
            using (ServiceHost serviceHost = new ServiceHost(typeof(CarOrderService), baseAddress))
            {
                // Open the host and start listening for incoming messages.
                serviceHost.Open();

                // Just for fun.
                DisplayHostStats(serviceHost);

                // Keep the service running until Enter key is hit.
                Console.WriteLine("The service is ready.");
                Console.WriteLine("Press Enter key to terminate service.");
                Console.ReadLine();

                // Close the ServiceHostBase to shutdown the service.
                serviceHost.Close();
            }
        }

        #region Helper function to display host stats
        private static void DisplayHostStats(ServiceHost serviceHost)
        {
            Console.WriteLine("***** Stats about your host *****");
            Console.WriteLine("Open timeout: {0}", serviceHost.OpenTimeout);
            Console.WriteLine("Close timeout: {0}", serviceHost.CloseTimeout);
            Console.WriteLine();

            // Display information about the current host.
            foreach (Uri address in serviceHost.BaseAddresses)
            {
                Console.WriteLine("Absolute Uri: {0}", address.AbsoluteUri);
                Console.WriteLine("Absolute Path: {0}", address.AbsolutePath);
            }
            Console.WriteLine();
        }
        #endregion
    }
}
