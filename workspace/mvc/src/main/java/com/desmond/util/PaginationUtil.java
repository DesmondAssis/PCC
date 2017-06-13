package com.desmond.util;

/**
 * Created by presleyli on 2017/6/12.
 */
public class PaginationUtil {
    public static long getOffset(long offset, long actSize) {
        return offset + actSize;
    }
}
