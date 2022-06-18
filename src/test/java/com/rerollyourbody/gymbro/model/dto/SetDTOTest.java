package com.rerollyourbody.gymbro.model.dto;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.SetDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Set;
import org.junit.jupiter.api.Test;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetDTOTest {
    @Test
    public void test_of_when_Set_is_valid() {
        Set set = createSet();
        SetDTO setDTO = SetDTO.of(set);

        assertEquals(setDTO.getWeight(), set.getWeight());
        assertEquals(setDTO.getRepetitions(), set.getRepetitions());
    }
}
