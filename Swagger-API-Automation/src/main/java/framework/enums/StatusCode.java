package framework.enums;

public enum StatusCode {
    CODE_200(200),
    CODE_201(201),
    CODE_404(404);

    public final int code;

    StatusCode(int code) {
        this.code = code;
    }
}
