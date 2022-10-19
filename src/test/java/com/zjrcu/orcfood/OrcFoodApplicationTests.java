package com.zjrcu.orcfood;

import com.zjrcu.orcfood.mapper.FoodAdditiveMapper;
import com.zjrcu.orcfood.pojo.FoodAdditive;
import com.zjrcu.orcfood.service.DataTransformationService;
import com.zjrcu.orcfood.utils.TxtProcess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrcFoodApplicationTests {
	@Autowired
	TxtProcess txtProcess;

	@Autowired
	FoodAdditiveMapper foodAdditiveMapper;

	@Autowired
	DataTransformationService dataTransformationService;

	@Test
	void contextLoads() {
//		String txt = "vvvvv";
//		List<String> segment = txtProcess.segment(txt);
//		System.out.println(segment);
//		FoodAdditive foodAdditive = foodAdditiveMapper.selectById(597);
//		System.out.println(foodAdditive);

//		dataTransformationService.saveFoodAdditive();
	}

}
