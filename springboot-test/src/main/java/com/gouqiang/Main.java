package com.gouqiang;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shengouqiang
 * @date 2020/4/16
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Integer orderId = 12324;
        Byte refundChannel = new Byte("3");
        Byte refundType = new Byte("7");
        Throwable cause = null;
        log.warn("remote submitGuaranteeRefund service fallback, orderId is {},refundChannel is {},refundType is {}",orderId,refundChannel,refundType, cause );
    }
}
