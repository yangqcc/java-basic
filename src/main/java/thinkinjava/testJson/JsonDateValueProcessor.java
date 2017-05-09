/*
package thinkinjava.testJson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

*/
/**
 * @author zhang yanan
 * @createTime 2011-3-12 下午02:57:17
 * @desc Json处理java对象到json格式转换的日期处理类
 * 
 *//*

public class JsonDateValueProcessor implements JsonValueProcessor {
	private String datePattern = "yyyy-MM-dd HH:mm:ss";// 日期格式

	public JsonDateValueProcessor() {
		super();
	}

	// 构造函数
	public JsonDateValueProcessor(String format) {
		super();
		this.datePattern = format;
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process(value);
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		return process(value);
	}

	private Object process(Object value) {
		try {
			if (value instanceof Date) {
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern,
						Locale.UK);
				return sdf.format((Date) value);
			}
			return value == null ? "" : value.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePaterns) {
		this.datePattern = datePaterns;
	}

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		Users user = new Users();
		user.setDate(new Date());
		user.setName("qc");
		list.add(user);
		JsonConfig jsonConfig = new JsonConfig();

		// 设置javabean中日期转换时的格式
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor("yyyy-MM-dd"));
		// 获取json数组
		JSONArray jsonArray = JSONArray.fromObject(user, jsonConfig);
		JSONObject jsonObject=JSONObject.fromObject(user,jsonConfig);
        String s=jsonArray.toString();
        JSONObject jb=jsonArray.getJSONObject(0);
        System.out.println(jb.get("date") instanceof Date);
//        System.out.println(jb.get);
        jb.put("hello", "你好");
        System.out.println(jb.toString());
		System.out.println(jsonArray.toString());
		System.out.println(jsonObject.toString());
		
		Map<String,String> strmap=new JSONObject();
		Map<String,String> map=new HashMap<>();
		map.put("aa", "aa");
		map.put("bb", "aa");
		map.put("cc", "aa");
		map.put("dd", "aa");
		List listt=new ArrayList();
		listt.add(map);
		JSONArray js=JSONArray.fromObject(listt);
		JSONArray ppArray=JSONArray.fromObject(map);
		System.out.println(js.toString());
		
	}
}
*/
