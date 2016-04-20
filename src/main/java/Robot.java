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
            if (charge < 100){
                if (1 == myNumber && stuff.p1 == false && stuff.c3 == false){ stuff.p1 = true; stuff.c3 = true; }
                if (2 == myNumber && stuff.p1 == false && stuff.c1 == false){ stuff.p1 = true; stuff.c1 = true; }
                if (3 == myNumber && stuff.p2 == false && stuff.c1 == false){ stuff.p2 = true; stuff.c1 = true; }
                if (4 == myNumber && stuff.p2 == false && stuff.c2 == false){ stuff.p2 = true; stuff.c2 = true; }
                if (5 == myNumber && stuff.p3 == false && stuff.c2 == false){ stuff.p3 = true; stuff.c2 = true; }
                if (6 == myNumber && stuff.p3 == false && stuff.c3 == false){ stuff.p3 = true; stuff.c3 = true; }
            }
            if (charge<95){charge+= 10; wasCharged = true;}
        }

        //greedy
        if (2 == behaviour){
            if (charge < 60){
                if (1 == myNumber){ stuff.p1 = true; stuff.c3 = true; }
                if (2 == myNumber){ stuff.p1 = true; stuff.c1 = true; }
                if (3 == myNumber){ stuff.p2 = true; stuff.c1 = true; }
                if (4 == myNumber){ stuff.p2 = true; stuff.c2 = true; }
                if (5 == myNumber){ stuff.p3 = true; stuff.c2 = true; }
                if (6 == myNumber){ stuff.p3 = true; stuff.c3 = true; }
                if (100 == charge){
                    //
                } else if (charge<95){charge+= 10; wasCharged = true;}
            } else if ((charge>=60) && (charge<=100)){
                stuff.p1 = false;
                stuff.p2 = false;
                stuff.p3 = false;
                stuff.c1 = false;
                stuff.c2 = false;
                stuff.c3 = false;
            }
        }

        //gentleman
        if (3 == behaviour){

        }
    }

}
