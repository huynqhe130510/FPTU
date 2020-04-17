namespace Project
{
    partial class EditDialog
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
            this.PriceTxT = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.Categorylb = new System.Windows.Forms.Label();
            this.cbCategory = new System.Windows.Forms.ComboBox();
            this.pIDtxt = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.saveBtn = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.pNameTxt = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.SizeTxt = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.DescriptionTxT = new System.Windows.Forms.TextBox();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.btUpload = new System.Windows.Forms.Button();
            this.Pictureb = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.Pictureb)).BeginInit();
            this.SuspendLayout();
            // 
            // PriceTxT
            // 
            this.PriceTxT.Location = new System.Drawing.Point(221, 186);
            this.PriceTxT.Margin = new System.Windows.Forms.Padding(2);
            this.PriceTxT.Name = "PriceTxT";
            this.PriceTxT.Size = new System.Drawing.Size(104, 20);
            this.PriceTxT.TabIndex = 18;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(110, 186);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(31, 13);
            this.label3.TabIndex = 17;
            this.label3.Text = "Price";
            // 
            // Categorylb
            // 
            this.Categorylb.AutoSize = true;
            this.Categorylb.Location = new System.Drawing.Point(110, 142);
            this.Categorylb.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.Categorylb.Name = "Categorylb";
            this.Categorylb.Size = new System.Drawing.Size(49, 13);
            this.Categorylb.TabIndex = 16;
            this.Categorylb.Text = "Category";
            // 
            // cbCategory
            // 
            this.cbCategory.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbCategory.FormattingEnabled = true;
            this.cbCategory.Location = new System.Drawing.Point(221, 142);
            this.cbCategory.Margin = new System.Windows.Forms.Padding(2);
            this.cbCategory.Name = "cbCategory";
            this.cbCategory.Size = new System.Drawing.Size(104, 21);
            this.cbCategory.TabIndex = 15;
            // 
            // pIDtxt
            // 
            this.pIDtxt.Location = new System.Drawing.Point(221, 72);
            this.pIDtxt.Margin = new System.Windows.Forms.Padding(2);
            this.pIDtxt.Name = "pIDtxt";
            this.pIDtxt.ReadOnly = true;
            this.pIDtxt.Size = new System.Drawing.Size(104, 20);
            this.pIDtxt.TabIndex = 14;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(112, 72);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(58, 13);
            this.label2.TabIndex = 13;
            this.label2.Text = "Product ID";
            // 
            // saveBtn
            // 
            this.saveBtn.Location = new System.Drawing.Point(113, 288);
            this.saveBtn.Margin = new System.Windows.Forms.Padding(2);
            this.saveBtn.Name = "saveBtn";
            this.saveBtn.Size = new System.Drawing.Size(88, 28);
            this.saveBtn.TabIndex = 12;
            this.saveBtn.Text = "Save";
            this.saveBtn.UseVisualStyleBackColor = true;
            this.saveBtn.Click += new System.EventHandler(this.saveBtn_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(110, 106);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(75, 13);
            this.label1.TabIndex = 11;
            this.label1.Text = "Product Name";
            // 
            // pNameTxt
            // 
            this.pNameTxt.Location = new System.Drawing.Point(221, 103);
            this.pNameTxt.Margin = new System.Windows.Forms.Padding(2);
            this.pNameTxt.Name = "pNameTxt";
            this.pNameTxt.Size = new System.Drawing.Size(104, 20);
            this.pNameTxt.TabIndex = 10;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(113, 224);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(27, 13);
            this.label4.TabIndex = 20;
            this.label4.Text = "Size";
            // 
            // SizeTxt
            // 
            this.SizeTxt.Location = new System.Drawing.Point(221, 221);
            this.SizeTxt.Margin = new System.Windows.Forms.Padding(2);
            this.SizeTxt.Name = "SizeTxt";
            this.SizeTxt.Size = new System.Drawing.Size(104, 20);
            this.SizeTxt.TabIndex = 19;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(113, 258);
            this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(60, 13);
            this.label5.TabIndex = 22;
            this.label5.Text = "Description";
            // 
            // DescriptionTxT
            // 
            this.DescriptionTxT.Location = new System.Drawing.Point(221, 255);
            this.DescriptionTxT.Margin = new System.Windows.Forms.Padding(2);
            this.DescriptionTxT.Name = "DescriptionTxT";
            this.DescriptionTxT.Size = new System.Drawing.Size(104, 20);
            this.DescriptionTxT.TabIndex = 21;
            // 
            // btUpload
            // 
            this.btUpload.Location = new System.Drawing.Point(390, 229);
            this.btUpload.Name = "btUpload";
            this.btUpload.Size = new System.Drawing.Size(75, 23);
            this.btUpload.TabIndex = 24;
            this.btUpload.Text = "Upload";
            this.btUpload.UseVisualStyleBackColor = true;
            this.btUpload.Click += new System.EventHandler(this.button1_Click);
            // 
            // Pictureb
            // 
            this.Pictureb.ErrorImage = null;
            this.Pictureb.Location = new System.Drawing.Point(390, 72);
            this.Pictureb.Name = "Pictureb";
            this.Pictureb.Size = new System.Drawing.Size(150, 150);
            this.Pictureb.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Pictureb.TabIndex = 23;
            this.Pictureb.TabStop = false;
            // 
            // EditDialog
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(596, 395);
            this.Controls.Add(this.btUpload);
            this.Controls.Add(this.Pictureb);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.DescriptionTxT);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.SizeTxt);
            this.Controls.Add(this.PriceTxT);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.Categorylb);
            this.Controls.Add(this.cbCategory);
            this.Controls.Add(this.pIDtxt);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.saveBtn);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.pNameTxt);
            this.Name = "EditDialog";
            this.Text = "EditDialog";
            this.Load += new System.EventHandler(this.EditDialog_Load);
            ((System.ComponentModel.ISupportInitialize)(this.Pictureb)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox PriceTxT;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label Categorylb;
        private System.Windows.Forms.ComboBox cbCategory;
        private System.Windows.Forms.TextBox pIDtxt;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button saveBtn;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox pNameTxt;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox SizeTxt;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox DescriptionTxT;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Button btUpload;
        private System.Windows.Forms.PictureBox Pictureb;
    }
}