package data;

import java.util.List;

public interface HospitalObserver {
    void notify(List<Integer> measurements);  //data transfor object
}
