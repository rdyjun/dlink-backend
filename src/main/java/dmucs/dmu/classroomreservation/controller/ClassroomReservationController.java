package dmucs.dmu.classroomreservation.controller;

import dmucs.dmu.classroomreservation.dto.ClassroomReservationDTO;
import dmucs.dmu.classroomreservation.entity.Classroom;
import dmucs.dmu.classroomreservation.entity.ClassroomReservation;
import dmucs.dmu.classroomreservation.entity.RentalType;
import dmucs.dmu.classroomreservation.service.ClassroomReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Api(value="ApiController v1")
@RequestMapping("/reservation/room")
@RestController
@RequiredArgsConstructor
public class ClassroomReservationController {
    private final ClassroomReservationService classroomReservationService;
    @ApiOperation(value = "강의실 대여", notes = "강의실 대여에 대한 정보 저장")
    @PostMapping("/")
    public void saveOpenClassReservation (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        classroomReservationService.reservationToRoom(classroomReservationDTO);
    }
    @ApiOperation(value = "대여목록 확인", notes = "특정 날짜에 대한 대여 정보 출력")
    @PostMapping("/list")
    public ArrayList<ClassroomReservationDTO> getClassReservationList (@RequestBody ClassroomReservationDTO classroomReservationDTO) throws ParseException {
        return classroomReservationService.getClassReservationList(classroomReservationDTO);
    }
}
