/*
package thinkinjava.testJson;

import java.text.SimpleDateFormat;
import java.util.*;

*/
/**
 * @author zhang yanan
 * @createTime 2011-3-12 ����02:57:17
 * @desc Json����java����json��ʽת�������ڴ�����
 *//*



public class JsonDateValueProcessor implements JsonValueProcessor {
    private String datePattern = "yyyy-MM-dd HH:mm:ss";// ���ڸ�ʽ

    public JsonDateValueProcessor() {
        super();
    }

    // ���캯��
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

        // ����javabean������ת��ʱ�ĸ�ʽ
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor("yyyy-MM-dd"));
        // ��ȡjson����
        JSONArray jsonArray = JSONArray.fromObject(user, jsonConfig);
        JSONObject jsonObject = JSONObject.fromObject(user, jsonConfig);
        String s = jsonArray.toString();
        JSONObject jb = jsonArray.getJSONObject(0);
        System.out.println(jb.get("date") instanceof Date);
//        System.out.println(jb.get);
        jb.put("hello", "���");
        System.out.println(jb.toString());
        System.out.println(jsonArray.toString());
        System.out.println(jsonObject.toString());

        Map<String, String> strmap = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("aa", "aa");
        map.put("bb", "aa");
        map.put("cc", "aa");
        map.put("dd", "aa");
        List listt = new ArrayList();
        listt.add(map);
        JSONArray js = JSONArray.fromObject(listt);
        JSONArray ppArray = JSONArray.fromObject(map);
        System.out.println(js.toString());

    }
}
*/
