package domain;

public class RacingCount {
    int count;

    public RacingCount(int count) {
        if (!ValidationUtils.validatePositiveNumber(count)) {
            throw new IllegalArgumentException("시도 횟수는 자연수 범위의 값을 입력해주세요.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
