package com.huangda7.reflectionandannotation.myAnnotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class myEntity = Class.forName("com.huangda7.reflectionandannotation.myAnnotation.MyEntity");
        MyTableAnnotation myTableAnnotation = (MyTableAnnotation) myEntity.getAnnotation(MyTableAnnotation.class);
        String tableName = myTableAnnotation.value();
        Field[] fields = myEntity.getDeclaredFields();
        List<ColumnDto> columnDtos = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            MyColumnAnnotation column = fields[i].getAnnotation(MyColumnAnnotation.class);
            ColumnDto columnDTO = ColumnDto.builder()
                    .columnName(column.value())
                    .type(column.type())
                    .length(column.length())
                    .build();
            columnDtos.add(columnDTO);
        }
        System.out.println("tableName ：" + tableName);
        int count = 1;
        columnDtos.stream()
                .forEach(columnDto -> {
                    System.out.println("columnName : " + columnDto.getColumnName());
                    System.out.println("type : " + columnDto.getType());
                    System.out.println("length : " + columnDto.getLength());
                });
    }
}
