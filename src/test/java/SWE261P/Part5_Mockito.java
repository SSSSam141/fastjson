package SWE261P;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

public class Part5_Mockito {

    private GetJson getJson;
    private String result;
    @Before
    public void setup() {
        getJson = mock(GetJson.class);
        result = new String("");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockitotest() {

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
        result = getJson.get("https://baidu.com/");
        assertThat(JSON.toJSON("{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}")).isEqualTo(JSON.toJSON(result));
    }

}

