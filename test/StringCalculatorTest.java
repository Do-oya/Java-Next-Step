import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setUp() {
        cal = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우")
    public void add1() throws Exception {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력한 경우")
    public void add2() throws Exception {
        assertEquals(1, cal.add("1"));
    }

    @Test
    @DisplayName("숫자 두개를 쉼표(,) 구분자료 입력한 경우")
    public void add3() throws Exception {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    @DisplayName("구분자를 쉼포(,) 이외에 콜론(:)을 사용한 경우")
    public void add4() throws Exception {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정한 경우")
    public void add5() throws Exception {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    @DisplayName("음수를 전달하는 경우")
    public void add6() throws Exception {
        cal.add("-1, 2, 3");
    }

}
