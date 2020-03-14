/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DepartmentModel;
import model.StudentModel;

/**
 *
 * @author sonnt
 */
public class StudentDAO extends BaseDAO<StudentModel> {

    @Override
    public ArrayList<StudentModel> all() {
        try {
            ArrayList<StudentModel> students = new ArrayList<>();
            String sql = "SELECT [id]\n" +
                    "      ,[name]\n" +
                    "      ,[gender]\n" +
                    "      ,[dob]\n" +
                    "  FROM [Student_1]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                StudentModel student = new StudentModel();
                student.setId( rs.getInt("id")  );
                student.setName(rs.getString("name")  );
                student.setDob(rs.getDate("dob")  );
                student.setGender(rs.getBoolean("gender")  );
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<StudentModel> search(
            int id, // -1 all
            String name, //blank all
            Date from, // null all
            Date to, // null all
            Boolean gender, // null all
            int did // -1 all
    )
    {
        try {
            String sql = "SELECT \n" +
                    "s.id,\n" +
                    "s.name,\n" +
                    "s.dob,\n" +
                    "s.gender,\n" +
                    "s.did,\n" +
                    "d.name as dname\n" +
                    "FROM\n" +
                    "Student_1 s INNER JOIN Department d\n" +
                    "ON s.did = d.id\n" +
                    "WHERE\n" +
                    "1=1 ";
            
            HashMap<Integer,Object[]> params = new HashMap<>();
            int param_index = 0;
            
            if(id != -1)
            {
                param_index++;
                sql += " AND s.id = ? ";
                Object[] param = {"INT",id};
                params.put(param_index, param);
            }
            
            if(name.length()>0)
            {
                param_index++;
                sql+=" AND s.name like '%' + ? + '%' ";
                Object[] param = {"STRING",name};
                params.put(param_index, param);
            }
            
            if(from !=null)
            {
                param_index++;
                sql+=" AND s.dob >= ? ";
                Object[] param = {"DATE",from};
                params.put(param_index, param);
            }
            
            if(to !=null)
            {
                param_index++;
                sql+=" AND s.dob <= ? ";
                Object[] param = {"DATE",to};
                params.put(param_index, param);
            }
            
            if(gender !=null)
            {
                param_index++;
                sql+=" AND s.gender = ? ";
                Object[] param = {"BOOLEAN",gender};
                params.put(param_index, param);
            }
            
            if(did != -1)
            {
                param_index++;
                sql+=" AND s.did = ? ";
                Object[] param = {"INT",did};
                params.put(param_index, param);
            }
            
            PreparedStatement statment = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : params.entrySet()) {
                Integer key = entry.getKey();
                Object[] value = entry.getValue();
                
                if(value[0].equals("INT"))
                {
                    statment.setInt(key, (int)value[1]);
                }
                else if(value[0].equals("STRING"))
                {
                    statment.setString(key, value[1].toString());
                }
                if(value[0].equals("DATE"))
                {
                    statment.setDate(key, (Date)value[1]);
                }
                if(value[0].equals("BOOLEAN"))
                {
                    statment.setBoolean(key, (Boolean)value[1]);
                }
            }
            
            ArrayList<StudentModel> students = new ArrayList<>();
            ResultSet rs = statment.executeQuery();
            while(rs.next())
            {
                StudentModel student = new StudentModel();
                student.setId( rs.getInt("id")  );
                student.setName(rs.getString("name")  );
                student.setDob(rs.getDate("dob")  );
                student.setGender(rs.getBoolean("gender"));
                DepartmentModel d = new DepartmentModel();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                student.setDepartment(d);
                students.add(student);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    @Override
    public StudentModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(StudentModel model) {
        try {
            String sql = "INSERT INTO [Student_1]\n" +
                    "           ([id]\n" +
                    "           ,[name]\n" +
                    "           ,[gender]\n" +
                    "           ,[dob]"
                    + "         ,[did])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,? , ?)";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, model.getId());
            statement.setString(2, model.getName());
            statement.setBoolean(3, model.isGender());
            statement.setDate(4, model.getDob());
            statement.setInt(5, model.getDepartment().getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
