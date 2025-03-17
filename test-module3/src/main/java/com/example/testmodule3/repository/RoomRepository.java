package com.example.testmodule3.repository;

import com.example.testmodule3.dto.RoomDto;
import com.example.testmodule3.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements IRoomRepository{

    Connection connection = BaseRepository.getConnectDB();
    @Override
    public List<RoomDto> getAll() {
        List<RoomDto> roomDtos = new ArrayList<>();
        String query = "SELECT r.id, r.code, r.name, r.phone, r.start_date, r.id_pay, p.form, r.note \n" +
                "FROM room r \n" +
                "JOIN pay p ON r.id_pay = p.id;";
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                RoomDto roomDto = new RoomDto(resultSet.getInt("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("start_date"),
                        resultSet.getInt("id_pay"),
                        resultSet.getString("form"),
                        resultSet.getString("note")
                );
                roomDtos.add(roomDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roomDtos;
    }

    @Override
    public boolean add(Room room) {
        String query = "insert into room(code,name,phone,start_date,id_pay,note) values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, room.getCode());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setString(3, room.getPhone());
            preparedStatement.setString(4, room.getStartDate());
            preparedStatement.setInt(5, room.getIdPay());
            preparedStatement.setString(6, room.getNote());
            int row = preparedStatement.executeUpdate();
            return row == 1;
        } catch (SQLException e) {
            System.out.println("lỗi");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from room where id = ?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            return row == 1;
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return false;}

    @Override
    public List<RoomDto> search(String code) {
        List<RoomDto> roomDtos = new ArrayList<>();
        String query = "SELECT r.*, p.form \n" +
                "FROM room r \n" +
                "JOIN pay p ON r.id_pay = p.id \n" +
                "WHERE r.code LIKE ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"%"+code+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                RoomDto roomDto = new RoomDto(resultSet.getInt("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("start_date"),
                        resultSet.getInt("id_pay"),
                        resultSet.getString("form"),
                        resultSet.getString("note")
                );
                roomDtos.add(roomDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomDtos;}
}
