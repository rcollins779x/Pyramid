import static board.Board.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println("***** N-Queens Problem *****"); //title

        getDimension();

        setup();

        solutionFinder();
    }
}
