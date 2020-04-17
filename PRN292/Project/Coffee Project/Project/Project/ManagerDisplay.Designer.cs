namespace Project
{
    partial class ManagerDisplay
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ManagerDisplay));
            this.btSale = new System.Windows.Forms.Button();
            this.btStaffManager = new System.Windows.Forms.Button();
            this.btMenuManager = new System.Windows.Forms.Button();
            this.btReport = new System.Windows.Forms.Button();
            this.lbDate = new System.Windows.Forms.Label();
            this.lbTime = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.btProfile = new System.Windows.Forms.Button();
            this.btLogout = new System.Windows.Forms.Button();
            this.panel3 = new System.Windows.Forms.Panel();
            this.label8 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // btSale
            // 
            this.btSale.BackColor = System.Drawing.Color.DarkRed;
            this.btSale.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btSale.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btSale.Location = new System.Drawing.Point(352, 357);
            this.btSale.Name = "btSale";
            this.btSale.Size = new System.Drawing.Size(247, 103);
            this.btSale.TabIndex = 0;
            this.btSale.Text = "Sale";
            this.btSale.UseVisualStyleBackColor = false;
            this.btSale.Click += new System.EventHandler(this.btSale_Click);
            // 
            // btStaffManager
            // 
            this.btStaffManager.BackColor = System.Drawing.Color.DarkRed;
            this.btStaffManager.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btStaffManager.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btStaffManager.Location = new System.Drawing.Point(772, 357);
            this.btStaffManager.Name = "btStaffManager";
            this.btStaffManager.Size = new System.Drawing.Size(257, 103);
            this.btStaffManager.TabIndex = 1;
            this.btStaffManager.Text = "Staff Manager";
            this.btStaffManager.UseVisualStyleBackColor = false;
            this.btStaffManager.Click += new System.EventHandler(this.btStaffManager_Click);
            // 
            // btMenuManager
            // 
            this.btMenuManager.BackColor = System.Drawing.Color.DarkRed;
            this.btMenuManager.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btMenuManager.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btMenuManager.Location = new System.Drawing.Point(352, 529);
            this.btMenuManager.Name = "btMenuManager";
            this.btMenuManager.Size = new System.Drawing.Size(247, 103);
            this.btMenuManager.TabIndex = 2;
            this.btMenuManager.Text = "Menu Manager";
            this.btMenuManager.UseVisualStyleBackColor = false;
            this.btMenuManager.Click += new System.EventHandler(this.btMenuManager_Click);
            // 
            // btReport
            // 
            this.btReport.BackColor = System.Drawing.Color.DarkRed;
            this.btReport.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btReport.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btReport.Location = new System.Drawing.Point(772, 529);
            this.btReport.Name = "btReport";
            this.btReport.Size = new System.Drawing.Size(257, 103);
            this.btReport.TabIndex = 3;
            this.btReport.Text = "Report";
            this.btReport.UseVisualStyleBackColor = false;
            this.btReport.Click += new System.EventHandler(this.btReport_Click);
            // 
            // lbDate
            // 
            this.lbDate.AutoSize = true;
            this.lbDate.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbDate.ForeColor = System.Drawing.Color.DarkRed;
            this.lbDate.Location = new System.Drawing.Point(1556, 110);
            this.lbDate.Name = "lbDate";
            this.lbDate.Size = new System.Drawing.Size(57, 20);
            this.lbDate.TabIndex = 41;
            this.lbDate.Text = "label1";
            // 
            // lbTime
            // 
            this.lbTime.AutoSize = true;
            this.lbTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbTime.ForeColor = System.Drawing.Color.DarkRed;
            this.lbTime.Location = new System.Drawing.Point(1390, 110);
            this.lbTime.Name = "lbTime";
            this.lbTime.Size = new System.Drawing.Size(57, 20);
            this.lbTime.TabIndex = 40;
            this.lbTime.Text = "label1";
            this.lbTime.Click += new System.EventHandler(this.lbTime_Click);
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // btProfile
            // 
            this.btProfile.BackColor = System.Drawing.Color.DarkRed;
            this.btProfile.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btProfile.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btProfile.Location = new System.Drawing.Point(1215, 357);
            this.btProfile.Name = "btProfile";
            this.btProfile.Size = new System.Drawing.Size(249, 103);
            this.btProfile.TabIndex = 42;
            this.btProfile.Text = "Profile";
            this.btProfile.UseVisualStyleBackColor = false;
            this.btProfile.Click += new System.EventHandler(this.btProfile_Click);
            // 
            // btLogout
            // 
            this.btLogout.BackColor = System.Drawing.Color.DarkRed;
            this.btLogout.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btLogout.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btLogout.Location = new System.Drawing.Point(1215, 529);
            this.btLogout.Name = "btLogout";
            this.btLogout.Size = new System.Drawing.Size(249, 103);
            this.btLogout.TabIndex = 43;
            this.btLogout.Text = "Logout";
            this.btLogout.UseVisualStyleBackColor = false;
            this.btLogout.Click += new System.EventHandler(this.btLogout_Click);
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.DarkRed;
            this.panel3.Controls.Add(this.label8);
            this.panel3.Controls.Add(this.pictureBox1);
            this.panel3.Location = new System.Drawing.Point(39, 15);
            this.panel3.Margin = new System.Windows.Forms.Padding(2);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(98, 116);
            this.panel3.TabIndex = 45;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label8.Location = new System.Drawing.Point(24, 84);
            this.label8.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(0, 20);
            this.label8.TabIndex = 1;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(14, 10);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(75, 81);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.DarkRed;
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.panel2.Location = new System.Drawing.Point(0, 0);
            this.panel2.Margin = new System.Windows.Forms.Padding(2);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(1924, 15);
            this.panel2.TabIndex = 44;
            // 
            // ManagerDisplay
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1924, 1061);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.btLogout);
            this.Controls.Add(this.btProfile);
            this.Controls.Add(this.lbDate);
            this.Controls.Add(this.lbTime);
            this.Controls.Add(this.btReport);
            this.Controls.Add(this.btMenuManager);
            this.Controls.Add(this.btStaffManager);
            this.Controls.Add(this.btSale);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "ManagerDisplay";
            this.Text = "ManagerDisplay";
            this.Load += new System.EventHandler(this.ManagerDisplay_Load);
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btSale;
        private System.Windows.Forms.Button btStaffManager;
        private System.Windows.Forms.Button btMenuManager;
        private System.Windows.Forms.Button btReport;
        private System.Windows.Forms.Label lbDate;
        private System.Windows.Forms.Label lbTime;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button btProfile;
        private System.Windows.Forms.Button btLogout;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel2;
    }
}