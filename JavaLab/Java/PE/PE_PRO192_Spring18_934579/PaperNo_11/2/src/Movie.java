
public class Movie {   
    int length;
    String title;
    public Movie() {
        
    }

    
    public Movie(String title, int length) {
        this.length=length;
        this.title=title;
    }

    /*the below function return the value of movie length*/
    public int getLength() {
        return length;
    }

    /*the below function return the value of movie title*/
    public String getTitle() {
        return title;
    }
 
}
