

import static org.junit.Assert.*;

import domain.IdCounter;
import org.junit.Test;

import java.util.Map;
import java.util.Set;


/***
 * 通过测试
 *
 * 要求： 不改变测试代码的情况下，通过实现缺失的功能代码来通过测试
 *
 * */
public class PassesTheTest {

    /***
     * IdCounter 是一个id计数器，负责统计某个id出现的次数。
     *
     * */
    @Test
    public void test() {
        IdCounter aIdCounter = new IdCounter();
        aIdCounter.addId(123);
        aIdCounter.addId(123);
        aIdCounter.addId(124);
        aIdCounter.addId(123);
        aIdCounter.addId(125);

        Set<Integer> allId = aIdCounter.getIds();
        assertEquals(3, allId.size());

        Map<Integer, Integer> result = aIdCounter.getResult();
        assertEquals(3,(int)result.get(123));

    }
}