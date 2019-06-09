package com.myproject.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserExcel extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 1)
    private int id;
    @ExcelProperty(value = "姓名", index = 2)
    private String name;
    @ExcelProperty(value = "部门", index = 3)
    private String dept;
    @ExcelProperty(value = "电话", index = 4)
    private String phone;
    @ExcelProperty(value = "职位", index = 5)
    private String website;
    @ExcelProperty(value = "生日", index = 6)
    private Date birthday;
}
