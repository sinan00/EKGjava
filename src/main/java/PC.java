import data.HospitalObservable;
import data.HospitalObserver;
import data.SerialConnector;

import java.util.LinkedList;

// This class has a list, producer (adds items to list
// and consumber (removes items).
public class PC
implements HospitalObservable
{

    SerialConnector serialConnector = new SerialConnector();
    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 1000;
    private HospitalObserver observer;

    // Function called by producer thread
    public void produce() throws InterruptedException {

        while (true) {
            synchronized (this) {
                // producer thread waits while list
                // is full
                while (list.size() == capacity)
                    wait();
                int[] value = serialConnector.getData();

                // to insert the jobs in the list
                for (int i = 0; i < value.length; i++) {
                    list.add(value[i]);

                }

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to understand
                Thread.sleep(10);
            }
        }
    }
    // Function called by consumer thread
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // consumer thread waits while list
                System.out.println("consumer started");
                while (list.size() < 50)
                    wait();

                // to retrive the ifrst job in the list
                LinkedList<Integer> removedObject = list;
                observer.notify(removedObject);
                list= new LinkedList<>();

                System.out.println("Consumer consumed");

                // Wake up producer thread
                notify();

                //and sleep
                //Thread.sleep(1000);
            }
        }
    }

    @Override
    public void register(HospitalObserver hospitalObserver) {
this.observer=hospitalObserver;
    }

    @Override
    public void run() {

    }
}
