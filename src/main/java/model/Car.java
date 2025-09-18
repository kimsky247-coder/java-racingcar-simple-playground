package model;

public class Car {
    private static final int MOVE_DISTANCE = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private String carName;
    private int position;

    public Car(String carName) {
        validateName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void moveForward() {
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
