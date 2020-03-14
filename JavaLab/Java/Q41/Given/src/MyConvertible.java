
public class MyConvertible implements Convertible {
    double km;
    double mile;
    @Override
    public double toMile(double km) {
        return mile = km * 0.621371;
    }

    
    @Override
    public String getCode(String rc)
    {
        StringBuilder StringBuilder = new StringBuilder(rc);
        for (int i= rc.length()-3; i >=1; i-=3) {
           StringBuilder.insert(i, '-');
        }
        return StringBuilder.toString();
    }
}
