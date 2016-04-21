public class ChargingStuff {

    boolean p1toR1 = false;
    boolean p1toR2 = false;
    boolean p1 = !(p1toR1 || p1toR2);

    boolean p2toR3 = false;
    boolean p2toR4 = false;
    boolean p2 = !(p2toR3 || p2toR4);

    boolean p3toR5 = false;
    boolean p3toR6 = false;
    boolean p3 = !(p3toR5 || p3toR6);

    boolean c1toR2 = false;
    boolean c1toR3 = false;
    boolean c1 = !(c1toR2 || c1toR3);

    boolean c2toR4 = false;
    boolean c2toR5 = false;
    boolean c2 = !(c2toR4 || c2toR5);

    boolean c3toR1 = false;
    boolean c3toR6 = false;
    boolean c3 = !(c3toR1 || c3toR6);

    int r1charge = -1;
    int r2charge = -1;
    int r3charge = -1;
    int r4charge = -1;
    int r5charge = -1;
    int r6charge = -1;

    void enableCheck(){
        if (p1toR1 && p1toR2){

        }
    }

}
