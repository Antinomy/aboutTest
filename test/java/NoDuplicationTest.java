import domain.CustomerApiClient;
import domain.GiftRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class NoDuplicationTest {

    /**
     * 去除重复
     * <p/>
     * 要求： 重构以下getGiftRecords()代码，不改变测试代码和功能的情况下，去除重复的代码
     */

    @Test
    public void test() {

        ArrayList<GiftRecord> giftRecord2List = getGiftRecords();

        assertThat(giftRecord2List.size(), is(4));

        assertThat(giftRecord2List.get(0).getGiftId(),is(123));
        assertThat(giftRecord2List.get(1).getGiftId(),is(223));
        assertThat(giftRecord2List.get(2).getGiftId(),is(444));
        assertThat(giftRecord2List.get(3).getGiftId(),is(555));

    }

    private ArrayList<GiftRecord> getGiftRecords() {
        Integer giftModelId1 = 123;
        Integer giftModelId2 = 223;
        Integer giftModelId3 = 444;
        Integer otherGiftModelId1 = 555;

        List<GiftRecord> normal1GiftRecords = new ArrayList<GiftRecord>();
        List<GiftRecord> normal2GiftRecords = new ArrayList<GiftRecord>();
        List<GiftRecord> normal3GiftRecords = new ArrayList<GiftRecord>();
        List<GiftRecord> specGiftRecords = new ArrayList<GiftRecord>();

        Integer recordId = 11;
        normal1GiftRecords = CustomerApiClient.listTakedGift(recordId,
                giftModelId1);
        normal2GiftRecords = CustomerApiClient.listTakedGift(recordId,
                giftModelId2);
        normal3GiftRecords = CustomerApiClient.listTakedGift(recordId,
                giftModelId3);
        specGiftRecords = CustomerApiClient.listTakedGift(recordId,
                otherGiftModelId1);

        ArrayList<GiftRecord> giftRecord2List = new ArrayList<GiftRecord>();


        if (normal1GiftRecords.size() > 0) {
            giftRecord2List.addAll(normal1GiftRecords);
        }
        if (normal2GiftRecords.size() > 0) {
            giftRecord2List.addAll(normal2GiftRecords);
        }
        if (normal3GiftRecords.size() > 0) {
            giftRecord2List.addAll(normal3GiftRecords);
        }
        if (specGiftRecords.size() > 0) {
            giftRecord2List.addAll(specGiftRecords);
        }
        return giftRecord2List;
    }
}