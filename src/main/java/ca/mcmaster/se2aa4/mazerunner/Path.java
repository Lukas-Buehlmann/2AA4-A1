package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Path {
    private StringBuffer path = new StringBuffer();

    public void setPath(String str) {
        path = new StringBuffer(str);
    }

    public String getPath() {
        return path.toString();
    }

    public void append(String str) {
        path.append(str);
    }

    public String getCanonical() {
        StringBuffer canonical = new StringBuffer(path.toString());
        ArrayList<Integer> indices = new ArrayList<>();

        for (int i=0;i < path.length()-1;i++) {
            if (canonical.charAt(i) != canonical.charAt(i + 1)) indices.add(i + 1);
        }

        int count = 0;
        for (int i : indices) {
            canonical.insert(i + count, " ");
            count++;
        }

        return canonical.toString();
    }

    public String getFactorized() {
        StringBuffer factorized = new StringBuffer();
        String[] tokens = this.getCanonical().split("\\s");

        for (String token : tokens) {
            if (token.length() > 1) factorized.append("" + token.length() + token.charAt(0) + " ");
            else factorized.append(token.charAt(0) + " ");
        }

        return factorized.toString();
    }
}
