package data;

import data.HospitalObserver;

public interface HospitalObservable extends Runnable { //interesseret i nye data
    void register (HospitalObserver hospitalObserver);
}
