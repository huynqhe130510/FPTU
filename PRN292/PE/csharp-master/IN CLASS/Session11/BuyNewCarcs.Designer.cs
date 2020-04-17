namespace Chapter21
{
    partial class BuyNewCarcs
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
            this.checkFloorMats = new System.Windows.Forms.CheckBox();
            this.checkedBoxRadioOptions = new System.Windows.Forms.CheckedListBox();
            this.listOrderStatus = new System.Windows.Forms.ListBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioPink = new System.Windows.Forms.RadioButton();
            this.radioRed = new System.Windows.Forms.RadioButton();
            this.radioYellow = new System.Windows.Forms.RadioButton();
            this.radioGreen = new System.Windows.Forms.RadioButton();
            this.btnOrder = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.infoLabel = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // checkFloorMats
            // 
            this.checkFloorMats.AutoSize = true;
            this.checkFloorMats.Location = new System.Drawing.Point(46, 22);
            this.checkFloorMats.Name = "checkFloorMats";
            this.checkFloorMats.Size = new System.Drawing.Size(73, 17);
            this.checkFloorMats.TabIndex = 0;
            this.checkFloorMats.Text = "Extra floor";
            this.checkFloorMats.UseVisualStyleBackColor = true;
            this.checkFloorMats.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // checkedBoxRadioOptions
            // 
            this.checkedBoxRadioOptions.FormattingEnabled = true;
            this.checkedBoxRadioOptions.Items.AddRange(new object[] {
            "Casssete Player",
            "Rear Speaker",
            "Ultra Base Thumber",
            "Banana"});
            this.checkedBoxRadioOptions.Location = new System.Drawing.Point(46, 149);
            this.checkedBoxRadioOptions.Name = "checkedBoxRadioOptions";
            this.checkedBoxRadioOptions.Size = new System.Drawing.Size(271, 64);
            this.checkedBoxRadioOptions.TabIndex = 2;
            // 
            // listOrderStatus
            // 
            this.listOrderStatus.FormattingEnabled = true;
            this.listOrderStatus.Location = new System.Drawing.Point(46, 318);
            this.listOrderStatus.Name = "listOrderStatus";
            this.listOrderStatus.Size = new System.Drawing.Size(271, 95);
            this.listOrderStatus.TabIndex = 3;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioPink);
            this.groupBox1.Controls.Add(this.radioRed);
            this.groupBox1.Controls.Add(this.radioYellow);
            this.groupBox1.Controls.Add(this.radioGreen);
            this.groupBox1.Location = new System.Drawing.Point(46, 61);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(445, 60);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Exterior Color: Thanks for visiting the group...";
            // 
            // radioPink
            // 
            this.radioPink.AutoSize = true;
            this.radioPink.Location = new System.Drawing.Point(350, 20);
            this.radioPink.Name = "radioPink";
            this.radioPink.Size = new System.Drawing.Size(46, 17);
            this.radioPink.TabIndex = 3;
            this.radioPink.TabStop = true;
            this.radioPink.Text = "Pink";
            this.radioPink.UseVisualStyleBackColor = true;
            // 
            // radioRed
            // 
            this.radioRed.AutoSize = true;
            this.radioRed.Location = new System.Drawing.Point(234, 20);
            this.radioRed.Name = "radioRed";
            this.radioRed.Size = new System.Drawing.Size(45, 17);
            this.radioRed.TabIndex = 2;
            this.radioRed.TabStop = true;
            this.radioRed.Text = "Red";
            this.radioRed.UseVisualStyleBackColor = true;
            // 
            // radioYellow
            // 
            this.radioYellow.AutoSize = true;
            this.radioYellow.Location = new System.Drawing.Point(116, 20);
            this.radioYellow.Name = "radioYellow";
            this.radioYellow.Size = new System.Drawing.Size(56, 17);
            this.radioYellow.TabIndex = 1;
            this.radioYellow.TabStop = true;
            this.radioYellow.Text = "Yellow";
            this.radioYellow.UseVisualStyleBackColor = true;
            // 
            // radioGreen
            // 
            this.radioGreen.AutoSize = true;
            this.radioGreen.Location = new System.Drawing.Point(0, 20);
            this.radioGreen.Name = "radioGreen";
            this.radioGreen.Size = new System.Drawing.Size(54, 17);
            this.radioGreen.TabIndex = 0;
            this.radioGreen.TabStop = true;
            this.radioGreen.Text = "Green";
            this.radioGreen.UseVisualStyleBackColor = true;
            // 
            // btnOrder
            // 
            this.btnOrder.Location = new System.Drawing.Point(335, 363);
            this.btnOrder.Name = "btnOrder";
            this.btnOrder.Size = new System.Drawing.Size(81, 39);
            this.btnOrder.TabIndex = 5;
            this.btnOrder.Text = "Confirm Order";
            this.btnOrder.UseVisualStyleBackColor = true;
            this.btnOrder.Click += new System.EventHandler(this.btnOrder_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(46, 133);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "Radio Option";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(46, 292);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(66, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "Order Status";
            // 
            // infoLabel
            // 
            this.infoLabel.AutoSize = true;
            this.infoLabel.Location = new System.Drawing.Point(46, 231);
            this.infoLabel.Name = "infoLabel";
            this.infoLabel.Size = new System.Drawing.Size(68, 13);
            this.infoLabel.TabIndex = 8;
            this.infoLabel.Text = "Information : ";
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(440, 363);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 39);
            this.btnExit.TabIndex = 9;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // BuyNewCarcs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(530, 425);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.infoLabel);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnOrder);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.listOrderStatus);
            this.Controls.Add(this.checkedBoxRadioOptions);
            this.Controls.Add(this.checkFloorMats);
            this.Name = "BuyNewCarcs";
            this.Text = "BuyNewCarcs";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox checkFloorMats;
        private System.Windows.Forms.CheckedListBox checkedBoxRadioOptions;
        private System.Windows.Forms.ListBox listOrderStatus;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioPink;
        private System.Windows.Forms.RadioButton radioRed;
        private System.Windows.Forms.RadioButton radioYellow;
        private System.Windows.Forms.RadioButton radioGreen;
        private System.Windows.Forms.Button btnOrder;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label infoLabel;
        private System.Windows.Forms.Button btnExit;
    }
}