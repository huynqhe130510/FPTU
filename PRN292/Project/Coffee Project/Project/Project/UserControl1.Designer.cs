namespace Project
{
    partial class usEmployee
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lbSalary = new System.Windows.Forms.Label();
            this.lbPos = new System.Windows.Forms.Label();
            this.lbPhone = new System.Windows.Forms.Label();
            this.lbName = new System.Windows.Forms.Label();
            this.lbID = new System.Windows.Forms.Label();
            this.pbAvatar = new System.Windows.Forms.PictureBox();
            this.tbID = new System.Windows.Forms.TextBox();
            this.tbName = new System.Windows.Forms.TextBox();
            this.tbPhone = new System.Windows.Forms.TextBox();
            this.tbSalary = new System.Windows.Forms.TextBox();
            this.btUpdataInfo = new System.Windows.Forms.Button();
            this.btViewInfo = new System.Windows.Forms.Button();
            this.cbRole = new System.Windows.Forms.ComboBox();
            this.tbRole = new System.Windows.Forms.TextBox();
            this.btDelete = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pbAvatar)).BeginInit();
            this.SuspendLayout();
            // 
            // lbSalary
            // 
            this.lbSalary.AutoSize = true;
            this.lbSalary.Location = new System.Drawing.Point(2, 270);
            this.lbSalary.Name = "lbSalary";
            this.lbSalary.Size = new System.Drawing.Size(36, 13);
            this.lbSalary.TabIndex = 13;
            this.lbSalary.Text = "Salary";
            // 
            // lbPos
            // 
            this.lbPos.AutoSize = true;
            this.lbPos.Location = new System.Drawing.Point(3, 244);
            this.lbPos.Name = "lbPos";
            this.lbPos.Size = new System.Drawing.Size(29, 13);
            this.lbPos.TabIndex = 11;
            this.lbPos.Text = "Role";
            this.lbPos.Click += new System.EventHandler(this.lbPos_Click);
            // 
            // lbPhone
            // 
            this.lbPhone.AutoSize = true;
            this.lbPhone.Location = new System.Drawing.Point(3, 218);
            this.lbPhone.Name = "lbPhone";
            this.lbPhone.Size = new System.Drawing.Size(38, 13);
            this.lbPhone.TabIndex = 10;
            this.lbPhone.Text = "Phone";
            // 
            // lbName
            // 
            this.lbName.AutoSize = true;
            this.lbName.Location = new System.Drawing.Point(3, 192);
            this.lbName.Name = "lbName";
            this.lbName.Size = new System.Drawing.Size(35, 13);
            this.lbName.TabIndex = 9;
            this.lbName.Text = "Name";
            // 
            // lbID
            // 
            this.lbID.AutoSize = true;
            this.lbID.Location = new System.Drawing.Point(3, 166);
            this.lbID.Name = "lbID";
            this.lbID.Size = new System.Drawing.Size(18, 13);
            this.lbID.TabIndex = 8;
            this.lbID.Text = "ID";
            // 
            // pbAvatar
            // 
            this.pbAvatar.Location = new System.Drawing.Point(25, 3);
            this.pbAvatar.Name = "pbAvatar";
            this.pbAvatar.Size = new System.Drawing.Size(150, 150);
            this.pbAvatar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbAvatar.TabIndex = 7;
            this.pbAvatar.TabStop = false;
            // 
            // tbID
            // 
            this.tbID.Location = new System.Drawing.Point(44, 163);
            this.tbID.Name = "tbID";
            this.tbID.ReadOnly = true;
            this.tbID.Size = new System.Drawing.Size(56, 20);
            this.tbID.TabIndex = 14;
            this.tbID.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // tbName
            // 
            this.tbName.Location = new System.Drawing.Point(44, 189);
            this.tbName.Name = "tbName";
            this.tbName.ReadOnly = true;
            this.tbName.Size = new System.Drawing.Size(144, 20);
            this.tbName.TabIndex = 15;
            // 
            // tbPhone
            // 
            this.tbPhone.Location = new System.Drawing.Point(44, 215);
            this.tbPhone.Name = "tbPhone";
            this.tbPhone.ReadOnly = true;
            this.tbPhone.Size = new System.Drawing.Size(144, 20);
            this.tbPhone.TabIndex = 16;
            // 
            // tbSalary
            // 
            this.tbSalary.Location = new System.Drawing.Point(44, 267);
            this.tbSalary.Name = "tbSalary";
            this.tbSalary.ReadOnly = true;
            this.tbSalary.Size = new System.Drawing.Size(144, 20);
            this.tbSalary.TabIndex = 18;
            // 
            // btUpdataInfo
            // 
            this.btUpdataInfo.Location = new System.Drawing.Point(70, 293);
            this.btUpdataInfo.Name = "btUpdataInfo";
            this.btUpdataInfo.Size = new System.Drawing.Size(60, 23);
            this.btUpdataInfo.TabIndex = 20;
            this.btUpdataInfo.Text = "Update";
            this.btUpdataInfo.UseVisualStyleBackColor = true;
            this.btUpdataInfo.Click += new System.EventHandler(this.btUpdataInfo_Click);
            // 
            // btViewInfo
            // 
            this.btViewInfo.Location = new System.Drawing.Point(3, 293);
            this.btViewInfo.Name = "btViewInfo";
            this.btViewInfo.Size = new System.Drawing.Size(60, 23);
            this.btViewInfo.TabIndex = 21;
            this.btViewInfo.Text = "View";
            this.btViewInfo.UseVisualStyleBackColor = true;
            this.btViewInfo.Click += new System.EventHandler(this.btViewInfo_Click);
            // 
            // cbRole
            // 
            this.cbRole.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbRole.FormattingEnabled = true;
            this.cbRole.Items.AddRange(new object[] {
            "MANAGER",
            "STAFF"});
            this.cbRole.Location = new System.Drawing.Point(44, 241);
            this.cbRole.Name = "cbRole";
            this.cbRole.Size = new System.Drawing.Size(144, 21);
            this.cbRole.TabIndex = 22;
            // 
            // tbRole
            // 
            this.tbRole.Location = new System.Drawing.Point(44, 241);
            this.tbRole.Name = "tbRole";
            this.tbRole.ReadOnly = true;
            this.tbRole.Size = new System.Drawing.Size(144, 20);
            this.tbRole.TabIndex = 23;
            // 
            // btDelete
            // 
            this.btDelete.ForeColor = System.Drawing.Color.Red;
            this.btDelete.Location = new System.Drawing.Point(137, 293);
            this.btDelete.Name = "btDelete";
            this.btDelete.Size = new System.Drawing.Size(60, 23);
            this.btDelete.TabIndex = 24;
            this.btDelete.Text = "Delete";
            this.btDelete.UseVisualStyleBackColor = true;
            this.btDelete.Click += new System.EventHandler(this.btDelete_Click);
            // 
            // usEmployee
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.btDelete);
            this.Controls.Add(this.tbRole);
            this.Controls.Add(this.cbRole);
            this.Controls.Add(this.btViewInfo);
            this.Controls.Add(this.btUpdataInfo);
            this.Controls.Add(this.tbSalary);
            this.Controls.Add(this.tbPhone);
            this.Controls.Add(this.tbName);
            this.Controls.Add(this.tbID);
            this.Controls.Add(this.lbSalary);
            this.Controls.Add(this.lbPos);
            this.Controls.Add(this.lbPhone);
            this.Controls.Add(this.lbName);
            this.Controls.Add(this.lbID);
            this.Controls.Add(this.pbAvatar);
            this.Name = "usEmployee";
            this.Size = new System.Drawing.Size(200, 320);
            this.Load += new System.EventHandler(this.usEmployee_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pbAvatar)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbSalary;
        private System.Windows.Forms.Label lbPos;
        private System.Windows.Forms.Label lbPhone;
        private System.Windows.Forms.Label lbName;
        private System.Windows.Forms.Label lbID;
        private System.Windows.Forms.PictureBox pbAvatar;
        private System.Windows.Forms.TextBox tbID;
        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.TextBox tbPhone;
        private System.Windows.Forms.TextBox tbSalary;
        private System.Windows.Forms.Button btUpdataInfo;
        private System.Windows.Forms.Button btViewInfo;
        private System.Windows.Forms.ComboBox cbRole;
        private System.Windows.Forms.TextBox tbRole;
        private System.Windows.Forms.Button btDelete;
    }
}
