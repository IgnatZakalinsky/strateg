import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * главный управляющий класс: <br>
 *      - правила игры <br>
 *      - цикл игры <br>
 *      - обработка ввода <br>
 *      - отображение состояния базы игрока <br>
 * ----------------------------------------------------------------------------------------------- <br>
 * поля: <br>
 *      - ⓢ{@link Start#q} флаг выхода <br>
 *      - ⓢ{@link Start#b1} база игрока <br>
 *      - ⓢ{@link Start#b2} база врага <br>
 * методы: <br>
 *      - 🔒ⓢ{@link Start#rules()} вывод правил <br>
 *      - 🔒ⓢ{@link Start#in()} ввод <br>
 *      - 🔒ⓢ{@link Start#info()} вывод состояния базы игрока <br>
 *      - 🚶ⓢ{@link Start#main(String[])} стартовый класс <br>
 */
public class Start {
    static boolean q = false;
    static Base b1, b2;

    public static void main(String[] args) {
        //rules
        rules();

        //load
        b1 = new Base();
        b2 = new Base();

        //go
        System.out.println("---------------------------------------------------------------------------");
        while (!q) {
            //info
            info();

            //in -> commands
            Coms.go(in());
        }
    }

    private static void rules() {
        System.out.println("Командир! Мы возвели Ваш \"Центр Управления\" на Марсе в квадрате 4, 2.\n" +
                            "Если мы защитим его и уничтожим Конкурента - квадрат будет нашим.\n" +
                            "Для Вашего удобства мы установили 4 команды упровления:\n" +
                            " - c - укрепить\\починить \"Центр Управления\"\n" +
                            "       (+ 2*\"Производственная мощность\" едениц прочности)\n" +
                            " - p - увеличить \"Производственные мощности\"\n" +
                            "       (+ 1 еденица)\n" +
                            " - o - соорудить оборону\n" +
                            "       (+ 4*\"Производственная мощность\" едениц)\n" +
                            " - a - организовать атаку\n" +
                            "       (+ 2^(\"Производственная мощность\" - 1) едениц," +
                            " 1 еденица уничтожает (1 обороны) или (2 \"Производственные мощности\"\n" +
                            "        и 1 прочности \"Центра Управления\") если нет обороны)\n" +
                            "(для ухода в отстваку введите q)");
    }

    private static String in() {
        String s;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            s = is.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            s = "error: in";
            q = true;
        }
        return s;
    }

    private static void info() {
        System.out.println("Центр Управления: " + b1.cu +
                "\nПроизводственные мощности: " + b1.pm +
                "\nОборона: " + b1.o + "\n");
    }
}
