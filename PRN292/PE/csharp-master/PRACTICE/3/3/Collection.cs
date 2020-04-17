using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace LAB1
{
    class MyCollection<T>
    {
        public delegate void OnLengthChanged(int newLength);
        public event OnLengthChanged LengthChanged;
        public delegate void OnOrderChanged();
        public event OnOrderChanged OrderChanged;

        List<T> InnerList;
        public MyCollection()
        {
            InnerList = new List<T>();
        }
        public bool AddItem(T item)
        {
            try
            {
                for (int i = 0; i < InnerList.Count; i++)
                    if (InnerList[i].Equals(item))
                        throw new ExistingItemException(InnerList[i].ToString());
                InnerList.Add(item);
                if (LengthChanged != null) LengthChanged(InnerList.Count);
                return true;
            }
            catch (ExistingItemException e)
            {
                Console.WriteLine(e.Message);
                return false;
            }
            catch (Exception e)
            {
                return false;
            }
        }
        public bool Remove(T item)
        {
            try
            {
                InnerList.Remove(item);
                if (LengthChanged != null) LengthChanged(InnerList.Count);
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }

        public string Search(T item)
        {
            for (int i = 0; i < InnerList.Count; i++)
                if (InnerList[i].Equals(item))
                    return "found at postion " + i;
            return "not found";
        }

        public void Sort()
        {

            List<T> oldList = new List<T>(InnerList);

            InnerList.Sort();

            for (int i = 0; i < InnerList.Count; i++)
            {
                if (InnerList[i].Equals(oldList[i]))
                {

                }
                else
                {
                    if (OrderChanged != null) OrderChanged();
                    break;
                }
            }

        }

        public void Sort(IComparer<T> comparer)
        {
            List<T> oldList = new List<T>(InnerList);


            InnerList.Sort(comparer);


            for (int i = 0; i < InnerList.Count; i++)
            {
                if (!InnerList[i].Equals(oldList[i]))

                {
                    if (OrderChanged != null) OrderChanged();
                    break;
                }
            }



        }

        public int GetLength()
        {
            return InnerList.Count;
        }

        public T GetItemByPosition(int index)
        {
            try
            {
                return InnerList[index];
            }
            catch (Exception e)
            {
                throw e;
            }
        }
    }
    class AutoCollection : MyCollection<Auto>
    {
        public AutoCollection() : base()
        {
        }
        public Auto CreateItem(string line)
        {
            try
            {
                string[] arr = line.Trim().Split('|');
                int id = Convert.ToInt32(arr[1]);
                int basePrice = Convert.ToInt32(arr[2]);
                int year = Convert.ToInt32(arr[3]);
                int a4 = Convert.ToInt32(arr[4]);
                int a5 = Convert.ToInt32(arr[5]);
                if (arr[0].Equals("1"))
                {

                    return new Truck(id, basePrice, year, a4, a5);
                }
                else
                    return new Car(id, basePrice, year, a4, a5);
            }
            catch (Exception e)
            {
                return null;
            }
        }
        public void ReadFromFile(string FileName)
        {
            try
            {
                StreamReader reader = new StreamReader(FileName);
                string line;
                while ((line = reader.ReadLine()) != null)
                    AddItem(CreateItem(line));
                reader.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("Co loi trong luc doc file");
            }
        }
        public void WriteToFile(string FileName)
        {
            try
            {
                StreamWriter writer = new StreamWriter(FileName);
                for (int i = 0; i < GetLength(); i++)
                    writer.WriteLine(GetItemByPosition(i).ToString());
                writer.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("Co loi trong qua trinh ghi file");
            }
        }

        public void DemoUsingEmpCollection()
        {
            string InputFile = @"D:\C# Ky 5\LAB1\data.txt";
            string OutputFile = @"D:\C# Ky 5\LAB1\out.txt";
            ReadFromFile(InputFile);
            AddItem(new Truck(10, 100, 5, 2000, 1000.5));   
            AddItem(new Car(20, 200, 4, 8, 50.25));
            AddItem(new Truck(123, 54, 800, 100, 2.75));
            AddItem(new Car(50, 156, 1998, 5, 12.08));

            Console.WriteLine(Search(new Car(20, 156, 1998, 5, 12.008)));
            Remove(new Car(123, 123123, 80132120, 101320, 2.7335));
            Sort(new IDComparer());
            Sort(new BasePriceComparer());

            WriteToFile(OutputFile);
        }
    }
}
