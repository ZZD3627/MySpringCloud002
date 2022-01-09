package com.zzd.springcloud.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {
    private Integer code; //返回状态码
    private String message; //返回是否调用成功
    private T data; //返回的数据

    public CommonResult(Integer code, String message) {
       this(code, message, null);
    }
}
