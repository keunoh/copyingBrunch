package com.brunch.kaltz.builder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentBuilderTest {

    @Test
    public void makeBuilder() {
        Student student = new StudentBuilder()
                .id(11111)
                .name("kaltz")
                .grade("junior")
                .phoneNumber("0102222")
                .build();

        assertThat(student.getName()).isEqualTo("kaltz");
    }


}