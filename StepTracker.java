import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);
    int dayNorm = 10000; // дневная норма
    Converter converter= new Converter();



    int selectedMonth; // переменная "выбранный месяц" для использования в статистике


    int[][] monthsAndDays = new int[12][30];

    public void inputStepByDayInMonth() {
        while (true) {
            System.out.print("Введите номер месяц (например, январь = 1): ");
            int month = scanner.nextInt(); // вводим номер месяца
            System.out.print("Введите день от 1 до 30: ");
            int day = scanner.nextInt();// вводим номер дня
            System.out.print("Введите кол-во шагов, пройденных в этот день: ");
            int stepsOnThisDay = scanner.nextInt(); //вводим кол-во шагов, пройденных именно в этот день
            monthsAndDays[month - 1][day - 1] = stepsOnThisDay;
            System.out.println("Запись успешно сохранена! " + day + "." + month + "." + "2022 Вы прошли " + stepsOnThisDay + " шагов.");

            System.out.println("Продолжить заносить шаги?\n" +
                    "Да -- 1. Нет -- 2");
            int next = scanner.nextInt();
            if (next == 2) {
                break;
            } else if (next == 1) {
            } else {
                System.out.println("Неверная команда");
            }
        }
    }

    public int countSumStepsMonth() {
        int sumStepsMonth = 0;
        for (int i = 0; i < 30; i++) {
            sumStepsMonth += monthsAndDays[selectedMonth - 1][i];
        }
        return sumStepsMonth;
    }

    public double countAverageSteps() {     //среднее кол-во шагов за месяц
        double averageSteps = countSumStepsMonth() / 30;
        return averageSteps;
    }

    public int findMaxSteps() {               //max кол-во шагов за месяц
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (monthsAndDays[selectedMonth - 1][i] > maxSteps) {
                maxSteps = monthsAndDays[selectedMonth - 1][i];
            }
        }
        return maxSteps;
    }

    public void writeAllDays() {               //печатает сколько было шагов каждый день
        for (int i = 0; i < 30; i++) {
            System.out.println("День " + (i + 1) + ". " + (monthsAndDays[selectedMonth - 1][i]) + " шагов");
        }
    }

    public int findBestSeries() {
        int bestSeries = 0;
        int series = 0;
        for (int i = 0; i < 30; i++) {
            if (monthsAndDays[selectedMonth - 1][i] >= dayNorm) {
                series = series + 1;
            } else {
                if (bestSeries < series) {
                    bestSeries = series;
                    series = 0;
                }
            }
        }
        if (bestSeries < series) {
            bestSeries = series;
        }
        return bestSeries;
    }   // Метод выводит лучшую серию шагов


    public void statistics() {                          // Метод, который выводит статистику за месяц
        System.out.print("Введите номер месяца за который хотите узнать статистику: ");
        selectedMonth = scanner.nextInt();

        System.out.println("********** Статистика **********");
        System.out.println("Количество пройденных шагов по дням: ");
        writeAllDays();
        System.out.println("Общее количество шагов за месяц: " + countSumStepsMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + findMaxSteps());
        System.out.println("Среднее количество шагов: " + countAverageSteps());
        System.out.println("Пройденная дистанция (в км): "+ converter.countDistanceTraveled());
        System.out.println("Количество сожжённых килокалорий: "+ converter.countKcal());
        System.out.println("Лучшая серия: " + findBestSeries());
    }


    public void changeDayNorm() {    //Метод, который меняет дневную норму шагов
        System.out.println("Ваша текущая дневная норма: " + dayNorm + " шагов.");
        while (true) {
            System.out.println("Укажите новое значение: ");
            int newDayNorm = scanner.nextInt();
            if (newDayNorm == 0) {
                System.out.println("Хитрый какой! Нельзя весь день лежать!");
            } else if (newDayNorm < 0) {
                System.out.println("Это как?)");
            } else {
                dayNorm = newDayNorm;
                System.out.println("Установлена новая дневная норма: " + dayNorm + " шагов.");
                break;
            }
        }
    }
}
     /*
     void printMassive (){             //ТЕСТОВЫЙ: выводит двумерный массив с памятью шагов по дням каждого месяца

        for (int i = 0; i < 12; i++) {  //идём по строкам
            for (int j = 0; j < 30; j++) {//идём по столбцам
                System.out.print(" " + monthsAndDays[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
    }
     */

