using System;
using System.ComponentModel;
using System.ComponentModel.Design;
using System.Collections;
using System.Drawing;
using System.Workflow.ComponentModel.Compiler;
using System.Workflow.ComponentModel.Serialization;
using System.Workflow.ComponentModel;
using System.Workflow.ComponentModel.Design;
using System.Workflow.Runtime;
using System.Workflow.Activities;
using System.Workflow.Activities.Rules;

namespace UserDataWFApp
{
	public sealed partial class ProcessUsernameWorkflow: SequentialWorkflowActivity
    {
        #region Properties and backing fields.
        private string userName = String.Empty;
        private string errorMsg;
        private int nameLength;

        public string UserName
        {
            get { return userName; }
            set { userName = value; }
        }
        public string ErrorMessage
        {
            get { return errorMsg; }
            set { errorMsg = value; }
        }
        public int NameLength
        {
            get { return nameLength; }
            set { nameLength = value; }
        }
        #endregion

        public ProcessUsernameWorkflow()
        {
            InitializeComponent();
        }

        private void GetAndValidateUserName(object sender, ConditionalEventArgs e)
        {
            Console.Write("Please enter name, which much be less than {0} chars: ", NameLength);
            userName = Console.ReadLine();
            
            // See if name is correct length, and set the result. 
            e.Result = (userName.Length > NameLength);
        }

        private void NameNotValid(object sender, EventArgs e)
        {
            Console.WriteLine(ErrorMessage);
        }

        private void ShowInstructions(object sender, EventArgs e)
        {
            ConsoleColor previousColor = Console.ForegroundColor;
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("*******************************************");
            Console.WriteLine("***** Welcome to the first WF Example *****");
            Console.WriteLine("*******************************************");
            Console.WriteLine("\nI will now ask for your name and validate the data...\n");
            Console.ForegroundColor = previousColor;
        }
	}
}
