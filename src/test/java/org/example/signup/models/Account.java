package org.example.signup.models;

import com.github.ngoanh2n.YamlData;
import com.github.ngoanh2n.YamlFrom;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@YamlFrom(resource = "org.example.automation/account.yml")
public class Account extends YamlData<Account> {
    private String email;
    private String password;

    public Account generateEmail(){
        String uuid = String.valueOf(UUID.randomUUID());
        this.email = email.replaceAll("%UUID%",uuid);
        return this;
    }
}
