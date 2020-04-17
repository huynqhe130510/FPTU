namespace Project
{
    partial class StaffManager
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(StaffManager));
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tPStaffList = new System.Windows.Forms.TabPage();
            this.flpEmployee = new System.Windows.Forms.FlowLayoutPanel();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.tPAddStaff = new System.Windows.Forms.TabPage();
            this.btReset = new System.Windows.Forms.Button();
            this.btCancel = new System.Windows.Forms.Button();
            this.btAddNew = new System.Windows.Forms.Button();
            this.dtpBD = new System.Windows.Forms.DateTimePicker();
            this.cbRole = new System.Windows.Forms.ComboBox();
            this.lbRole = new System.Windows.Forms.Label();
            this.tbPassword = new System.Windows.Forms.TextBox();
            this.tbUsername = new System.Windows.Forms.TextBox();
            this.lbPassword = new System.Windows.Forms.Label();
            this.lbUsername = new System.Windows.Forms.Label();
            this.rbFemale = new System.Windows.Forms.RadioButton();
            this.rbMale = new System.Windows.Forms.RadioButton();
            this.tbPhone = new System.Windows.Forms.TextBox();
            this.tbSalary = new System.Windows.Forms.TextBox();
            this.tbAddress = new System.Windows.Forms.TextBox();
            this.tbName = new System.Windows.Forms.TextBox();
            this.tbID = new System.Windows.Forms.TextBox();
            this.lbPhone = new System.Windows.Forms.Label();
            this.lbSalary = new System.Windows.Forms.Label();
            this.lbGender = new System.Windows.Forms.Label();
            this.lbBirthDate = new System.Windows.Forms.Label();
            this.lbAddress = new System.Windows.Forms.Label();
            this.lbName = new System.Windows.Forms.Label();
            this.lbEID = new System.Windows.Forms.Label();
            this.btUpload = new System.Windows.Forms.Button();
            this.pbAvatar = new System.Windows.Forms.PictureBox();
            this.lbDate = new System.Windows.Forms.Label();
            this.lbTime = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.btBack = new System.Windows.Forms.Button();
            this.btExit = new System.Windows.Forms.Button();
            this.panel3 = new System.Windows.Forms.Panel();
            this.label8 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.panel2 = new System.Windows.Forms.Panel();
            this.tabControl1.SuspendLayout();
            this.tPStaffList.SuspendLayout();
            this.flpEmployee.SuspendLayout();
            this.tPAddStaff.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbAvatar)).BeginInit();
            this.panel3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tPStaffList);
            this.tabControl1.Controls.Add(this.tPAddStaff);
            this.tabControl1.Location = new System.Drawing.Point(253, 217);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(1500, 690);
            this.tabControl1.TabIndex = 34;
            // 
            // tPStaffList
            // 
            this.tPStaffList.Controls.Add(this.flpEmployee);
            this.tPStaffList.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tPStaffList.Location = new System.Drawing.Point(4, 22);
            this.tPStaffList.Name = "tPStaffList";
            this.tPStaffList.Padding = new System.Windows.Forms.Padding(3);
            this.tPStaffList.Size = new System.Drawing.Size(1492, 664);
            this.tPStaffList.TabIndex = 0;
            this.tPStaffList.Text = "Staff";
            this.tPStaffList.UseVisualStyleBackColor = true;
            // 
            // flpEmployee
            // 
            this.flpEmployee.AutoScroll = true;
            this.flpEmployee.Controls.Add(this.flowLayoutPanel1);
            this.flpEmployee.Location = new System.Drawing.Point(0, 0);
            this.flpEmployee.Name = "flpEmployee";
            this.flpEmployee.Size = new System.Drawing.Size(1495, 665);
            this.flpEmployee.TabIndex = 0;
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(8, 8);
            this.flowLayoutPanel1.TabIndex = 0;
            // 
            // tPAddStaff
            // 
            this.tPAddStaff.Controls.Add(this.btReset);
            this.tPAddStaff.Controls.Add(this.btCancel);
            this.tPAddStaff.Controls.Add(this.btAddNew);
            this.tPAddStaff.Controls.Add(this.dtpBD);
            this.tPAddStaff.Controls.Add(this.cbRole);
            this.tPAddStaff.Controls.Add(this.lbRole);
            this.tPAddStaff.Controls.Add(this.tbPassword);
            this.tPAddStaff.Controls.Add(this.tbUsername);
            this.tPAddStaff.Controls.Add(this.lbPassword);
            this.tPAddStaff.Controls.Add(this.lbUsername);
            this.tPAddStaff.Controls.Add(this.rbFemale);
            this.tPAddStaff.Controls.Add(this.rbMale);
            this.tPAddStaff.Controls.Add(this.tbPhone);
            this.tPAddStaff.Controls.Add(this.tbSalary);
            this.tPAddStaff.Controls.Add(this.tbAddress);
            this.tPAddStaff.Controls.Add(this.tbName);
            this.tPAddStaff.Controls.Add(this.tbID);
            this.tPAddStaff.Controls.Add(this.lbPhone);
            this.tPAddStaff.Controls.Add(this.lbSalary);
            this.tPAddStaff.Controls.Add(this.lbGender);
            this.tPAddStaff.Controls.Add(this.lbBirthDate);
            this.tPAddStaff.Controls.Add(this.lbAddress);
            this.tPAddStaff.Controls.Add(this.lbName);
            this.tPAddStaff.Controls.Add(this.lbEID);
            this.tPAddStaff.Controls.Add(this.btUpload);
            this.tPAddStaff.Controls.Add(this.pbAvatar);
            this.tPAddStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tPAddStaff.Location = new System.Drawing.Point(4, 22);
            this.tPAddStaff.Name = "tPAddStaff";
            this.tPAddStaff.Padding = new System.Windows.Forms.Padding(3);
            this.tPAddStaff.Size = new System.Drawing.Size(1492, 664);
            this.tPAddStaff.TabIndex = 1;
            this.tPAddStaff.Text = "Add New";
            this.tPAddStaff.UseVisualStyleBackColor = true;
            this.tPAddStaff.Click += new System.EventHandler(this.tPAddStaff_Click);
            // 
            // btReset
            // 
            this.btReset.Location = new System.Drawing.Point(858, 475);
            this.btReset.Name = "btReset";
            this.btReset.Size = new System.Drawing.Size(150, 46);
            this.btReset.TabIndex = 64;
            this.btReset.Text = "Reset";
            this.btReset.UseVisualStyleBackColor = true;
            this.btReset.Click += new System.EventHandler(this.btReset_Click);
            // 
            // btCancel
            // 
            this.btCancel.Location = new System.Drawing.Point(1071, 475);
            this.btCancel.Name = "btCancel";
            this.btCancel.Size = new System.Drawing.Size(150, 46);
            this.btCancel.TabIndex = 63;
            this.btCancel.Text = "Cancel";
            this.btCancel.UseVisualStyleBackColor = true;
            // 
            // btAddNew
            // 
            this.btAddNew.Location = new System.Drawing.Point(624, 475);
            this.btAddNew.Name = "btAddNew";
            this.btAddNew.Size = new System.Drawing.Size(150, 46);
            this.btAddNew.TabIndex = 62;
            this.btAddNew.Text = "Add New";
            this.btAddNew.UseVisualStyleBackColor = true;
            this.btAddNew.Click += new System.EventHandler(this.btAddNew_Click);
            // 
            // dtpBD
            // 
            this.dtpBD.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.dtpBD.Location = new System.Drawing.Point(740, 179);
            this.dtpBD.Name = "dtpBD";
            this.dtpBD.Size = new System.Drawing.Size(381, 31);
            this.dtpBD.TabIndex = 61;
            // 
            // cbRole
            // 
            this.cbRole.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbRole.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.cbRole.FormattingEnabled = true;
            this.cbRole.Items.AddRange(new object[] {
            "MANAGER",
            "STAFF"});
            this.cbRole.Location = new System.Drawing.Point(740, 399);
            this.cbRole.Name = "cbRole";
            this.cbRole.Size = new System.Drawing.Size(162, 33);
            this.cbRole.TabIndex = 60;
            // 
            // lbRole
            // 
            this.lbRole.AutoSize = true;
            this.lbRole.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbRole.Location = new System.Drawing.Point(619, 402);
            this.lbRole.Name = "lbRole";
            this.lbRole.Size = new System.Drawing.Size(56, 25);
            this.lbRole.TabIndex = 59;
            this.lbRole.Text = "Role";
            // 
            // tbPassword
            // 
            this.tbPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbPassword.Location = new System.Drawing.Point(740, 362);
            this.tbPassword.Name = "tbPassword";
            this.tbPassword.PasswordChar = '*';
            this.tbPassword.Size = new System.Drawing.Size(281, 31);
            this.tbPassword.TabIndex = 58;
            // 
            // tbUsername
            // 
            this.tbUsername.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbUsername.Location = new System.Drawing.Point(740, 325);
            this.tbUsername.Name = "tbUsername";
            this.tbUsername.Size = new System.Drawing.Size(281, 31);
            this.tbUsername.TabIndex = 57;
            // 
            // lbPassword
            // 
            this.lbPassword.AutoSize = true;
            this.lbPassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbPassword.Location = new System.Drawing.Point(619, 362);
            this.lbPassword.Name = "lbPassword";
            this.lbPassword.Size = new System.Drawing.Size(106, 25);
            this.lbPassword.TabIndex = 56;
            this.lbPassword.Text = "Password";
            // 
            // lbUsername
            // 
            this.lbUsername.AutoSize = true;
            this.lbUsername.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbUsername.Location = new System.Drawing.Point(619, 328);
            this.lbUsername.Name = "lbUsername";
            this.lbUsername.Size = new System.Drawing.Size(110, 25);
            this.lbUsername.TabIndex = 55;
            this.lbUsername.Text = "Username";
            // 
            // rbFemale
            // 
            this.rbFemale.AutoSize = true;
            this.rbFemale.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.rbFemale.Location = new System.Drawing.Point(823, 216);
            this.rbFemale.Name = "rbFemale";
            this.rbFemale.Size = new System.Drawing.Size(101, 29);
            this.rbFemale.TabIndex = 54;
            this.rbFemale.TabStop = true;
            this.rbFemale.Text = "Female";
            this.rbFemale.UseVisualStyleBackColor = true;
            // 
            // rbMale
            // 
            this.rbMale.AutoSize = true;
            this.rbMale.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.rbMale.Location = new System.Drawing.Point(740, 216);
            this.rbMale.Name = "rbMale";
            this.rbMale.Size = new System.Drawing.Size(77, 29);
            this.rbMale.TabIndex = 53;
            this.rbMale.TabStop = true;
            this.rbMale.Text = "Male";
            this.rbMale.UseVisualStyleBackColor = true;
            // 
            // tbPhone
            // 
            this.tbPhone.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbPhone.Location = new System.Drawing.Point(740, 288);
            this.tbPhone.Name = "tbPhone";
            this.tbPhone.Size = new System.Drawing.Size(281, 31);
            this.tbPhone.TabIndex = 52;
            // 
            // tbSalary
            // 
            this.tbSalary.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbSalary.Location = new System.Drawing.Point(740, 251);
            this.tbSalary.Name = "tbSalary";
            this.tbSalary.Size = new System.Drawing.Size(281, 31);
            this.tbSalary.TabIndex = 51;
            this.tbSalary.TextChanged += new System.EventHandler(this.tbSalary_TextChanged);
            // 
            // tbAddress
            // 
            this.tbAddress.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbAddress.Location = new System.Drawing.Point(740, 142);
            this.tbAddress.Name = "tbAddress";
            this.tbAddress.Size = new System.Drawing.Size(381, 31);
            this.tbAddress.TabIndex = 50;
            // 
            // tbName
            // 
            this.tbName.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbName.Location = new System.Drawing.Point(740, 105);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(281, 31);
            this.tbName.TabIndex = 49;
            // 
            // tbID
            // 
            this.tbID.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.tbID.Location = new System.Drawing.Point(740, 68);
            this.tbID.Name = "tbID";
            this.tbID.ReadOnly = true;
            this.tbID.Size = new System.Drawing.Size(79, 31);
            this.tbID.TabIndex = 48;
            // 
            // lbPhone
            // 
            this.lbPhone.AutoSize = true;
            this.lbPhone.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbPhone.Location = new System.Drawing.Point(619, 291);
            this.lbPhone.Name = "lbPhone";
            this.lbPhone.Size = new System.Drawing.Size(74, 25);
            this.lbPhone.TabIndex = 47;
            this.lbPhone.Text = "Phone";
            // 
            // lbSalary
            // 
            this.lbSalary.AutoSize = true;
            this.lbSalary.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbSalary.Location = new System.Drawing.Point(619, 254);
            this.lbSalary.Name = "lbSalary";
            this.lbSalary.Size = new System.Drawing.Size(73, 25);
            this.lbSalary.TabIndex = 46;
            this.lbSalary.Text = "Salary";
            // 
            // lbGender
            // 
            this.lbGender.AutoSize = true;
            this.lbGender.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbGender.Location = new System.Drawing.Point(619, 218);
            this.lbGender.Name = "lbGender";
            this.lbGender.Size = new System.Drawing.Size(83, 25);
            this.lbGender.TabIndex = 45;
            this.lbGender.Text = "Gender";
            // 
            // lbBirthDate
            // 
            this.lbBirthDate.AutoSize = true;
            this.lbBirthDate.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbBirthDate.Location = new System.Drawing.Point(619, 184);
            this.lbBirthDate.Name = "lbBirthDate";
            this.lbBirthDate.Size = new System.Drawing.Size(101, 25);
            this.lbBirthDate.TabIndex = 44;
            this.lbBirthDate.Text = "BirthDate";
            // 
            // lbAddress
            // 
            this.lbAddress.AutoSize = true;
            this.lbAddress.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbAddress.Location = new System.Drawing.Point(619, 145);
            this.lbAddress.Name = "lbAddress";
            this.lbAddress.Size = new System.Drawing.Size(91, 25);
            this.lbAddress.TabIndex = 43;
            this.lbAddress.Text = "Address";
            // 
            // lbName
            // 
            this.lbName.AutoSize = true;
            this.lbName.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbName.Location = new System.Drawing.Point(619, 108);
            this.lbName.Name = "lbName";
            this.lbName.Size = new System.Drawing.Size(68, 25);
            this.lbName.TabIndex = 42;
            this.lbName.Text = "Name";
            // 
            // lbEID
            // 
            this.lbEID.AutoSize = true;
            this.lbEID.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbEID.Location = new System.Drawing.Point(619, 71);
            this.lbEID.Name = "lbEID";
            this.lbEID.Size = new System.Drawing.Size(103, 25);
            this.lbEID.TabIndex = 41;
            this.lbEID.Text = "EmployID";
            this.lbEID.Click += new System.EventHandler(this.lbEID_Click);
            // 
            // btUpload
            // 
            this.btUpload.Location = new System.Drawing.Point(332, 401);
            this.btUpload.Name = "btUpload";
            this.btUpload.Size = new System.Drawing.Size(150, 46);
            this.btUpload.TabIndex = 9;
            this.btUpload.Text = "Upload";
            this.btUpload.UseVisualStyleBackColor = true;
            this.btUpload.Click += new System.EventHandler(this.btUpload_Click);
            // 
            // pbAvatar
            // 
            this.pbAvatar.Image = global::Project.Properties.Resources._default;
            this.pbAvatar.Location = new System.Drawing.Point(253, 71);
            this.pbAvatar.Name = "pbAvatar";
            this.pbAvatar.Size = new System.Drawing.Size(300, 300);
            this.pbAvatar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbAvatar.TabIndex = 8;
            this.pbAvatar.TabStop = false;
            // 
            // lbDate
            // 
            this.lbDate.AutoSize = true;
            this.lbDate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbDate.ForeColor = System.Drawing.Color.DarkRed;
            this.lbDate.Location = new System.Drawing.Point(1679, 35);
            this.lbDate.Name = "lbDate";
            this.lbDate.Size = new System.Drawing.Size(60, 24);
            this.lbDate.TabIndex = 41;
            this.lbDate.Text = "label1";
            // 
            // lbTime
            // 
            this.lbTime.AutoSize = true;
            this.lbTime.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lbTime.ForeColor = System.Drawing.Color.DarkRed;
            this.lbTime.Location = new System.Drawing.Point(1535, 35);
            this.lbTime.Name = "lbTime";
            this.lbTime.Size = new System.Drawing.Size(60, 24);
            this.lbTime.TabIndex = 40;
            this.lbTime.Text = "label1";
            // 
            // timer1
            // 
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // btBack
            // 
            this.btBack.BackColor = System.Drawing.Color.DarkRed;
            this.btBack.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btBack.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btBack.Location = new System.Drawing.Point(1376, 939);
            this.btBack.Name = "btBack";
            this.btBack.Size = new System.Drawing.Size(130, 48);
            this.btBack.TabIndex = 42;
            this.btBack.Text = "Back";
            this.btBack.UseVisualStyleBackColor = false;
            this.btBack.Click += new System.EventHandler(this.btBack_Click);
            // 
            // btExit
            // 
            this.btExit.BackColor = System.Drawing.Color.DarkRed;
            this.btExit.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.btExit.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btExit.Location = new System.Drawing.Point(1589, 939);
            this.btExit.Name = "btExit";
            this.btExit.Size = new System.Drawing.Size(130, 48);
            this.btExit.TabIndex = 43;
            this.btExit.Text = "Exit";
            this.btExit.UseVisualStyleBackColor = false;
            this.btExit.Click += new System.EventHandler(this.btExit_Click);
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.DarkRed;
            this.panel3.Controls.Add(this.label8);
            this.panel3.Controls.Add(this.pictureBox1);
            this.panel3.Location = new System.Drawing.Point(28, 15);
            this.panel3.Margin = new System.Windows.Forms.Padding(2);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(98, 116);
            this.panel3.TabIndex = 47;
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
            this.panel2.TabIndex = 46;
            // 
            // StaffManager
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1924, 1061);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.btExit);
            this.Controls.Add(this.btBack);
            this.Controls.Add(this.lbDate);
            this.Controls.Add(this.lbTime);
            this.Controls.Add(this.tabControl1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "StaffManager";
            this.Text = "Staff Management";
            this.Load += new System.EventHandler(this.StaffManager_Load);
            this.tabControl1.ResumeLayout(false);
            this.tPStaffList.ResumeLayout(false);
            this.flpEmployee.ResumeLayout(false);
            this.tPAddStaff.ResumeLayout(false);
            this.tPAddStaff.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbAvatar)).EndInit();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tPStaffList;
        private System.Windows.Forms.TabPage tPAddStaff;
        private System.Windows.Forms.Button btUpload;
        private System.Windows.Forms.PictureBox pbAvatar;
        private System.Windows.Forms.ComboBox cbRole;
        private System.Windows.Forms.Label lbRole;
        private System.Windows.Forms.TextBox tbPassword;
        private System.Windows.Forms.TextBox tbUsername;
        private System.Windows.Forms.Label lbPassword;
        private System.Windows.Forms.Label lbUsername;
        private System.Windows.Forms.RadioButton rbFemale;
        private System.Windows.Forms.RadioButton rbMale;
        private System.Windows.Forms.TextBox tbPhone;
        private System.Windows.Forms.TextBox tbSalary;
        private System.Windows.Forms.TextBox tbAddress;
        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.TextBox tbID;
        private System.Windows.Forms.Label lbPhone;
        private System.Windows.Forms.Label lbSalary;
        private System.Windows.Forms.Label lbGender;
        private System.Windows.Forms.Label lbBirthDate;
        private System.Windows.Forms.Label lbAddress;
        private System.Windows.Forms.Label lbName;
        private System.Windows.Forms.Label lbEID;
        private System.Windows.Forms.DateTimePicker dtpBD;
        private System.Windows.Forms.Button btCancel;
        private System.Windows.Forms.Button btAddNew;
        private System.Windows.Forms.Button btReset;
        private System.Windows.Forms.Label lbDate;
        private System.Windows.Forms.Label lbTime;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button btBack;
        private System.Windows.Forms.FlowLayoutPanel flpEmployee;
        private System.Windows.Forms.Button btExit;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Panel panel2;
    }
}