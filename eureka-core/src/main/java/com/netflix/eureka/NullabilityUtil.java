package com.netflix.eureka;

import javax.annotation.Nullable;

public class NullabilityUtil {

    public static <T> T castToNonnull(@Nullable T param){
        if(param == null){
            throw new RuntimeException("param is null");
        }
        return param;
    }
}
