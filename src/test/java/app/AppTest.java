package app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 행렬만들고 => 맵이 필요하다.
//위치 초기화하고
//어느 손이 움직일지 판단하고
//147는 왼쪽
//369는 오른쪽
//2580은 거리를 계산한다. 거리 계산에서 짧은쪽
//같으면 손잡이
//기록한다
class AppTest {
    @Test
    void copyOfRange() {
        assertThat(
                Arrays.copyOfRange(new int[]{1}, 1, 1)
        ).isEqualTo(new int[]{});
    }

    @Test
    void run() {
        assertThat(new App().run(
                new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
            "right"
        )).isEqualTo("LRLLLRLLRRL");

        assertThat(new App().run(
                new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                "left"
        )).isEqualTo("LRLLRRLLLRR");

        assertThat(new App().run(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                "right"
        )).isEqualTo("LLRLLRLLRL");
    }

    @Test
    void whichHandTest() {
        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        1,
                        "left"
                )
        ).isEqualTo("L");

        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        4,
                        "left"
                )
        ).isEqualTo("L");

        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        7,
                        "left"
                )
        ).isEqualTo("L");

        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        3,
                        "left"
                )
        ).isEqualTo("R");

        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        6,
                        "left"
                )
        ).isEqualTo("R");

        assertThat(
                new App().whichHand(
                        new int[]{0, 0},
                        new int[]{2, 0},
                        9,
                        "left"
                )
        ).isEqualTo("R");
    }

    @Test
    void closeLeftWhichHandTest() {
        assertThat(
                new App().whichHand(
                        new int[]{0, 1}, // 7
                        new int[]{2, 0}, // 0
                        8,
                        "left"
                )
        ).isEqualTo("L");
    }

    @Test
    void closeRightWhichHandTest() {
        assertThat(
                new App().whichHand(
                        new int[]{0, 3}, // 1
                        new int[]{2, 1}, // 9
                        8,
                        "left"
                )
        ).isEqualTo("R");
    }

    @Test
    void sameDistanceWhichHandTest() {
        assertThat(
                new App().whichHand(
                        new int[]{0, 1}, // 7
                        new int[]{2, 1}, // 9
                        8,
                        "left"
                )
        ).isEqualTo("L");

        assertThat(
                new App().whichHand(
                        new int[]{0, 1}, // 7
                        new int[]{2, 1}, // 9
                        8,
                        "right"
                )
        ).isEqualTo("R");
    }

    @Test
    void calculateDistance() {
        assertThat(
                new App().calculateDistance(new int[]{0, 1}, 8)
        ).isEqualTo(1);
        assertThat(
                new App().calculateDistance(new int[]{0, 2}, 8)
        ).isEqualTo(2);
        assertThat(
                new App().calculateDistance(new int[]{0, 3}, 8)
        ).isEqualTo(3);
    }
}
