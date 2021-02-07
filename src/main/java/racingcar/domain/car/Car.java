package racingcar.domain.car;

import static racingcar.utils.ValidateUtils.validateCarName;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_CONDITION = 4;
    public static final char SINGLE_VISUAL_POSITION = '-';

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMoveForward(int randomInteger) {
        if (randomInteger >= MOVE_CONDITION) {
            ++position;
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return position == maxDistance;
    }

    @Override
    public String toString() {
        StringBuilder visualPosition = new StringBuilder();
        while (visualPosition.length() < position) {
            visualPosition.append(SINGLE_VISUAL_POSITION);
        }
        return name + " : " + visualPosition;
    }
}
