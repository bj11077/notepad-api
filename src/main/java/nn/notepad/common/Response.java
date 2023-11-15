package nn.notepad.common;

public record Response<T>(boolean status, T data) {
}
