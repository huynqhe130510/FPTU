public class Password {
    String password;
    String role;
    
    public Password() {
    }

    public Password(String password, String role) {
        this.password = password;
        this.role = role;
    }
    
     
    public String getCode() {
        String pass = null;
        if(password.length() > 4){
            for(int i = 0; i < password.length();i++){
                char c = password.charAt(i);       
                if(Character.isLetter(c)){
                    
                        pass = password.replaceAll("a","*");
                   
                }   
            }
            
        }
        StringBuilder str = new StringBuilder(pass);
        for(int i = 0; i < str.length()-3; i+=4){
            str.insert(i+3, "-");
        }  
        return new String(str);
    }

    public String getRole() {
        return role.toLowerCase();
    }
    
    
    
    @Override
    public String toString() {
        return this.role + " " + this.password;
    }
    /*add more need method around here*/
}
