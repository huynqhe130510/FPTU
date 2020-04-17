using System;

namespace ch6_SE1315_01
{
    class Student
    {
        String name;
        int mark;
        int numberAbsent;

        public Student(String name, int mark, int numberAbsent)
        {
            this.Name = name;
            this.mark = mark;
            this.numberAbsent = numberAbsent;
        }

        public string Name { get => name; set => name = value; }

        public void TestAbsent()
        {
            if (numberAbsent > 6)
            {
                Exception ex = new Exception(String.Format("Name = {0}, NumberAbsent = {1}", name, numberAbsent));
                throw ex;
            }
        }

        public void TestMark()
        {
            /*int[] ar = new int[2];*/
            /*ar[2] = 10;*/
            if (mark < 4)
            {
                Exception ex = new Exception(String.Format("Name = {0}, Mark = {1}", Name, mark));
                throw ex;
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Student[] sl = new Student[4];
            sl[0] = new Student("A", 10, 5);
            sl[1] = new Student("B", 6, 1);
            sl[2] = new Student("C", 3, 7);
            sl[3] = new Student("D", 4, 0);
            foreach (Student s in sl)
            {
                try
                {
                    /*s.TestMark();*/
                    s.TestAbsent();
                }

                /*catch (IndexOutOfRangeException ex)
                {
                    Console.WriteLine("Catch #1");
                    Console.WriteLine(ex.Message);
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Catch #2");
                    Console.WriteLine(ex.Message);
                }*/
                catch(Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                finally
                {
                    Console.WriteLine(string.Format("Student {0} is tested", s.Name));
                }
            }
            Console.ReadLine();
        }
    }
}
