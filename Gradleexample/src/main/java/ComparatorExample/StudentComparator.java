package ComparatorExample;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 03/09/14
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if(student1.getMathsMark() < student2.getMathsMark())
            return -1;
        if(student1.getMathsMark() > student2.getMathsMark())
            return 1;
        return 0;
    }

}
