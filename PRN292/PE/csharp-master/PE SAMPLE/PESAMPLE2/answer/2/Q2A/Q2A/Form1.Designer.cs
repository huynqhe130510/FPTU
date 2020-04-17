namespace Q2A
{
    partial class Form1
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
            this.lbName = new System.Windows.Forms.Label();
            this.lblClass = new System.Windows.Forms.Label();
            this.lbLaunched = new System.Windows.Forms.Label();
            this.tbName = new System.Windows.Forms.TextBox();
            this.tbLaunched = new System.Windows.Forms.TextBox();
            this.cbbClass = new System.Windows.Forms.ComboBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbName
            // 
            this.lbName.AutoSize = true;
            this.lbName.Location = new System.Drawing.Point(132, 53);
            this.lbName.Name = "lbName";
            this.lbName.Size = new System.Drawing.Size(38, 13);
            this.lbName.TabIndex = 0;
            this.lbName.Text = "Name:";
            // 
            // lblClass
            // 
            this.lblClass.AutoSize = true;
            this.lblClass.Location = new System.Drawing.Point(135, 112);
            this.lblClass.Name = "lblClass";
            this.lblClass.Size = new System.Drawing.Size(35, 13);
            this.lblClass.TabIndex = 1;
            this.lblClass.Text = "Class:";
            // 
            // lbLaunched
            // 
            this.lbLaunched.AutoSize = true;
            this.lbLaunched.Location = new System.Drawing.Point(112, 179);
            this.lbLaunched.Name = "lbLaunched";
            this.lbLaunched.Size = new System.Drawing.Size(58, 13);
            this.lbLaunched.TabIndex = 2;
            this.lbLaunched.Text = "Launched:";
            // 
            // tbName
            // 
            this.tbName.Location = new System.Drawing.Point(187, 46);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(204, 20);
            this.tbName.TabIndex = 3;
            // 
            // tbLaunched
            // 
            this.tbLaunched.Location = new System.Drawing.Point(187, 171);
            this.tbLaunched.Name = "tbLaunched";
            this.tbLaunched.Size = new System.Drawing.Size(204, 20);
            this.tbLaunched.TabIndex = 4;
            // 
            // cbbClass
            // 
            this.cbbClass.FormattingEnabled = true;
            this.cbbClass.Location = new System.Drawing.Point(187, 103);
            this.cbbClass.Name = "cbbClass";
            this.cbbClass.Size = new System.Drawing.Size(250, 21);
            this.cbbClass.TabIndex = 5;
            this.cbbClass.SelectedIndexChanged += new System.EventHandler(this.cbbClass_SelectedIndexChanged);
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(187, 236);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 6;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(582, 356);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.cbbClass);
            this.Controls.Add(this.tbLaunched);
            this.Controls.Add(this.tbName);
            this.Controls.Add(this.lbLaunched);
            this.Controls.Add(this.lblClass);
            this.Controls.Add(this.lbName);
            this.Name = "Form1";
            this.Text = "Add a new ship";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbName;
        private System.Windows.Forms.Label lblClass;
        private System.Windows.Forms.Label lbLaunched;
        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.TextBox tbLaunched;
        private System.Windows.Forms.ComboBox cbbClass;
        private System.Windows.Forms.Button btnAdd;
    }
}

