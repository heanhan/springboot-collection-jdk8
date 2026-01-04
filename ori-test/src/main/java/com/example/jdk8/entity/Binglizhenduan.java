package com.example.jdk8.entity;


import lombok.Data;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/7/29 下午2:41
 */
@Data
public class Binglizhenduan {

    private String visit_id;
    private String patient_id;
    private String diagnosis_name;
    private String diagnosis_code;
    private String diagnosis_desc;
    private String diagnosis_time;
    private String diagnosis_num;
    private String diagnosis_sub_num;
    private String diagnosis_type_name;
    private String synonym_name;
    private String diagnosis_flag_name;
    private String normalization_diagnosis_name;
    private String normalization_name;
    private String treat_result_name;
    private String main_diagnosis;
    private String norm_diagnosis_name;

    // Getters and setters
    public String getVisit_id() { return visit_id; }
    public void setVisit_id(String visit_id) { this.visit_id = visit_id; }
    public String getPatient_id() { return patient_id; }
    public void setPatient_id(String patient_id) { this.patient_id = patient_id; }
    public String getDiagnosis_name() { return diagnosis_name; }
    public void setDiagnosis_name(String diagnosis_name) { this.diagnosis_name = diagnosis_name; }
    public String getDiagnosis_code() { return diagnosis_code; }
    public void setDiagnosis_code(String diagnosis_code) { this.diagnosis_code = diagnosis_code; }
    public String getDiagnosis_desc() { return diagnosis_desc; }
    public void setDiagnosis_desc(String diagnosis_desc) { this.diagnosis_desc = diagnosis_desc; }
    public String getDiagnosis_time() { return diagnosis_time; }
    public void setDiagnosis_time(String diagnosis_time) { this.diagnosis_time = diagnosis_time; }
    public String getDiagnosis_num() { return diagnosis_num; }
    public void setDiagnosis_num(String diagnosis_num) { this.diagnosis_num = diagnosis_num; }
    public String getDiagnosis_sub_num() { return diagnosis_sub_num; }
    public void setDiagnosis_sub_num(String diagnosis_sub_num) { this.diagnosis_sub_num = diagnosis_sub_num; }
    public String getDiagnosis_type_name() { return diagnosis_type_name; }
    public void setDiagnosis_type_name(String diagnosis_type_name) { this.diagnosis_type_name = diagnosis_type_name; }
    public String getSynonym_name() { return synonym_name; }
    public void setSynonym_name(String synonym_name) { this.synonym_name = synonym_name; }
    public String getDiagnosis_flag_name() { return diagnosis_flag_name; }
    public void setDiagnosis_flag_name(String diagnosis_flag_name) { this.diagnosis_flag_name = diagnosis_flag_name; }
    public String getNormalization_diagnosis_name() { return normalization_diagnosis_name; }
    public void setNormalization_diagnosis_name(String normalization_diagnosis_name) {
        this.normalization_diagnosis_name = normalization_diagnosis_name; }
    public String getNormalization_name() { return normalization_name; }
    public void setNormalization_name(String normalization_name) { this.normalization_name = normalization_name; }
    public String getTreat_result_name() { return treat_result_name; }
    public void setTreat_result_name(String treat_result_name) { this.treat_result_name = treat_result_name; }
    public String getMain_diagnosis() { return main_diagnosis; }
    public void setMain_diagnosis(String main_diagnosis) { this.main_diagnosis = main_diagnosis; }
    public String getNorm_diagnosis_name() { return norm_diagnosis_name; }
    public void setNorm_diagnosis_name(String norm_diagnosis_name) { this.norm_diagnosis_name = norm_diagnosis_name; }
}
