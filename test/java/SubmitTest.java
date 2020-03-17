import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Antinomy on 15/6/3.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PassesTheTest.class,
                RevealsIntentionTest.class,
                NoDuplicationTest.class,
                FewestElementTest.class
        }
)
public class SubmitTest {
    // 提交代码之前， 保证通过所有的测试
}
