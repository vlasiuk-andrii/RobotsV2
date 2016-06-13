class Robot implements Runnable {
    private Thread t;
    private String threadName;
    private int threadBehaviour;


    Robot( String name, int behaviour){
        threadName = name;
        threadBehaviour = behaviour;
        //System.out.println("Creating " +  threadName );
    }


    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", output:" + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start ()
    {
        System.out.println("Start " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}