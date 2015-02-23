Files = java.nio.file.Files
Paths = java.nio.file.Paths
StandardCharsets = java.nio.charset.StandardCharsets
Arrays = java.util.Arrays

function csv2Data(filePath) {
    csvData = new Array()
        data = new java.lang.String(
                Files.readAllBytes(Paths.get(filePath)),
                StandardCharsets.UTF_8)
    lines = data.split('\n')
    print('lines length : ' + lines.length)
    print('lines : ' + lines)
    for (i = 0; i < lines.length;++i) {
        cells = lines[i].split(",")
            if( cells.length != 1 ) {
                csvData.push(
                        new javafx.scene.chart.PieChart.Data(cells[0], cells[1])
                        )
            }
    }
    return csvData
}

filePath = (arguments[0] != null) ? arguments[0] : 'data.csv'
datas = csv2Data(filePath)
list = javafx.collections.FXCollections.observableList(datas)

graph = new javafx.scene.chart.PieChart(list)
    $STAGE.scene = new javafx.scene.Scene(graph)
    $STAGE.title = 'Result'
