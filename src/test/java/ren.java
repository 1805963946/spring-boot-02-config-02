import java.util.ArrayList;
import java.util.List;

public class ren {
    String name;
    List<ren> haizi = new ArrayList<>();

    public ren(String name) {
        this.name = name;
    }

    public String toJson() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"name\":\"" + this.name + "\"");
        if (haizi.size() > 0) {
            sb.append(",");
            sb.append("\"haizi\":");
            sb.append("[");
            for (Integer i = 0; i < this.haizi.size(); i++) {
                sb.append(haizi.get(i).toJson());
                if (i < this.haizi.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String arg[]) {
        ren waipo = new ren("康志芳");
        ren waigong = new ren("陈世华");
        ren mama = new ren("陈小彬");
        ren meimei = new ren("朱佳音");
        ren ziji = new ren("朱家华");
        ren 舅舅 = new ren("陈康");
        ren 小姨 = new ren("陈健");

        waipo.haizi.add(舅舅);
        waipo.haizi.add(小姨);
        waipo.haizi.add(mama);

        waigong.haizi.add(舅舅);
        waigong.haizi.add(小姨);
        waigong.haizi.add(mama);

        mama.haizi.add(meimei);
        mama.haizi.add(ziji);

        System.out.println(waipo.toJson());
    }
}
