import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int patty = sc.nextInt();
        int cheese = sc.nextInt();
        int burgerCount = 0;
        int addCount = 0;

        if(patty == cheese){
            System.out.println("NO");
            return;
        }
        
        // Create main burgers
        while (patty >= 2 && cheese >= 1 && patty!=cheese) {
            patty -= 2;
            cheese -= 1;
            burgerCount += 1;
        }
        
        // Create additional smaller burgers
        while (patty >= 1 && cheese >= 1) {
            patty -= 1;
            cheese -= 1;
            addCount += 1;
        }
        
        // Check if all ingredients were used
        if (patty == 0 && cheese == 0) {
            System.out.println("YES");
            System.out.println(burgerCount);
            
            String mainBurger = "aba";
            StringBuilder result = new StringBuilder();
            
            if (addCount > 0) {
                result.append(mainBurger);
                for (int i = 0; i < addCount; i++) {
                    result.append("ba");
                }
                System.out.println(result.toString());
                burgerCount -= 1;
            }
            
            while (burgerCount > 0) {
                System.out.println(mainBurger);
                burgerCount -= 1;
            }
        } else {
            System.out.println("NO");
        }
    }
}
