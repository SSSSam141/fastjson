package com.alibaba.fastjson.serializer.issues3601;

import lombok.Data;
import com.alibaba.fastjson.serializer.issues3601.TestEnum;

@Data
public class TestEntity {
    private TestEnum testEnum;
    private String testName;
    public void setTestName(String name) {
        this.testName = name;
    }
    public void setTestEnum(TestEnum testEnum) {
        this.testEnum = testEnum;
    }
}
