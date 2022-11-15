package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }


}
