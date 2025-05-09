package com.boot.demo.springbootdemo.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseNote {
    private String version;
    private LocalDateTime date;
    private String changeLogData;

}
