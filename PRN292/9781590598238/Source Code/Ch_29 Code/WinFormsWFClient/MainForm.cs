using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

// Need the WF runtime!
using System.Workflow.Runtime;

// Be sure to reference our custom WF library.
using MyWorkflowLibrary;

namespace WinFormsWFClient
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void btnExecuteWorkflow_Click(object sender, EventArgs e)
        {
            // Create the WF runtime.
            WorkflowRuntime wfRuntime = new WorkflowRuntime();

            // Get an insance of our WF.
            WorkflowInstance myWorkflow = 
                wfRuntime.CreateWorkflow(typeof(SimpleExampleWorkflow));

            // Start it up!
            myWorkflow.Start();
        }
    }
}