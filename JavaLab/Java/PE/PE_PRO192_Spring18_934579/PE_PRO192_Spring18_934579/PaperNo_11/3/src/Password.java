

public class Password {
    String role;
    String password;
    public Password() {
        
    }
    public Password(String password, String role) {
        this.role=role;
        this.password=password;
    }
     
    public String getCode() {
        int i;
        char []a;
        a = password.toCharArray();
        for(i=0;i<password.length();i++){
            if((a[i]>='a' && a[i]<='z')||(a[i]>='A' && a[i]<='Z')){
                a[i]='*';
            }
        }
        StringBuilder s= new StringBuilder("");
        if(a.length>3){
           for(i=0;i<a.length-4;i+=3){
           s.append(a[i]);
           s.append(a[i+1]);
           s.append(a[i+2]);
           s.append('-');
        }
        s.append(a[a.length-4]);
        s.append(a[a.length-3]);
        s.append(a[a.length-2]);
        s.append('-');
        s.append(a[a.length-1]);
        }
        else{
            for(i=0;i<a.length;i++){
                s.append(a[i]);
            }
        }
        
        
        
        
        return s.toString();
    }
    
    public String getRole() {
        return role;
    }
    
    @Override
    public String toString() {
        String s= role+"    "+password;
        return s;
    }
    /*add more need method around here*/
}
