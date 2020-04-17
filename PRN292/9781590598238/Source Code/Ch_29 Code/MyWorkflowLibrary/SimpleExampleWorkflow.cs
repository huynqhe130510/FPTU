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

namespace MyWorkflowLibrary
{
    public sealed partial class SimpleExampleWorkflow : SequentialWorkflowActivity
	{
        public SimpleExampleWorkflow()
		{
			InitializeComponent();
		}

        private void ShowMessage(object sender, EventArgs e)
        {
            System.Windows.Forms.MessageBox.Show("Success!");
        }

        private void ShowEndMessage(object sender, EventArgs e)
        {
            System.Windows.Forms.MessageBox.Show("Time up!");
        }
	}

}
