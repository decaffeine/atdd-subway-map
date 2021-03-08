package nextstep.subway.line;

import nextstep.subway.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static nextstep.subway.line.LineSteps.*;
import static nextstep.subway.line.LineSteps.����ö_�뼱��_����_���_����;

@DisplayName("����ö ���� ���� ���")
public class LineSectionAcceptanceTest extends AcceptanceTest {

    @DisplayName("����ö �뼱�� ������ ����Ѵ�.")
    @Test
    void addSectionToLine() {
        // given
        ����ö_�뼱_����_��û(�뼱_2ȣ��());
        // when
        ����ö_�뼱��_����_���_��û();
        // then
        ����ö_�뼱��_����_���_����();
    }

    @DisplayName("����ö �뼱�� ���� ��Ͽ� �����Ѵ�.")
    @Test
    void failToAddSectionToLine() {
        // given
        ����ö_�뼱_����_��û(�뼱_2ȣ��());
        // when
//        ���ο� ������ ���࿪�� ���� ��ϵǾ��ִ� ���� �������̾�� �Ѵ�.
//        ���ο� ������ ���࿪�� ���� ��ϵǾ��ִ� ���� �� ����.
//        ���ǿ� �������� �ʴ� ���� ���.
        ����ö_�뼱��_����_���_��û();
        // then
        ����ö_�뼱��_����_���_����();
    }

    @DisplayName("����ö �뼱���� ������ �����Ѵ�.")
    @Test
    void deleteSectionFromLine() {
        // given
        ����ö_�뼱_����_��û(�뼱_2ȣ��());
        ����ö_�뼱��_����_���_��û();
        // when
        ����ö_����_����();
        // then
        ����ö_����_����_����();
    }

    @DisplayName("����ö �뼱���� ���� ���ſ� ������.")
    @Test
    void failToDeleteSectionFromLine() {
        // given
        ����ö_�뼱_����_��û(�뼱_2ȣ��());
        ����ö_�뼱��_����_���_��û();
        // when
//        ����ö �뼱�� ��ϵ� ������ ��(���� ������)�� ������ �� �ִ�.
//        ����ö �뼱�� ���� �������� ���� �������� �ִ� ���(������ 1���� ���) ���� ������ �� ����.
//          ���ǿ� �������� �ʴ� ���
        ����ö_����_����();
        // then
        ����ö_����_����_����();
    }

    @DisplayName("��ϵ� ������ ���� �� ��� ��ȸ")
    @Test
    void getLineStationOrderBySection() {
        // given
        ����ö_�뼱_����_��û(�뼱_2ȣ��());
        ����ö_�뼱��_����_���_��û();
        ����ö_�뼱��_����_���_��û();
        // when
        ����ö_�뼱_���_��ȸ();
        // then
        // ���� ������� ���ĵǾ��°�??
    }


    private Map<String, String> �뼱_2ȣ��() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "2ȣ��");
        params.put("color", "bg-green-600");
        return params;
    }

}
