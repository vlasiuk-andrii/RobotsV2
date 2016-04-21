public class Robot {

    public Robot(int number) {
        myNumber = number;
    }

    ChargingStuff stuff = new ChargingStuff();

    int myNumber = 0;
    int charge = 50;
    int behaviour = 0;
    boolean wasCharged = false;

    void todo(){
        // random
        if (1 == behaviour){
            if (charge<95){charge+= 10; wasCharged = true;}
            if (charge <= 100){
                if (1 == myNumber && stuff.p1 == false && stuff.c3 == false){ stuff.p1 = true; stuff.c3 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
                if (2 == myNumber && stuff.p1 == false && stuff.c1 == false){ stuff.p1 = true; stuff.c1 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (3 == myNumber && stuff.p2 == false && stuff.c1 == false){ stuff.p2 = true; stuff.c1 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (4 == myNumber && stuff.p2 == false && stuff.c2 == false){ stuff.p2 = true; stuff.c2 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (5 == myNumber && stuff.p3 == false && stuff.c2 == false){ stuff.p3 = true; stuff.c2 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (6 == myNumber && stuff.p3 == false && stuff.c3 == false){ stuff.p3 = true; stuff.c3 = true;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                stuff.p1 = false;
                stuff.p2 = false;
                stuff.p3 = false;
                stuff.c1 = false;
                stuff.c2 = false;
                stuff.c3 = false;
            }
        }

        //greedy
        if (2 == behaviour){
            if (charge < 60){
                if (1 == myNumber){ stuff.p1 = true; stuff.c3 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
                if (2 == myNumber){ stuff.p1 = true; stuff.c1 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (3 == myNumber){ stuff.p2 = true; stuff.c1 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (4 == myNumber){ stuff.p2 = true; stuff.c2 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (5 == myNumber){ stuff.p3 = true; stuff.c2 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (6 == myNumber){ stuff.p3 = true; stuff.c3 = true; if (charge<95){charge+= 10; wasCharged = true;}
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}


            } else if ((charge>=60) && (charge<=100)){
                if (1 == myNumber){ //stuff.p1 = false; stuff.c3 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
                if (2 == myNumber){ //stuff.p1 = false; stuff.c1 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (3 == myNumber){ //stuff.p2 = false; stuff.c1 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
                if (4 == myNumber){ //stuff.p2 = false; stuff.c2 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (5 == myNumber){ //stuff.p3 = false; stuff.c2 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
                if (6 == myNumber){ //stuff.p3 = false; stuff.c3 = false;
                    System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}

            }
        }

        //gentleman
        if (3 == behaviour){
            if (1 == myNumber && (stuff.r2charge<charge || stuff.r6charge<charge)){ stuff.p1=false; stuff.c3=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
            if (2 == myNumber && (stuff.r1charge<charge || stuff.r3charge<charge)){ stuff.p1=false; stuff.c1=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
            if (3 == myNumber && (stuff.r2charge<charge || stuff.r4charge<charge)){ stuff.p2=false; stuff.c1=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
            if (4 == myNumber && (stuff.r3charge<charge || stuff.r5charge<charge)){ stuff.p2=false; stuff.c2=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
            if (5 == myNumber && (stuff.r4charge<charge || stuff.r6charge<charge)){ stuff.p3=false; stuff.c2=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
            if (6 == myNumber && (stuff.r5charge<charge || stuff.r1charge<charge)){ stuff.p3=false; stuff.c3=false;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
        } else if (3 == behaviour) {
            if (charge<95){charge+= 10; wasCharged = true;}
            if (1 == myNumber){ stuff.p1=true; stuff.c3=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
            if (2 == myNumber){ stuff.p1=true; stuff.c1=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p1+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
            if (3 == myNumber){ stuff.p2=true; stuff.c1=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c1+ "   wasCharged=" +wasCharged);}
            if (4 == myNumber){ stuff.p2=true; stuff.c2=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p2+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
            if (5 == myNumber){ stuff.p3=true; stuff.c2=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c2+ "   wasCharged=" +wasCharged);}
            if (6 == myNumber){ stuff.p3=true; stuff.c3=true;
                System.out.println("  r"+myNumber+" charge="+charge+ "   c=" +stuff.p3+ "   p=" +stuff.c3+ "   wasCharged=" +wasCharged);}
            stuff.p1 = false;
            stuff.p2 = false;
            stuff.p3 = false;
            stuff.c1 = false;
            stuff.c2 = false;
            stuff.c3 = false;
        }
    }

}
