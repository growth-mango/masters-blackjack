import java.util.Arrays;

public class temp {
    public static void main(String[] args) {
        char[] c = {'c', 'a', 'm', 'p', 'u', 's'};

        // 버블 정렬
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length - i - 1; j++) {
                if (c[j] > c[j + 1]) {
                    // 요소의 위치 교환
                    char temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }

        // 정렬된 배열 출력
        for (char ch : c) {
            System.out.print(ch + " ");
        }

        int index = Arrays.binarySearch(c, 'p');
        System.out.println(index);

    }
}