/**  
 * @Title JsonDateSerializer.java
 * @Package cn.boom.util
 * @Description TODO
 * @author crown
 * @date Nov 3, 2017 9:56:21 AM
 */
package cn.boom.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @ClassName JsonDateSerializer
 * @Description 自定义Date类型转换成Json
 * @author crown
 * @email 1084961504@qq.com
 * @date Nov 3, 2017 9:56:21 AM
 */
public class JsonDateSerializer extends JsonSerializer<Date> {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		String value = dateFormat.format(date);
		gen.writeString(value);
	}

}
