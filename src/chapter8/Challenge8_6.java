package chapter8;

/**
 * Created by asus on 8/27/17.
 * Implement a jigsaw puzzle.
 *
 * Each piece has position (relative in our case) and 4 edges.
 */

class Edge{
    enum Type{ inner, outer, flat}
    Piece parent;
    Type type;
    int index; // index into edge of the piece
    Edge attachedTo; // relative position

    boolean fitsWith(Edge edge) { return false; }

    boolean isFlat(){
        return type == Type.flat;
    }

    boolean isInner() { return  type == Type.inner; }
    boolean isOuter() { return  type == Type.outer; }
}

class Piece{
    Edge[] edges;
    boolean isCorner(){ return false;}
    int flatEdges(){
        int flat = 0;
        for (Edge e : edges){
            if (e.isFlat()) flat++;
        }
        return flat;
    }
}

class Puzzle{
    Piece[] pieces;  // remaining pieces
    Piece[][] solution;
    Edge[] inners, outers, flats;

    void sort(){
        for (Piece piece : pieces){
            if (piece.flatEdges() == 2){
                // add piece to corners
            }
            for (Edge e: piece.edges){
                if (e.isInner()){
                    // add to inners
                }
                else if (e.isOuter()) {
                    // add to outers
                }
            }
        }
    }
    void solve(){}
}

public class Challenge8_6 {
}
