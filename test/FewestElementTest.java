import domain.BusinessConstants;
import domain.User;
import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 最少的元素
 * <p/>
 * 要求： 重构以下settingJumpTo()代码，不改变测试代码和功能的情况下，去除所有的else和重复代码
 */
public class FewestElementTest {

    @Test
    public void test() {

        User none = new User();
        assertThat(settingJumpTo(none), is(nullValue()));

        User storeUser = new User();
        storeUser.setAccountType("store");
        assertThat(settingJumpTo(storeUser), is("setting/store/storeAccountInfo"));

        User bizUser = new User();
        bizUser.setBusinessId(1);
        bizUser.setAgencyId(0);
        bizUser.setResellerId(0);
        bizUser.setState(BusinessConstants.BusinessState.REVIEWED);
        assertThat(settingJumpTo(bizUser), is("setting/business/businessAccountInfo"));

        User agencyUser = new User();
        agencyUser.setBusinessId(0);
        agencyUser.setAgencyId(1);
        agencyUser.setResellerId(0);
        agencyUser.setState(BusinessConstants.BusinessState.EDITABLE);
        assertThat(settingJumpTo(agencyUser), is("setting/agency/agencyAccountInfo"));


        User resellerUser = new User();
        resellerUser.setBusinessId(0);
        resellerUser.setAgencyId(0);
        resellerUser.setResellerId(1);
        resellerUser.setState(BusinessConstants.BusinessState.PENDING_REVIEW);
        assertThat(settingJumpTo(resellerUser), is("setting/reseller/resellerAccountInfo"));
    }

    public String settingJumpTo(User user) {

        //门店
        if ("store".equals(user.getAccountType())) {
            return "setting/store/storeAccountInfo";

        } else {
            //商家
            if (user.getBusinessId() != null && user.getBusinessId() > 0) {
                String stateStr = "";

                if (BusinessConstants.BusinessState.REVIEWED.equals(user.getState())) {
                    stateStr = "企业信息已认证";
                } else if (BusinessConstants.BusinessState.NOT_PASS.equals(user.getState())) {
                    stateStr = "信息审核不通过";
                } else if (BusinessConstants.BusinessState.EDITABLE.equals(user.getState())) {
                    stateStr = "企业信息未认证";
                } else if (BusinessConstants.BusinessState.PENDING_REVIEW.equals(user.getState())) {
                    stateStr = "信息已提交，审核中";
                }

                StringBuffer buffer = new StringBuffer();

                buffer.append("已经开通");
                if (user.getBusinessId() != null && user.getBusinessId() > 0) {
                    buffer.append("商家");
                }
                if (user.getAgencyId() != null && user.getAgencyId() > 0) {
                    buffer.append("代理商");
                }
                if ((user.getBusinessId() > 0 && user.getResellerId() > 0) || (user.getAgencyId() > 0 && user.getResellerId() > 0)) {
                    buffer.append("和");
                }
                if (user.getResellerId() != null && user.getResellerId() > 0) {
                    buffer.append("分销商");
                }
                buffer.append("角色");

                log("roleTypeInfo", buffer.toString());
                log("stateStr", stateStr);

                return "setting/business/businessAccountInfo";

            } else if (user.getAgencyId() != null && user.getAgencyId() > 0) {


                String stateStr = "";

                if (BusinessConstants.BusinessState.REVIEWED.equals(user.getState())) {
                    stateStr = "企业信息已认证";
                } else if (BusinessConstants.BusinessState.NOT_PASS.equals(user.getState())) {
                    stateStr = "信息审核不通过";
                } else if (BusinessConstants.BusinessState.EDITABLE.equals(user.getState())) {
                    stateStr = "企业信息未认证";
                } else if (BusinessConstants.BusinessState.PENDING_REVIEW.equals(user.getState())) {
                    stateStr = "信息已提交，审核中";
                }

                StringBuffer buffer = new StringBuffer();

                buffer.append("已经开通");
                if (user.getBusinessId() != null && user.getBusinessId() > 0) {
                    buffer.append("商家");
                }
                if (user.getAgencyId() != null && user.getAgencyId() > 0) {
                    buffer.append("代理商");
                }
                if ((user.getBusinessId() > 0 && user.getResellerId() > 0) || (user.getAgencyId() > 0 && user.getResellerId() > 0)) {
                    buffer.append("和");
                }
                if (user.getResellerId() != null && user.getResellerId() > 0) {
                    buffer.append("分销商");
                }
                buffer.append("角色");

                log("roleTypeInfo", buffer.toString());
                log("stateStr", stateStr);

                return "setting/agency/agencyAccountInfo";

            } else if (user.getResellerId() != null && user.getResellerId() > 0) {

                String stateStr = "";
                if (BusinessConstants.BusinessState.REVIEWED.equals(user.getState())) {
                    stateStr = "企业信息已认证";
                } else if (BusinessConstants.BusinessState.NOT_PASS.equals(user.getState())) {
                    stateStr = "信息审核不通过";
                } else if (BusinessConstants.BusinessState.EDITABLE.equals(user.getState())) {
                    stateStr = "企业信息未认证";
                } else if (BusinessConstants.BusinessState.PENDING_REVIEW.equals(user.getState())) {
                    stateStr = "信息已提交，审核中";
                }


                StringBuffer buffer = new StringBuffer();

                buffer.append("已经开通");
                if (user.getBusinessId() != null && user.getBusinessId() > 0) {
                    buffer.append("商家");
                }
                if (user.getAgencyId() != null && user.getAgencyId() > 0) {
                    buffer.append("代理商");
                }
                if ((user.getBusinessId() > 0 && user.getResellerId() > 0) || (user.getAgencyId() > 0 && user.getResellerId() > 0)) {
                    buffer.append("和");
                }
                if (user.getResellerId() != null && user.getResellerId() > 0) {
                    buffer.append("分销商");
                }
                buffer.append("角色");

                log("roleTypeInfo", buffer.toString());
                log("stateStr", stateStr);

                return "setting/reseller/resellerAccountInfo";

            } else {
                return null;
            }
        }
    }

    private void log(String key, String value) {
        System.out.println(key + " >>> " + value);
    }
}