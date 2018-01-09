package com.ustbyjy.util;

public class IpUtil {

    /**
     * 判断IP是否在某个网段内
     *
     * @param ip      IP地址，如 192.168.1.127
     * @param segment 网段，如 192.168.1.64/26
     * @return boolean
     */
    public static boolean isInRange(String ip, String segment) {
        String[] ipBlocks = ip.split("\\.");
        int binaryIp = (Integer.parseInt(ipBlocks[0]) << 24)
                | (Integer.parseInt(ipBlocks[1]) << 16)
                | (Integer.parseInt(ipBlocks[2]) << 8)
                | Integer.parseInt(ipBlocks[3]);

        int type = Integer.parseInt(segment.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String segmentIp = segment.replaceAll("/.*", "");
        String[] segmentIpBlocks = segmentIp.split("\\.");
        int binarySegmentIp = (Integer.parseInt(segmentIpBlocks[0]) << 24)
                | (Integer.parseInt(segmentIpBlocks[1]) << 16)
                | (Integer.parseInt(segmentIpBlocks[2]) << 8)
                | Integer.parseInt(segmentIpBlocks[3]);

        return (binaryIp & mask) == (binarySegmentIp & mask);
    }
}

