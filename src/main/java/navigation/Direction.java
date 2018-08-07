package navigation;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * This enum represents directions.
 * There are 4 different directions.
 * Each direction know what direction is on their left or right.
 * Each direction also knows what it means on the x-y axis to move one ahead.
 *
 * N(0,1) would call the constructor to initialize the fields for that member.
 */
public enum Direction {

    N(0,1) {
        public String label = "N";

        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }

    },

    S(0,-1) {
        @Override
        public Direction right() {
            return W;
        }

        @Override
        public Direction left() {
            return E;
        }
    },

    E(1,0) {
        @Override
        public Direction right() {
            return S;
        }

        @Override
        public Direction left() {
            return N;
        }
    },

    W(-1,0) {
        @Override
        public Direction right() {
            return N;
        }

        @Override
        public Direction left() {
            return S;
        }
    };

    public abstract Direction right();
    public abstract Direction left();
    private final int moveOnXAxis;
    private final int moveOnYAxis;

    Direction(final int moveOnXAxis, final int moveOnYAxis) {
        this.moveOnXAxis = moveOnXAxis;
        this.moveOnYAxis = moveOnYAxis;
    }

    public int movementOnXAxis() {
        return this.moveOnXAxis;
    }

    public int movementOnYAxis() {
        return this.moveOnYAxis;
    }

    public static final Map<String, Direction> stringToDirectionMap = ImmutableMap
            .of("N", Direction.N,
                "S", Direction.S,
                "E", Direction.E,
                "W", Direction.W);


}
