package com.huangda7.reflectionandannotation.myAnnotation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDto {
    private String columnName;
    private String type;
    private int length;
}
