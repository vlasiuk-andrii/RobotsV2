public class Robot {

    public Robot(int number) {
        myNumber = number;
    }

    ChargingStuff stuff = new ChargingStuff();

    int myNumber = 0;
    int charge = 50;
    int behavior = 0;
    int status = 1; // 0 - sleep, 1 - do nothing, 2 - charge
    int chargePercent = 0; // 0-5 steps, from x to x+10 percent of charge
    int waitPercent = 0; // 0-5 steps by 0.1sec

    void todo(){
        // random
        if (1 == behavior){
            if (charge < 100 && 1 == status && chargePercent == 0 ){
                if (1 == myNumber && 0 == stuff.p1 && 0 == stuff.c3 ){ stuff.p1 = 1;  stuff.c3 = -1; status = 2; }
                if (2 == myNumber && 0 == stuff.p1 && 0 == stuff.c1 ){ stuff.p1 = -1; stuff.c1 = 1;  status = 2; }
                if (3 == myNumber && 0 == stuff.p2 && 0 == stuff.c1 ){ stuff.p2 = 1;  stuff.c1 = -1; status = 2; }
                if (4 == myNumber && 0 == stuff.p2 && 0 == stuff.c1 ){ stuff.p2 = -1; stuff.c2 = 1;  status = 2; }
                if (5 == myNumber && 0 == stuff.p3 && 0 == stuff.c2 ){ stuff.p3 = 1;  stuff.c2 = -1; status = 2; }
                if (6 == myNumber && 0 == stuff.p3 && 0 == stuff.c3 ){ stuff.p3 = -1; stuff.c3 = 1;  status = 2; }
                if (charge<98){charge+= 2; chargePercent++;}
            }
            if (charge < 100 && 2 == status && chargePercent < 5 ){
                if (charge<98){charge+= 2; chargePercent++;}
            }
            if (charge < 100 && 2 == status && chargePercent == 5 ){
                if (1 == myNumber && 1  == stuff.p1 && -1 == stuff.c3 ){ stuff.p1 = 0;  stuff.c3 = 0; status = 0; }
                if (2 == myNumber && -1 == stuff.p1 && 1  == stuff.c1 ){ stuff.p1 = 0;  stuff.c1 = 0; status = 0; }
                if (3 == myNumber && 1  == stuff.p2 && -1 == stuff.c1 ){ stuff.p2 = 0;  stuff.c1 = 0; status = 0; }
                if (4 == myNumber && -1 == stuff.p2 && 1  == stuff.c1 ){ stuff.p2 = 0;  stuff.c2 = 0; status = 0; }
                if (5 == myNumber && 1  == stuff.p3 && -1 == stuff.c2 ){ stuff.p3 = 0;  stuff.c2 = 0; status = 0; }
                if (6 == myNumber && -1 == stuff.p3 && 1  == stuff.c3 ){ stuff.p3 = 0;  stuff.c3 = 0; status = 0; }
                chargePercent = 0;
            }
            if (0 == status && waitPercent!=3){ waitPercent++; }
            else {status = 1;
                waitPercent = 0;}
        }

        //greedy
        if (2 == behavior){
            if (charge < 60 && 1 == status && waitPercent>=5 ){
                if (1 == myNumber && 0 == stuff.p1 && 0 == stuff.c3 ){ stuff.p1 = 1;  stuff.c3 = -1; status = 2; }
                if (2 == myNumber && 0 == stuff.p1 && 0 == stuff.c1 ){ stuff.p1 = -1; stuff.c1 = 1;  status = 2; }
                if (3 == myNumber && 0 == stuff.p2 && 0 == stuff.c1 ){ stuff.p2 = 1;  stuff.c1 = -1; status = 2; }
                if (4 == myNumber && 0 == stuff.p2 && 0 == stuff.c1 ){ stuff.p2 = -1; stuff.c2 = 1;  status = 2; }
                if (5 == myNumber && 0 == stuff.p3 && 0 == stuff.c2 ){ stuff.p3 = 1;  stuff.c2 = -1; status = 2; }
                if (6 == myNumber && 0 == stuff.p3 && 0 == stuff.c3 ){ stuff.p3 = -1; stuff.c3 = 1;  status = 2; }
                if (charge<98 && chargePercent<5){charge+= 2; chargePercent++; waitPercent=0;}
            } else if (charge>=60 && charge<=100 && 1 == status){ waitPercent++; }
            if (charge < 60 && 2 == status ){
                if (charge<98 && chargePercent<5){charge+= 2; chargePercent++; waitPercent=0;}
                else if (chargePercent == 5){ charge+=2; chargePercent=1;
                }
            }
            if (charge >= 60 && 1 == status && waitPercent < 5 ){ waitPercent++; }
            if (charge >= 60 && 1 == status && waitPercent == 5 ){ waitPercent=0;
                System.out.println("r"+myNumber+"  finished waiting in iteration"); }
            if (charge == 100 && 2 == status ){
                    waitPercent=0;
                    chargePercent=0;
                    if (1 == myNumber){ stuff.p1 = 0;  stuff.c3 = 0; status = 1; }
                    if (2 == myNumber){ stuff.p1 = 0;  stuff.c1 = 0; status = 1; }
                    if (3 == myNumber){ stuff.p2 = 0;  stuff.c1 = 0; status = 1; }
                    if (4 == myNumber){ stuff.p2 = 0;  stuff.c2 = 0; status = 1; }
                    if (5 == myNumber){ stuff.p3 = 0;  stuff.c2 = 0; status = 1; }
                    if (6 == myNumber){ stuff.p3 = 0;  stuff.c3 = 0; status = 1; }
            }

        }

        //gentleman
        if (3 == behavior){
//            if (1 == myNumber && (stuff.r2charge<charge || stuff.r6charge<charge)){ stuff.p1=false; stuff.c3=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
//            else if (1 == myNumber){ stuff.p1=true; stuff.c3=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
//            if (2 == myNumber && (stuff.r1charge<charge || stuff.r3charge<charge)){ stuff.p1=false; stuff.c1=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
//            else if (2 == myNumber){ stuff.p1=true; stuff.c1=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
//            if (3 == myNumber && (stuff.r2charge<charge || stuff.r4charge<charge)){ stuff.p2=false; stuff.c1=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
//            else if (3 == myNumber){ stuff.p2=true; stuff.c1=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
//            if (4 == myNumber && (stuff.r3charge<charge || stuff.r5charge<charge)){ stuff.p2=false; stuff.c2=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
//            else  if (4 == myNumber){ stuff.p2=true; stuff.c2=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
//            if (5 == myNumber && (stuff.r4charge<charge || stuff.r6charge<charge)){ stuff.p3=false; stuff.c2=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
//            else  if (5 == myNumber){ stuff.p3=true; stuff.c2=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
//            if (6 == myNumber && (stuff.r5charge<charge || stuff.r1charge<charge)){ stuff.p3=false; stuff.c3=false;
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
//            else  if (6 == myNumber){ stuff.p3=true; stuff.c3=true; if (charge<95){charge+= 10; wasCharged = true;}
//                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
//
//            stuff.p1 = false;
//            stuff.p2 = false;
//            stuff.p3 = false;
//            stuff.c1 = false;
//            stuff.c2 = false;
//            stuff.c3 = false;
        }
    }

}
