import java.util.*;

class Fight {
    public static Scanner scanner = new Scanner(System.in);
    public static Players p = new Players();
    public static Warrior w = new Warrior();
    public static Monster m = new Monster();
    public static String[] body = p.getBodyParts();
    public static boolean quit = false;
    public static void main(String[] args) {
        menu();

        System.out.print("Выберите: ");
        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 1:
                    play();
                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Добро пожаловать в игру!\n");
        System.out.println("1. Сразиться с Монстром");
        System.out.println("2. Выйти\n");
    }

    public static void play() {
        int warriorHealth = w.getHealth();
        int monsterHealth = m.getHealth();

        while(!quit) {
            System.out.println("\n1.Голова 2.Грудь 3.Живот 4.Пах 5.Ноги");
            System.out.print("Выберите в какую часть тела хотите нанести удар: ");                

            int warriorChoise = scanner.nextInt();
            int warriorHit = w.warriorHit(warriorChoise);

            int warriorDamage = w.warriorDamage(warriorChoise);

            System.out.print("Выберите какую часть тела хотите заблокировать: ");

            warriorChoise = scanner.nextInt();
            scanner.nextLine();
            int warriorBlock = w.warriorBlock(warriorChoise);

            int monsterHit = m.monsterHit();

            int monsterDamage = m.monsterDamage();
            int monsterBlock = m.monsterBlock();

            if(warriorHit != monsterBlock) {
                System.out.println("\nВоин наносит Монстру " + warriorDamage + " урона в " + body[warriorHit]);
                monsterHealth -= warriorDamage;
            } else {
                System.out.println("\nМонстр заблокировал удар Воина в " + body[warriorHit]);
            }

            if(warriorBlock == monsterHit) {
                System.out.println("Воин заблокировал удар Монстра в " + body[monsterHit]);
            } else {
                System.out.println("Монстр наносит Воину " + monsterDamage + " урона в " + body[monsterHit]);
                warriorHealth -= monsterDamage;
            }

            if(warriorHealth > 0 && monsterHealth <= 0) {
                System.out.println("\nВоин победил!");
                System.out.print("Вы легко одолели Монстра. Хотите сразиться еще раз? (Да/Нет): ");
                String playerChoise = scanner.nextLine();

                if(playerChoise.toLowerCase().equals("нет")) {
                    quit = true;
                } else {
                    warriorHealth = 100;
                    monsterHealth = 100;
                }
            } else if(monsterHealth > 0 && warriorHealth <= 0) {
                System.out.println("\nМонстр победил!");
                System.out.print("Вы отлично сражались, но монстр оказался сильнее. Хотите повторить попытку? (Да/Нет): ");
                String playerChoise = scanner.nextLine();

                if(playerChoise.toLowerCase().equals("нет")) {
                    quit = true;
                } else {
                    
                }
            } else {
                System.out.println("\nЗдоровье Воина: " + warriorHealth);
                System.out.println("Здоровье Монстра: " + monsterHealth);
            }
        } 
    }
}