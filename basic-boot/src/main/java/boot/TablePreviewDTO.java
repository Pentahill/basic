package boot;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
public class TablePreviewDTO implements Serializable{
    private String tableName;
    private Map<String, Object> data;
    private List<Field> fields;
    private Map<String,Object> dataRange;

    public TablePreviewDTO(String tableName) {
        this.tableName = tableName;
    }

    @Setter
    @Getter
    public static class Field implements Serializable {
        private String name;
        private String type;

        public Field(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Field baseBean = (Field) o;
            return type.equals(baseBean.type) &&
                    name.equals(baseBean.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, type);
        }
    }

    @Setter
    @Getter
    public static class FieldWithRange implements Serializable {
        private String columnType;
        private String columnName;
        private Object dataRange;

        public FieldWithRange() {
        }

        public FieldWithRange(String columnType, String columnName, Object dataRange) {
            this.columnType = columnType;
            this.columnName = columnName;
            this.dataRange = dataRange;
        }
    }
}
