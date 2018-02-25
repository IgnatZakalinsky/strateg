/**
 * расчёт атаки
 */
class Att {
    static void go() {

        if (Start.b1.a > Start.b2.a) {
            System.out.println("...на пути было мелкое сопротивление в размере " + Start.b2.a + " едениц");
            Start.b1.a -= Start.b2.a;
            Start.b2.a = 0;
            System.out.println(", наших выжило " + Start.b1.a + " едениц!\n");
            if (Start.b2.o >= Start.b1.a) {
                System.out.print("...однако оборону из " + Start.b2.o + " едениц преодолеть не удалось");
                Start.b2.o -= Start.b1.a;
                Start.b1.a = 0;
                System.out.println("...\n...разведчики доложили о прочности обороны - " + Start.b2.o
                        + " едениц.\n");
            } else {
                System.out.println("Вражеская оборона из " + Start.b2.o + " едениц уничтожена," +
                        " Командир!\n");
                Start.b1.a -= Start.b2.o;
                Start.b2.o = 0;
                System.out.println("Так же мы нанесли урон по другим вражеским строения - " +
                        Start.b1.a + " едениц!\n");
                Start.b2.cu -= Start.b1.a;
                Start.b1.a = 0;
                Start.b2.pm -= 2;
                if (Start.b2.pm < 1) Start.b2.pm = 1;
                if (Start.b2.cu < 0) Start.b2.cu = 0;
                System.out.println("Разведчики докладывают, что прочность вражеского Центра управления" +
                        " - " + Start.b2.cu + " едениц\nПроизводственные мощности - " + Start.b2.pm
                        + " едениц\n");
            }
        } else if (Start.b1.a < Start.b2.a) {
            Start.b2.a -= Start.b1.a;
            Start.b1.a = 0;
            System.out.println("Командир, наше наступление разбито! Ожидается контратака из " +
                    Start.b2.a + " едениц!\n");
            if (Start.b1.o >= Start.b2.a) {
                Start.b1.o -= Start.b2.a;
                Start.b2.a = 0;
                System.out.println("Наша оборона выстояла, Командир!\n");
            } else {
                Start.b2.a -= Start.b1.o;
                Start.b1.o = 0;
                System.out.println("Внимание! Вражеское подразделение из " + Start.b2.a +
                " едениц прорвало оборону!\n");
                Start.b1.cu -= Start.b2.a;
                Start.b2.a = 0;
                Start.b1.pm -= 2;
                if (Start.b1.pm < 1) Start.b1.pm = 1;
                System.out.println("Мы несём потери, Командир!\n");
            }
        } else {
            Start.b1.a = 0;
            Start.b2.a = 0;
            System.out.println("Мы встретили равное по силе вражеское подразделение.\n" +
                    "Результат - Ничья.\n");
        }
    }
}
