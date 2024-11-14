package moduleTwo;

/*
И ещё можете попрактиковаться и нарисовать оставшиеся 2
треугольника
      *
    * *      (1)
  * * *
* * * *

* * * *
  * * *      (2)
    * *
      *
 */
public class task8 {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < i; j++) {
                str.append("*");
            }
            System.out.printf("%4s%n", str);
        }

        for (int i = 4; i >= 1; i--) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < i; j++) {
                str.append("*");
            }
            System.out.printf("%4s%n", str);
        }
    }
}
