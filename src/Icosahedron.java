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

        //GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_FAN_ARRAY);
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

        //gi.setCoordinates(vertices);
        //gi.setCoordinateIndices(indices);
        int[] stripCounts = {7,7,7,7,7,7,7,7,7,7,7,7};
        //gi.setStripCounts(stripCounts);
        //NormalGenerator ng = new NormalGenerator();
        //ng.generateNormals(gi);

        /*String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R"
                ,"S","T","U","V","X","Y","Z"};*/

        IndexedTriangleFanArray triangleFanArray = new IndexedTriangleFanArray(84,
                GeometryArray.COORDINATES, 84, stripCounts);
        //IndexedTriangleFanArray triangleFanArray2 = new IndexedTriangleFanArray(84,
        //                GeometryArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2 ,
        //                84, stripCounts, 84, stripCounts);
        triangleFanArray.setCoordinates(0, vertices);
        triangleFanArray.setCoordinateIndices(0, indices);

        return triangleFanArray;

        /*int i = 0;
        int j = 1;
        int mid = 0;
        String dot = "";
        boolean bandera = false;
        Point3d previos = new Point3d();
        Point3d aux = new Point3d();*/

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


        /*for (int vertex: indices) {

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
        }*/

        /* Icosaedro

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
    }
}
