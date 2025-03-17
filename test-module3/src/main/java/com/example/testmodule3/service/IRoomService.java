package com.example.testmodule3.service;

import com.example.testmodule3.dto.RoomDto;
import com.example.testmodule3.model.Room;

import java.util.List;

public interface IRoomService {
    List<RoomDto> getAll();
    boolean add(Room room);
    boolean delete(int id);
    List<RoomDto> search(String code);
}
