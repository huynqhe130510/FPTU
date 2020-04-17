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

namespace XmlWebServiceWFApp
{
	public sealed partial class CallWebServiceWF : SequentialWorkflowActivity
	{
        private int xVal, yVal;

        public int Y
        {
            get { return yVal; }
            set { yVal = value; }
        }

        public int X
        {
            get { return xVal; }
            set { xVal = value; }
        }

		public CallWebServiceWF()
		{
			InitializeComponent();
		}

        private void GetDataToAdd(object sender, EventArgs e)
        {
            // For simplicity, we are not bothering to verify
            // the input values are indeed numerical. 
            Console.Write("Enter first number: ");
            X = int.Parse(Console.ReadLine());
            Console.Write("Enter second number: ");
            Y = int.Parse(Console.ReadLine());
        }

        public static DependencyProperty ResultProperty = DependencyProperty.Register("Result", typeof(System.Int32), typeof(XmlWebServiceWFApp.CallWebServiceWF));

        [DesignerSerializationVisibilityAttribute(DesignerSerializationVisibility.Visible)]
        [BrowsableAttribute(true)]
        [CategoryAttribute("Parameters")]
        public Int32 Result
        {
            get
            {
                return ((int)(base.GetValue(XmlWebServiceWFApp.CallWebServiceWF.ResultProperty)));
            }
            set
            {
                base.SetValue(XmlWebServiceWFApp.CallWebServiceWF.ResultProperty, value);
            }
        }

        private void DisplayResult(object sender, EventArgs e)
        {
            Console.WriteLine("{0} + {1} = {2}", X, Y, Result);
        }

        private void GreaterCode(object sender, EventArgs e)
        {
            Console.WriteLine("Your sum is greater than 20.");
        }

        private void LesserCode(object sender, EventArgs e)
        {
            Console.WriteLine("Your sum is less than 20.");
        }

        private void CheckValue(object sender, ConditionalEventArgs e)
        {
            e.Result = Result > 20;
        }
	}
}
