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
        r1.behavior = input.r1behaviourBuffer();
        r2.behavior = input.r2behaviourBuffer();
        r3.behavior = input.r3behaviourBuffer();
        r4.behavior = input.r4behaviourBuffer();
        r5.behavior = input.r5behaviourBuffer();
        r6.behavior = input.r6behaviourBuffer();

        do{
            time+= 0.1;
            System.out.print(time+"\n");
            if(0 != r1.charge) {r1.charge -= 1;}
            if(0 != r2.charge) {r2.charge -= 1;}
            if(0 != r3.charge) {r3.charge -= 1;}
            if(0 != r4.charge) {r4.charge -= 1;}
            if(0 != r5.charge) {r5.charge -= 1;}
            if(0 != r6.charge) {r6.charge -= 1;}
            stuff.r1charge = r1.charge;
            stuff.r2charge = r2.charge;
            stuff.r3charge = r3.charge;
            stuff.r4charge = r4.charge;
            stuff.r5charge = r5.charge;
            stuff.r6charge = r6.charge;

            r1.todo();
            System.out.println( "r1 charge=" + r1.charge + "  chPercent=" + r1.chargePercent + "  wait=" + r1.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);
            r2.todo();
            System.out.println( "r2 charge=" + r2.charge + "  chPercent=" + r2.chargePercent + "  wait=" + r2.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);
            r3.todo();
            System.out.println( "r3 charge=" + r3.charge + "  chPercent=" + r3.chargePercent + "  wait=" + r3.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);
            r4.todo();
            System.out.println( "r4 charge=" + r4.charge + "  chPercent=" + r4.chargePercent + "  wait=" + r4.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);
            r5.todo();
            System.out.println( "r5 charge=" + r5.charge + "  chPercent=" + r5.chargePercent + "  wait=" + r5.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);
            r6.todo();
            System.out.println( "r6 charge=" + r6.charge + "  chPercent=" + r6.chargePercent + "  wait=" + r6.waitPercent);
            System.out.println("                                   p1="+stuff.p1+" p2="+stuff.p2+" p3="+stuff.p3+" c1="+stuff.c1+" c2="+stuff.c2+" c3="+stuff.c3);

        } while ((r1.charge>minCharge)&&(r2.charge>minCharge)&&(r3.charge>minCharge)&&(r4.charge>minCharge)&&(r5.charge>minCharge)&&(r6.charge>minCharge));

    }
}
