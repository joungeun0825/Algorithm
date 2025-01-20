import java.util.*;

public class Main {
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String pwd = sc.next();
            if ("end".equals(pwd)) break;

            if (isAcceptable(pwd)) {
                System.out.printf("<%s> is acceptable.%n", pwd);
            } else {
                System.out.printf("<%s> is not acceptable.%n", pwd);
            }
        }
    }

    private static boolean isAcceptable(String pwd) {
        return firstCondition(pwd) && secondCondition(pwd) && thirdCondition(pwd);
    }

    private static boolean firstCondition(String pwd) {
        return pwd.chars().anyMatch(c -> vowels.contains((char) c));
    }

    private static boolean secondCondition(String pwd) {
        int cnt = 1;
        for (int i = 1; i < pwd.length(); i++) {
            if ((vowels.contains(pwd.charAt(i)) == vowels.contains(pwd.charAt(i - 1)))) {
                cnt++;
                if (cnt == 3) return false;
            } else {
                cnt = 1;
            }
        }
        return true;
    }

    private static boolean thirdCondition(String pwd) {
        for (int i = 1; i < pwd.length(); i++) {
            char current = pwd.charAt(i);
            char previous = pwd.charAt(i - 1);
            if (current != 'e' && current != 'o' && current == previous) {
                return false;
            }
        }
        return true;
    }
}
