namespace WinFormsWFClient
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnExecuteWorkflow = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnExecuteWorkflow
            // 
            this.btnExecuteWorkflow.Location = new System.Drawing.Point(13, 13);
            this.btnExecuteWorkflow.Name = "btnExecuteWorkflow";
            this.btnExecuteWorkflow.Size = new System.Drawing.Size(153, 23);
            this.btnExecuteWorkflow.TabIndex = 0;
            this.btnExecuteWorkflow.Text = "Execute Workflow";
            this.btnExecuteWorkflow.UseVisualStyleBackColor = true;
            this.btnExecuteWorkflow.Click += new System.EventHandler(this.btnExecuteWorkflow_Click);
            // 
            // MainForm
            // 
            this.ClientSize = new System.Drawing.Size(260, 73);
            this.Controls.Add(this.btnExecuteWorkflow);
            this.Name = "MainForm";
            this.Text = "Workflow Windows App";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnExecuteWorkflow;
    }
}

