import java.util.TreeMap;

public class KeyboardNeighbours {
    private TreeMap<Character, String> neighbours;

    public KeyboardNeighbours(TreeMap<Character, Character> neighbours) {
        this.neighbours = new TreeMap<>();

        // Admittedly not the most gentle way to put the data in
        this.neighbours.put('q', "w");
        this.neighbours.put('w', "qe");
        this.neighbours.put('e', "wr");
        this.neighbours.put('r', "et");
        this.neighbours.put('t', "ry");
        this.neighbours.put('y', "tu");
        this.neighbours.put('u', "yi");
        this.neighbours.put('i', "uo");
        this.neighbours.put('o', "ip");
        this.neighbours.put('p', "o");

        this.neighbours.put('a', "s");
        this.neighbours.put('s', "ad");
        this.neighbours.put('d', "sf");
        this.neighbours.put('f', "dg");
        this.neighbours.put('g', "fh");
        this.neighbours.put('h', "gj");
        this.neighbours.put('j', "hk");
        this.neighbours.put('k', "jl");
        this.neighbours.put('l', "k");

        this.neighbours.put('z', "x");
        this.neighbours.put('x', "zc");
        this.neighbours.put('c', "xv");
        this.neighbours.put('v', "xv");
        this.neighbours.put('b', "vn");
        this.neighbours.put('n', "bm");
        this.neighbours.put('m', "n");
    }

    public Boolean isNeighbour(char letter1, char letter2) {
        return this.neighbours.get(letter1).contains(String.valueOf(letter2));
    }
}
