package ServerBox.AxisServerBox.dto;

import lombok.Getter;//lombok은 어노테이션을 통해 코드를 자동으로 만들어주는 도구
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString  //@ToString: 객체를 찍으면 필드값들이 보기 좋게 나옴
public class MemberDTO {
    String name;
    String email;
    String group;
}
