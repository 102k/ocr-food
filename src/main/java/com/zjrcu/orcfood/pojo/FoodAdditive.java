package com.zjrcu.orcfood.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodAdditive implements Serializable {
    public Integer id;
    public String chineseName;
    public String englishName;
    public String cnsNo;
    public String insNo;
    public String function;
}
