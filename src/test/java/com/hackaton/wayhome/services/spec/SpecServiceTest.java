package com.hackaton.wayhome.services.spec;

import com.hackaton.wayhome.repositories.ISpecRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpecServiceTest {

    @Mock
    ISpecRepository specRepository;

    @Test
    void getAll() {
    }

    @Test
    void getByHousingId() {
    }
}