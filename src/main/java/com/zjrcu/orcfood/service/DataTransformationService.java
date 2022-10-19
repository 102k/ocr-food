package com.zjrcu.orcfood.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjrcu.orcfood.mapper.FoodAdditiveMapper;
import com.zjrcu.orcfood.mapper.FoodTypeAdditiveMapper;
import com.zjrcu.orcfood.pojo.FoodAdditive;
import com.zjrcu.orcfood.pojo.FoodTypeAdditive;
import com.zjrcu.orcfood.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTransformationService {
    @Autowired
    FoodAdditiveMapper foodAdditiveMapper;

    @Autowired
    FoodTypeAdditiveMapper foodTypeAdditiveMapper;

    @Autowired
    RedisCache redisCache;

    //将food_additive张表的数据存储到redis
    public void saveFoodAdditive(){
        List<FoodAdditive> foodAdditives = foodAdditiveMapper.selectList(null);

        String prefix = "food_additive";
        for (FoodAdditive additive:
        foodAdditives) {
            String key = prefix + ":id:" + additive.getId() + ":" + additive.getChineseName();
            redisCache.setCacheObject(key,additive);
        }
    }

    //将food_type_additive这张表的数据存储到redis
    public void saveFoodTypeAdditive(){
        List<FoodTypeAdditive> foodTypeAdditives = foodTypeAdditiveMapper.selectList(null);

        String prefix = "food_type_additive";
        for (FoodTypeAdditive additive:
                foodTypeAdditives) {
            String key = prefix + ":id:" + additive.getId() + ":type:" + additive.getFoodTypeNo()
                    + ":" + additive.getAdditiveName();
            redisCache.setCacheObject(key,additive);
        }
    }
}
