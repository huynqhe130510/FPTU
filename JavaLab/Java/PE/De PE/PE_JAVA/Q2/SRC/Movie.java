
public class Movie implements Comparable<Movie>{   
    String title;
    int length;
    public Movie() {
    }

    public Movie(String title, int length) {
        this.title = title;
        this.length = length;
    }

    /*the below function return the value of movie length*/

    public int getLength() {
        return length;
    }
  
    /*the below function return the value of movie title*/

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }
    
}
