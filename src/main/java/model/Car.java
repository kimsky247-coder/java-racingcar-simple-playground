package model;

public class Car {
    private static final int MOVE_DISTANCE = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String carName;
    private int position;

    private Car(String name) {
        String trimmedName = name.trim();
        validateName(trimmedName);
        this.carName = trimmedName;
        this.position = 0;
    }

    public static Car fromName(String name) {
        return new Car(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void moveForward() {
        position += MOVE_DISTANCE;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
