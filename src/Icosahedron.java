import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import sun.jvm.hotspot.types.PointerType;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;

public class Icosahedron extends Shape3D {

    public Icosahedron() {

        this.setGeometry(createGeometry());

    }

    private Geometry createGeometry() {
        
        //int vertex = 60;
        int[] counts = new int[1];
        /*counts[0] = 60;
        int c = 0;

        PointsFactory pointsFactory = new PointsFactory();
        Dot[] dots = pointsFactory.generateDots();
        Color3f[] colors = pointsFactory.vertexColors();

        LineStripArray lineStripArray = new LineStripArray(vertex,
                GeometryArray.COORDINATES| GeometryArray.COLOR_3,counts);

        for(int i = 0; i < dots.length; i++) {
            lineStripArray.setCoordinate(i, new Point3d(dots[i].x, dots[i].y, dots[i].z));
            lineStripArray.setColor(i, colors[c]);

            if(c == 11)
                c = 0;
            else
                c = c + 1;
        }

        return lineStripArray;*/

        //int vertices = 60;
        //counts[0] = vertices;

        GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_FAN_ARRAY);
        double phi = 0.5*(Math.sqrt(5)+1);
        Point3d[] vertices = {new Point3d(1,1,1),
                new Point3d(0,1/phi,phi),new Point3d(phi,0,1/phi),
                new Point3d(1/phi,phi,0),
                new Point3d(-1,1,1),new Point3d(0,-1/phi,phi),
                new Point3d(1,-1,1),
                new Point3d(phi,0,-1/phi),new Point3d(1,1,-1),
                new Point3d(-1/phi,phi,0),
                new Point3d(-phi,0,1/phi),new Point3d(-1,-1,1),
                new Point3d(1/phi,-phi,0),
                new Point3d(1,-1,-1),new Point3d(0,1/phi,-phi),
                new Point3d(-1,1,-1),
                new Point3d(-1/phi,-phi,0),new Point3d(-phi,0,-1/phi),
                new Point3d(0,-1/phi,-phi),
                new Point3d(-1,-1,-1),
                new Point3d(1.32,-0.01,2.18),
                new Point3d(2.14,1.35,-0.05),
                new Point3d(0,2.1,1.4),
                new Point3d(-1.37,-0.04,2.17),
                new Point3d(2.13,-1.32,-0.02),
                new Point3d(-0.04,2.13,-1.39),
                new Point3d(0,-2.1,1.4),
                new Point3d(1.41,0,-2.09),
                new Point3d(-2.15,1.32,-0.04),
                new Point3d(-2.17,-1.31,0),
                new Point3d(-1.34,-0.02,-2.14),
                new Point3d(0.11,-2.15,-1.31)

        };

        /*int[] indices = {0,1,5,6,2,20,
                         0,2,7,8,3,21,
                         0,3,9,4,1,22,
                         1,4,10,11,5,23,
                         2,6,12,13,7,24,
                         3,8,14,15,9,25,
                         5,11,16,12,6,26,
                         7,13,18,14,8,27,
                         9,15,17,10,4,28,
                         19,16,11,10,17,29,
                         19,17,15,14,18,30,
                         19,18,13,12,16,31};*/

        int[] indices = {20,0,1,5,6,2,0,
                21,0,2,7,8,3,0,
                22,0,3,9,4,1,0,
                23,1,4,10,11,5,1,
                24,2,6,12,13,7,2,
                25,3,8,14,15,9,3,
                26,5,11,16,12,6,5,
                27,7,13,18,14,8,7,
                28,9,15,17,10,4,9,
                29,19,16,11,10,17,19,
                30,19,17,15,14,18,19,
                31,19,18,13,12,16,19};

        gi.setCoordinates(vertices);
        gi.setCoordinateIndices(indices);
        int[] stripCounts = {7,7,7,7,7,7,7,7,7,7,7,7};
        gi.setStripCounts(stripCounts);
        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);

        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"
                ,"S","T","U","V","X","Y","Z"};
        int i = 0;
        int j = 1;
        int mid = 0;
        String dot = "";
        boolean bandera = false;
        Point3d previos = new Point3d();
        Point3d aux = new Point3d();

        /*for (Point3d v: vertices) {
            if (bandera) {
                dot = letters[i] + j;
                j = j + 1;
            }
            else
                dot = letters[i];

            System.out.println(dot + " = (" + v.x + "," +
                    v.y + "," + v.z + ")");
            i++;

            if (i >= letters.length) {
                bandera = true;
                i = 0;
            }
        }*/


        for (int vertex: indices) {

            if (bandera) {
                dot = letters[i] + j;
                j = j + 1;
            }
            else
                dot = letters[i];

            System.out.println(dot + " = (" + vertices[vertex].x + "," +
                    vertices[vertex].y + "," + vertices[vertex].z + ")");
            i++;

            if (i >= letters.length) {
                bandera = true;
                i = 0;
            }

            /*if(mid == 1){
                mid = 0;
                aux.x = (previos.x + vertices[vertex].x) / 2;
                aux.y = (previos.y + vertices[vertex].y) / 2;
                aux.z = (previos.z + vertices[vertex].z) / 2;
                System.out.println("I"+ i +" = (" + aux.x + "," +
                        aux.y + "," + aux.z + ")");
            }
            else
                mid = mid + 1;

            previos = vertices[vertex];*/
        }

        //this.setGeometry(gi.getGeometryArray());

        /*Point3f a = new Point3f( 0f, -0.68f, 0.5f);
        Point3f b = new Point3f( 0.47553f, -0.68f, 0.12941f);
        Point3f c = new Point3f(-0.5f, -0.67f, 0.16f);
        Point3f d = new Point3f( -0.33f, -0.67f, -0.42f);
        Point3f e = new Point3f( 0.27f, -0.67f, -0.44f);
        Point3f f = new Point3f(0.02f, -0.18f, 0.83f);
        Point3f g = new Point3f( -0.78f, -0.14f, 0.29f);
        Point3f h = new Point3f( -0.51f, -0.12f, -0.65f);
        Point3f i = new Point3f( 0.46f, -0.14f, -0.68f);
        Point3f j = new Point3f( 0.79f, -0.18f, 0.23f);
        Point3f k = new Point3f( 0.51f, 0.13f, 0.67f);
        Point3f l = new Point3f( -0.46f, 0.16f, 0.7f);
        Point3f m = new Point3f(-0.79f, 0.19f, -0.22f);
        Point3f n = new Point3f( -0.02f, 0.19f, -0.82f);
        Point3f o = new Point3f( 0.78f, 0.16f, -0.27f);
        Point3f p = new Point3f( 0.33f, 0.66f, 0.43f);
        Point3f q = new Point3f( -0.27f, 0.67f, 0.45f);
        Point3f r = new Point3f( -0.48f, 0.69f, -0.11f);
        Point3f s = new Point3f( 0f, 0.69f, -0.48f);
        Point3f t = new Point3f(0.5f, 0.67f, -0.15f);

        LineArray axisZLines = new LineArray(104, LineArray.COORDINATES);

        axisZLines.setCoordinate(0, a);
        axisZLines.setCoordinate(1, b);
        axisZLines.setCoordinate(2, b);
        axisZLines.setCoordinate(3, e);
        axisZLines.setCoordinate(4, e);
        axisZLines.setCoordinate(5, d);
        axisZLines.setCoordinate(6, d);
        axisZLines.setCoordinate(7, c);
        axisZLines.setCoordinate(8, c);
        axisZLines.setCoordinate(9, a);
        axisZLines.setCoordinate(10,c );
        axisZLines.setCoordinate(11, g);
        axisZLines.setCoordinate(12, g);
        axisZLines.setCoordinate(13, l);
        axisZLines.setCoordinate(14, l);
        axisZLines.setCoordinate(15, f);
        axisZLines.setCoordinate(16, f);
        axisZLines.setCoordinate(17, a);
        axisZLines.setCoordinate(18, d);
        axisZLines.setCoordinate(19, h);
        axisZLines.setCoordinate(20, h);
        axisZLines.setCoordinate(21, m);
        axisZLines.setCoordinate(22, m);
        axisZLines.setCoordinate(23, g);
        axisZLines.setCoordinate(24, g);
        axisZLines.setCoordinate(25, c);
        axisZLines.setCoordinate(26, d);
        axisZLines.setCoordinate(27, e);
        axisZLines.setCoordinate(28, e);
        axisZLines.setCoordinate(29, i);
        axisZLines.setCoordinate(30, i);
        axisZLines.setCoordinate(31, n);
        axisZLines.setCoordinate(32, n);
        axisZLines.setCoordinate(33, h);
        axisZLines.setCoordinate(34, h);
        axisZLines.setCoordinate(35, d);
        axisZLines.setCoordinate(36, e);
        axisZLines.setCoordinate(37, b);
        axisZLines.setCoordinate(38, b);
        axisZLines.setCoordinate(39, j);
        axisZLines.setCoordinate(40, j);
        axisZLines.setCoordinate(41, o);
        axisZLines.setCoordinate(42, o);
        axisZLines.setCoordinate(43, i);
        axisZLines.setCoordinate(44, i);
        axisZLines.setCoordinate(45, e);
        axisZLines.setCoordinate(46, a);
        axisZLines.setCoordinate(47, f);
        axisZLines.setCoordinate(48, f);
        axisZLines.setCoordinate(49, k);
        axisZLines.setCoordinate(50, k);
        axisZLines.setCoordinate(51, j);
        axisZLines.setCoordinate(52, j);
        axisZLines.setCoordinate(53, b);
        axisZLines.setCoordinate(54, k);
        axisZLines.setCoordinate(55, f);
        axisZLines.setCoordinate(56, f);
        axisZLines.setCoordinate(57, l);
        axisZLines.setCoordinate(58, l);
        axisZLines.setCoordinate(59, q);
        axisZLines.setCoordinate(60, q);
        axisZLines.setCoordinate(61, p);
        axisZLines.setCoordinate(62, p);
        axisZLines.setCoordinate(63, k);
        axisZLines.setCoordinate(64, l);
        axisZLines.setCoordinate(65, g);
        axisZLines.setCoordinate(66, g);
        axisZLines.setCoordinate(67, m);
        axisZLines.setCoordinate(68, m);
        axisZLines.setCoordinate(69, r);
        axisZLines.setCoordinate(70, r);
        axisZLines.setCoordinate(71, q);
        axisZLines.setCoordinate(72, q);
        axisZLines.setCoordinate(73, l);
        axisZLines.setCoordinate(74, o);
        axisZLines.setCoordinate(75, j);
        axisZLines.setCoordinate(76, j);
        axisZLines.setCoordinate(77, k);
        axisZLines.setCoordinate(78, k);
        axisZLines.setCoordinate(79, p);
        axisZLines.setCoordinate(80, p);
        axisZLines.setCoordinate(81, t);
        axisZLines.setCoordinate(82, t);
        axisZLines.setCoordinate(83, o);
        axisZLines.setCoordinate(84, n);
        axisZLines.setCoordinate(85, i);
        axisZLines.setCoordinate(86, i);
        axisZLines.setCoordinate(87, o);
        axisZLines.setCoordinate(88, o);
        axisZLines.setCoordinate(89, t);
        axisZLines.setCoordinate(90, t);
        axisZLines.setCoordinate(91, s);
        axisZLines.setCoordinate(92, s);
        axisZLines.setCoordinate(93, n);
        axisZLines.setCoordinate(94, t);
        axisZLines.setCoordinate(95, p);
        axisZLines.setCoordinate(96, p);
        axisZLines.setCoordinate(97, q);
        axisZLines.setCoordinate(98, q);
        axisZLines.setCoordinate(99, r);
        axisZLines.setCoordinate(100, r);
        axisZLines.setCoordinate(101, s);
        axisZLines.setCoordinate(102, s);
        axisZLines.setCoordinate(103, t);

        LineStripArray lineStripArray = new LineStripArray(vertices, GeometryArray.COORDINATES,counts);
        lineStripArray.setCoordinate(0,new Point3d(0 ,8.09017 ,3.09017));
        lineStripArray.setCoordinate(1,new Point3d(0 ,-8.09017 ,3.09017));
        lineStripArray.setCoordinate(2,new Point3d(0 ,8.09017 ,-3.09017));
        lineStripArray.setCoordinate(3,new Point3d(0 ,-8.09017 ,-3.09017));
        lineStripArray.setCoordinate(4,new Point3d(8.09017 ,3.09017,0));
        lineStripArray.setCoordinate(5,new Point3d(-8.09017 ,3.09017,0));
        lineStripArray.setCoordinate(6,new Point3d(8.09017 ,-3.09017,0));
        lineStripArray.setCoordinate(7,new Point3d(-8.09017 ,-3.09017,0));
        lineStripArray.setCoordinate(8,new Point3d(3.09017,0, 8.09017));
        lineStripArray.setCoordinate(9,new Point3d(3.09017,0, -8.09017));
        lineStripArray.setCoordinate(10,new Point3d(-3.09017,0, 8.09017));
        lineStripArray.setCoordinate(11,new Point3d(-3.09017,0, -8.09017));
        lineStripArray.setCoordinate(12,new Point3d(-1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(13,new Point3d(0.0 ,1.0 ,-1.618033988749895));
        lineStripArray.setCoordinate(14,new Point3d(0.0 ,-1.0 ,-1.618033988749895));
        lineStripArray.setCoordinate(15,new Point3d(-1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(16,new Point3d(-1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(17,new Point3d(-1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(18,new Point3d(1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(19,new Point3d(0.0 ,-1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(20,new Point3d(-1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(21,new Point3d(1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(22,new Point3d(1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(23,new Point3d(1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(24,new Point3d(0.0 ,1.0 ,-1.618033988749895));
        lineStripArray.setCoordinate(25,new Point3d(1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(26,new Point3d(1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(27,new Point3d(-1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(28,new Point3d(-1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(29,new Point3d(0.0 ,1.0 ,-1.618033988749895));
        lineStripArray.setCoordinate(30,new Point3d(-1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(31,new Point3d(0.0 ,-1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(32,new Point3d(-1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(33,new Point3d(-1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(34,new Point3d(-1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(35,new Point3d(-1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(36,new Point3d(1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(37,new Point3d(-1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(38,new Point3d(0.0 ,1.0 ,-1.618033988749895));
        lineStripArray.setCoordinate(39,new Point3d(1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(40,new Point3d(1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(41,new Point3d(1.618033988749895 ,0.0 ,-1.0));
        lineStripArray.setCoordinate(42,new Point3d(0.0 ,-1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(43,new Point3d(1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(44,new Point3d(1.0 ,-1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(45,new Point3d(0.0 ,1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(46,new Point3d(1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(47,new Point3d(1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(48,new Point3d(1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(49,new Point3d(0.0 ,-1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(50,new Point3d(0.0 ,1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(51,new Point3d(0.0 ,1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(52,new Point3d(0.0 ,-1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(53,new Point3d(-1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(54,new Point3d(0.0 ,1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(55,new Point3d(-1.618033988749895 ,0.0 ,1.0));
        lineStripArray.setCoordinate(56,new Point3d(-1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(57,new Point3d(1.0 ,1.618033988749895 ,0.0));
        lineStripArray.setCoordinate(58,new Point3d(0.0 ,1.0 ,1.618033988749895));
        lineStripArray.setCoordinate(59,new Point3d(-1.0 ,1.618033988749895 ,0.0));*/

        return gi.getGeometryArray();
    }
}
