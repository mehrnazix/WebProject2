package Biz;

import DAO.GradeDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 12/26/2015.
 */
public class GradeBLO {

    private GradeDAO gradeDAO;

    public GradeBLO() throws SQLException, ClassNotFoundException {

        gradeDAO = new GradeDAO();
    }

    public List<Grade> loadListByStudentId(int studentId) throws SQLException {

        return gradeDAO.loadListByStudentId(studentId);
    }

    public List<Grade> loadListByTeacherId(int studentId) throws SQLException {

        return gradeDAO.loadListByTeacherId(studentId);
    }

    public void delete(int gradeId) throws SQLException {
        gradeDAO.delete(gradeId);
    }

    public void update(int gradeId, int score) throws SQLException {
        gradeDAO.update(gradeId, score);
    }

    public void add(int courseId, int studentId) throws SQLException {
        gradeDAO.add(courseId, studentId);
    }
}
