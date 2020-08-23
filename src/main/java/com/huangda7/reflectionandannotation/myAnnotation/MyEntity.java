package com.huangda7.reflectionandannotation.myAnnotation;

@MyTableAnnotation("my_table_name")
public class MyEntity {
    @MyColumnAnnotation(value = "my_table_column1",type = "varchar",length = 10)
    private String colunm1;
    @MyColumnAnnotation(value = "my_table_column2",type = "int",length = 20)
    private String colunm2;
}
