import java.util.Random;

/**
 * исполнение приказа, действия ИИ <br>
 *    - f🔒ⓢ{@link Coms#AI} вероятность действий ИИ <br>
 *    - 🔒ⓢ{@link Coms#n} количество читов у ИИ <br>
 *        ///// <br>
 *    - ⓢ{@link Coms#go(String)} расчёт действий игрока <br>
 *    - 🔒ⓢ{@link Coms#ai()} ход ИИ <br>
 */
class Coms {
    final private static byte[] AI = {0, 0, 0, 0, 2, 2, 2, 1, 1, 3, 4};
    private static byte n = 3;

    static void go(String s) {
        System.out.println("---------------------------------------------------------------------------");
        switch (s) {
            case "q":
                Start.q = true;
                System.out.println("Удачной пенсии, Командир!\n");
                return;
            case "p":
                Start.b1.pm++;
                System.out.println("Производственные мощности увеличены, Командир!\n");
                break;
            case "o":
                Start.b1.o += Start.b1.pm * 4;
                System.out.println("Оборона увеличена на " + (Start.b1.pm * 4) + " едениц, Командир!\n");
                break;
            case "a":
                Start.b1.a = (long) Math.pow(2, Start.b1.pm - 1);
                System.out.println("Подразделение из " + ((long) Math.pow(2, Start.b1.pm - 1))
                        + " едениц отправилось в атаку, Командир!\n");
                break;
            case "c":
                Start.b1.cu += Start.b1.pm * 2;
                System.out.println("Центр Управления укреплён на " + (Start.b1.pm * 2)
                        + " едениц, Командир!\n");
                break;
            default:
                System.out.println("Командир, у нас помехи на линии! " +
                        "Повторите, пожалуйста, приказ.\n");
                return;
        }

        // attack
        if ((AI[ai()] == 2) || (s.equals("a"))) Att.go();

        //win?
        if (Start.b1.cu < 1) {
            System.out.println("Наша База уничтожена, Командир! ...но мы извлекли урок, " +
                    "и в следующий раз обязательно победим!\n");
            System.out.println("(" + Start.b2.cu + "/" + Start.b2.pm + "/" + Start.b2.o + ")");
            Start.q = true;
        } else if (Start.b2.cu < 1) {
            System.out.println("Поздравляю, Командир! Конкурент Уничтожен!!!");
            Start.q = true;
        }
    }

    private static int ai() {
        int r = new Random().nextInt(AI.length);

        switch (AI[r]) {
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
                    System.out.println("Внимание, замечен неопознанный объект! " +
                            "Возможно противник использует читы!\n");
                } else Start.b2.o += Start.b2.pm * 4;
                break;
            case 4:
                Start.b2.cu += Start.b1.pm * 2;
                break;
        }
        return r;
    }
}
