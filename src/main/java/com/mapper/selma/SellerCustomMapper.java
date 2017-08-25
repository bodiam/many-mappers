package com.mapper.selma;

import com.mapper.model.input.Contact;
import com.mapper.model.output.OutputContact;

import java.util.List;
import java.util.Objects;

/**
 * Created by yangliu on 25/08/2017.
 */
public class SellerCustomMapper {

    public OutputContact contactMapper(List<Contact> contacts) {
        return contacts.stream()
                .filter(c -> Objects.equals(c.getRole(), "seller"))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .orElseThrow(() -> new IllegalArgumentException("Coudln't find contact with role " + "seller"));
    }
}
