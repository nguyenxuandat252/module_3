package com.example.testmodule3.service;

import com.example.testmodule3.dto.RoomDto;
import com.example.testmodule3.model.Room;
import com.example.testmodule3.repository.IRoomRepository;
import com.example.testmodule3.repository.RoomRepository;

import java.util.List;

public class RoomService implements IRoomService{
    private IRoomRepository roomRepository = new RoomRepository();
    @Override
    public List<RoomDto> getAll() {
        return roomRepository.getAll();
    }

    @Override
    public boolean add(Room room) {
        return roomRepository.add(room);
    }

    @Override
    public boolean delete(int id) {
        return roomRepository.delete(id);
    }

    @Override
    public List<RoomDto> search(String code) {
        return roomRepository.search(code);
    }
}
