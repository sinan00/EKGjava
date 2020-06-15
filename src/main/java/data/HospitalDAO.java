package data;

import java.sql.Timestamp;
import java.util.List;

public interface HospitalDAO {
    void save(TemperaturlDTO temperaturlDTO);

    List<TemperaturlDTO> load(Timestamp time);
}
