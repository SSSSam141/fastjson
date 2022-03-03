package SWE261P;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class Part5_Mockito {

    public interface GetJson {
        String get(String url);
    }

    @Test
    public void test() {
        GetJson getJson = mock(GetJson.class);
        when(getJson.get("https://baidu.com/")).thenReturn("{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}");

        String result = getJson.get("https://baidu.com/");
        Object jo = JSON.toJSON(result);
        Object jo1 = JSON.toJSON("{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}");
        Assert.assertEquals(jo, jo1);
    }

}

