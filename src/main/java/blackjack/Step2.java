package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step2 {
    private static final String GAME_PREFIX = "Game ";
    private static int game = 1;
    private static final String PROPERTY_PREFIX = "현재 재산: ";
    private static final String BET_PREFIX = "얼마를 거시겠습니까? ";
    private static List<Integer> deck = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("간단 카드 게임을 시작합니다.");
        resetDeck();
        System.out.println(PROPERTY_PREFIX);
        System.out.println(BET_PREFIX);
        gamePrint();
        System.out.println(cards());


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
        for (int i = 0; i <= 11; i++) {
            int count = (i==11) ? 12 : 4 ;
            for (int j = 0; j < count; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }

}
