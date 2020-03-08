package com.zhihui.id.model;

import com.zhihui.id.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author LDZ
 * @date 2020-03-08 10:35
 */
@Data
@AllArgsConstructor
public class Result {
    private long id;
    private Status status;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("id=").append(id);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
