package com.rhizomind.ds.integrations.security.licensescan.hieronymus;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DependencyDeserializer extends JsonDeserializer<DependencyId> {

    public static final String FULL_DEPENDENCY_ID_REG_EX = "([a-zA-Z0-9\\.]+):([a-zA-Z0-9\\-]+):([a-zA-Z0-9\\.]+)";

    public static final Pattern DEPENDENCY_ID_PATTERN = Pattern.compile(FULL_DEPENDENCY_ID_REG_EX);

    static {
    }

    public DependencyId deserialize(
            JsonParser jp,
            DeserializationContext deserializationContext
    ) throws IOException, JacksonException {
        String textValue = jp.getCodec().<TextNode>readTree(jp).textValue();
        Matcher matcher = DEPENDENCY_ID_PATTERN.matcher(textValue);
        if (matcher.matches()) {
            return new DependencyId(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3)
            );
        }
        return new DependencyId(textValue, null, null);
    }
}
