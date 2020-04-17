using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter3
{
    class Program
    {
        public const string Fullname = "Pham Ngoc Ha";
        static void Main(string[] args)
        {
            // Print member-level const.
            Console.WriteLine("fullname const: {0}", Fullname);
            Console.ReadLine();
            // Print local-scoped const.
            const int LocalFixedValue = 4;
            Console.WriteLine("Local const: {0}", LocalFixedValue);
            Console.ReadLine();

            //// Error! Can't change the value of a read-only field.
            //Tire t = new Tire();
            ////t.FireYear = new Tire(33);

            //Tire myTire = Tire.FireYear;
            //Console.WriteLine("ID of my tire is: {0}", myTire.manufactureID);
            //Console.ReadLine();
            //// public
            //Cat tom = new Cat("Meo Tom");
            //tom.HowManyCats();
            //Cat muop = new Cat("Meo Muop");
            //muop.HowManyCats();
            //Console.ReadLine();

            //// static sample 1
            //Cat_Static tom_static = new Cat_Static("Meo Tom");
            //Cat_Static.HowManyCats();
            //Cat_Static muop_static = new Cat_Static("Meo Muop");
            //Cat_Static.HowManyCats();


            //// static sample 2
            //Console.ReadLine();
            //ClassName L_A = new ClassName(" Lop 5A ");
            //L_A.So_Lop_Dang_Ky();
            //ClassName L_B = new ClassName(" Lop 5B ");
            //L_B.So_Lop_Dang_Ky();


            //Console.ReadLine();

            // Note! 'i' is only visible within the scope of the for loop.
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Number is: {0} ", i);
            }
            Console.ReadLine();

            // Iterate array items using foreach.
            string[] books = { "Complex Algorithms", "Do you Remember Classic COM?", "C# and the .NET Platform" };
            foreach (string s in books)
                Console.WriteLine(s);
            int[] myInts = { 10, 20, 30, 40 };
            foreach (int i in myInts)
                Console.WriteLine(i);
            Console.ReadLine();

            // The while and do/while Looping Constructs
            string userIsDone = "no";
            // Test on a lower class copy of the string.
            while (userIsDone.ToLower() != "yes")
            {
                Console.WriteLine("In while loop");
                Console.Write("Are you done? [yes] [no]: ");
                userIsDone = Console.ReadLine();
           
            }
            Console.WriteLine("Out of loop");
            Console.ReadLine();
            /*
             * 
             * 
             * */
            ////Value Types, References Types, and the Assignment Operator
            //Console.WriteLine("***** Value Types / Reference Types *****");
            //Console.WriteLine("-> Creating p1");
            //MyPoint p1 = new MyPoint();
            //p1.x = 100;
            //p1.y = 100;
            //Console.WriteLine("-> Assigning p2 to p1\n");
            //MyPoint p2 = p1;
            //// Here is p1.
            //Console.WriteLine("p1.x = {0}", p1.x);
            //Console.WriteLine("p1.y = {0}", p1.y);
            //// Here is p2.
            //Console.WriteLine("p2.x = {0}", p2.x);
            //Console.WriteLine("p2.y = {0}", p2.y);
            //// Change p2.x. This will NOT change p1.x.
            //Console.WriteLine("-> Changing p2.x to 900");
            //p2.x = 900;
            //// Print again.
            //Console.WriteLine("-> Here are the X values again...");
            //Console.WriteLine("p1.x = {0}", p1.x);
            //Console.WriteLine("p2.x = {0}", p2.x);
            //Console.ReadLine();

            // Passing ref-types by value.
            Console.WriteLine("***** Passing Person object by value *****");
            Person fred = new Person("Fred 567", 120);
            Console.WriteLine("Before by value call, Person is:");
            fred.PrintInfo();
            Console.ReadLine();

            SendAPersonByValue(fred);
            Console.WriteLine("After by value call, Person is:");
            fred.PrintInfo();
            Console.ReadLine();

            // enumeration
            // Print information for the EmpType enumeration.
            Array obj = Enum.GetValues(typeof(EmpType));
            Console.WriteLine("This enum has {0} members.", obj.Length);
            foreach (EmpType e in obj)
            {
                Console.Write("String name: {0},", e.ToString());
                Console.Write(" int: ({0}),", Enum.Format(typeof(EmpType), e, "D"));
               
            }
            Console.ReadLine();
            
            // system.object
            Console.WriteLine("***** Working with Object *****\n");
            Person_Object fred_object = new Person_Object("Fred", "Clark", "111-11-1111", 20);
            Console.WriteLine("-> fred.ToString: {0}", fred_object.ToString());
            Console.WriteLine("-> fred.GetHashCode: {0}", fred_object.GetHashCode());
            Console.WriteLine("-> fred's base class: {0}", fred_object.GetType().BaseType);
            // Make some other references to 'fred'.
            Person_Object p2_object = fred_object;
            object o = p2_object;
            // Are all 3 instances pointing to the same object in memory?
            if (o.Equals(fred) && p2_object.Equals(o))
                Console.WriteLine("fred_object, p2 and o are referencing the same object!");
            Console.ReadLine();
        }
        public static void SendAPersonByValue(Person p)
        {
            // Change the age of 'p'?
            p.age = 23;
            p.fullName = "N Cong Phuong";
            // Will the caller see this reassignment?
            p = new Person("Nikki", 99);
        }

        // A custom enumeration.
        enum EmpType
        {
            Manager, // = 0
            Grunt, // = 1
            Contractor, // = 2
            VP // = 3
        }
    }
}
