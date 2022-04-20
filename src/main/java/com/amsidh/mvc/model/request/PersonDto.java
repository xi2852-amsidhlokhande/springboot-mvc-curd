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
    @NotNull(message = "id must not be null")
    private Integer id;
    @Size(min = 4, max = 10, message = "name must be in between 4 and 10")
    private String name;
    @Email(message = "EmailId must be valid email address")
    private String emailId;
    @Size(min = 10, max = 12, message = "Mobile Number must be minimum 10 and maximum 12 length")
    private Long mobileNumber;
}
