//package boot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.hadoop.hive.HiveTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.*;
//
//@RestController
//public class HiveController {
//
//    @Autowired
//    HiveTemplate hiveTemplate;
//
//    @GetMapping("/hive")
//    public Object hive(@RequestParam("table") String table,
//                       @RequestParam(value = "start", defaultValue = "0", required = false) Integer start,
//                       @RequestParam(value = "end", defaultValue = "100", required = false) Integer end) {
//
//        TablePreviewDTO result;
//        try {
//            result = hiveTemplate.execute(h -> {
//
//                TablePreviewDTO dto = new TablePreviewDTO(table);
//
//                List<TablePreviewDTO.Field> fields = new ArrayList<>();
//                Connection connection = h.getConnection();
//                try(Statement statement = connection.createStatement()) {
//                    ResultSet resultSet = statement.executeQuery(String.format("describe %s", table));
//                    while (resultSet.next()) {
//                        String colName = resultSet.getString(1);
//                        String colType = resultSet.getString(2);
//                        fields.add(new TablePreviewDTO.Field(colName, colType));
//                    }
//                }
//
//                Map<String, Object> data = new HashMap<>();
//                Map<String, Object> range = new HashMap<>();
//                for(TablePreviewDTO.Field f : fields) {
//                    String name = f.getName();
//
//                    List<String> columnData = h.execute(String.format("select `%s` from %s limit %s, %s", name, table, start, end));
//                    String min = h.executeAndfetchOne(String.format("select min(`%s`) from %s", name, table));
//                    String max = h.executeAndfetchOne(String.format("select max(`%s`) from %s", name, table));
//                    data.put(name, columnData);
//                    range.put(name, Arrays.asList(min, max));
//                }
//
//                dto.setData(data);
//                dto.setFields(fields);
//                dto.setDataRange(range);
//
//                return dto;
//            });
//        } catch (DataAccessException ex) {
//            throw ex;
//        }
//
//        return result;
//    }
//}
