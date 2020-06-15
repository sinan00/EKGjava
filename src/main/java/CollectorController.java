import data.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CollectorController implements HospitalObserver {
    public TextArea hospitalDataOutput;
    public TextField idField;  //id for flere hospitaler
    private boolean record;
    private HospitalDAO TemperaturDAO = new HospitalDAOSQLImpl();

    public void startDataCollection(ActionEvent actionEvent) throws InterruptedException {
        Threadmanager threadmanager = new Threadmanager();
        threadmanager.startcollecting(this);

    }

    public void startRecording(ActionEvent actionEvent) {
        this.record = !this.record;
    }


    public void loadData(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loadGUI.fxml"));
        try {
            FlowPane flowPane = fxmlLoader.load();
            Stage loadStage = new Stage();
            loadStage.setScene(new Scene(flowPane));
            loadStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void notify(List<Integer> measurements) {
        //Show data
        String text = hospitalDataOutput.getText();
        TemperaturlDTO temperaturlDTO = new TemperaturlDTO();
        text += "New Data! Time:" + temperaturlDTO.getTime() + ",Temperatur:" + temperaturlDTO.getTemperatur() + "\r\n";
        String finalText = text;
        System.out.println(finalText);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
             hospitalDataOutput.setText(finalText);
            }
        });

        //Save data
        if (this.record) {
            temperaturlDTO.setHospitalStationID(idField.getText());
            TemperaturDAO.save(temperaturlDTO);
        }
    }
}