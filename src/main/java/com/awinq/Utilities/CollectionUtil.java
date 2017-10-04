package com.awinq.Utilities;

import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {
    public static boolean isEmpty(Collection<?> colleaction){
        return CollectionUtil.isEmpty(colleaction);
    }

    public static boolean isNotEmpty(Collection<?> colleaction){
        return !isEmpty(colleaction);
    }

    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?,?> map){
        return !isEmpty(map);
    }
}
