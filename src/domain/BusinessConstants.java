package domain;

/**
 * Created by Antinomy on 15/6/8.
 */
public final class BusinessConstants {
    private BusinessConstants() {
    }

    public interface BusinessState {
        Integer EDITABLE = 0;
        Integer REVIEWED = 1;
        Integer USING = 2;
        Integer DELETED = 3;
        Integer PENDING_REVIEW = 4;
        Integer NOT_PASS = 5;
    }
}
