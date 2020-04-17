using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Chapter10
{
    class GenericSample <T>
    {
        private T[] array;
        public GenericSample(int size)
        {
            array = new T[size + 1];
        }

        public T getItem(int index)
        {
            return array[index];
        }

        public void setItem(int index, T value)
        {
            array[index] = value;
        }

    }
}
