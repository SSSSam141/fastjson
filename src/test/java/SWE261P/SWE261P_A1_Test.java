package SWE261P;
import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

public class SWE261P_A1_Test extends TestCase{
    @Test
    public void test_String() throws Exception {
        Assert.assertEquals("\"SWE261\"", JSON.toJSONString("SWE261"));
        Assert.assertEquals("3", JSON.toJSONString(3));
    }
    @Test
    public void test_Array() throws Exception {
        int[] values = new int[] {-1, 0, 1};
        String text = JSON.toJSONString(values);
        long[] values_2 = JSON.parseObject(text, long[].class);
        assertEquals(values_2.length, values.length);
        for (int i = 0; i < values.length; ++i) {
            assertEquals(values[i], values_2[i]);
        }
    }

}
