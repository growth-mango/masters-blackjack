package blackjack;

import java.util.*;
import java.util.stream.Collectors;

public class Step1 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PLAYER_PREFIX = "You   : ";
    private static final String DEALER_PREFIX = "Dealer: ";
    private static List<Integer> playerCards = new ArrayList<>();
    private static List<Integer> dealerCards = new ArrayList<>();
    private static final String RECORD_PREFIX = "현재 전적: ";
    private static int winCount = 0;
    private static int loseCount = 0;
    private static int tieCount = 0;

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");

        while (true) {
            System.out.println();
            gamePrint(); // Game 1

            playerCards.add(drawCard()); // 플레이어 카드 셋업
            dealerCards.add(drawCard());// 딜러 카드 셋업

            System.out.println(PLAYER_PREFIX + formatCards(playerCards)); // 출력
            System.out.println(DEALER_PREFIX + formatCards(dealerCards));

            String winner = winnerDecision(
                    playerCards.get(playerCards.size() - 1),
                    dealerCards.get(playerCards.size() - 1)
            ); // 마지막 카드로 승자 결정
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

    // 랜덤 카드 생성
    private static int drawCard() {
        Random random = new Random();
        return random.nextInt(11) + 1;
    }

    private static String formatCards(List<Integer> cards) {
        return cards.stream()
                .map(card -> "[" + card + "]")
                .collect(Collectors.joining(" ")); // 공백으로 구분된 단일 문자열로 결합
    }

    // 승자 결정 로직
    public static String winnerDecision(int playerCard, int dealerCard) {
        if (playerCard > dealerCard) {
            return "당신이 이겼습니다.";
        } else if (playerCard < dealerCard) {
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

