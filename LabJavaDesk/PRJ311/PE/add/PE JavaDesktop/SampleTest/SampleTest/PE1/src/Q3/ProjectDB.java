/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ProjectDB {
    
    private final DBContext db = new DBContext();
    private Connection con = null;
    
    public ArrayList<Project> getProjectAll(){
        ArrayList<Project> list = new ArrayList<>();
        try{
            con = db.getConnection();
            String sql = "select * from Project";
            PreparedStatement ppsm = con.prepareStatement(sql);
            ResultSet rs = ppsm.executeQuery();
            while(rs.next()){
                Project p = new Project(rs.getInt(1),rs.getString(2));
                list.add(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
   
}
