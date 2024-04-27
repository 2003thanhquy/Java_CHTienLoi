package org.LapTrinhTienTien.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Response {
    String message;
    Boolean flag;
    Object data;
}
