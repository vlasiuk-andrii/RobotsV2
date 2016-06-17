public class Main {
    public static void main(String[] arg) {
        Input input = new Input();
        Values stuff = new Values();
        input.makeInput();
        double time = 0;
        int minCharge = 0;
        int maxCharge = 100;

        Robot r1 = new Robot( 1, input.r1behaviour());
        Robot r2 = new Robot( 2, input.r2behaviour());
        Robot r3 = new Robot( 3, input.r3behaviour());
        Robot r4 = new Robot( 4, input.r4behaviour());
        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }
}
