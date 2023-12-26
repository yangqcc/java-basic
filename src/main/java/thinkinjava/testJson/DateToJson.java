/*
package thinkinjava.testJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateToJson implements JsonValueProcessor{
	private String format="yyyy-MM-dd";
	
	public DateToJson(){
		super();
	}
	public DateToJson(String format){
		super();
		this.format=format;
	}
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return process(arg0);
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return process(arg0);
	}
	
	private Object process(Object value){
		if(value instanceof Date){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			System.out.println(sdf.format(value)+"****");
			return sdf.format(value);
		}
		return value==null?"":value.toString();
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public static void main(String[] args) throws ParseException {
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new DateToJson("yyyy-MM-dd HH:mm:ss"));
		JSONObject json=new JSONObject();
		String s="2019-12-10";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(s);
		System.out.println(date);
		JSONArray jsonObject=JSONArray.fromObject(new Date(),jsonConfig);
		System.out.println(jsonObject.toString());
	}
}
*/
