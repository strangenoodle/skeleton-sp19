public class NBody {

    public double readRadius(String s){
        In in = new In(s);

        /* Every time you call a read method from the In class,
         * it reads the next thing from the file, assuming it is
         * of the specified type. */

        /* Compare the calls below to the contents of BasicInDemo_input_file.txt */

        int firstItemInFile = in.readInt();
    }
}
