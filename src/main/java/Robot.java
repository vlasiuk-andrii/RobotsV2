import java.util.Arrays;

class Robot implements Runnable {
    Robot( int number, int behaviour){
        threadNumber = number;
        threadBehaviour = behaviour;
        //System.out.println("Creating " +  threadName );
    }

        /*  main schema of robots' location
    *       2(^3)cable2      R3      2(^0)fork1
    *       R4                             R1
    *       2(^2)fork2       R2      2(^1)cable1
    */

    private Thread t;
    private int threadNumber;
    private int threadBehaviour;
    private int charge = 50;
    String robotOwn = new String("empty_value");

    public int time = 0;



    public void start () {
        System.out.println("r" + threadNumber + " started");
        if (t == null) {
            t = new Thread (this, String.valueOf(threadNumber));
            t.start ();
        }
        Values.iterationArray[threadNumber-1]++;
        do {} while (Values.iterationArray[0]!=Values.iterationArray[1] & Values.iterationArray[1]!=Values.iterationArray[2] & Values.iterationArray[2]!=Values.iterationArray[3] & Values.iterationArray[3]!=Values.iterationArray[0]);
        System.out.println("r" + threadNumber + " iteratorArray=" + Arrays.toString(Values.iterationArray));
    }

    public void run() {
        System.out.println("r" + threadNumber + " is running");
        do{
            //System.out.println("r = " + threadNumber + " Time:" + time + ". Start of iteration for this robot");
            charge -= 5;

            refreshOwning();
            doStartAction();
            printStatus();
            refreshOwning();
            doEndAction();
            //System.out.println("r" + threadNumber + ". End of iteration for this robot");

            Values.iterationArray[threadNumber-1]++;
            do {} while (Values.iterationArray[0]!=Values.iterationArray[1] & Values.iterationArray[1]!=Values.iterationArray[2] & Values.iterationArray[2]!=Values.iterationArray[3] & Values.iterationArray[3]!=Values.iterationArray[0]);
            System.out.println("r" + threadNumber + " iteratorArray=" + Arrays.toString(Values.iterationArray));

            time += 0.5;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (charge != 0);
        System.out.println("Thread r" +  threadNumber + " exiting.");
    }

    public void refreshOwning(){
        switch (Values.own) {
            case "0000": robotOwn = "nothing";
                break;
            case "0011": robotOwn = "fork1, cable1";
                break;
            case "0110": robotOwn = "fork2, cable1";
                break;
            case "1100": robotOwn = "fork2, cable2";
                break;
            case "1001": robotOwn = "fork1, cable2";
                break;
        }
    }

    public void printStatus(){
        refreshOwning();
        System.out.println("r" + threadNumber + ": time=" + time + "  " + charge + "%" + ", has: " + robotOwn + " Behaviour=" + threadBehaviour);
    }

    public void doStartAction(){
        switch (threadBehaviour){
            case 1: //random
                if (charge < 100){
                    Values.own = String.valueOf( Integer.toBinaryString((3 * threadNumber)) );
                    charge += 10;
                    System.out.println("r" + threadNumber + " took stuff");
                }
                break;
            case 2: //gready
                break;
            case 3: //gentleman
                break;
        }

    }

    public void doEndAction(){
        Values.chargeArray[ threadNumber - 1 ] = charge;
        // give or not to give stuff
        switch (threadBehaviour){
            case 1: //random
                if (charge == 100 & Values.own != "0000"){
                    int i = Integer.parseInt(Values.own);
                    Values.own =  String.valueOf( (i/threadNumber) - 3 ); // make 0000 from 0011 (or 1001, or 1100, or 0110)
                    System.out.println("r" + threadNumber + " gave away " + robotOwn);
                }
                break;
            case 2: //gready
                break;
            case 3: //gentleman
                break;
        }
        //System.out.println("r" + threadNumber + " sleep -------------");
    }

}