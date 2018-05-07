package hw_jw0;

import java.util.Scanner;
// класс для работы с пользователем
public class UserConsole {
    public int getTime(String text) {
        int result;
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        while (true)
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result <= 5 && result > 0) {
                    break;
                }
            } else {
                scanner.nextLine();
            }
        return  result * 60;
    }
}
