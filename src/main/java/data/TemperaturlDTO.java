package data;

import java.sql.Timestamp;

public class TemperaturlDTO {
    private int id;
    private String hospitalId;
    private String hospitalStationID;
    private double Temperatur;
    private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalStationID() {
        return hospitalStationID;
    }

    public void setHospitalStationID(String hospitalStationID) {
        this.hospitalStationID = hospitalStationID;
    }

    public double getTemperatur() {
        return Temperatur;
    }

    public void setTemperatur(double temperatur) {
        Temperatur = temperatur;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}

