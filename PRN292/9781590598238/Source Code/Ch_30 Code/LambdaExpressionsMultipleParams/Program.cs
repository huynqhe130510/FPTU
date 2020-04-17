    using System;
using System.Collections.Generic;
using System.Text;
using System.Query;
using System.Xml.XLinq;
using System.Data.DLinq;
   
namespace LambdaExpressionsMultipleParams
{
    public delegate string VerySimpleDelegate();

	public class SimpleMath
	{
		public delegate void MathMessage(string msg, int result);
        private MathMessage mmDelegate;

        public void SetMathHandler(MathMessage target)
        {mmDelegate = target; }

		public void Add(int x, int y)
		{
            if (mmDelegate != null)
			    mmDelegate.Invoke("Adding has completed!", x + y);
		}
	}

	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("***** Lambdas with Multiple or no Params! *****\n");

            // Register w/ delegate as a lambda expression. 
			SimpleMath m = new SimpleMath();
            m.SetMathHandler((msg, result) => {Console.WriteLine("Message: {0}, Result: {1}", msg, result);});			

            // This will execute the lambda expression.
            m.Add(10, 10);

            VerySimpleDelegate d = new VerySimpleDelegate( () => {return "Enjoy your string!";} );
            Console.WriteLine(d.Invoke());
			Console.ReadLine();
		}
	}
}
