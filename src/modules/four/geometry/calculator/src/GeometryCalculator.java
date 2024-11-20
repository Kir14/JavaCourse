package modules.four.geometry.calculator.src;

/*
В проекте GeometryCalculator реализуйте в классе GeometryCalculator методы:
— подсчёта площади круга, площади треугольника и объёма сферы;
— проверки возможности построения треугольника по трём длинам сторон.
 */

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(Math.abs(radius), 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return 4.0 / 3.0 * Math.PI * Math.pow(Math.abs(radius), 3);
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        return ((a + b > c) && (a + c > b) && (b + c > c));
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (!isTriangleRightAngled(a, b, c))
            return -1.0;
        double halfPerimetr = (a + b + c) / 2;
        return Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
    }
}
