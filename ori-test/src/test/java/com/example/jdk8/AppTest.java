package com.example.jdk8;

import com.example.jdk8.entity.Binglizhenduan;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

//    @Before
//    public void setUp() {
//        diagnoses = new ArrayList<>();
//
//        // 中医诊断
//        Binglizhenduan zhongyi1 = new Binglizhenduan();
//        zhongyi1.setDiagnosis_name("湿浊证");
//        zhongyi1.setDiagnosis_code("B02.05.05.");
//        zhongyi1.setDiagnosis_desc("湿浊证");
//        zhongyi1.setDiagnosis_time("2025-06-11 11:48:03");
//        zhongyi1.setDiagnosis_num("1");
//        zhongyi1.setDiagnosis_sub_num("1");
//        zhongyi1.setDiagnosis_type_name("初步诊断");
//        zhongyi1.setDiagnosis_flag_name("中医诊断");
//        zhongyi1.setNormalization_diagnosis_name("湿浊证");
//        zhongyi1.setNormalization_name("湿浊证");
//        zhongyi1.setNorm_diagnosis_name("湿浊证");
//        diagnoses.add(zhongyi1);
//
//        Binglizhenduan zhongyi2 = new Binglizhenduan();
//        zhongyi2.setDiagnosis_name("冷泪");
//        zhongyi2.setDiagnosis_code("A11.01.02.01");
//        zhongyi2.setDiagnosis_desc("冷泪");
//        zhongyi2.setDiagnosis_time("2025-06-11 11:47:43");
//        zhongyi2.setDiagnosis_num("1");
//        zhongyi2.setDiagnosis_sub_num("0");
//        zhongyi2.setDiagnosis_type_name("初步诊断");
//        zhongyi2.setDiagnosis_flag_name("中医诊断");
//        zhongyi2.setNormalization_diagnosis_name("冷泪症");
//        zhongyi2.setNormalization_name("冷泪症");
//        zhongyi2.setNorm_diagnosis_name("冷泪症");
//        diagnoses.add(zhongyi2);
//
//        Binglizhenduan zhongyi3 = new Binglizhenduan();
//        zhongyi3.setDiagnosis_name("湿热疫毒内陷证");
//        zhongyi3.setDiagnosis_code("B02.05.04.03.08.08");
//        zhongyi3.setDiagnosis_desc("湿热疫毒内陷证");
//        zhongyi3.setDiagnosis_time("2025-06-11 11:47:43");
//        zhongyi3.setDiagnosis_num("2");
//        zhongyi3.setDiagnosis_sub_num("0");
//        zhongyi3.setDiagnosis_type_name("初步诊断");
//        zhongyi3.setDiagnosis_flag_name("中医诊断");
//        zhongyi3.setNormalization_diagnosis_name("湿热疫毒内陷证");
//        zhongyi3.setNormalization_name("湿热疫毒内陷证");
//        zhongyi3.setNorm_diagnosis_name("湿热疫毒内陷证");
//        diagnoses.add(zhongyi3);
//
//        // 西医诊断
//        Binglizhenduan xiyi1 = new Binglizhenduan();
//        xiyi1.setDiagnosis_name("高血压急症");
//        xiyi1.setDiagnosis_code("I10.x10");
//        xiyi1.setDiagnosis_desc("高血压急症");
//        xiyi1.setDiagnosis_time("2025-06-11 11:47:07");
//        xiyi1.setDiagnosis_num("1");
//        xiyi1.setDiagnosis_sub_num("1");
//        xiyi1.setDiagnosis_type_name("初步诊断");
//        xiyi1.setDiagnosis_flag_name("西医诊断");
//        xiyi1.setNormalization_diagnosis_name("高血压急症");
//        xiyi1.setNormalization_name("高血压急症");
//        xiyi1.setNorm_diagnosis_name("高血压急症");
//        diagnoses.add(xiyi1);
//
//        Binglizhenduan xiyi2 = new Binglizhenduan();
//        xiyi2.setDiagnosis_name("高血压");
//        xiyi2.setDiagnosis_code("I10.x00x002");
//        xiyi2.setDiagnosis_desc("高血压");
//        xiyi2.setDiagnosis_time("2025-06-11 11:46:45");
//        xiyi2.setDiagnosis_num("1");
//        xiyi2.setDiagnosis_sub_num("0");
//        xiyi2.setDiagnosis_type_name("初步诊断");
//        xiyi2.setDiagnosis_flag_name("西医诊断");
//        xiyi2.setNormalization_diagnosis_name("高血压");
//        xiyi2.setNormalization_name("高血压");
//        xiyi2.setNorm_diagnosis_name("高血压");
//        diagnoses.add(xiyi2);
//
//        Binglizhenduan xiyi3 = new Binglizhenduan();
//        xiyi3.setDiagnosis_name("营养风险");
//        xiyi3.setDiagnosis_code("R63.801");
//        xiyi3.setDiagnosis_desc("营养风险");
//        xiyi3.setDiagnosis_time("2025-06-11 11:46:40");
//        xiyi3.setDiagnosis_num("2");
//        xiyi3.setDiagnosis_sub_num("0");
//        xiyi3.setDiagnosis_type_name("初步诊断");
//        xiyi3.setDiagnosis_flag_name("西医诊断");
//        xiyi3.setNormalization_diagnosis_name("营养风险");
//        xiyi3.setNormalization_name("营养风险");
//        xiyi3.setNorm_diagnosis_name("营养风险");
//        diagnoses.add(xiyi3);
//
//        Binglizhenduan xiyi4 = new Binglizhenduan();
//        xiyi4.setDiagnosis_name("解毒剂和螯合剂的有害效应，不可归类在他处者");
//        xiyi4.setDiagnosis_code("Y57.200");
//        xiyi4.setDiagnosis_desc("解毒剂和螯合剂的有害效应，不可归类在他处者");
//        xiyi4.setDiagnosis_time("2025-06-12 11:53:50");
//        xiyi4.setDiagnosis_num("3");
//        xiyi4.setDiagnosis_sub_num("0");
//        xiyi4.setDiagnosis_type_name("初步诊断");
//        xiyi4.setDiagnosis_flag_name("西医诊断");
//        xiyi4.setNormalization_diagnosis_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
//        xiyi4.setNormalization_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
//        xiyi4.setNorm_diagnosis_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
//        diagnoses.add(xiyi4);
//
//        Binglizhenduan xiyi5 = new Binglizhenduan();
//        xiyi5.setDiagnosis_name("糖尿病");
//        xiyi5.setDiagnosis_code("E14.900x001");
//        xiyi5.setDiagnosis_desc("糖尿病");
//        xiyi5.setDiagnosis_time("2025-06-13 11:55:52");
//        xiyi5.setDiagnosis_num("4");
//        xiyi5.setDiagnosis_sub_num("0");
//        xiyi5.setDiagnosis_type_name("初步诊断");
//        xiyi5.setDiagnosis_flag_name("西医诊断");
//        xiyi5.setNormalization_diagnosis_name("糖尿病");
//        xiyi5.setNormalization_name("糖尿病");
//        xiyi5.setNorm_diagnosis_name("糖尿病");
//        diagnoses.add(xiyi5);
//    }

    @Test
    public  void processDiagnoses() {
        List<Binglizhenduan> diagnoses = new ArrayList<>();
        // 中医诊断
        Binglizhenduan zhongyi1 = new Binglizhenduan();
        zhongyi1.setDiagnosis_name("湿浊证");
        zhongyi1.setDiagnosis_code("B02.05.05.");
        zhongyi1.setDiagnosis_desc("湿浊证");
        zhongyi1.setDiagnosis_time("2025-06-11 11:48:03");
        zhongyi1.setDiagnosis_num("1");
        zhongyi1.setDiagnosis_sub_num("1");
        zhongyi1.setDiagnosis_type_name("初步诊断");
        zhongyi1.setDiagnosis_flag_name("中医诊断");
        zhongyi1.setNormalization_diagnosis_name("湿浊证");
        zhongyi1.setNormalization_name("湿浊证");
        zhongyi1.setNorm_diagnosis_name("湿浊证");
        diagnoses.add(zhongyi1);

        Binglizhenduan zhongyi2 = new Binglizhenduan();
        zhongyi2.setDiagnosis_name("冷泪");
        zhongyi2.setDiagnosis_code("A11.01.02.01");
        zhongyi2.setDiagnosis_desc("冷泪");
        zhongyi2.setDiagnosis_time("2025-06-11 11:47:43");
        zhongyi2.setDiagnosis_num("1");
        zhongyi2.setDiagnosis_sub_num("0");
        zhongyi2.setDiagnosis_type_name("初步诊断");
        zhongyi2.setDiagnosis_flag_name("中医诊断");
        zhongyi2.setNormalization_diagnosis_name("冷泪症");
        zhongyi2.setNormalization_name("冷泪症");
        zhongyi2.setNorm_diagnosis_name("冷泪症");
        diagnoses.add(zhongyi2);

        Binglizhenduan zhongyi3 = new Binglizhenduan();
        zhongyi3.setDiagnosis_name("湿热疫毒内陷证");
        zhongyi3.setDiagnosis_code("B02.05.04.03.08.08");
        zhongyi3.setDiagnosis_desc("湿热疫毒内陷证");
        zhongyi3.setDiagnosis_time("2025-06-11 11:47:43");
        zhongyi3.setDiagnosis_num("2");
        zhongyi3.setDiagnosis_sub_num("0");
        zhongyi3.setDiagnosis_type_name("初步诊断");
        zhongyi3.setDiagnosis_flag_name("中医诊断");
        zhongyi3.setNormalization_diagnosis_name("湿热疫毒内陷证");
        zhongyi3.setNormalization_name("湿热疫毒内陷证");
        zhongyi3.setNorm_diagnosis_name("湿热疫毒内陷证");
        diagnoses.add(zhongyi3);

        // 西医诊断
        Binglizhenduan xiyi1 = new Binglizhenduan();
        xiyi1.setDiagnosis_name("高血压急症");
        xiyi1.setDiagnosis_code("I10.x10");
        xiyi1.setDiagnosis_desc("高血压急症");
        xiyi1.setDiagnosis_time("2025-06-11 11:47:07");
        xiyi1.setDiagnosis_num("1");
        xiyi1.setDiagnosis_sub_num("1");
        xiyi1.setDiagnosis_type_name("初步诊断");
        xiyi1.setDiagnosis_flag_name("西医诊断");
        xiyi1.setNormalization_diagnosis_name("高血压急症");
        xiyi1.setNormalization_name("高血压急症");
        xiyi1.setNorm_diagnosis_name("高血压急症");
        diagnoses.add(xiyi1);

        Binglizhenduan xiyi2 = new Binglizhenduan();
        xiyi2.setDiagnosis_name("高血压");
        xiyi2.setDiagnosis_code("I10.x00x002");
        xiyi2.setDiagnosis_desc("高血压");
        xiyi2.setDiagnosis_time("2025-06-11 11:46:45");
        xiyi2.setDiagnosis_num("1");
        xiyi2.setDiagnosis_sub_num("0");
        xiyi2.setDiagnosis_type_name("初步诊断");
        xiyi2.setDiagnosis_flag_name("西医诊断");
        xiyi2.setNormalization_diagnosis_name("高血压");
        xiyi2.setNormalization_name("高血压");
        xiyi2.setNorm_diagnosis_name("高血压");
        diagnoses.add(xiyi2);

        Binglizhenduan xiyi3 = new Binglizhenduan();
        xiyi3.setDiagnosis_name("营养风险");
        xiyi3.setDiagnosis_code("R63.801");
        xiyi3.setDiagnosis_desc("营养风险");
        xiyi3.setDiagnosis_time("2025-06-11 11:46:40");
        xiyi3.setDiagnosis_num("2");
        xiyi3.setDiagnosis_sub_num("0");
        xiyi3.setDiagnosis_type_name("初步诊断");
        xiyi3.setDiagnosis_flag_name("西医诊断");
        xiyi3.setNormalization_diagnosis_name("营养风险");
        xiyi3.setNormalization_name("营养风险");
        xiyi3.setNorm_diagnosis_name("营养风险");
        diagnoses.add(xiyi3);

        Binglizhenduan xiyi4 = new Binglizhenduan();
        xiyi4.setDiagnosis_name("解毒剂和螯合剂的有害效应，不可归类在他处者");
        xiyi4.setDiagnosis_code("Y57.200");
        xiyi4.setDiagnosis_desc("解毒剂和螯合剂的有害效应，不可归类在他处者");
        xiyi4.setDiagnosis_time("2025-06-12 11:53:50");
        xiyi4.setDiagnosis_num("3");
        xiyi4.setDiagnosis_sub_num("0");
        xiyi4.setDiagnosis_type_name("初步诊断");
        xiyi4.setDiagnosis_flag_name("西医诊断");
        xiyi4.setNormalization_diagnosis_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
        xiyi4.setNormalization_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
        xiyi4.setNorm_diagnosis_name("解毒剂和螯合剂的有害效应,不可归类在他处者");
        diagnoses.add(xiyi4);

        Binglizhenduan xiyi5 = new Binglizhenduan();
        xiyi5.setDiagnosis_name("糖尿病");
        xiyi5.setDiagnosis_code("E14.900x001");
        xiyi5.setDiagnosis_desc("糖尿病");
        xiyi5.setDiagnosis_time("2025-06-13 11:55:52");
        xiyi5.setDiagnosis_num("4");
        xiyi5.setDiagnosis_sub_num("0");
        xiyi5.setDiagnosis_type_name("初步诊断");
        xiyi5.setDiagnosis_flag_name("西医诊断");
        xiyi5.setNormalization_diagnosis_name("糖尿病");
        xiyi5.setNormalization_name("糖尿病");
        xiyi5.setNorm_diagnosis_name("糖尿病");
        diagnoses.add(xiyi5);

        // 分离中医和西医诊断
        List<Binglizhenduan> zhongyiDiagnoses = diagnoses.stream()
                .filter(d -> "中医诊断".equals(d.getDiagnosis_flag_name()))
                .collect(Collectors.toList());

        List<Binglizhenduan> xiyiDiagnoses = diagnoses.stream()
                .filter(d -> "西医诊断".equals(d.getDiagnosis_flag_name()))
                .collect(Collectors.toList());

        // 对两个集合分别按diagnosis_num排序
        Comparator<Binglizhenduan> comparator = Comparator
                .comparing(Binglizhenduan::getDiagnosis_num)
                .thenComparing(Binglizhenduan::getDiagnosis_sub_num);

        zhongyiDiagnoses.sort(comparator);
        xiyiDiagnoses.sort(comparator);

        // 设置主诊断
        setMainDiagnosis(zhongyiDiagnoses);
        setMainDiagnosis(xiyiDiagnoses);

        // 合并结果，中医在前，西医在后
        List<Binglizhenduan> result = new ArrayList<>();
        result.addAll(zhongyiDiagnoses);
        result.addAll(xiyiDiagnoses);
        System.out.println(result);
        System.out.println(result);
    }

    private  void setMainDiagnosis(List<Binglizhenduan> diagnoses) {
        for (Binglizhenduan diagnosis : diagnoses) {
            if ("1".equals(diagnosis.getDiagnosis_num()) &&
                    "0".equals(diagnosis.getDiagnosis_sub_num())) {
                diagnosis.setMain_diagnosis("true");
            }
        }
    }


}