package moduleFour.stringExperiments.src;

/*
Напишите код в проекте StringExperiments, который считает сумму заработка всех друзей (Васи, Пети и Маши).
Используйте методы indexOf(), lastIndexOf(), substring() и trim().
 */

public class MoneySubstr {
    public static void main(String[] args) {
        String text = "Вася заработал 5000,56 рублей, Петя - 7563.12 рубля, а Маша - 30000 рублей";
        int[] indexesSpace = new int[2];
        double sumVasia = parseMoney(text, indexesSpace);
        double sumPetya = parseMoney(text, indexesSpace);
        double sumMasha = parseMoney(text, indexesSpace);
        System.out.println(sumVasia);
        System.out.println(sumPetya);
        System.out.println(sumMasha);
        System.out.println(sumVasia + sumPetya + sumMasha);
    }

    public static double parseMoney(String text, int[] indexesSpace) {
        indexesSpace[0] = text.indexOf("руб", indexesSpace[0] + 3);
        indexesSpace[1] = text.lastIndexOf(' ', indexesSpace[0] - 2);
        return Double.parseDouble(text.substring(indexesSpace[1] + 1, indexesSpace[0] - 1).replace(',', '.'));
    }
}