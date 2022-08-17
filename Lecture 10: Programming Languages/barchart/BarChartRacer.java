import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String file = args[0];
        int k = Integer.parseInt(args[1]);
        In datas = new In(file);
        String title = datas.readLine();
        String xAxisLabel = datas.readLine();
        String dataSource = datas.readLine();
        datas.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        while (datas.hasNextLine()) {
            int n = Integer.parseInt(datas.readLine());
            Bar[] bars = new Bar[n];
            String year = "";
            for (int i = 0; i < n; i++) {
                String record = datas.readLine();
                String[] compo = record.split(",");
                year = compo[0];
                String name = compo[1];
                int value = Integer.parseInt(compo[3]);
                String category = compo[4];
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);
            chart.setCaption(year);
            for (int i = 0; i < k; i++) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            datas.readLine();
        }
        chart.reset();
    }
}
