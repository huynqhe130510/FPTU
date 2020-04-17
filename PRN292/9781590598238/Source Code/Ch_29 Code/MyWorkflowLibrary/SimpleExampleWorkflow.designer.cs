using System;
using System.ComponentModel;
using System.ComponentModel.Design;
using System.Collections;
using System.Drawing;
using System.Reflection;
using System.Workflow.ComponentModel.Compiler;
using System.Workflow.ComponentModel.Serialization;
using System.Workflow.ComponentModel;
using System.Workflow.ComponentModel.Design;
using System.Workflow.Runtime;
using System.Workflow.Activities;
using System.Workflow.Activities.Rules;

namespace MyWorkflowLibrary
{
    partial class SimpleExampleWorkflow
	{
		#region Designer generated code
		
		/// <summary> 
		/// Required method for Designer support - do not modify 
		/// the contents of this method with the code editor.
		/// </summary>
        [System.Diagnostics.DebuggerNonUserCode]
		private void InitializeComponent()
		{
            this.CanModifyActivities = true;
            this.ShowEndActivity = new System.Workflow.Activities.CodeActivity();
            this.DelayActivity = new System.Workflow.Activities.DelayActivity();
            this.ShowMessageActivity = new System.Workflow.Activities.CodeActivity();
            // 
            // ShowEndActivity
            // 
            this.ShowEndActivity.Name = "ShowEndActivity";
            this.ShowEndActivity.ExecuteCode += new System.EventHandler(this.ShowEndMessage);
            // 
            // DelayActivity
            // 
            this.DelayActivity.Name = "DelayActivity";
            this.DelayActivity.TimeoutDuration = System.TimeSpan.Parse("00:00:10");
            // 
            // ShowMessageActivity
            // 
            this.ShowMessageActivity.Name = "ShowMessageActivity";
            this.ShowMessageActivity.ExecuteCode += new System.EventHandler(this.ShowMessage);
            // 
            // SimpleExampleWorkflow
            // 
            this.Activities.Add(this.ShowMessageActivity);
            this.Activities.Add(this.DelayActivity);
            this.Activities.Add(this.ShowEndActivity);
            this.Name = "SimpleExampleWorkflow";
            this.CanModifyActivities = false;

		}

		#endregion

        private CodeActivity ShowEndActivity;
        private DelayActivity DelayActivity;
        private CodeActivity ShowMessageActivity;





    }
}
