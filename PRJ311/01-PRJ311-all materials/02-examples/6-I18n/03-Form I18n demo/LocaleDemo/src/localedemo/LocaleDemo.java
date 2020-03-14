package localedemo;
import java.util.*; // Locale,ResourceBundle
public class LocaleDemo {
    public static void main(String[] args) {
  Locale xLocale; ResourceBundle xBundle;
  String xFname, xLang, xCountry,xKey;
  xFname = "localedemo/myBundle";
  xLang = "en";
  xCountry = "US";
  xKey = "wish";
  xLocale = new Locale(xLang, xCountry);
  xBundle = ResourceBundle.getBundle(xFname, xLocale);
  String s = xBundle.getString(xKey); // Happy new year
  System.out.println(s);
    }
    
}
