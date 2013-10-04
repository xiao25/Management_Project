package Student.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/3/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomDateSerializer extends JsonSerializer<Date> {
    @Override

    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,

            JsonProcessingException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = formatter.format(value);

        jgen.writeString(formattedDate);

    }

}
