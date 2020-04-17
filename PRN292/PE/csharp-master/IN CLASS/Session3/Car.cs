using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter6
{
    class Car
    {
        // Constant for maximum speed.
        public const int maxSpeed = 100;
        // Internal state data.
        private int currSpeed;
        private string petName;
        // Is the car still operational?
        private bool carIsDead;
        // A car has-a radio.
        private Radio theMusicBox = new Radio();
        // Constructors.
        public Car() { }
        public Car(string name, int currSp)
        {
            currSpeed = currSp;
            petName = name;
        }
        public void CrankTunes(bool state)
        {
            // Delegate request to inner object.
            theMusicBox.TurnOn(state);
        }
        // See if Car has overheated.
        public void Accelerate(int delta)
        {
            if (carIsDead)
                Console.WriteLine("{0} is out of order...", petName);
            else
            {
                currSpeed += delta;
                if (currSpeed > maxSpeed)
                {
                    Console.WriteLine("{0} has overheated!", petName);
                    currSpeed = 0;
                    carIsDead = true;
                }
                else
                    Console.WriteLine("=> CurrSpeed = {0}", currSpeed);
            }
        }
        }
    }
