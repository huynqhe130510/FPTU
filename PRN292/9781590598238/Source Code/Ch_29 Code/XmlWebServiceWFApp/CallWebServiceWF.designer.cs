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

namespace XmlWebServiceWFApp
{
	partial class CallWebServiceWF
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
            System.Workflow.Activities.CodeCondition codecondition1 = new System.Workflow.Activities.CodeCondition();
            System.Workflow.ComponentModel.ActivityBind activitybind1 = new System.Workflow.ComponentModel.ActivityBind();
            System.Workflow.ComponentModel.WorkflowParameterBinding workflowparameterbinding1 = new System.Workflow.ComponentModel.WorkflowParameterBinding();
            System.Workflow.ComponentModel.ActivityBind activitybind2 = new System.Workflow.ComponentModel.ActivityBind();
            System.Workflow.ComponentModel.WorkflowParameterBinding workflowparameterbinding2 = new System.Workflow.ComponentModel.WorkflowParameterBinding();
            System.Workflow.ComponentModel.ActivityBind activitybind3 = new System.Workflow.ComponentModel.ActivityBind();
            System.Workflow.ComponentModel.WorkflowParameterBinding workflowparameterbinding3 = new System.Workflow.ComponentModel.WorkflowParameterBinding();
            this.LessCodeActivity = new System.Workflow.Activities.CodeActivity();
            this.GreaterCodeActivity = new System.Workflow.Activities.CodeActivity();
            this.NotGreaterThan20 = new System.Workflow.Activities.IfElseBranchActivity();
            this.GreaterThan20 = new System.Workflow.Activities.IfElseBranchActivity();
            this.GreaterThan20Activity = new System.Workflow.Activities.IfElseActivity();
            this.ShowResultActivity = new System.Workflow.Activities.CodeActivity();
            this.invokeSimpleWebServiceActivity = new System.Workflow.Activities.InvokeWebServiceActivity();
            this.GetDataToAddActivity = new System.Workflow.Activities.CodeActivity();
            // 
            // LessCodeActivity
            // 
            this.LessCodeActivity.Name = "LessCodeActivity";
            this.LessCodeActivity.ExecuteCode += new System.EventHandler(this.LesserCode);
            // 
            // GreaterCodeActivity
            // 
            this.GreaterCodeActivity.Name = "GreaterCodeActivity";
            this.GreaterCodeActivity.ExecuteCode += new System.EventHandler(this.GreaterCode);
            // 
            // NotGreaterThan20
            // 
            this.NotGreaterThan20.Activities.Add(this.LessCodeActivity);
            this.NotGreaterThan20.Name = "NotGreaterThan20";
            // 
            // GreaterThan20
            // 
            this.GreaterThan20.Activities.Add(this.GreaterCodeActivity);
            codecondition1.Condition += new System.EventHandler<System.Workflow.Activities.ConditionalEventArgs>(this.CheckValue);
            this.GreaterThan20.Condition = codecondition1;
            this.GreaterThan20.Name = "GreaterThan20";
            // 
            // GreaterThan20Activity
            // 
            this.GreaterThan20Activity.Activities.Add(this.GreaterThan20);
            this.GreaterThan20Activity.Activities.Add(this.NotGreaterThan20);
            this.GreaterThan20Activity.Name = "GreaterThan20Activity";
            // 
            // ShowResultActivity
            // 
            this.ShowResultActivity.Name = "ShowResultActivity";
            this.ShowResultActivity.ExecuteCode += new System.EventHandler(this.DisplayResult);
            // 
            // invokeSimpleWebServiceActivity
            // 
            this.invokeSimpleWebServiceActivity.MethodName = "Add";
            this.invokeSimpleWebServiceActivity.Name = "invokeSimpleWebServiceActivity";
            activitybind1.Name = "CallWebServiceWF";
            activitybind1.Path = "X";
            workflowparameterbinding1.ParameterName = "x";
            workflowparameterbinding1.SetBinding(System.Workflow.ComponentModel.WorkflowParameterBinding.ValueProperty, ((System.Workflow.ComponentModel.ActivityBind)(activitybind1)));
            activitybind2.Name = "CallWebServiceWF";
            activitybind2.Path = "Y";
            workflowparameterbinding2.ParameterName = "y";
            workflowparameterbinding2.SetBinding(System.Workflow.ComponentModel.WorkflowParameterBinding.ValueProperty, ((System.Workflow.ComponentModel.ActivityBind)(activitybind2)));
            activitybind3.Name = "CallWebServiceWF";
            activitybind3.Path = "Result";
            workflowparameterbinding3.ParameterName = "(ReturnValue)";
            workflowparameterbinding3.SetBinding(System.Workflow.ComponentModel.WorkflowParameterBinding.ValueProperty, ((System.Workflow.ComponentModel.ActivityBind)(activitybind3)));
            this.invokeSimpleWebServiceActivity.ParameterBindings.Add(workflowparameterbinding1);
            this.invokeSimpleWebServiceActivity.ParameterBindings.Add(workflowparameterbinding2);
            this.invokeSimpleWebServiceActivity.ParameterBindings.Add(workflowparameterbinding3);
            this.invokeSimpleWebServiceActivity.ProxyClass = typeof(XmlWebServiceWFApp.localhost.Service);
            // 
            // GetDataToAddActivity
            // 
            this.GetDataToAddActivity.Name = "GetDataToAddActivity";
            this.GetDataToAddActivity.ExecuteCode += new System.EventHandler(this.GetDataToAdd);
            // 
            // CallWebServiceWF
            // 
            this.Activities.Add(this.GetDataToAddActivity);
            this.Activities.Add(this.invokeSimpleWebServiceActivity);
            this.Activities.Add(this.ShowResultActivity);
            this.Activities.Add(this.GreaterThan20Activity);
            this.Name = "CallWebServiceWF";
            this.CanModifyActivities = false;

		}

		#endregion

        private IfElseBranchActivity NotGreaterThan20;
        private IfElseBranchActivity GreaterThan20;
        private IfElseActivity GreaterThan20Activity;
        private CodeActivity LessCodeActivity;
        private CodeActivity GreaterCodeActivity;
        private CodeActivity ShowResultActivity;
        private InvokeWebServiceActivity invokeSimpleWebServiceActivity;
        private CodeActivity GetDataToAddActivity;















    }
}
