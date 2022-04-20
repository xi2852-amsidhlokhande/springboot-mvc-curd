package com.amsidh.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Person implements Serializable {
    private static final long serialVersionUID = -6051031196068596573L;
    @Id
    private Integer id;
    private String name;
    private String emailId;
    private Long mobileNumber;
}
