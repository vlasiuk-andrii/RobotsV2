public class Main {
    public static void main(String[] arg) {
        Input input = new Input();
        ChargingStuff stuff = new ChargingStuff();
        input.makeInput();
        double time = 0;
        int minCharge = 10;
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
            r1.wasCharged = false;
            r2.wasCharged = false;
            r3.wasCharged = false;
            r4.wasCharged = false;
            r5.wasCharged = false;
            r6.wasCharged = false;

            r1.todo(); r2.todo(); r3.todo(); r4.todo(); r5.todo();
            System.out.println("  r1 charge="+r1.charge+ "   c=" +stuff.c3+ "   p=" +stuff.p1+ "   wasCharged=" +r1.wasCharged);
            System.out.println("  r2 charge="+r2.charge+ "   c=" +stuff.c1+ "   p=" +stuff.p1+ "   wasCharged=" +r2.wasCharged);
            System.out.println("  r3 charge="+r3.charge+ "   c=" +stuff.c1+ "   p=" +stuff.p2+ "   wasCharged=" +r3.wasCharged);
            System.out.println("  r4 charge="+r4.charge+ "   c=" +stuff.c2+ "   p=" +stuff.p2+ "   wasCharged=" +r4.wasCharged);
            System.out.println("  r5 charge="+r5.charge+ "   c=" +stuff.c2+ "   p=" +stuff.p3+ "   wasCharged=" +r5.wasCharged);
            System.out.println("  r6 charge="+r6.charge+ "   c=" +stuff.c3+ "   p=" +stuff.p3+ "   wasCharged=" +r6.wasCharged);
        } while (time<10); /*((r1.charge>0)&&(r2.charge>0)&&(r3.charge>0)&&(r4.charge>0)&&(r5.charge>0)&&(r6.charge>0));*/



    }
}
