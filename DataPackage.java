package data;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DataPackage {
    private String msg;
    private Byte[] bytes;

    public DataPackage(String msg) {
        this.msg = msg;
    }

    public DataPackage(String msg, Byte[] bytes) {
        this.msg = msg;
        this.bytes = bytes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    public void setBytes(Byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataPackage that = (DataPackage) o;
        return Objects.equals(msg, that.msg) && Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(msg);
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }
}
