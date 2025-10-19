package me.hmhb.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class User {
    int id;
    String name;
    String sex;
    int age;
}
