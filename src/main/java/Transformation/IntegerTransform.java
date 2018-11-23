package Transformation;

import cucumber.api.Transformer;

public class IntegerTransform extends Transformer<Integer> {

    @Override
    public Integer transform(String emailCount){
        return emailCount.length();
    }
}
