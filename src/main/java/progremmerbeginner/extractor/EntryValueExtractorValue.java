package progremmerbeginner.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import progremmerbeginner.container.Entry;

public class EntryValueExtractorValue implements ValueExtractor<Entry <?,@ExtractedValue?>> {
    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null,"value",originalValue.getValue());
    }
}
