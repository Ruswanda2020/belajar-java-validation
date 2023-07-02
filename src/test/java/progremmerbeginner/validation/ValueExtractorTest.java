package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.SampleData;
import progremmerbeginner.SampleEntry;
import progremmerbeginner.container.Data;

public class ValueExtractorTest extends AbstractValidatorTest{


    @Test
    void testSampleData() {
        SampleData data =new SampleData();
        data.setData(new Data<>());
        data.getData().setData("wanda dirgantara ya");

        validate(data);
    }

    @Test
    void testEntry() {
        SampleEntry entry=new SampleEntry();
        entry.getEntry().setKey(" ");
        entry.getEntry().setValue(" ");

        validate(entry);

    }
}
