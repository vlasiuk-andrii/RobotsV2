class Robot implements Runnable {
    private Thread t;
    private String threadName;
    private int threadBehaviour;
    private int charge = 50;


    /*  main schema of robots' location
    *       2(^3)cable2      R1      2(^0)fork1
    *       R4                             R2
    *       2(^2)fork2       R3      2(^1)cable1
    */


    Robot( String name, int behaviour){
        threadName = name;
        threadBehaviour = behaviour;
        //System.out.println("Creating " +  threadName );
    }


    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int time = 0; time < 30; time++) {
                printStatus();
                doStartAction();
                Thread.sleep(3000);
                doEndAction();
                printStatus();
                System.out.println("");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Start " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
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
        System.out.println(threadName + ": " + charge + "%" + ", has: " + robotOwn);
    }

    public void doStartAction(){
        if (1 == threadBehaviour){
            //random

        } else if (2 == threadBehaviour){
                //greedy

            } else if (3 == threadBehaviour){
                    //gentleman

        }
    }

    public void doEndAction(){
        charge -= 5;
        Values.chargeArray[ Integer.parseInt(threadName.substring(1,2)) ] = charge;
        // give or not to give stuff
    }

}