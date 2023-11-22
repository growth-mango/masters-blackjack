package blackjack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PracticeStep1 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PLAYER_PREFIX = "You   : ";
    private static final String DEALER_PREFIX = "Dealer: ";
    private static int win = 0;
    private static int lose = 0;
    private static int tie = 0;
    private static final String RECORD_PREFIX = "현재 전적: ";

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");

        while (true) {
            System.out.println();
            gamePrint();

            int[] playerCards = playerCard();
            int[] dealerCards = dealerCard();
            System.out.println(PLAYER_PREFIX + Arrays.toString(playerCards)); // 플레이어 카드 출력
            System.out.println(DEALER_PREFIX + Arrays.toString(dealerCards)); // 딜러 카드 출력

            System.out.println(winnerDecision(playerCards, dealerCards)); // 위너 출력
            gameRecord(winnerDecision(playerCards, dealerCards)); // 전적 출력

            if (!getMoreGame()) {
                break;
            }
        }
        System.out.println("게임을 종료합니다.\n플레이해주셔서 감사합니다.");
    }

    // game 몇 회 차인지 출력
    public static void gamePrint() {
        System.out.println(GAME_PREFIX + game);
        game++; // gamePrint() 메서드가 호출될 때 마다 +1 됨
    }

    // 플레이어 카드 출력 // 1에서 11사이
    public static int[] playerCard() {
        Random random = new Random();
        int[] card = new int[1];
        card[0] = random.nextInt(11) + 1;
        return card;
    }

    // 딜러의 카드 출력 // 1에서 11 사이
    public static int[] dealerCard() {
        Random random = new Random();
        int[] card = new int[1];
        card[0] = random.nextInt(11) + 1; // 1부터 11사이 숫자 출력
        return card;
    }

    // 승패 결정 로직
    public static String winnerDecision(int[] playerCard, int[] dealerCard) {
        if (playerCard[0] > dealerCard[0]) {
            return "당신이 이겼습니다.";
        } else if (playerCard[0] < dealerCard[0]) {
            return "딜러가 이겼습니다.";
        } else {
            return "비겼습니다.";
        }
    }

    // 전적 출력 로직
    public static void gameRecord(String winner) {
        if (winner.equals("당신이 이겼습니다.")) {
            win++;
        } else if (winner.equals("딜러가 이겼습니다.")) {
            lose++;
        } else {
            tie++;
        }

        String record = "";
        if (win > 0) {
            record += win + "승 ";
        }
        if (tie > 0) {
            record += tie + "무 ";
        }
        if (lose > 0) {
            record += lose + "패";
        }

        System.out.println(RECORD_PREFIX + record);
    }

    // 게임 재진행 여부 확인
    public static boolean getMoreGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
        String answer = sc.nextLine();

        while (true) {
            if (answer.equalsIgnoreCase("N")) {
                break;
            } else if (answer.equalsIgnoreCase("Y")) {
                return true;
            }
            System.out.println("잘못 입력하셨습니다.");
        }
        return false;
    }
}


