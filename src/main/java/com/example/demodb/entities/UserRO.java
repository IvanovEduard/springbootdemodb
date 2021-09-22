package com.example.demodb.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Eduard Ivanov on 7/1/21
 */
@Data
@NoArgsConstructor
public class UserRO {
    private String name;
    private String email;
}
