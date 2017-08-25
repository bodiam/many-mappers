package com.mapper.mapstruct.helper;

import com.mapper.model.input.Contact;
import com.mapper.model.output.OutputContact;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class ContactIterableUtil {

    @Buyer
    public OutputContact buyer(List<Contact> contacts) {
        return findContactByRole(contacts, "buyer");
    }

    @Seller
    public OutputContact seller(List<Contact> contacts) {
        return findContactByRole(contacts, "seller");
    }

    @Nullable
    private OutputContact findContactByRole(List<Contact> contacts, String role) {
        return contacts.stream()
                .filter(c -> Objects.equals(c.getRole(), role))
                .findFirst()
                .map(x -> new OutputContact(x.getName(), x.getRole()))
                .orElse(null);
    }


}
