package blackjack;

import java.util.Arrays;
import java.util.Random;

public class Step1 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PLAYER_PREFIX = "You   : ";
    private static final String DEALER_PREFIX = "Dealer: ";

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.\n");


        gamePrint();
        int[] playerCards = playerCard();
        int[] dealerCards = dealerCard();

        System.out.println(PLAYER_PREFIX + Arrays.toString(playerCard()));
        System.out.println(DEALER_PREFIX + Arrays.toString(dealerCard()));
        System.out.println(winnerDecision(playerCard(), dealerCard()));
    }

    public static void gamePrint() {
        System.out.println(GAME_PREFIX + game);
        game++;
    }

    // 플레이어 숫자 생성
    public static int[] playerCard() {
        Random random = new Random();
        int[] card = new int[1];
        card[0] = random.nextInt(11) + 1; // 1부터 11사이의 숫자 생성
        return card;
    }

    // 딜러 숫자 생성
    public static int[] dealerCard() {
        Random random = new Random();
        int[] card = new int[1];
        card[0] = random.nextInt(11) + 1;
        return card;
    }

    // 승자 결정 로직
    public static String winnerDecision(int[] playerCard, int[] dealerCard) {
        if (playerCard[0] > dealerCard[0]) {
            return "당신이 이겼습니다.";
        } else if (playerCard[0] < dealerCard[0]) {
            return "딜러가 이겼습니다.";
        } else {
            return "비겼습니다.";
        }
    }


}

