package pard.thirdSeminar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data){
//        public static <D> ResponseDto<D> - 이 메소드가 제네릭, 반환타입이 ResponseDto<D>
        return ResponseDto.set(true,message,data);
//        result가 true인 ResponseDto 객체 생성
    }

    public static <D> ResponseDto<D> setFailed(String message){
        return ResponseDto.set(false,message,null);
    }
}
