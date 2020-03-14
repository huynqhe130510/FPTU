/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Movie;
import model.Movie_Type;

/**
 *
 * @author huyNguyen
 */
public class InsertDAO extends DBContext {

    public void insertMovie(int id, String title) {
        try {
            String insert_Movie
                    = "INSERT INTO [PRJ321].[dbo].[Movie]\n"
                    + "           ([id]\n"
                    + "           ,[title])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement insertPreparedStatement
                    = connection.prepareStatement(insert_Movie);
            insertPreparedStatement.setInt(1, id);
            insertPreparedStatement.setString(2, title);
            insertPreparedStatement.executeUpdate();

        } catch (SQLException sQLException) {
        }
    }

    public void insertMovieType(int mid, String[] tid) {
        try {
            String insert_MovieTYpe
                    = "INSERT INTO [PRJ321].[dbo].[Movie_Type]\n"
                    + "           ([mid]\n"
                    + "           ,[tid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";

            for (int i = 0; i < tid.length; i++) {
                PreparedStatement insertPreparedStatement
                        = connection.prepareStatement(insert_MovieTYpe);
                insertPreparedStatement.setInt(1, mid);
                insertPreparedStatement.setString(2, tid[i]);
                insertPreparedStatement.executeUpdate();
            }
        } catch (SQLException sQLException) {
        }
    }
}
