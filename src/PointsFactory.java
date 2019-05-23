import javax.vecmath.Color3f;

public class PointsFactory {

    public Dot[] dots;
    private Color3f[] colors;

    public PointsFactory(){
        this.dots = new Dot[60];
        this.colors = new Color3f[12];
    }

    public Dot[] generateDots(){
        Dot[] temp = new Dot[12];
        int t = 0;
        double goldenRatio = (1 + Math.sqrt(5)) / 2d;
        int[] index = indices();
        int aux;
        float off_color;

        for(int j = 0; j <= 1; j+=1) {
            int jFactor = j*2 - 1;
            for(int i = 0; i <= 1; i+=1) {
                int iFactor = i*2 - 1;
                int vertex_number = j * 2 + i+1;

                int loc1 = (j * 2 + i);
                int loc2 = (j * 2 + i + 4);
                int loc3 = (j * 2 + i + 8);

                temp[loc1] = new Dot(0 , iFactor , jFactor * goldenRatio);
                temp[loc2] = new Dot(iFactor , jFactor * goldenRatio , 0);
                temp[loc3] = new Dot(jFactor * goldenRatio , 0 , iFactor);

                off_color = 1 - vertex_number / 4;

                this.colors[loc1] = new Color3f(0.5f,off_color,off_color);
                this.colors[loc2] = new Color3f(off_color,0.5f,off_color);
                this.colors[loc3] = new Color3f(off_color,off_color,0.5f);
            }
        }



        for(t = 0; t < index.length; t++){
            aux = index[t];
            this.dots[t] = temp[aux];
        }

        return this.dots;

    }

    private int[] indices(){
        int[] indices = new int[60];

        //top
        int i = 0;
        indices[i++] = 4;
        indices[i++] = 8;
        indices[i++] = 0;

        indices[i++] = 5;
        indices[i++] = 4;
        indices[i++] = 0;

        indices[i++] = 10;
        indices[i++] = 5;
        indices[i++] = 0;

        indices[i++] = 1;
        indices[i++] = 10;
        indices[i++] = 0;

        indices[i++] = 8;
        indices[i++] = 1;
        indices[i++] = 0;

        //side1
        indices[i++] = 4;
        indices[i++] = 9;
        indices[i++] = 8;

        indices[i++] = 5;
        indices[i++] = 2;
        indices[i++] = 4;

        indices[i++] = 10;
        indices[i++] = 11;
        indices[i++] = 5;

        indices[i++] = 1;
        indices[i++] = 7;
        indices[i++] = 10;

        indices[i++] = 8;
        indices[i++] = 6;
        indices[i++] = 1;

        //side2
        indices[i++] = 4;
        indices[i++] = 2;
        indices[i++] = 9;

        indices[i++] = 8;
        indices[i++] = 6;
        indices[i++] = 9;

        indices[i++] = 7;
        indices[i++] = 6;
        indices[i++] = 1;

        indices[i++] = 11;
        indices[i++] = 7;
        indices[i++] = 10;

        indices[i++] = 2;
        indices[i++] = 11;
        indices[i++] = 5;

        //bottom
        indices[i++] = 3;
        indices[i++] = 7;
        indices[i++] = 11;

        indices[i++] = 11;
        indices[i++] = 2;
        indices[i++] = 3;

        indices[i++] = 3;
        indices[i++] = 2;
        indices[i++] = 9;

        indices[i++] = 3;
        indices[i++] = 9;
        indices[i++] = 6;

        indices[i++] = 7;
        indices[i++] = 3;
        indices[i++] = 6;

        return indices;
    }

    public Color3f[] vertexColors(){
        return this.colors;
    }
}
