package blackjack;

public class Step2 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PROPERTY_PREFIX = "현재 재산: ";
    private static final String BET_PREFIX = "얼마를 거시겠습니까? ";

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");
        System.out.println(PROPERTY_PREFIX);
        System.out.println(BET_PREFIX);
        gamePrint();

    }

    public static void gamePrint() {
        System.out.println(GAME_PREFIX + game);
        game++;
    }
}
