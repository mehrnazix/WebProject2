package DAO;

import Biz.Course.Course;
import Biz.Teacher.Teacher;
import Database.Database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 11/16/2015.
 */
public class CourseDAO {

    private Database database;

    public CourseDAO() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    public void create(Course course) throws SQLException {

        database.addCourse(course);
    }

    public void update(Course course) throws SQLException {

        database.editCourse(course);
    }

    public void delete(int courseId) throws SQLException {

        database.deleteCourse(courseId);
    }

    public List<Course> loadList() throws SQLException {

        return database.loadAllCourses();
    }

    public Course loadByCourseId(int courseId) throws SQLException {

        return database.loadCourse(courseId);
    }

    public List<Teacher> loadTeacherList() throws SQLException {
        return database.loadTeachers();
    }


}
