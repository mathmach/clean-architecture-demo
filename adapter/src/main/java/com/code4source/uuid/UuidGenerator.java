package com.code4source.uuid;

import com.code4source.usecase.port.IdGenerator;
import java.util.UUID;

public class UuidGenerator implements IdGenerator {

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
