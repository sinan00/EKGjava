/*
package data;

import java.sql.Timestamp;

public class HospitalDataGenerator implements HospitalObservable {
    private HospitalObserver hospitalObserver;

    @Override
    public void register(HospitalObserver hospitalObserver) {
        this.hospitalObserver = hospitalObserver;
    }

    @Override
    public void run() {
        while (true){
            TemperaturlDTO temperaturlDTO = new TemperaturlDTO();
            temperaturlDTO.setTime(new Timestamp(System.currentTimeMillis()));
            temperaturlDTO.setTemperatur(Math.random()*10+30);
            if (hospitalObserver != null) {
                hospitalObserver.notify(temperaturlDTO);
                
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
*/