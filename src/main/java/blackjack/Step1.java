package blackjack;

public class Step1 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.\n");


        gamePrint();
    }

    public static void gamePrint() {
        System.out.println(GAME_PREFIX + game);
        game++;
    }
}
