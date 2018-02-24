import java.util.Random;

public class Coms {
    static byte[] b = {0, 0, 2, 1, 0, 1, 0, 2, 2, 3};
    static byte n = 3;

    public static void go(String s) {
        switch (s) {
            case "q":
                Start.q = false;
                return;
            case "p":
                Start.b1.pm++;
                break;
            case "o":
                Start.b1.o += Start.b1.pm * 4;
                break;
            case "a":
                Start.b1.a = (long) Math.pow(2, Start.b1.pm - 1);
                break;
        }

        //ii
        int r = ii();

        // attack
        if ((b[r] == 2) || (s.equals("a"))) Att.go();

        //win?
        if (Start.b1.cu < 1) {
            System.out.println("You lose!");
            Start.q = false;
        } else if (Start.b2.cu < 1) {
            System.out.println("You win!");
            Start.q = false;
        }
    }

    private static int ii() {
        Random rr = new Random();
        int r = rr.nextInt(b.length);
        //System.out.println("ii:" + r);
        //System.out.println("ii:" + b[r]);

        switch (b[r]) {
            case 0:
                Start.b2.pm++;
                break;
            case 1:
                Start.b2.o += Start.b2.pm * 4;
                break;
            case 2:
                Start.b2.a = (long) Math.pow(2, Start.b2.pm - 1);
                break;
            case 3:
                if (n > 0) {
                    n--;
                    Start.b2.pm += 3;
                } else Start.b2.o += Start.b2.pm * 4;
        }
        return r;
    }
}
