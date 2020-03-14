

 
import java.util.*;

public class MyCourse implements ICourse { 

     
    @Override
    public void f1(List<Course> a, int st) {
       if(st==1){
       Comparator u= new Comparator<Course>(){
           @Override
           public int compare(Course a, Course a1){
               if(a.fee>a1.fee) return 1;
               else if(a.fee==a1.fee) return 0;
               else return -1;
                
            }     
        };
       Collections.sort(a,u);
       }
       else{
           Comparator u= new Comparator<Course>(){
           @Override
           public int compare(Course a1, Course a2){               
                return a2.getName().compareToIgnoreCase(a1.getName());
            }     
        };
       Collections.sort(a,u);
    }
    }

    @Override
    public int f2(List<Course> a, double fee) {
        int count =0;
        for(int i=0;i<a.size();i++){
            if(a.get(i).fee>=fee) count++;
        }
        return count;
    }
    @Override
    public void f3(List<Course> t, int k, int h){
      Course [] a;
      Object [] b = t.toArray();
      int n,i,j; Course x;
      n=b.length;
      a= new Course[n];
      for(i=0;i<n;i++) a[i]=(Course) b[i];
      //coud change by another ways behind
      for(i=k;i<h;i++){
          for(j=i+1;j<=h;j++){
              if(a[j].fee < a[i].fee){
                  x=a[j]; a[j]=a[i];a[i]=x;
              }
          }
      }
      t.clear();
      for(i=0;i<n;i++) t.add(a[i]);
      /*another ways
      
      Comparator<Course> u= new Comparator<Course>(){
          public int compare(Course x, Course y){
              if(x.fee<y.fee) return -1;
              else if(x.fee==y.fee) return 0;
              else return 1;
          }
      };
      Arrays.sort(a,k,h,u);
      t.clear();
      for(i=0;i<n;i++) t.add(a[i]);
      
      */
  }
            
    @Override
    public void f4(List<Course>a, double xFee){
        int count=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i).fee<xFee) count++;
            if(count==2) a.remove(i);
        }
    }
    @Override
    public void f5(List<Course> t){
      Course [] a;
      Object [] b = t.toArray();
      int n,i,j; Course x;
      n=b.length;
      a= new Course[n];
      for(i=0;i<n;i++) a[i]=(Course) b[i];
      for(i=0;i<n/2;i++){
          x=a[i];
          a[i]=a[n-i-1];
          a[n-i-1]=x;
      }
      t.clear();
      for(i=0;i<n;i++) t.add(a[i]);
    }
}
