package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAOSQLImpl implements HospitalDAO {
    @Override
    public void save(TemperaturlDTO temperaturlDTO) {
        Connection conn = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO hospitalData(hospitalStationId, Temperatur,  time) VALUES (?,?,?)"); {
                preparedStatement.setString(1, temperaturlDTO.getHospitalStationID());
                preparedStatement.setDouble(2, temperaturlDTO.getTemperatur());
                preparedStatement.setTimestamp(3, temperaturlDTO.getTime());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TemperaturlDTO> load(Timestamp time) {
        List <TemperaturlDTO> data = new ArrayList<>();
        Connection connection = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hospitalData WHERE time > ?");
            preparedStatement.setTimestamp(1,time);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TemperaturlDTO temperaturlDTO = new TemperaturlDTO();
                temperaturlDTO.setId(resultSet.getInt("id"));
                temperaturlDTO.setHospitalStationID(resultSet.getString("hospitalStationId"));
                temperaturlDTO.setTemperatur(resultSet.getDouble("Temperatur"));
                temperaturlDTO.setTime(resultSet.getTimestamp("time"));
                data.add(temperaturlDTO);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;


    }
    }

