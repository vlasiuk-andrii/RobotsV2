public class Main {
    public static void main(String[] arg) {
        Input input = new Input();
        ChargingStuff stuff = new ChargingStuff();
        input.makeInput();
        double time = 0;
        int minCharge = 0;
        int maxCharge = 100;

        Robot r1 = new Robot(1);
        Robot r2 = new Robot(2);
        Robot r3 = new Robot(3);
        Robot r4 = new Robot(4);
        Robot r5 = new Robot(5);
        Robot r6 = new Robot(6);
        r1.behaviour = input.r1behaviourBuffer();
        r2.behaviour = input.r2behaviourBuffer();
        r3.behaviour = input.r3behaviourBuffer();
        r4.behaviour = input.r4behaviourBuffer();
        r5.behaviour = input.r5behaviourBuffer();
        r6.behaviour = input.r6behaviourBuffer();

        do{
            time+= 0.5;
            System.out.print(time+"\n");
            if(0 != r1.charge) {r1.charge -= 5;}
            if(0 != r2.charge) {r2.charge -= 5;}
            if(0 != r3.charge) {r3.charge -= 5;}
            if(0 != r4.charge) {r4.charge -= 5;}
            if(0 != r5.charge) {r5.charge -= 5;}
            if(0 != r6.charge) {r6.charge -= 5;}
            stuff.r1charge = r1.charge;
            stuff.r2charge = r2.charge;
            stuff.r3charge = r3.charge;
            stuff.r4charge = r4.charge;
            stuff.r5charge = r5.charge;
            stuff.r6charge = r6.charge;

            r1.todo();
            r2.todo();
            r3.todo();
            r4.todo();
            r5.todo();
            r6.todo();


            r1.wasCharged = false;
            r2.wasCharged = false;
            r3.wasCharged = false;
            r4.wasCharged = false;
            r5.wasCharged = false;
            r6.wasCharged = false;
        } while ((r1.charge>minCharge)&&(r2.charge>minCharge)&&(r3.charge>minCharge)&&(r4.charge>minCharge)&&(r5.charge>minCharge)&&(r6.charge>minCharge));

    }
}
