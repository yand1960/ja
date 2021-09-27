package my.lambdas;

import java.util.ArrayList;
import java.util.List;

public class IntegerCollectionTransformer {

    public List<Integer> squares(List<Integer> data) {
        List<Integer> results = new ArrayList<>();
        for(int x: data) {
            results.add(x * x);
        }
        return results;
    }

}
