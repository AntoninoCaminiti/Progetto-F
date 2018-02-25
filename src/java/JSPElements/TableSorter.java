/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSPElements;

/**
 *
 * @author root
 */
public class TableSorter {
    
    
    public static String sortTable(String tableName)
    {
        StringBuilder ss = new StringBuilder();
        String output;
        ss.append("<script>\n" +
"function sortTable(n) {\n" +
"  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;\n" +
"  table = document.getElementById(\""+tableName+"\");\n" +
"  switching = true;\n" +
"dir = \"asc\"; \n" +
"while (switching) {\n" +
"switching = false;\n" +
"    rows = table.getElementsByTagName(\"TR\");\n" +
"for (i = 1; i < (rows.length - 1); i++) {\n" +
"shouldSwitch = false;\n" +
"x = rows[i].getElementsByTagName(\"TD\")[n];\n" +
"      y = rows[i + 1].getElementsByTagName(\"TD\")[n];\n" +
"if (dir == \"asc\") {\n" +
"        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {\n" +
"          shouldSwitch= true;\n" +
"          break;\n" +
"        }\n" +
"      } else if (dir == \"desc\") {\n" +
"        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {\n" +
"shouldSwitch= true;\n" +
"          break;\n" +
"        }\n" +
"      }\n" +
"    }\n" +
"    if (shouldSwitch) {\n" +
"      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);\n" +
"      switching = true;\n" +
"switchcount ++; \n" +
"    } else {\n" +
"if (switchcount == 0 && dir == \"asc\") {\n" +
"        dir = \"desc\";\n" +
"        switching = true;\n" +
"      }\n" +
"    }\n" +
"  }\n" +
"}\n" +
"</script>");
    output = ss.toString();
    return output;
    }
}
