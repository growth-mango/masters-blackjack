package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Step2 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static List<Integer> playerCards = new ArrayList<>();
    private static List<Integer> dealerCards = new ArrayList<>();
    private static final String PROPERTY_PREFIX = "현재 재산: ";
    private static int property = 1000;
    private static final String BET_PREFIX = "얼마를 거시겠습니까? ";
    private static List<Integer> deck = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");
        resetDeck();

        System.out.println(PROPERTY_PREFIX + property); // 현재자산
        currentProperty(); // 현재 자산 계산 로직

        getUserBet(); // 베팅 금액 입력받기
        // System.out.println(BET_PREFIX);

        gamePrint(); // 게임 프린트
        System.out.println(playerCard());
        winnerDecision(); // 승패 결정 로직
        getMoreGame(); // 한 게임 더?
        System.out.println(dealerCard());
        System.out.println(cards());
        cheat();


    }

    public static void gamePrint() {
        System.out.println(GAME_PREFIX + game);
        game++;
    }

    // 52장의 카드 프리셋
    public static List<Integer> cards() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            int count = (i == 11) ? 12 : 4; // 11은 12장, 나머지는 4장 
            for (int j = 0; j < count; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public static int playerCard() {
        return drawCard();
    }

    public static int dealerCard() {
        return drawCard();
    }

    private static int drawCard() {
        if (deck.size() <= 10) { // 덱이 10장 이하인 경우 새로운 덱으로 재설정
            resetDeck();
        }
        return deck.remove(0); // 덱이 10장을 초과할경우 덱에서 하나 뽑고 제거
    }


    private static void resetDeck() {
        deck.clear();
        for (int i = 1; i <= 11; i++) {
            int count = (i == 11) ? 12 : 4;
            for (int j = 0; j < count; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }

    public static int playerCardTotal() {
        return calculateTotal(playerCards);
    }

    public static int dealerCardTotal() {
        return calculateTotal(dealerCards);
    }

    private static int calculateTotal(List<Integer> cards) {
        int total = 0;
        for (int card : cards) {
            total += card;
        }
        return total;
    }

    public static void cheat() {
        int cardsToShow = 6;
        int deckSize = deck.size();

        if (deckSize < cardsToShow) {
            cardsToShow = deckSize;
        }

        List<Integer> cheatCards = deck.subList(0, cardsToShow);

        System.out.println("덱의 카드 " + cheatCards);
    }

    // 현재 자산과 베팅 금액 관련된 로직들
    // 현재 자산 계산
    public static void currentProperty() {
        if (playerCardTotal() == 21) {
            property += (getUserBet() * 2);
        } else if (winnerDecision().equals("당신의 승리입니다.")) {
            property += getUserBet();
        } else {
            property -= getUserBet();
        }
    }

    // 사용자에게 베팅 금액 입력받기
    public static int getUserBet() {
        Scanner sc = new Scanner(System.in);
        int money;

        do {
            System.out.print(BET_PREFIX);
            money = sc.nextInt(); // 입력은 do 구문 실행 후 받아야함
            if (money % 100 == 0 && money <= property && money >= 100) {
                return money;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        } while (true);
    }

    // 승자 결정 로직
    public static String winnerDecision() {
        // 당신의 패배입니다. 현재 자산: currentProperty
        // 당신의 승리입니다.
        if (playerCardTotal() >= 22 || dealerCardTotal() == 21 || playerCardTotal() < dealerCardTotal()) {
            return "당신의 패배입니다.";
        } else if (dealerCardTotal() >= 22 || playerCardTotal() == 21 || playerCardTotal() > dealerCardTotal()) {
            return "당신의 승리입니다.";
        } else {
            return "무승부 입니다.";
        }
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

    // 카드 추가 여부 입력받기
    public static boolean getMoreCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("카드를 더 받겠습니까? (Y / N) ");
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
