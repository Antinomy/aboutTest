package domain;

/**
 * Created by Antinomy on 15/6/4.
 */
public class GiftRecord {
    private static final long serialVersionUID = 2710743185289704361L;

    /**
     * 主键
     */
    private Integer userId;

    /**
     * 礼包Id
     */
    private Integer giftId;

    /**
     * 领取次数
     */
    private Integer takeCount = 0;

    /**
     * 是否结束
     */
    private Integer isFinish = 0;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getTakeCount() {
      return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public int isFinish() {
        return isFinish;
    }

    public void setFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }
}
