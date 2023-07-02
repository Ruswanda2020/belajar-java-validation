package progremmerbeginner.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import progremmerbeginner.container.Entry;

public class EntryValueExtractorKey implements ValueExtractor<Entry <@ExtractedValue?,?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null,"key",entry.getKey());
    }
}
