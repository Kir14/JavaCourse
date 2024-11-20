package modules.two;

/*
Начав тренировки, спортсмен в первый день пробежал 10 км. Каждый
день он увеличивал дневную норму на 10% нормы предыдущего дня. Какой
суммарный путь пробежит спортсмен за 7 дней?
*/
public class Task1 {
    public static void main(String[] args) {
        double start = 10;
        double sum = 0;

        for (int i = 0; i < 7; i++) {
            sum += start;
            start *= (1 + 0.1);
        }
        System.out.println(sum);
    }
}
