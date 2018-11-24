// Operations on K-d Tree with 2 dimensions
//
// CS 201 Exam 2
//
// Name: Benjamin Allan-Rahill

import java.awt.*;
import java.util.Vector;

public class KdTreeOps{

    // problem 1 --------------------------------------------------

    // return number of nodes in t that have type isX
    public static int countNodes(KdTree t, boolean isX) {
        if(t == null){
            return 0;
        }else{
            if(isX){
                return 1 + countNodes(t.left(), false)
                            + countNodes(t.right(), false);
            }
            else{
                return 0 + countNodes(t.left(), true)
                            + countNodes(t.right(), true);
            }
        }
    }


    // problem 2 --------------------------------------------------

    // return whether left and right subtrees of t have mirrored shape
    public static boolean isSymmetric(KdTree t) {
        if (t == null)
            return true;
        else if (t.left() == null && t.right() != null)
            return false;
        else if (t.right() == null && t.left() != null)
            return false;
        else
            return isSymmetricRec(t.left(), t.right());
    }

    public static boolean isSymmetricRec(KdTree t1, KdTree t2){
        //used by isSymmetric (above)
        if(t1 == null && t2 != null)
            return false;
        if(t1 == null && t2 != null)
            return false;
        if(t1 == null && t2 == null)
            return true;
        else if (countNodes(t1, false) == countNodes(t2, false)) {
            return(isSymmetricRec(t1.left(), t2.right())
                && isSymmetricRec(t1.right(), t2.left()));
        } else return false;
    }

    // problem 3 --------------------------------------------------

    // return width of t:
    //   0 if t is null
    //   2 if t is a leaf
    //   if one child is null, 1 + width of the other child
    //   otherwise, the sum of the widths of t's subtrees
    public static int width(KdTree t) {
        if (t == null){
            return 0;
        }
        else if (t.left() == null && t.right() == null) {
            return 2;
        }
        else if (t.left() == null || t.right() == null){
            return 1 + width(t.left()) + width(t.right());
        }
        else
            return width(t.left()) + width(t.right());
    }

    // return width of left "half" of t:
    //   0 if t is null
    //   otherwise, the width of t's left subtree (but at least 1)
    public static int leftWidth(KdTree t) {
        if (t == null)
            return 0;
        else
            return 1 + width(t.left());
    }

    // returns width of right "half" of t:
    //   0 if t is null
    //   otherwise, the width of t's right subtree (but at least 1)
    public static int rightWidth(KdTree t) {
        if (t == null)
            return 0;
        else
            return 1 + width(t.right());
    }

    // problem 4 --------------------------------------------------

    // draw the tree in rectangle x0...x1, y0...y1
    public static void draw(Graphics g, KdTree t, int level,
            int x0, int y0, int x1, int y1) {

        // set color and line width according to level and node type (x or y)
        TreeCanvas.setNodeColor(g, level, t.isX());
        TreeCanvas.setLineWidth(g, 4 - level/2); // progressively thinner

        Point p = t.point();

        // draw the dividing lines
        if (t.isX()) { // vertical line
            g.drawLine(p.x,  y1,  p.x,  y0);
            if (t.left() != null)
                draw(g, t.left(),  level+1, x0, y0, p.x, y1);
            if (t.right() != null)
                draw(g, t.right(), level+1, p.x, y0, x1, y1);
        } else { // horizontal line
            g.drawLine(x1,  p.y,  x0,  p.y);
            if (t.left() != null)
                draw(g, t.left(),  level+1, x0, y0, x1, p.y);
            if (t.right() != null)
                draw(g, t.right(), level+1, x0, p.y, x1, y1);
        }

        // draw a black dot for the node
        g.setColor(Color.black);
        g.fillOval(p.x-4, p.y-4, 9, 9);
    }



    // problem 5 --------------------------------------------------

    // rebuild the tree so it is balanced (return as new tree)
    public static KdTree rebuild(KdTree t) {

        // first, collect all the points in the tree into a vector
        Vector<Point> points = new Vector<Point>();
        collectPoints(t, points);

        // then, build a new K-d tree recursively
        return buildKdTree(points, true, 0, points.size());
    }

    // add all the points in t to the vector using pre-order traversal
    private static void collectPoints(KdTree t, Vector<Point> points) {
        points.add(t.point());
        if(t.left() != null){
            collectPoints(t.left(), points);
        }
        if (t.right() != null)
            collectPoints(t.right(), points);
    }

    // build the tree recursively from the portion of the vector
    // with indices start (inclusive) through end (exclusive)
    // (in Python slicing notation this would be points[start:end])
    private static KdTree buildKdTree(Vector<Point> points, boolean isX,
            int start, int end) {
        if (start >= end)
            return null;
        else{
            sortPoints(points, isX, start, end-1);
            int midIndex = (start + end)/2;
            System.out.println("Mid Index is:" + midIndex);
            Point midVal = points.get(midIndex);
            System.out.println("Mid Point is:" + midVal.coord(isX));
            boolean isX2 = !isX;
            System.out.println("!isX:" + !isX);
            System.out.println("!isX:" + !isX);
            return new KdTree(midVal, isX,
                        buildKdTree(points, !isX, start, midIndex),
                        buildKdTree(points, !isX, midIndex+1, end));

        }



        // 1. sort points[start:end] using helper function below
        // 2. compute mid index (average of start, end)
        // 3. get point at mid index for node value
        // 4. call function recursively on first and second half
        //    (in Python: points[start:mid] and points[mid+1:end])
        //    using negated isX parameter
        // 5. return new KdTree node with mid point and two recursive results

    }


    // sort vector from index start (inclusive) through end (exclusive)
    // according to coordinate isX using selection sort
    private static void sortPoints(Vector<Point> points, boolean isX,
            int start, int end) {
        for (int lastUnsorted = end-1; lastUnsorted > start; lastUnsorted--) {
            int maxIndex = start;
            for (int index = start+1; index <= lastUnsorted; index++) {
                if (points.get(index).coord(isX) >
                    points.get(maxIndex).coord(isX))
                {
                    maxIndex = index;
                }
            }
            // swap max value with last unsorted
            Point tmp = points.get(maxIndex);
            points.set(maxIndex, points.get(lastUnsorted));
            points.set(lastUnsorted, tmp);
        }
    }
}
