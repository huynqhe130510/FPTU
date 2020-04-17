#region Using directives

using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;
using System.Workflow.Runtime;
using System.Workflow.Runtime.Hosting;

#endregion

namespace UserDataWFApp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Ensure the runtime shuts down when we are finished. 
            using (WorkflowRuntime workflowRuntime = new WorkflowRuntime())
            {
                AutoResetEvent waitHandle = new AutoResetEvent(false);

                #region Events for the runtime engine.
                // Handle events which capture when the engine completes
                // the workflow process and if the engine shuts down with error.
                workflowRuntime.WorkflowCompleted
                  += delegate(object sender, WorkflowCompletedEventArgs e)
                {
                    waitHandle.Set();
                };
                workflowRuntime.WorkflowTerminated
                  += delegate(object sender, WorkflowTerminatedEventArgs e)
                {
                    Console.WriteLine(e.Exception.Message);
                    waitHandle.Set();
                };
                #endregion

                #region Define the custom parameters for our workflow.
                // Define two parameters for use by our workflow.
                // Remember!  These must be mapped to identically named
                // properties in our workflow class type. 
                Dictionary<string, object> parameters = new Dictionary<string, object>();
                parameters.Add("ErrorMessage", "Ack!  Your name is too long!");
                parameters.Add("NameLength", 5);
                #endregion

                // Now, create a WF instance that represents our type,
                // and pass in the Dictionary object.
                WorkflowInstance instance =
                    workflowRuntime.CreateWorkflow(typeof(UserDataWFApp.ProcessUsernameWorkflow), parameters);
                instance.Start();

                waitHandle.WaitOne();
            }
        }
    }
}
