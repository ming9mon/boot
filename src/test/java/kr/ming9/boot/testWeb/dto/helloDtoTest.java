package kr.ming9.boot.testWeb.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class helloDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        String name = "가나다";
        int amount = 10000;

        HelloDto dto = new HelloDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
