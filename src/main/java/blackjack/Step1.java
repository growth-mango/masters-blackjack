package blackjack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Step1 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PLAYER_PREFIX = "You   : ";
    private static final String DEALER_PREFIX = "Dealer: ";
    private static final String RECORD_PREFIX = "현재 전적: ";
    private static int winCount = 0;
    private static int loseCount = 0;
    private static int tieCount = 0;

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.\n");

        while (true) {
            gamePrint(); // Game 1

            int[] playerCards = playerCard(); // 플레이어 카드 셋업
            int[] dealerCards = dealerCard(); // 딜러 카드 셋업

            System.out.println(PLAYER_PREFIX + Arrays.toString(playerCards)); // 출력
            System.out.println(DEALER_PREFIX + Arrays.toString(dealerCards));

            String winner = winnerDecision(playerCards, dealerCards);
            System.out.println(winner); // OO이이겼습니다.

            gameRecord(winner); // 현재 전적

            if (!getMoreGame()) {
                break;
            }
        }
        System.out.println("게임을 종료합니다.\n플레이해주셔서 감사합니다.");


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

    // 현재 전적 출력 로직
    public static void gameRecord(String winner) {
        if (winner.equals("당신이 이겼습니다.")) {
            winCount++;
        } else if (winner.equals("딜러가 이겼습니다.")) {
            loseCount++;
        } else {
            tieCount++;
        }

        String record = "";
        if (winCount > 0) {
            record += winCount + "승 ";
        }
        if (tieCount > 0) {
            record += tieCount + "무 ";
        }
        if (loseCount > 0) {
            record += loseCount + "패";
        }
        System.out.println(RECORD_PREFIX + record);
    }

    // 게임 진행 여부 입력받기
    public static boolean getMoreGame() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("잘못 입력하셨습니다.");
        }
    }
}

