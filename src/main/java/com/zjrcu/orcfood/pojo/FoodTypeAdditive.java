package com.zjrcu.orcfood.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodTypeAdditive implements Serializable {
    public Integer id;
    public String foodTypeNo;
    public String additiveName;
    public String function;
    public String maxUsage;
    public String cnsNo;
    public String insNo;
    public String remarks;
}
