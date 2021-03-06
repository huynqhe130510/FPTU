﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:2.0.50215.44
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by wsdl, Version=2.0.50215.44.
// 
namespace CalculatorClient {
    using System.Diagnostics;
    using System.Web.Services;
    using System.ComponentModel;
    using System.Web.Services.Protocols;
    using System;
    using System.Xml.Serialization;
    
    
    /// <remarks/>
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="CalculatorWebServiceSoap", Namespace="http://www.IntertechTraining.com/")]
    public partial class CalculatorWebService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback SubtractOperationCompleted;
        
        private System.Threading.SendOrPostCallback AddFloatsOperationCompleted;
        
        private System.Threading.SendOrPostCallback AddIntsOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetSimplePIOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetMyRandomNumberOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetMyPointOperationCompleted;
        
        /// <remarks/>
        public CalculatorWebService() {
            this.Url = "http://localhost/CalcService/Service.asmx";
        }
        
        /// <remarks/>
        public event SubtractCompletedEventHandler SubtractCompleted;
        
        /// <remarks/>
        public event AddFloatsCompletedEventHandler AddFloatsCompleted;
        
        /// <remarks/>
        public event AddIntsCompletedEventHandler AddIntsCompleted;
        
        /// <remarks/>
        public event GetSimplePICompletedEventHandler GetSimplePICompleted;
        
        /// <remarks/>
        public event GetMyRandomNumberCompletedEventHandler GetMyRandomNumberCompleted;
        
        /// <remarks/>
        public event GetMyPointCompletedEventHandler GetMyPointCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/Subtract", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int Subtract(int x, int y) {
            object[] results = this.Invoke("Subtract", new object[] {
                        x,
                        y});
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginSubtract(int x, int y, System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("Subtract", new object[] {
                        x,
                        y}, callback, asyncState);
        }
        
        /// <remarks/>
        public int EndSubtract(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public void SubtractAsync(int x, int y) {
            this.SubtractAsync(x, y, null);
        }
        
        /// <remarks/>
        public void SubtractAsync(int x, int y, object userState) {
            if ((this.SubtractOperationCompleted == null)) {
                this.SubtractOperationCompleted = new System.Threading.SendOrPostCallback(this.OnSubtractOperationCompleted);
            }
            this.InvokeAsync("Subtract", new object[] {
                        x,
                        y}, this.SubtractOperationCompleted, userState);
        }
        
        private void OnSubtractOperationCompleted(object arg) {
            if ((this.SubtractCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.SubtractCompleted(this, new SubtractCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.WebMethodAttribute(MessageName="AddFloats")]
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/AddFloats", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public float Add(float x, float y) {
            object[] results = this.Invoke("AddFloats", new object[] {
                        x,
                        y});
            return ((float)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginAddFloats(float x, float y, System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("AddFloats", new object[] {
                        x,
                        y}, callback, asyncState);
        }
        
        /// <remarks/>
        public float EndAddFloats(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((float)(results[0]));
        }
        
        /// <remarks/>
        public void AddFloatsAsync(float x, float y) {
            this.AddFloatsAsync(x, y, null);
        }
        
        /// <remarks/>
        public void AddFloatsAsync(float x, float y, object userState) {
            if ((this.AddFloatsOperationCompleted == null)) {
                this.AddFloatsOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddFloatsOperationCompleted);
            }
            this.InvokeAsync("AddFloats", new object[] {
                        x,
                        y}, this.AddFloatsOperationCompleted, userState);
        }
        
        private void OnAddFloatsOperationCompleted(object arg) {
            if ((this.AddFloatsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AddFloatsCompleted(this, new AddFloatsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.WebMethodAttribute(MessageName="AddInts")]
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/AddInts", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int Add(int x, int y) {
            object[] results = this.Invoke("AddInts", new object[] {
                        x,
                        y});
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginAddInts(int x, int y, System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("AddInts", new object[] {
                        x,
                        y}, callback, asyncState);
        }
        
        /// <remarks/>
        public int EndAddInts(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public void AddIntsAsync(int x, int y) {
            this.AddIntsAsync(x, y, null);
        }
        
        /// <remarks/>
        public void AddIntsAsync(int x, int y, object userState) {
            if ((this.AddIntsOperationCompleted == null)) {
                this.AddIntsOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddIntsOperationCompleted);
            }
            this.InvokeAsync("AddInts", new object[] {
                        x,
                        y}, this.AddIntsOperationCompleted, userState);
        }
        
        private void OnAddIntsOperationCompleted(object arg) {
            if ((this.AddIntsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AddIntsCompleted(this, new AddIntsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/GetSimplePI", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public float GetSimplePI() {
            object[] results = this.Invoke("GetSimplePI", new object[0]);
            return ((float)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginGetSimplePI(System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("GetSimplePI", new object[0], callback, asyncState);
        }
        
        /// <remarks/>
        public float EndGetSimplePI(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((float)(results[0]));
        }
        
        /// <remarks/>
        public void GetSimplePIAsync() {
            this.GetSimplePIAsync(null);
        }
        
        /// <remarks/>
        public void GetSimplePIAsync(object userState) {
            if ((this.GetSimplePIOperationCompleted == null)) {
                this.GetSimplePIOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetSimplePIOperationCompleted);
            }
            this.InvokeAsync("GetSimplePI", new object[0], this.GetSimplePIOperationCompleted, userState);
        }
        
        private void OnGetSimplePIOperationCompleted(object arg) {
            if ((this.GetSimplePICompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetSimplePICompleted(this, new GetSimplePICompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/GetMyRandomNumber", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int GetMyRandomNumber() {
            object[] results = this.Invoke("GetMyRandomNumber", new object[0]);
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginGetMyRandomNumber(System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("GetMyRandomNumber", new object[0], callback, asyncState);
        }
        
        /// <remarks/>
        public int EndGetMyRandomNumber(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public void GetMyRandomNumberAsync() {
            this.GetMyRandomNumberAsync(null);
        }
        
        /// <remarks/>
        public void GetMyRandomNumberAsync(object userState) {
            if ((this.GetMyRandomNumberOperationCompleted == null)) {
                this.GetMyRandomNumberOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetMyRandomNumberOperationCompleted);
            }
            this.InvokeAsync("GetMyRandomNumber", new object[0], this.GetMyRandomNumberOperationCompleted, userState);
        }
        
        private void OnGetMyRandomNumberOperationCompleted(object arg) {
            if ((this.GetMyRandomNumberCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetMyRandomNumberCompleted(this, new GetMyRandomNumberCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://www.IntertechTraining.com/GetMyPoint", RequestNamespace="http://www.IntertechTraining.com/", ResponseNamespace="http://www.IntertechTraining.com/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Point GetMyPoint() {
            object[] results = this.Invoke("GetMyPoint", new object[0]);
            return ((Point)(results[0]));
        }
        
        /// <remarks/>
        public System.IAsyncResult BeginGetMyPoint(System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("GetMyPoint", new object[0], callback, asyncState);
        }
        
        /// <remarks/>
        public Point EndGetMyPoint(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((Point)(results[0]));
        }
        
        /// <remarks/>
        public void GetMyPointAsync() {
            this.GetMyPointAsync(null);
        }
        
        /// <remarks/>
        public void GetMyPointAsync(object userState) {
            if ((this.GetMyPointOperationCompleted == null)) {
                this.GetMyPointOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetMyPointOperationCompleted);
            }
            this.InvokeAsync("GetMyPoint", new object[0], this.GetMyPointOperationCompleted, userState);
        }
        
        private void OnGetMyPointOperationCompleted(object arg) {
            if ((this.GetMyPointCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetMyPointCompleted(this, new GetMyPointCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
    }
    
    /// <remarks/>
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.IntertechTraining.com/")]
    public partial class Point {
        
        private int xField;
        
        private int yField;
        
        private string pointNameField;
        
        /// <remarks/>
        public int x {
            get {
                return this.xField;
            }
            set {
                this.xField = value;
            }
        }
        
        /// <remarks/>
        public int y {
            get {
                return this.yField;
            }
            set {
                this.yField = value;
            }
        }
        
        /// <remarks/>
        public string pointName {
            get {
                return this.pointNameField;
            }
            set {
                this.pointNameField = value;
            }
        }
    }
    
    /// <remarks/>
    public delegate void SubtractCompletedEventHandler(object sender, SubtractCompletedEventArgs e);
    
    /// <remarks/>
    public partial class SubtractCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal SubtractCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public int Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((int)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    public delegate void AddFloatsCompletedEventHandler(object sender, AddFloatsCompletedEventArgs e);
    
    /// <remarks/>
    public partial class AddFloatsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal AddFloatsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public float Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((float)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    public delegate void AddIntsCompletedEventHandler(object sender, AddIntsCompletedEventArgs e);
    
    /// <remarks/>
    public partial class AddIntsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal AddIntsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public int Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((int)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    public delegate void GetSimplePICompletedEventHandler(object sender, GetSimplePICompletedEventArgs e);
    
    /// <remarks/>
    public partial class GetSimplePICompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetSimplePICompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public float Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((float)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    public delegate void GetMyRandomNumberCompletedEventHandler(object sender, GetMyRandomNumberCompletedEventArgs e);
    
    /// <remarks/>
    public partial class GetMyRandomNumberCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetMyRandomNumberCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public int Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((int)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    public delegate void GetMyPointCompletedEventHandler(object sender, GetMyPointCompletedEventArgs e);
    
    /// <remarks/>
    public partial class GetMyPointCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetMyPointCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Point Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Point)(this.results[0]));
            }
        }
    }
}
