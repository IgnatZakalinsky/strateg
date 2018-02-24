public class Att {
    public static void go() {
        System.out.println(Start.b1.a + "/a:" + Start.b2.a);

        if (Start.b1.a > Start.b2.a) {
            Start.b1.a -= Start.b2.a;
            Start.b2.a = 0;
            System.out.println(Start.b1.a + "/o:" + Start.b2.o);
            if (Start.b2.o >= Start.b1.a) {
                Start.b2.o -= Start.b1.a;
                Start.b1.a = 0;
                System.out.println("o:" + Start.b2.o);
            } else {
                Start.b1.a -= Start.b2.o;
                Start.b2.o = 0;
                System.out.println(Start.b1.a + "/cu:" + Start.b2.cu);
                Start.b2.cu -= Start.b1.a;
                Start.b1.a = 0;
                Start.b2.pm -= 2;
                if (Start.b2.pm < 1) Start.b2.pm = 1;
                System.out.println("cu:" + Start.b2.cu + " pm:" + Start.b2.pm);
            }
        } else if (Start.b1.a < Start.b2.a) {
            Start.b2.a -= Start.b1.a;
            Start.b1.a = 0;
            if (Start.b1.o >= Start.b2.a) {
                Start.b1.o -= Start.b2.a;
                Start.b2.a = 0;
                //
            } else {
                Start.b2.a -= Start.b1.o;
                Start.b1.o = 0;
                Start.b1.cu -= Start.b2.a;
                Start.b2.a = 0;
                Start.b1.pm -= 2;
                if (Start.b1.pm < 1) Start.b1.pm = 1;
                //
            }
        } else {
            Start.b1.a = 0;
            Start.b2.a = 0;
        }
    }
}
