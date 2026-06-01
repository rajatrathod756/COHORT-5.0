package com.example.module2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @Nullable
    private Long id;
    @NotNull
    private String title;
    private LocalDate createdAt;
    @JsonProperty("isActive")
    private Boolean isActive;
}
