package moduleTwo;

/*
Начав тренировки, спортсмен в первый день пробежал 10 км. Каждый
день он увеличивал дневную норму на 10% нормы предыдущего дня. Какой
суммарный путь пробежит спортсмен за 7 дней?
*/
public class task1 {
    public static void main(String[] args) {
        double start = 10;
        double sum = 0;
        double interest = 0.10;
        int days = 7;
        for (int i = 0; i < days; i++) {
            sum += start;
            start *= (1 + interest);
        }
        System.out.println(sum);
    }
}
