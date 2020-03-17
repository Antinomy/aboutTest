package domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 通过测试
 *
 * 要求： 不改变测试代码的情况下，通过实现缺失的功能代码来通过测试
 *
 * */
public class IdCounter {
    private Map<Integer, Integer> result;
    private ArrayList<Integer> ids;

    public IdCounter() {
        result = new ConcurrentHashMap<Integer, Integer>();
    }

    public void addId(int id) {

        if (isIn(id, result)) {

            //TODO 添加实现代码

        }
        result.put(id, 1);
    }


    private boolean isIn(Integer key, Map<Integer, Integer> map) {

        Integer result = map.get(key);
        if (result == null)
            return false;

        return true;
    }

    public Set<Integer> getIds() {

        return result.keySet();
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
}
