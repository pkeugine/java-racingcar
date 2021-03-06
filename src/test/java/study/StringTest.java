package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 인덱스 문자 테스트")
    void chatAt() {
        String values = "abcd";
        assertEquals(values.charAt(0), 'a');
        assertEquals(values.charAt(1), 'b');
        assertEquals(values.charAt(2), 'c');

//        assertThatThrownBy(() -> {
//            values.charAt(4);
//        }).isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("String index out of range: 4");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    values.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }
}