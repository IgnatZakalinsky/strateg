import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    static boolean q = true;
    static Base b1, b2;
    static String s;

    public static void main(String[] args) {
        //info, setts

        //load
        b1 = new Base();
        b2 = new Base();

        //go
        while (q) {
            //info
            info();

            //in
            s = in();

            //if
            Coms.go(s);
        }
    }

    private static String in() {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in)); // объект,...
            // связанный с клавиатурой
            s = is.readLine(); // получение строки
        } catch (IOException e) {
            System.out.println("e:" + e);
            s = e.toString();
        }
        return s;
    }

    private static void info() {
        System.out.println("////////////////////////////////////////////");
        System.out.println("cu:" + b1.cu + " o:" + b1.o + " pm:" + b1.pm);
    }
}
