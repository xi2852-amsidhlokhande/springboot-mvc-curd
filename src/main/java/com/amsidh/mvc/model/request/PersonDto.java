package com.amsidh.mvc.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class PersonDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 802183953361745027L;
    private Integer id;
    private String name;
    private String emailId;
    private Long mobileNumber;
}
