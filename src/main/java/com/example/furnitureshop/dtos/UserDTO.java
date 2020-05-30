package com.example.furnitureshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
        @NotNull
        @NotBlank
        @Length(min = 4, max = 30)
        private String username;

        @NotNull
        @NotBlank
        @Length(min = 4)
        private String password;

        @NotNull
        @NotBlank
        @Length(min = 4)
        private String confirmPassword;

        @Email
        @NotNull
        @NotBlank
        private String email;

        @AssertTrue(message = "Password must be equal.")
        public boolean isPasswordEqual() {
                return password == null || password.equals(confirmPassword);
        }
}
