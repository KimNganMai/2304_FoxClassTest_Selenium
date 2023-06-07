package CommonFuncs;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableSection {
    public static String getDataRowByKey(DataTable dataTable, String key) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            if (row.get(key) == null) {
                return "ALERT: Row '" + key + "' is not found in data table";
            }
            return row.get(key);
        }
        return "Done";
    }
    public static String getDataColByKey(DataTable dataTable, String key) {
        List<List<String>> data = dataTable.asLists(String.class);

        for (List<String> row : data) {
            String keyName = row.get(0);
            String dataValue = row.get(1);

            if (keyName != null && keyName.equals(key)) {
                return dataValue;
            }
        }
        return "Done";
    }
    public static String getDataColAndRowByKey(DataTable dataTable, String keyRow, String keyCol) {
        if(!keyRow.equals("")) {
            List<List<String>> data = dataTable.asLists(String.class);
            for (List<String> row : data) {
                String keyName = row.get(0);
                String dataValue = row.get(1);

                if (keyName != null && keyName.equals(keyRow)) {
                    return dataValue;
                }
            }
        } else if (!keyCol.equals("")) {
            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                if (row.get(keyCol) == null) {
                    return "ALERT: Row '" + keyCol + "' is not found in data table";
                }
                return row.get(keyCol);
            }
        }
        return "Done";
    }
}
