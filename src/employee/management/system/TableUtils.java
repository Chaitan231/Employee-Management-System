package employee.management.system;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableUtils {
    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();

            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnLabel(column));
            }

            Vector<Vector<Object>> rows = new Vector<>();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int column = 1; column <= columnCount; column++) {
                    row.add(rs.getObject(column));
                }
                rows.add(row);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultTableModel();
        }
    }
}
