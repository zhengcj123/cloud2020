package com.dcsyun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhengcj
 * @create 2020-10-28 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{
    private Long id;
    private String serial;

}
