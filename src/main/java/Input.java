import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    String line = null;

    void makeInput () {
        System.out.print("Enter behaviour:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int r1behaviourBuffer(){
        int r1Behaviour = Integer.parseInt(line.substring(0,1));
        return r1Behaviour;
    }
    int r2behaviourBuffer(){
        int r2Behaviour = Integer.parseInt(line.substring(1,2));
        return r2Behaviour;
    }
    int r3behaviourBuffer(){
        int r3Behaviour = Integer.parseInt(line.substring(2,3));
        return r3Behaviour;
    }
    int r4behaviourBuffer(){
        int r4Behaviour = Integer.parseInt(line.substring(3,4));
        return r4Behaviour;
    }
    int r5behaviourBuffer(){
        int r5Behaviour = Integer.parseInt(line.substring(4,5));
        return r5Behaviour;
    }
    int r6behaviourBuffer(){
        int r6Behaviour = Integer.parseInt(line.substring(5,6));
        return r6Behaviour;
    }
}
