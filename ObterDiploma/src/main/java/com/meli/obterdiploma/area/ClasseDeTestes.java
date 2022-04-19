package com.meli.obterdiploma.area;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Comparator;
import java.util.List;

public class ClasseDeTestes {

    public static void main(String[] args) {

    }

    public Room getBiggestRoom(){

    }
}


    @PostMapping("/realEstate")
    public ResponseEntity<Room> returnBiggestRoom(@RequestBody RealEstate realEstate) {

        RoomService roomService = new RoomService();

        Room biggestRoom = roomService.getBiggestRoom(realEstate);

        return ResponseEntity.ok(biggestRoom);

    }

    public Room getBiggestRoom(RealEstate realEstate) {
        List<Room> rooms = realEstate.getRooms();
        rooms.sort(Comparator.comparing(room -> getRoomArea(room).shortValue()));

        return rooms.get(rooms.size() - 1);
    }
