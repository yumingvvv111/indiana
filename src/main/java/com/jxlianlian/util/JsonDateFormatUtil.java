package com.jxlianlian.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * jackson日期转换工具类
 */
public class JsonDateFormatUtil extends JsonSerializer<Date> {

  /**
   * Jackson支持日期字符串格式 "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
   * "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" "EEE, dd MMM yyyy HH:mm:ss zzz" "yyyy-MM-dd"
   * 在Date变量名前添加这句@JsonSerialize(using = JsonDateFormat.class)
   */
  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    String formattedDate = formatter.format(value);
    jgen.writeString(formattedDate);
  }

}
