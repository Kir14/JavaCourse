package moduleFour.regExp;

/*
Возьмите английский текст (не менее 100 слов) и напишите программу,
которая будет разбивать его на слова и печатать слова в консоли. Знаки препинания не являются частью слова.
 */

//sentences!!!!!

public class TaskTwoSplitWordSentences {
    public static void main(String[] args) {
        String text = "First, we’ll kick things off by... considering, solutions using JDK. " +
                "Then, we’re going to illustrate how?      to     achieve the same !!!! objective !! using external " +
                "libraries such? as Guava  and    Apache Commons Lang.";
        text += " ";

        String[] words = text.split("[\\W]*\\s");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("=================================================");
        String[] sentences = text.split("[.!?]+\\s");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }

    }
}
