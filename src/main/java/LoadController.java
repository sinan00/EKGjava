import data.HospitalDAO;
import data.HospitalDAOSQLImpl;
import data.SQLConnector;
import data.TemperaturlDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class LoadController {
    public DatePicker datePicker;
    public TextArea hospitalDataArea;

    public void LoadData(ActionEvent actionEvent) {
        LocalDateTime localDateTime = datePicker.getValue().atStartOfDay();
        Timestamp time = Timestamp.valueOf(localDateTime);
        HospitalDAO hospitalDAO = new HospitalDAOSQLImpl();
        List <TemperaturlDTO> hospitaData = hospitalDAO.load(time);
        String text = "";
        for (TemperaturlDTO data: hospitaData) {
            text += "ID:" + data.getId()+ ",Time:" + data.getTime() + ",Temperatur:" + data.getTemperatur()+ "\r\n";
            
        }
        hospitalDataArea.setText(text);


    }
}
