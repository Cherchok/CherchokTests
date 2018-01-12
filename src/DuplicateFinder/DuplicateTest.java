package DuplicateFinder;


import java.io.File;

public class DuplicateTest {
    public static void main(String[] args) {
        DuplicateFinder df = new DuplicateFinderImpl();
        df.process( new File("C:\\exmp\\a.txt"), new File("C:\\exmp\\b.txt"));
    }
}
