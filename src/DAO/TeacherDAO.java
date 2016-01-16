package DAO;

import Biz.StudentCourseMark;
import Biz.Teacher.Teacher;
import Database.Database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 11/16/2015.
 */
public class TeacherDAO {

    private Database database;

    public TeacherDAO() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    public void create(Teacher teacher) throws SQLException {

        database.addTeacher(teacher);
    }

    public void update(Teacher teacher) throws SQLException {

        database.editTeacher(teacher);
    }

    public void delete(int teacherId) throws SQLException {

        database.deleteTeacher(teacherId);
    }

    public List<Teacher> loadList() throws SQLException {

        return database.loadAllTeachers();
    }

    public Teacher loadByTeacherId(int teacherId) throws SQLException {

        return database.loadTeacherByTeacherId(teacherId);
    }

    public Teacher loadByUserId(Integer userId) throws SQLException {

        return database.loadTeacherByUserId(userId);
    }


    public List<StudentCourseMark> loadStudentCourseListByTeacherId(int teacherId) throws SQLException {
        return database.loadStudentCourseListByTeacherId(teacherId);
    }

    public void updateScore(int gradeId, int score) throws SQLException {
        database.updateStudent_Course_Mark(gradeId, score);
    }

    public StudentCourseMark loadTranscriptOfStudent(int gradeId) throws SQLException {
        return database.loadStudentCourseOfStudent(gradeId);
    }
}
