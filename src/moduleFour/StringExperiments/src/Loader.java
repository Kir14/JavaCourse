package moduleFour.StringExperiments.src;

/*
Напишите код в проекте StringExperiments, который считает сумму заработка всех друзей (Васи, Пети и Маши).
Используйте методы indexOf(), lastIndexOf(), substring() и trim().
 */

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int rubIndex = text.indexOf("руб");
        int sumIndex = text.lastIndexOf(' ', rubIndex - 2);
        int sumVasia = Integer.parseInt(text.substring(sumIndex + 1, rubIndex - 1));
        rubIndex = text.indexOf("руб", rubIndex + 3);
        sumIndex = text.lastIndexOf(' ', rubIndex - 2);
        int sumPetya = Integer.parseInt(text.substring(sumIndex + 1, rubIndex - 1));
        rubIndex = text.indexOf("руб", rubIndex + 3);
        sumIndex = text.lastIndexOf(' ', rubIndex - 2);
        int sumMasha = Integer.parseInt(text.substring(sumIndex + 1, rubIndex - 1));
        System.out.println(sumVasia);
        System.out.println(sumPetya);
        System.out.println(sumMasha);
        System.out.println(sumVasia + sumPetya + sumMasha);
    }
}