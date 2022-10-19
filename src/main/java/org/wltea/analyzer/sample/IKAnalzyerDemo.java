/**
 * IK 中文分词  版本 5.0.1
 * IK Analyzer release 5.0.1
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 *
 *
 */
package org.wltea.analyzer.sample;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * 使用IKAnalyzer进行分词的演示
 * 2012-10-22
 *
 */
public class IKAnalzyerDemo {

  public static void main(String[] args) {
    // 构建IK分词器，使用smart分词模式
    Analyzer analyzer = new IKAnalyzer(true);

    // 获取Lucene的TokenStream对象
    TokenStream ts = null;
    try {
      ts = analyzer.tokenStream("myfield", new StringReader(
          "营养成分资料Nutritional Informationa上连家配料:脱脂奶粉、脱盐乳清粉(蛋白酶解)、植物油(葵花籽油、大豆油、玉米油)、乳糖、乳清蛋白粉、无水奶油、低聚半乳糖(GOS)、低聚果糖(FOS)、牛磺酸、二十二碳六烯0话,老东净见酸(DHA)、花生四烯酸(ARA)、乳铁蛋白、叶黄素、属李，保公集东题乳杆菌LGG(添加量=2x10*CFU/g)、动物双歧杆菌其Bb-12(添加量>2x10CFUg);食品添加剂:磷脂。维生素:维生素A(醋酸视黄酯)、维生素D(胆钙化醇)、维能示生素C(L-抗坏血酸)、维生素E(d|-a-酯酸生育酚)、维生素B.(硝酸硫胺素)、维生素B:(盐酸此哆醇)、维生素B12(瓤YER1]钴胺)、维生素K(植物甲蔡醒)、叶酸、烟酰胺、D-泛酸钙、D一生物素、氯化胆碱、维生素Bz(核黄素)。矿物质，碳酸钙、硫酸亚铁、硫酸锌、硫酸铜、碘化钾。自营养成分表项目的成发先生能量小每100千焦每100克奶粉每100毫升心波260蛋白质小g)10019232.3乳跌蛋B/mg)0.917.04.7B的g)1.835.02.4其中:亚忠的八9)0.917.80.28服水化合物19)0.112.107.6一十二破六2.956.63.4D。\n"));
      //

      // 获取词元位置属性
      OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
      // 获取词元文本属性
      CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
      // 获取词元文本属性
      TypeAttribute type = ts.addAttribute(TypeAttribute.class);

      // 重置TokenStream（重置StringReader）
      ts.reset();
      // 迭代获取分词结果

      while (ts.incrementToken()) {
//        System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : "
//            + term.toString() + " | " + type.type());
        System.out.println(term.toString());
      }
      // 关闭TokenStream（关闭StringReader）
      ts.end(); // Perform end-of-stream operations, e.g. set the final offset.

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 释放TokenStream的所有资源
      if (ts != null) {
        try {
          ts.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

}
