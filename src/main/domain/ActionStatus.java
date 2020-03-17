package domain;

/**
 * Created by Antinomy on 15/6/5.
 */
public class ActionStatus {

    private static final int TAKE_COUNT = 3;
    private int status1;// 是否领取礼物超过3次，是＝2，否&领取过＝1
    private int status2;// 是否分享过礼物 ， 是＝1
    private int status3;// 满足结束条件 ， 已经满足＝1，已经结束＝2 ,未完成 ＝ 0

    public void updateStatus(int userId,int giftId1,int giftId2,int giftId3,int shareGiftId) {

        int i = CustomerApiClient.hasTakenGift(userId, giftId1);
        i += CustomerApiClient.hasTakenGift(userId, giftId2);
        i += CustomerApiClient.hasTakenGift(userId, giftId3);

        if (i == 3)
            status1 = 2;
        else if (i != 0)
            status1 = 1;

        GiftRecord giftShareRecord2 = CustomerApiClient.hasSharedGiftRecord(userId,
                shareGiftId);

        if (giftShareRecord2 != null) {
            status2 = 1;
            int takeCount = giftShareRecord2.getTakeCount();
            if (takeCount >= TAKE_COUNT) {
                status3 = 1;
                if (giftShareRecord2.isFinish() == 1)
                    status3 = 2;
            }
            else
                status3 = 0;
        }
    }

    public Integer hasBeenTaken() {
        return status1;
    }

    public Integer hasBeenShared() {
        return status2;
    }

    public Integer hasFinish() {
        return status3;
    }
}
