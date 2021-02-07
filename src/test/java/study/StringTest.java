package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 인덱스 문자 테스트")
    void chatAt() {
        String values = "abcd";
        assertEquals('a', values.charAt(0));
        assertEquals('b', values.charAt(1));
        assertEquals('c', values.charAt(2));

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    values.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }
}