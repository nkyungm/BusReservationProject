package bus.busReservation.dto;

import bus.busReservation.domain.Timetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TimetableDto {
    private String bus_name;
    private String busstop_name;
    private Time time;

    public TimetableDto(Timetable timetable){
        bus_name= timetable.getBus().getName();
        busstop_name=timetable.getBusStop().getName();
        time=timetable.getTime();
    }
}
