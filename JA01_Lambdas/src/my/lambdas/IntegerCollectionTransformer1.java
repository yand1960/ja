package my.lambdas;

import java.util.ArrayList;
import java.util.List;

public class IntegerCollectionTransformer1 {

    public List<Integer> transform(List<Integer> data, TransformInteger action) {
        List<Integer> results = new ArrayList<>();
        for(int x: data) {
            results.add(action.doTransform(x));
        }
        return results;
    }

}
