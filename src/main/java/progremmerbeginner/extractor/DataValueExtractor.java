package progremmerbeginner.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import progremmerbeginner.container.Data;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {
    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver valueReceiver) {
        Object data=originalValue.getData();
        valueReceiver.value(null,data);
    }
}
