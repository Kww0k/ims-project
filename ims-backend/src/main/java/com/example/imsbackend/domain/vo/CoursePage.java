package com.example.imsbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Silvery
 * @since 2023/11/15 02:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePage {

    List<CourseVO> courseVOS;

    Long total;
}
