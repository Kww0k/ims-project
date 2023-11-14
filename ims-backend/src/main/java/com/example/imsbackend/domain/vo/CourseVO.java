package com.example.imsbackend.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/15 02:22
 */
@Data
public class CourseVO {
    private Integer id;

    private String name;
    private Date startTime;
    private Date endTime;
    private Double credit;
    private Integer number;
    private Integer openedBy;
}
