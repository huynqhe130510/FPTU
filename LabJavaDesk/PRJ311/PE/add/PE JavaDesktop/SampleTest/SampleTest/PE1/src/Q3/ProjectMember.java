/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;


/**
 *
 * @author dell
 */
public class ProjectMember implements Comparable<ProjectMember>{
    
    private int pId;
    private String eId;
    private boolean isFulltime;
    private int hour;

    public ProjectMember() {
    }

    public ProjectMember(int pId, String eId, boolean isFulltime, int hour) {
        this.pId = pId;
        this.eId = eId;
        this.isFulltime = isFulltime;
        this.hour = hour;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public boolean getFulltime() {
        return isFulltime;
    }

    public void setFulltime(boolean isFulltime) {
        this.isFulltime = isFulltime;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    
    public Object[] toObjects(){
        return new Object[]{
          pId,eId,isFulltime,hour  
        };
    }

    @Override
    public int compareTo(ProjectMember o) {
        return hour<o.hour?1:-1;
    }
    
    
    
    
}
