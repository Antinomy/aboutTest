package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antinomy on 15/6/4.
 */
public class CustomerApiClient {


    public static List<GiftRecord> listTakedGift(Integer userId, Integer giftId) {
        List<GiftRecord> result = new ArrayList<GiftRecord>();
        GiftRecord record = getGiftRecord(userId, giftId);
        result.add(record);
        return result;
    }

    private static GiftRecord getGiftRecord(Integer userId, Integer giftId) {
        GiftRecord record = new GiftRecord();
        record.setUserId(userId);
        record.setGiftId(giftId);
        return record;
    }


    public static int hasTakenGift(int userId, int giftId) {
        if (giftId % 2 == 0)
            return 1;

        return 0;
    }

    public static GiftRecord hasSharedGiftRecord(int userId, int giftId) {

        if (giftId % 2 == 0)
            return getGiftRecord(userId, giftId);

        return null;
    }
}
