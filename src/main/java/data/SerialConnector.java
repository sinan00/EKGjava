package data;

import jssc.*;

public class SerialConnector {
    private SerialPort serialPort = null;
    private String result = null;

    public SerialConnector() {
        //konstruktør oprettes

        String[] portnames = null;//oprettelse af StringArray

        try {
            portnames = SerialPortList.getPortNames();//her hentes navnene til portene der er tilkoblet computeren
            serialPort = new SerialPort(portnames[0]);//objektet serialPort tildeles den første port
            serialPort.openPort();//porten åbnes
            serialPort.setRTS(true);//klar til at sende(ReadyToSend = true)
            serialPort.setDTR(true);//klar til at modtage(DataToReceive = true)
            serialPort.setParams(115200, 8, 1, SerialPort.PARITY_NONE);//parametre bestemmes
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);//kontrolere flowet af data

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int[] getData() {//metoden oprettes

        try {
            if (serialPort.getInputBufferBytesCount() >= 12) {//kontrolstruktur
                result = serialPort.readString();//strengen aflæses og tildeles result
                String[] rawValues= null;
                if (result != null) {//result kontroleres
                    rawValues = result.split("\r\n");//nu splittes strengen og gemmes i et array
                }
                if (rawValues != null && rawValues.length >= 1) {//kontrollere om rawValues har nok indexer til konvertering
                    try {
                        int[] returnArray = new int[rawValues.length];//returnArray oprettes med ir som 0. index og red som 1. index
                        for (int i = 0; i < rawValues.length; i++) {
                           if (!rawValues[i].equals(""))
                            returnArray[i] = Integer.parseInt(rawValues[i].trim());
                            
                        }
                        return returnArray;//returnArray returneres
                    } catch (Exception e) {//hvis der er et problem tildeles EKGdata værdien 0
                      e.printStackTrace();


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new int[0];
    }
}