package SWE261P;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.json.bvt.JSONTest3;
import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SWE261P_A1_Test extends TestCase{
    @Test
    public void test_String_Serialization() throws Exception {
        Assert.assertEquals("\"SWE261\"", JSON.toJSONString("SWE261"));
        Assert.assertEquals("3", JSON.toJSONString(3));
    }
    @Test
    public void test_Array_Serialization() throws Exception {
        int[] values = new int[] {-1, 0, 1};
        String text = JSON.toJSONString(values);
       Assert.assertEquals("[-1,0,1]", text);
    }


    @Test
    public void test_Array_Deserialization() throws Exception {
        int[] values = new int[] {-1, 0, 1};
        String text = JSON.toJSONString(values);
        Assert.assertEquals("[-1,0,1]", text);
        long[] values_2 = JSON.parseObject(text, long[].class);
        assertEquals(values_2.length, values.length);
        for (int i = 0; i < values.length; ++i) {
            assertEquals(values[i], values_2[i]);
        }
    }

    @Test
    public void test_Object_Deserialization() throws Exception {
        ExtraProcessor extraProcessor = new ExtraProcessor() {
            public void processExtra(Object object, String key, Object value) {
                testObject model = (testObject) object;
                model.attributes.put(key, value);
            }
        };

        testObject model = JSON.parseObject("{\"id\":1001}", (Type) testObject.class, extraProcessor);
        Assert.assertEquals(1, model.attributes.size());
        Assert.assertEquals(1001, model.attributes.get("id"));
    }

    @Test
    public void test_list_Deserialization_JavaGenerics() throws Exception {
        List<Long> list = JSON.parseObject("[1,2,3]", new TypeReference<List<Long>>() {});
        Assert.assertEquals(1L, ((Long) list.get(0)).longValue());
    }

    public static class testObject {
        public static Map<String, Object> attributes = new HashMap<String, Object>();
    }



}
