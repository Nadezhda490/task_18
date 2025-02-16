//import java.util.Random;
import java.util.Scanner;

public class Main {

//    Задание: Реализация игры "Крестики-нолики"

//    Цель: Создать программу на выбранном вами языке программирования (java) для игры в "Крестики-нолики" с использованием статического массива, циклов и условных операторов (if),методов и т.д.
//    Игра должна быть оформлена в консоли с красивым выводом игрового поля.

//    Требования и условия:

//    1. Человек против человека
//    Создайте игровое поле в виде статического двумерного массива размером 3x3, либо использовать одномерный массив на 9 элементов.
//    Каждый ход игрока:
//    Выводите текущее состояние игрового поля.
//    Запрашивайте у пользователя координаты для хода (номер строки и столбца) (в одномерном массиве номер квадратика).
//    Проверьте корректность хода:
//    Если ячейка занята, запросите ввод заново.
//    Если координаты вне игрового поля, запросите ввод заново.
//    Определите условия победы:
//    Проверка наличия трех одинаковых символов (X или O) по строкам, столбцам или диагоналям.
//    Если никто не победил, а поле заполнено, игра заканчивается ничьей.
//    Оформите вывод в консоли так, чтобы игровое поле отображалось красиво.

//    2. Человек против компьютера
//    Реализуйте логику игрового поля так же, как в первом варианте.
//    Добавьте возможность игры против компьютера:
//    Игрок делает ход первым (за X).
//    После хода игрока компьютер выбирает случайную свободную клетку для своего хода (за O).
//    После каждого хода:
//    Проверяйте условия победы.
//    Если поле заполнено, игра заканчивается ничьей.
//    Убедитесь, что компьютер не делает ход в занятую клетку.

//    3. Человек против компьютера (Hard Mode)
//    Реализуйте игровую логику аналогично предыдущему пункту.
//    Внесите улучшения для компьютера:
//    Приоритетное блокирование: Если у игрока есть возможность выиграть на следующем ходу, компьютер должен занять соответствующую клетку, чтобы заблокировать победу.
//    Умный ход: Если у компьютера есть возможность выиграть на своем ходу, он должен использовать эту возможность.
//    Если выигрышных или блокирующих ходов нет, компьютер ходит в первую свободную клетку (или случайным образом).
//    Общие требования:
//    Для хранения игрового поля используйте статический массив размером 3x3.
//    Логику ходов реализуйте с помощью циклов и условных операторов (if).
//    Красиво оформите консольный вывод:
//    Игровое поле должно быть наглядным и обновляться после каждого хода.
//    Например:
//    markdown

//    Отображение в случае двумерного массива:
//        0   1   2
//      -------------
//    0 | 0 | X | O |
//      |-----------|
//    1 | O | X |   |
//      |-----------|
//    2 |   |   | X |
//      -------------
//    Программа должна проверять ввод пользователя на корректность (например, не позволять ставить символ в занятую клетку или вводить некорректные координаты).

//    Отображение в случае одномерного массива:
//    1 | 2 | 3
//    ---------
//    4 | 5 | 6
//    ---------
//    7 | 8 | 9
//    Программа должна проверять ввод пользователя на корректность (например, не позволять ставить символ в занятую клетку или вводить некорректные координаты).

//    Критерии оценки:
//    Корректная реализация логики игры.
//    Выполнение всех трех режимов.
//    Понятный и красивый вывод на консоль.
//    Проверка на ошибки ввода (например, ввод за пределами поля или ход в занятую клетку).



    // 1. Человек против человека

    public static boolean viigrish(char[][] pole, char igrok) {
        if (pole[0][0] == igrok && pole[1][1] == igrok && pole[2][2] == igrok) {
            return true;
        }
        if (pole[0][2] == igrok && pole[1][1] == igrok && pole[2][0] == igrok) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (pole[i][0] == igrok && pole[i][1] == igrok && pole[i][2] == igrok) {
                return true;
            }
            if (pole[0][i] == igrok && pole[1][i] == igrok && pole[2][i] == igrok) {
                return true;
            }
        }
        return false;
    }

    public static boolean nichia(char[][] pole) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(pole[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] igrovoePole = new char[3][3];
        char igrok1 = 'X';
        char igrok2 = 'O';
        char tekusiy = igrok1;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                igrovoePole[i][j] = ' ';
            }
        }

        while (true) {
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.println("| " + igrovoePole[i][0] + " | " + igrovoePole[i][1] + " | " + igrovoePole[i][2] + " |");
                System.out.println("-------------");
            }

            int stroka = -1;
            int stolbik = -1;
            while (stroka < 0 || stroka > 2 || stolbik < 0 || stolbik > 2 || igrovoePole[stroka][stolbik] != ' ') {
                System.out.print("Игрок " + tekusiy + ", введите строку и столбик (через пробел): ");
                stroka = scanner.nextInt();
                stolbik = scanner.nextInt();
            }
            igrovoePole[stroka][stolbik] = tekusiy;

            if (viigrish(igrovoePole, tekusiy)) {
                System.out.println("Игрок " + tekusiy + " победил");
                break;
            }
            if (nichia(igrovoePole)) {
                System.out.println("Ничья");
                break;
            }
            if (tekusiy == igrok1) {
                tekusiy = igrok2;
            } else {
                tekusiy = igrok1;
            }

            System.out.println();
        }



        // 2. Человек против компьютера
        // для просмотра этого задания закомментируйте весь код задания "1. Человек против человека"
        // и раскомментируйте в самом верху "import java.util.Random;"

//        public static boolean viigrish(char[][] pole, char igrok) {
//            if (pole[0][0] == igrok && pole[1][1] == igrok && pole[2][2] == igrok) {
//                return true;
//            }
//            if (pole[0][2] == igrok && pole[1][1] == igrok && pole[2][0] == igrok) {
//                return true;
//            }
//            for (int i = 0; i < 3; i++) {
//                if (pole[i][0] == igrok && pole[i][1] == igrok && pole[i][2] == igrok) {
//                    return true;
//                }
//                if (pole[0][i] == igrok && pole[1][i] == igrok && pole[2][i] == igrok) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//    public static boolean nichia(char[][] pole) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (pole[i][j] == ' ') {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static void hodKompyutera(char[][] pole, char igrok) {
//        Random random = new Random();
//        int stroka, stolbik;
//        do {
//            stroka = random.nextInt(3);
//            stolbik = random.nextInt(3);
//        } while (pole[stroka][stolbik] != ' ');
//        pole[stroka][stolbik] = igrok;
//    }
//
//    public static void main(String[] args) {
//        char[][] igrovoePole = new char[3][3];
//        char igrok1 = 'X';
//        char igrok2 = 'O';
//        char tekusiy = igrok1;
//        Scanner scanner = new Scanner(System.in);
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                igrovoePole[i][j] = ' ';
//            }
//        }
//
//        while (true) {
//            System.out.println("-------------");
//            for (int i = 0; i < 3; i++) {
//                System.out.println("| " + igrovoePole[i][0] + " | " + igrovoePole[i][1] + " | " + igrovoePole[i][2] + " |");
//                System.out.println("-------------");
//            }
//
//            if (tekusiy == igrok1) {
//                int stroka = -1;
//                int stolbik = -1;
//                while (stroka < 0 || stroka > 2 || stolbik < 0 || stolbik > 2 || igrovoePole[stroka][stolbik] != ' ') {
//                    System.out.print("Игрок " + tekusiy + ", введите строку и столбик (через пробел): ");
//                    stroka = scanner.nextInt();
//                    stolbik = scanner.nextInt();
//                }
//                igrovoePole[stroka][stolbik] = tekusiy;
//            } else {
//                hodKompyutera(igrovoePole, tekusiy);
//                System.out.println("Компьютер сделал ход.");
//            }
//
//            if (viigrish(igrovoePole, tekusiy)) {
//                System.out.println("Игрок " + tekusiy + " победил");
//                break;
//            }
//            if (nichia(igrovoePole)) {
//                System.out.println("Ничья");
//                break;
//            }
//
//            if (tekusiy == igrok1) {
//                tekusiy = igrok2;
//            } else {
//                tekusiy = igrok1;
//            }
//            System.out.println();
//        }

    }
}