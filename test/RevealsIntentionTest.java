import domain.ActionStatus;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 展现意图
 * <p/>
 * 要求： 重构ActionStatus类的代码，不改变功能的情况下，提高代码的可读性
 */
public class RevealsIntentionTest {

    @Test
    public void test() {
        Integer userId = 11;
        Integer giftModelId1 = 111;
        Integer giftModelId2 = 222;
        Integer giftModelId3 = 444;
        Integer sharedGiftModelId1 = 666;

        ActionStatus a = new ActionStatus();
        a.updateStatus(userId, giftModelId1, giftModelId2,
                giftModelId3, sharedGiftModelId1);

        assertThat(a.hasBeenTaken(), is(1));
        assertThat(a.hasBeenShared(), is(1));
        assertThat(a.hasFinish(), is(0));
    }
}