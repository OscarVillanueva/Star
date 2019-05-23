
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.applet.Applet;
import java.awt.*;

public class Universe extends Applet {

    public Universe() {
        setLayout(new BorderLayout());
        GraphicsConfiguration config =
                SimpleUniverse.getPreferredConfiguration();

        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);

        BranchGroup scene = createSceneGraph();

        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);

        simpleU.getViewingPlatform().setNominalViewingTransform();

        simpleU.addBranchGraph(scene);
    }

    public BranchGroup createSceneGraph() {

        TransformGroup moveGroup = new TransformGroup();
        Transform3D move = new Transform3D();
        move.setTranslation(new Vector3f(0.0f,0.0f, -5.0f));
        moveGroup.setTransform(move);

        BranchGroup objRoot = new BranchGroup();

        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objSpin.addChild(new Icosahedron());

        Alpha rotationAlpha = new Alpha(-1, 6000);

        RotationInterpolator rotator =
                new RotationInterpolator(rotationAlpha, objSpin);
        BoundingSphere bounds =
                new BoundingSphere(new Point3d(0.0,0.0,0.0), 500.0);
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);

        moveGroup.addChild(objSpin);

        objRoot.addChild(moveGroup);

        objRoot.compile();

        return objRoot;
    }
}
