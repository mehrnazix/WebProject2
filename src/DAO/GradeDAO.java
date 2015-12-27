package DAO;

import Biz.Grade;
import Database.Database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 11/16/2015.
 */
public class GradeDAO {

    private Database database;

    public GradeDAO() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    public List<Grade> loadListByStudentId(int studentId) throws SQLException {

        return database.loadGradesByStudentId(studentId);
    }

    public List<Grade> loadListByTeacherId(int studentId) throws SQLException {

        return database.loadListByTeacherId(studentId);
    }

    public void delete(int gradeId) throws SQLException {
        database.deleteGrade(gradeId);
    }

    public void update(int gradeId, int score) throws SQLException {
        database.updateGrade(gradeId, score);
    }

    public void add(int courseId, int studentId) throws SQLException {
        database.addGrade(courseId, studentId);
    }
}
