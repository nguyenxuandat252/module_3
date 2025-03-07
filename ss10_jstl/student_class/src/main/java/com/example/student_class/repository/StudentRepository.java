package com.example.student_class.repository;

import com.example.student_class.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private final static String SELECT_ALL = "select * from student;";
    private final static String ADD_NEW = "insert into student(name,age,point,id_class) values (?,?,?,?)";
    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = ConnectDatabase.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                float point = resultSet.getFloat("point");
                int classId = resultSet.getInt("id_class");
                Student student = new Student(id,name,age,point,classId);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        Connection connection= ConnectDatabase.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(4,student.getClassId());
            int row = preparedStatement.executeUpdate();
            return row==1;
        } catch (SQLException e) {
            System.out.println("lỗi");
            return false;
        }
    }

    @Override
    public Student findById(int id) {
        String query = "SELECT * FROM student WHERE id = ?";
        Connection connection = ConnectDatabase.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getFloat("point"),
                        resultSet.getInt("id_class")
                );
            }
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return null;
    }

    @Override
    public boolean update(int id, Student student) {
        String query = "UPDATE student SET name = ?, age = ?, point = ?, id_class = ? WHERE id = ?";
        try (Connection connection = ConnectDatabase.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setInt(4, student.getClassId());
            preparedStatement.setInt(5, student.getId());

            int row = preparedStatement.executeUpdate();
            return row == 1 ;
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from student where id = ?";
        try (Connection connection = ConnectDatabase.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,id);

            int row = preparedStatement.executeUpdate();
            return row == 1 ;
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return false;
    }

    @Override
    public List<Student> searchById(String keyword) {
        List<Student> studentList = new ArrayList<>();
        String query;
        Connection connection = ConnectDatabase.getConnectDB();
        if(keyword.matches("\\d+")){
            query = "select * from student where id= ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(keyword));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    float point = resultSet.getFloat("point");
                    int classId = resultSet.getInt("id_class");
                    Student student = new Student(id,name,age,point,classId);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                System.out.println("lỗi");
            }
        }else {
            query = "select * from student where name LIKE";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, "%"+keyword+"%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    float point = resultSet.getFloat("point");
                    int classId = resultSet.getInt("id_class");
                    Student student = new Student(id,name,age,point,classId);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                System.out.println("lỗi");
            }
        }
        return studentList;
    }
}
