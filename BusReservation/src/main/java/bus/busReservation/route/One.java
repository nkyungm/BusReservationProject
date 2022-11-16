package bus.busReservation.route;

import bus.busReservation.domain.Timetable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class One {

    public List<Timetable> t = new ArrayList<>();

    public One(List<Timetable> t) {
        this.t = t;
    }
}
