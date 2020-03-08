package com.zhihui.id.model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;


/**
 * segment
 *
 * @author LDZ
 * @date 2020-03-08 22:26
 */
@Data
public class Segment {

    /**
     *
     */
    private AtomicLong value = new AtomicLong(0);

    /**
     * max
     */
    private volatile long max;

    /**
     * 步长
     */
    private volatile int step;

    /**
     *
     */
    private SegmentBuffer buffer;

    Segment(SegmentBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * 获取空当
     *
     * @return max 和当前值的差
     */
    public long getIdle() {
        return this.getMax() - getValue().get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Segment(");
        sb.append("value:");
        sb.append(value);
        sb.append(",max:");
        sb.append(max);
        sb.append(",step:");
        sb.append(step);
        sb.append(")");
        return sb.toString();
    }
}
