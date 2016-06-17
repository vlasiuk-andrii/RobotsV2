class Robot implements Runnable {
    Robot( int number, int behaviour){
        threadNumber = number;
        threadBehaviour = behaviour;
        //System.out.println("Creating " +  threadName );
    }

        /*  main schema of robots' location
    *       2(^3)cable2      R1      2(^0)fork1
    *       R4                             R2
    *       2(^2)fork2       R3      2(^1)cable1
    */

    private Thread t;
    private int threadNumber;
    private int threadBehaviour;
    private int charge = 50;


    public void start () {
        System.out.println("Start r" +  threadNumber );
        if (t == null) {
            t = new Thread (this, String.valueOf(threadNumber));
            t.start ();
        }
    }

    public void run() {
        System.out.println("Running " +  threadNumber );
        try {
            for(int time = 0; time < 30; time+=0.5) {
                System.out.println("Time:" + time);
                printStatus();
                doStartAction();
                Thread.sleep(3000);
                doEndAction();
                printStatus();
                System.out.println("");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread r" +  threadNumber + " interrupted.");
        }
        System.out.println("Thread r" +  threadNumber + " exiting.");
    }


    public void printStatus(){
        String robotOwn = new String("empty_value");
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
        System.out.println("r" + threadNumber + ": " + charge + "%" + ", has: " + robotOwn);
    }

    public void doStartAction(){
        switch (threadBehaviour){
            case 1: //random
                if (charge < 100 & Values.own == "0000"){
                    Values.own = String.valueOf( Integer.toBinaryString((3 * threadNumber)) );
                    charge += 10;
                }
                break;
            case 2: //gready
                break;
            case 3: //gentleman
                break;
        }
        System.out.println(threadNumber + " in progress...");
    }

    public void doEndAction(){
        charge -= 5;
        Values.chargeArray[ threadNumber ] = charge;
        // give or not to give stuff
        switch (threadBehaviour){
            case 1: //random
                break;
            case 2: //gready
                break;
            case 3: //gentleman
                break;
        }
    }

}