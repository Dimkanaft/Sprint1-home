
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        //Converter converter = new Converter();  ???
        Scanner scanner = new Scanner(System.in);


        System.out.println("\nПривет! Это Счетчик Калорий! \n"
        +"Перемещаться по меню приложения можно с помощью цифр 0-3");
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                stepTracker.inputStepByDayInMonth();


            } else if (userInput == 2){
               stepTracker.statistics(); // вывод статистики

            } else if (userInput == 3) {
                stepTracker.changeDayNorm();// тут будет команда по изменению цели по кол-ву шагов за день DONE

            } else {
                System.out.println("Такой команды нет");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu(){

        System.out.println("\n********** Счетчик калорий **********\n" +
                "Ввести количество шагов за определённый день (1)\n" +
                "Напечатать статистику за определённый месяц (2) \n" +
                "Изменить цель по количеству шагов в день (3) \n" +
                "Выйти из приложения (0).");
    }
}
