package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WordProviderTest {

    @Test
    @DisplayName("파일이 있으면 파일 로드 성공")
    void test() {
        WordProvider wordProvider = new WordProvider();
        wordProvider.loadWordFile("src/test/resources/test10words.txt");
    }

    @Test
    @DisplayName("파일이 없으면 IllegalArgumentException throw")
    void fileNotFoundTest() {
        WordProvider wordProvider = new WordProvider();
        assertThatThrownBy(()->wordProvider.loadWordFile("/asfas.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일 변환중에 err가 발생하였습니다.");

    }

    @Test
    @DisplayName("테스트 파일의 단어 갯수 테스트")
    void get10WordsTest() {
        WordProvider wordProvider = new WordProvider();
        List<String> words = wordProvider.loadWordFile("src/test/resources/test10words.txt");
        assertThat(words.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("테스트 파일 공백 테스트")
    void getEmptyWordsTest() {
        WordProvider wordProvider = new WordProvider();
        assertThatThrownBy(()->wordProvider.loadWordFile("src/test/resources/testEmptyWords.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("파일이 비어있습니다.");
    }
}
