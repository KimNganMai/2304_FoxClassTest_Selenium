package CommonFuncs;

import io.cucumber.datatable.DataTable;

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

//    public static String getData
}
